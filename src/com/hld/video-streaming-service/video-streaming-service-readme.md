#Video Streaming Service System Design

###Youtube, Netflix, Amazon Prime Video, HotStar


  ### Functional Requirements 
    
      1. Upload Videos  - should be able to upload videos,movies , songs ,anything( Could be people or production houses)
      2. User's Homepage and Search - Will see some most viewed videos and also able to search
      3. Play Videos
      4. Support all devices - brower,mobile phone, android,ios,windows,smartwatches,tablets.
         All of these devices support some of the formats(not all devices will support
         all the formats)
    
        List down all the support devices and their supporting formats.
        Devices ----> Formats  ------> Dimensions -----> Bandwidths
        Different Devices different formats different dimensions different regions with different bandwidth
        
        Videos have number of pixels, frames per second, bitrate of audio(all these things
        could be increased or decreased to reduce the file size --> that translates into 
        reduction in the bandwidth requirment).
        
        Combination of all those attributes could be used to have various formats or versions
        of the video with different bandwidth requiements.
         
        Suppose there are 'I' formats, 'J' Dimensions, 'k' Bandwidth.Then ( I * J * K ) number 
        of types of users ( means use cases ) to handle.
      

 ### Non Functional Requirements

      1. No Buffering(or minimum buffering) - Video should be available when device needs to play
         which means that the server which is serving the video should be responding in very low 
         latency and should be always available. Low Latency High Availability
      2. Increase User's Session Time - bad content people will discard, good content
         but not showing the right content to right person.
      3. Good Recommendation Engine
      


### Users of the Platform
    
    1. Client - basically a device (could laptop, mobile phone or any other device)
    2. Users - user who is actually viewing the content on the clients.
    3. Production Houses  - Users who will be uploading video on the platform.

      
### More Details

    1. If we notice any of these platform, they don't download the whole file to your 
       device and then start playing.
    2. They basically request a chunk of the video, play that and while that chunk is being 
       played, the client request for the further chunks, and subsequently each chunk comes in
       that get played and next chunks are in transit from server to the client.

    Example 
        A part of video is played and some chunks are coming.
        Client tries to figure out what device am I on and what file format can I support.
        If it supports multiple formats, it will request for one of them based on logic
        within the client.(could be based on quality).
        Suppose it request for a HD variant of that file format and first chunk get received
        on the client and it starts playing video.
        If client realizes subsequent chunks are not coming well in time.
        Let's say 3rd 4th chunk came very slowly.Then it basically requests for low quality verson of that chunk.
        At runtime tries to figure out the bandwidth adjust quality accordingly.

        This is called Adaptive Bitrate Streaming and client take cares of this.(which file to 
        request and play).


