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
     
     

 - ####A remaining piece of Architecture

    - In previous two sections, we had put in a lot of events into kafka of various types.
    How each of those events is helping us and what information can we extract 
      out of it and how it will help us to enhance the whole system.
    - One of the events that Asset Service publishes is the on-boarding of new video.
    Means the video is ready for consumers to see it.And how would consumers 
      would see it?Only when it pops up either in their home page or search results.
    - So we need to make this video available for searches , so that the event that was 
    pushed to kafka would have a lot of information about the whole movie like 
      cast, crew, description and some attributes.
    - So there will search consumer service which will be listening to topic 
    where that event was published.It will pick up that event, it will convert 
      that event in the format that it wants to. So think of it like it can discard 
      some of the fields, it can create some of the new fields also. 
    - So let's say if it has a particular tag, which might mean that we need to do 
    an age filter, it might add flag into that json saying I want to do age filtering.
      And post all of the data massaging that it will put it its data store.
    - We are using elastic search here. why elasticsearch ? Mainly because we need 
    to do fuzzy search here.(that will be taken care by ES)
    - On the otherside, when a user is actually trying to search for movie, 
    he will come to home screen, search for something in searchbox, it comes 
      through this Load balancer to search service. The schema is shared between
      search service and search consumer. So both of them understands what data is 
      within ES and how it is maintained.
    - Let's say Search Service gets some response from ES and it gets to know that 
    there is a particular flag which says that I need to do an age level filtering on the user
      who's searching for, it will query user service and get the information of the 
      particular user. and basis the information it gets from user service , it might 
      choose to show that result or ignore that result.
     - At the end of it after doing this whole data massaging , it can respond back to the 
    UI with search results.
     - All the components are horizontally scalable.If there is traffic increasing 
    in any of the component, we just need to increase the number of machines into that 
       particular service or that particular data store.
    - Content Processor - It has a component called Content Tagger.All the chunks 
    went through Content Tagger and it had the logic of parsing the whole video and 
      extracting some tags out of it.
    - Now let's say just there are thousands of chunks which are individually being 
    processed and all of those information about tags in each chunk is being put to kafka.
    -  Now let's try to understand how would that get aggregated and how would that be stored back again.
    Assuming that information again comes to kafka. There will be spark streaming cluster 
       running which will be listening on to the topic where all the tags related 
       information is being passed through.That information would have movie_id, 
       tag_name and chunk_id and some additional information like how many chunks are there
       so that it is able to identify that everything is processed.
     - Now what spark streaming cluster  will do is - it will keep polling  all of the 
    information and may be it will look at previous one hour of data or half an hour data
       or some time frame and do a simple reduce by key where a key could be 
       your movie_id.What essentially it does is, think of it in the SQL world as 
       something like Group by movie_id and count(tag) and group by tag as well.
      so it gets to know that for a movie, what all tags were present and how many times each
       tag came in.And then it could do Order By Count(*) and Select Top 10 or Top 5 
       or something of that sort . So this cluster , just in itself , should be 
       good enough to identify that - given a movie and all the events about all the chunks 
       and their tags , which are top 5 or top 10 in that movie.
       It could send back the same information to kafka, which could then be read by Asset Service 
       which could then be persisted back in the Cassandra data store that it uses.
     - Why using Cassandra ?   Cassandra is a database that handles massive amounts of read and writes 
    and that is the way it is being designed.Cassandra follows no master kind of strategy.
       so it has a ring of lot of nodes where in each node stores some part of data
       and each node knows that what particular data is residing in which node.
       Now assuming that kind of structure , if we want to handle more amount of data , all 
       we need to do is to add more nodes in cassandra cluster and it should be able to 
       handle more data.
     - What is the volume of data we have ? By some metrics , Youtube for example - 
    has bit of more than a billion videos.In our case , we have not only videos, 
       but also information about chunks.Cassandra should be able to handle that .
     - Good and bad about cassandra - Good when you have small number of queries 
    and query is by something called partition key.If we store the data in a format 
       where this key is the partition key then these are very efficient queries 
       in world of cassasndra. 
       Bad at when you want to do random queries.so if you want to do LIKE  search 
       in description or if you want to search by a crew name , or any random thing 
      - We are not using cassandra for those kind of searches.Those searches are 
    powered by search service which sits on top of elastic search .  Cassandra is 
        bad at aggregation. For that we have hadoop cluster.
      - Content Tagger part of workflow engine - other than tagging it was creating 
    thumbnail of images , one of them will possibly be chosen as best thumbnail.
        So, how does that work out?
      - Assuming all of those information again comes to kafka saying for a
    movie_id, a lot of thumbnails will be generated . They will be generated for 
        individual pieces and then that could be aggregated.
      - Asssuming of that information comes to this spark cluster and then it gets
    stored into hadoop cluster. 
      - When search results are shown to the user , randomly some of the thumbnails 
    would be shown to the users.
      - We had home screen service, search service and analytics service.Analytics 
    service was sending out various events into kafka about the performance of 
        search results and results of home page service.This could also bring us 
        information about which thumbnail works best.
      - So, let's say there are particular thumbnails on which we get a lot of clicks
    and there are certain thumbnails on which we do not get a lot of clicks. Both these
        information - of all thumbnails and the performance of each thumbnail would be 
        joined together to figure out which thumbnail is the best one for a movie
        and that thumbnail should be shown .
      - I do have that data in hadoop, of all thumbnails, we will put data of analytics 
    service also in hadoop saying I have a log of which thumbnail got what kind of 
        views for what kind of users.
        Now instead of just finding one best thumbnail , we could run our machine
        learning model on this, which kind of tells us that for which kind of user 
        which thumbnail works the best. Now we have the best thumbnails. 
      - we probably have a lot of best thumbnails for a kind of users. Now, when 
    search service queries, it kind of tries to figure out what type of user  I have and 
        basis that , it can select thumbnail
      - Now how do we do user tagging,this could be one good use case of a machine
    learning model that can run out of this Apache Spark Cluster.
      - We were also putting a lot of information into kafka about the videos that a
    person is watching and what percentage of video they are watching.
        If person is watching for very short time, we can safely assume that
        the person does not like the video. or if person is watching for long time
        we can assume that the person is liking the video.
     - so because we don't have functional requirement of adding a rating to a video,
    therefore we don't have this information in a very first hand model,  but we 
       can use this time duration as a proxy for rating. 
       Let's say that we convert this into a numerical value of 1-5 and try to give
       a rating to a video that a person would have potentially given basis the time they
       have watched.Think of it - for a lot of videos, for a lot of users, there are too 
       many users giving rating to too many videos. All of this information also comes
       into this kafka.
     - Now what could we do? firstly, we could just simply classify users into groups.
    we can say if a person is liking a certain kinds of  video , they possibly fall 
       into some category or we like some genre video. Once we have this kind of information
       we can store this information into cassandra then this information could be used for 
       other things like recommendations.
     - The other input would be the searches that the user is doing. So if user is 
     searching for let's say back to the future, the person is telling you that he wants
       to see that movie whether you have that movie in your datastore or not , but it is still good 
       to know what that movie is all about because that will give you enough 
       information about the user.All of these can also be part of user profiling information.
       Basis these lots of data points , we should be able to classify users into a couple of 
       genres that they like.
     - We could say we if person likes action movies and let's say the best movie in action 
    is for example mission impossible - then person is likely to watch mission impossible 
       because they like action movies.This becomes recommendation .So same data
       comes to kafka flows into your spark streaming , get stored into hadoop, there is 
       some analytics done on top of it, some classification ( based on machine learing model)
        So we can also precalculate what kind of movie user is gonna watch.So when 
       building home page we can put that movie.
    - 
    
    - Another event coming into kafka was geo-tagging and device finger printing of 
    users at the time of login.That could be handled in similar model.Put that into 
      spark streaming,put that into Hadoop, do a group by kindo of thing by user_id , try
      to figure out how many unique logins have come in for users, if you want to , kind of bifurcate by
      the kind of devices that the user has logged in through, or the kind of geographies 
      that the person has done it from.Just put that in report kind of thing 
      and look at it.
      May be we will get to know people are travelling and because of that, the 
      data is actually that great or may be we will get to know some of users who are 
      actually spreading out their credentials.
      
    - Traffic Predictor - We have two kinds of CDNs - one is main cdn, which has all 
    of our data , which is in very few locations across the globe and Then we have 
      local CDNs which are sitting in each country or may be multiple such CDNs
      within the country, which are catching the data to improve the experience of users 
      within that country.There are multiple ways to load that data into local CDN.
      One is - if somebody is watching the video, you request from main CDN and also put
      in the local CDN.But that's probably ok but not good
    - What if you would predict that what are the things that people are going to 
    watch tomorrow? If let's say you come up with a list of videos that people will 
      watch on the following day, you could actually cache it beforehand.
    and by doing that you could actually save a lot of bandwidth. and the most 
      important thing, by caching you will get is that , you will be able to achieve 
      your NFRs.Because if now latency is reducing , you will have less probability of 
      of buffering and thereby better user experience.
     - how would that work? Again it would be a machine learning model that uses all of the 
    usuage data like what videos people are watching and use that to predict what possibly people 
       will watch. But one more key data input into that would be new launch.
       Let's say new TV series is going to be launched tommorrow. You know for a
       fact that people in lot of geographies would watch that .Let's say series is 
       in German , So people in Germany would be watching it but probably not people in 
       India. So it make sense to put it in the local CDN only in Germany.
       So all of these data points could be used and could be input to the 
       traffic predictor, which again would run on the same data that sits 
       within the same hadoop cluster and it should be able to give out information 
       saying for tommorrow, you need to have videos in these CDNs .
       What it will give is - for each CDN what all videos need to come (from source of truth)
    - Overall once it calculates all the videos that are required to be present in each CDN, it
    put all event in kafka saying this is my report of what I belive is required 
      Go make sure it is available , whoever is responsible . 
     - There is something called CDN writer - it basically looks at those events 
    and fetches all the videos and puts them in the right place.
       It could fetch from S3 which source of truth or it could fetch from main 
       CDN and put this in required CDNs.
     - How that could be done efficiently
        LC1  ->   C1, C2  C3 C4 C5 C6 C7
       
 
      
    

    



     

