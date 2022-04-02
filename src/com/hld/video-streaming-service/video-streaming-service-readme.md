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