### Architecture of Video streaming System

 - #### Services to Production Houses 
    1. #####UI For production Houses
        - This component helps in uploading the content.Multiple ways content can be uploaded.
        - For a small video, there could be upload button wherein somebody's uploading the files
          from their own disk.That can work out for a video of couple of minutes.
          But for movies that's practical not possible.
        - So the raw file the production house will give out will be 20,30,40 GB or big.
          These are the highest definition content with good audio quality.Then later 
          will be trans coded into different kinds of formats.
        - So there would some sftp server running where all the content will be present.
          They will just give the link to the sftp server, some username and password.
        - UI for production house will talk to this asset on-boarding service, give it the url,
          and Asset on-boarding service would then call up wherever that content is hosted,maybe
          another s3 bucket,or may be some sftp server, pull the content from there and 
          put it into its own S3(kind of cheap database).
        - Using Cassandra to store all the information about all the videos(who is uploading,
          description,images attached to it,thumbnails,tags,etc).
        - Once the file is in our S3,Asset on-boarding service would send out an event into kafka
          saying I have taken the file and put it in my s3.
        - There are a lot of consumers sitting on kafka. 
          - Content-Processor - workflow engine which does a lot of things to that files that have 
            been uploaded for it to be available in various kinds of formats,various bandwidths,etc...
            - File chunker - There will be chunks that video should be divided in.
              And all the processing that is done on the video would also be done in chunks.
              So chunk the file at the beginning.So that we can parallelize all the further efforts.
              All this is done by File Chunker. (Divides into multiple segments - could size based segment,
              time base segment, or random based segment)
            - Content processor also uses kafka to send out various events and to invoke the further 
              processes.For each of these chunks or segments , it calls Content Filter.
            - Content Filter - So in each video platform , there are a certain kind of things that are not allowed
              For example - If upload pirates of the Caribbean movie on to youtube , I cannot do it
              because of legal reasons.(Piracy not allowed). All checks can happen parallel on the chunks
            - Content Tagger - Triggers after the completion of Content filter. When video is being 
              uploaded , production house will give out some tags by which that can be searched.
              But there could be some things that we can infer out of it.For example if there is 
              football video, we might want to tag it saying particular player in that.Content tagger 
              goes through the whole video tries to extract some parts of it which can be converted 
              into like English tags which can then be searched upon.It also tries to create thumbnails of the video.
            - It creates a list of thumbnails which could be used for AB testing and trying to figure out which 
              is the best one.
            - Transcoder -  Transcoding is basically an activity of converting one file type into another file type.
              So the raw video that was uploaded whose chunks we are processing those would be converted 
              into multiple file formats like AVI,MP4,etc.
              Post this transcoding effort, each file(chunk) will be split into multiple sub-files(sub-chunks)
              Now we have four files(chunks) instead of one.So each of the four will be sent out for 
              individual transformations next.
            - Quality Converter - People have different kind of bandwidths they are on.So we might want to have
              multiple formats which requires a different bandwidth. So each of these chunks will now be  converted into
              multiple formats basis the bandwidth we have.
            - Now once all of that is done, then we basically upload individual components(chunks) onto the CDN.
              These thousands or millions of chunks will be created.  
            - This is file processing cycle
            - Now once that is done, and even while it is happening, all the events are put into kafka.
              But kafka is not used for invoking the further processors, also for more other things.
              
    2. #### Spark Streaming Process        
        - Content Tagger tags each chunk with a certain tag.All of that information could be put into kafka.
          There could be spark streaming process that runs across all these chunks for a particular movie ID.
          and aggregating all the tags that are received.It can then filter out top 10 tags and then 
          tag the movie with those tags.Even though we are segregating all of that information across a lot 
          of worker nodes but at the end, it is aggregated at one point in time.
          That aggregation could be done through spark streaming.Looks like a Map-Reduce.
          
    3. #### Asset Service    
        - When all of that is done, again, even when CDN upload is complete, it will send out events into kafka.
          There will be Asset Service that will be reading all of these events.Because somewhere we need 
          to keep track of what is happening with the whole movie.How many chunks are there ?
          which chunk is in what status?So all of that is being handled by Asset Service and it is 
          storing all the information about all the chunks into this cassandra.
        - Once it identifies that everything is complete and all the chunks have been processed completely,
          it will send out notification through, again routing through kafka via notification service 
          to the person who has actually uploaded the image, saying your movie is now processed.
        
    4. #### Search Consumer
     

    
 - ####Services to User facing products
    - #####Check User Facing architecture for more details
    - Users are the people who are consuming content on our platform.So one of the very first 
      interactions that we have with the user is when they try to log in .And this login could 
      happen from a bunch of clients -  mobile application, browser, smart TV etc. 
    - But we will assume of those are coming through this one product called User Device Login 
    which  talks to user service internally for authentication.
    - Now the responsibility of the user service is to be the source of truth for all user related
    information.
   - This  user service sits on top of a MySQL database which has all the information of the user
    like name , email id , contact information ,country , their interest  and all.
     I could also have information about subscriptions if we have subscription based model.
   - Now it uses a Redis as a cache.Now what will happen is - a lot of times  a lot of other 
    services in the ecosystem will call user service to get the information about a particular user.
   - User Service could potentially call MySQL all the time for all the requests, but that's not 
    efficient.So Cache the user information where key will be user_id and value will be 
    payload of the user information.
   - When this will happen, a search service would call a user service to get user information 
    so that they can filter out certain results.So some search result would have age restrictions, 
    or  some search result would be applicable in only certain countries.
    So for all that information user service will become a source of truth.
   - Each time person tries to log in, we would want to store some information about the device , and 
    the geography that the person has come in from and we would be sending it to kafka for analytics
   - What kind of analytics can happen? 
   -  More than 40% of netflix users share credentials with other people.If we are building 
    subscription based model, we would probably do not want that to happen.But before 
      figuring out that it should happen or not , we need to figure out that it is happening.
   - And how could we figured it out -that if the same account is being logged in from a lot of devices
     and from different geographies,it probably means that either the person is traveling a lot or,
     credentials are shared with other.
   - Similarly, there could be an other kind of user profiling that could be done on top of this data.
    And this data will come through device finger printing via user service all the way to kafka.
   - Then analytics could be done on that data.
    
   - Home Screen - On home screen they should be able to search something.That is powered
    by Home Page Service and Search Service.
     Home Page Service is the one that gives out the data that would render as soon as 
     person has logged in - which is the first screen it sees.
   - Searching would be powered by search service.
   - Basis the result of these two services, we would probably want to do some analytics on top of it.
   - Let's say in youtube ,we see some categories.And video within those categories.
     and let's say, if our analytics say that a lot of people are actually going on that more videos
     and are not clicking on the one that are showing on home page.
   - That means there is something wrong on home page service and it is not returning the best
    possible result to the user and that needs some improvement.The same thing could be 
     said above search service.
   - This user activity Analytics Service which gets feeds from various actions done by users
     on the app or website or any client and it sends to the kafka and basis that , there 
     could be some kind of analytics that we could do , which will then be used to improve 
     the search results and the recommendation engine.
   - Let's just say person has done some search and they have got to a video and then they want 
    to play on it. So what they would do ? They would probably click on that  ,get to screen , 
     click on play button. and they expect screen to start playing.
   - User Device Playing Video - It basically make call to load balancer , to this host identity 
    service . Video from production house will be uploaded to a lot of CDNs.
   - For example - let's just say that we uploaded it into CDN in US and Germany.All of that 
    information about a video, and it's CDN, all of that lies within cassandra cluster 
     on which this Asset Service(discussed in previous section) sits.
   - This host identity service , it knows what video you want to play and where you are 
    coming from. It will query asset service to get me all the CDNs that are available 
     with this video and given the location of user and location of all the videos that are there,
     it will try to come up with one of the CDNs that is responsible to play this particular video.
     That's the main responsibility of this Host Identity service.
   - This service could return 2 types of CDNs. One -> main CDN which is basically repository 
    of all the videos that we have. There is another CDN we have , which is CDN optimized for 
     local views for a lack of better word.But it is basically a CDN, which is geography centric.
   - Suppose user from US requesting the video, he will be redirected to main CDN itself(which is in US).
    but let's say if user is from India.Normally Germany CDN is close by they would get
     the CDN of germany to talk to.  But for some reason we have enough analytics and we get to know 
     that people in India are watching a particular video a lot.we could host a CDN service in India
     and upload that video in that CDN.
   - Now all the users asking for that particular video from India would be given local CDN to talk to.
    because that help us save a lot of network traffic. Closer to server faster the response.
   - Now as client is playing a particular video , there are a lot of information that we can 
    capture about this interaction of a person viewing the video.
   -  One thing is - How good is video? Most of us don't really rate a video usually.Thumbs only 
    if it is too bad or too good.But capturing a rating about particular video is very important thing for a video. That can be used to improve search.  
   - Other thing is -    what length have people watched a video for.So, if a lot of people are closing 
    video in 10,20,30 seconds ,it's probably not that good.But if a lot of people are watching 
     more than 90% of video , they are kind of giving signal it is good video.
   - These kind of analytics can be done basis how people are watching the video.
    and All of that is done by Stream Stats Logger service, which basically gets ping 
     once in a while that person has watched this video till this point of time., and that again
     pushed to kafka.
   - And again can be used to do some analytics mainly to come up with a rating for a particular 
    video.
     
     

 - ####Remaining piece of Architecture

    - 



     

