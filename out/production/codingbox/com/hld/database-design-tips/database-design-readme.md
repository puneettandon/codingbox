# Database Design Readme

### Important Links 
- https://db-engines.com/en/system/Cassandra%3BCouchbase%3BRedis
- https://denuwanhimangahettiarachchi.medium.com/a-comprehensive-guide-to-distributed-caching-471a0319ed35


How Good your System Design is and how well it can scale depends very much on the choice of Database.

Generally Databases don't impact your functional requirements.
But the Non-Functional Requirements are the one that impacted by the choice of database.

So, let just say you have certain query patterns, or certain kind of data structure or certain 
kind of scale to handle, there are different set of databases optimized for different kinds
of things.So based on the choice of database, it would impact how well your design can scale upto 
the requirements that are given as part of NFRs.

Normally the choice of database depends on a couple of factors.

   1.  Structure of the data that we have
        Whether it is very structured data or totally unstructured
       
   2. Query Pattern that we have 

   3. Amount of scale that we need to handle

    
-- -
    

Solutions
1. ##Caching Solution
   
     + Different use cases of caching
        1. Let's say you are querying a database, and you don't want to query a database
            a lot of times you could cache the value in a cache.
           
        2. Alternatively, if you are making a remote call to different service and that is 
            having a high enough latency, you might want to cache the response of that system
           locally in caching solution.

        

  In Caching basically we have key and value.
  - Key normally is whatever your where clause is in the query 
              or whatever you query param or request params are when making API calls
    
 - Value is basically the response that you are expecting from other system.

 Most Common Solutions are 
 - Redis (Recommended - Most Stable , Used by Big companies)
- Memcache
- Hazelcast

-- -
   
- ##Blob/File Storage Options ->  s3  + CDN
   - Suppose we are designing a system like amazon where we are having various products
    that we are selling. Now the sellers would be uploading product images, may be products 
    videos.
   - You need data store to store these images and videos.
    Sly, could build system like Netflix where we have videos.
   
    - So wherever we have the  image/video kind of thing there we will use something called 
      as Blob storage. These are not really databases
        -   ###Amazon S3 good option for images/videos as a datastore.
        -   Along with S3 can use CDN.(Content Delivery Network)
        -   CDN is generally used for distributing the same image geographically in lot of 
            locations.
        -  Product image stored in S3 as primary datasource and there are a lot of people 
            from a globe who are accessing that product.So you might want to distribute that 
           image into various servers across the globe so that individual people can query
           them in a much faster way as compared to querying  s3 which is located in a couple of 
           locations.
           

- ##Searching Capabilities
  
    - If you are building a product like Amazon and you need to provide text searcing 
      capabilities on various products.
    - Search Capability on text of title and description. 
    - Sly for netflix to search on movies name, title,genres,cast etc
    - Or Uber or Google map where you want to provide text searching capabilities with support 
      for fuzzy search
      - ####Text Search Engine --> Elastic Search  and Solr
        - These are not database these are search engines.
        - Provides good availability and redundancy but potentially data could be lost
        - Should not keep any of these as your primary source of truth.
        -  Load data into either of these systems(elastic/solr) from primary data source to provide the searching capabilities.
        

- ##Metrics Kind of Data
    - If you are building a system like Graphite , Grafana or Prometheus which is basically
      an application metrics tracking system. 
    - Suppose a lot of applications are pushing metrics related to their throughput, 
      their CPU utilization, their latency and all of that.And you want to build a 
      system to support that.
    - ###Time Series Database --> Influx DB, Open TSDB
      - Time Series Database as an extension of relation database but with not all 
        the functionalities and certain additional functionalities.
      - Regular Relation databases have the ability to update a lot of records and ability 
        to query random records
      - But in metrics monitoring  kind of system you would never do random updates.
        Always do sequential updates in append-only mode.
      - First entry time T1 Second entry time T2 (T2 > T1). Appended only write mode.
      - Also the read queries we do are kind of bulk read with the time range.
            - Query for last few minutes of data or hours of data.
      - But no random update or read.
      - Time series database are optimized for this kind of query patterns and input patterns.

- ##Dataware house / Big Data
    - When you have a lot of information, and you want to store all of that information 
      of company in a certain kind of datastore for a various kind of analytics requirements.
    - Ex- amazon or uber or any system design where you want to provide analytics on all the 
       transactions. Provide analytics like how many orders I am having , what geographies 
       are giving what revenues, which is most sought after item
    -  Not used for transaction purpose but for offline reporting.
    - ###Dataware house --> Hadoop
        - Put in data from various transactional systems 
        - Then build system to generate reporting kind of thing on top of that data.
    
 
-  ##Relational vs Non-Relational Database
    
    - Structure of the data
    - Structured Information - Relational Database - Information can be easily modeled in form 
      of tables and tables would have rows and columns.
    - For example - user information - like user profile on a social network - it would have 
      name ,email, address,city, phone number , standard information that each user will have.
    - Refer flow chart to decide which database to choose relational vs non -relational db.  
    - Relational Data - Needs ACID Then Oracle,MySQL,Posgres,SQL Server
    - Relational Data - No ACID Guarantee - Choose any relational/non-relational (Structured data
       can be easily mapped to non-structured data) 
    - Unstructured data - More Data type -- More queries - 
      Catalog Type of System for an e-commerce platform which has information
      of all the items. Use Document DB - Elastic Search and Solr also cases of Document DB.
    - Data not relational - don't have complex queries  still use Document DB.
    - UnStructured data - finite queries - Ever increasing data like Uber - all the drivers of 
      Uber are continuously sending the location pings. - Columnar DB - Cassandra, HBase
    - Scenario 1 
      - RDBMS - can use  for Inventory Management system of Amazon.    
      - But  ever-increasing data  - number of orders additive  each day
      - So fits in Cassandra DB model
      - you can use combination of both Mysql and cassandra database.
      - RDBMS for storing data about the orders it has just placed and not yet deliver to the customer
      - Once delivered can remove from RDBMS and put it into Cassandra as a permanent store.
    - Scenario 2
      - For Amazon - want to build reporting kind of thing  which lets you query something
        like get me all the user who have bought sugar in last five days.
        - Can use combination of all three type of DB - mongo,cassandra and relational

      
    
 
   



