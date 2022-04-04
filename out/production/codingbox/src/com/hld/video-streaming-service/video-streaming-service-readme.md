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
     
              