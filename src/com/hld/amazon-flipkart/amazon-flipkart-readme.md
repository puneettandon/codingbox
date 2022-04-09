##Amazon Flipkart High Level Design

###Functional Requirements -
    1. People should be able to search for whatever product they want to buy
    2. We should able to tell them whether we can deliver it or not (At the page of search itself)
       And If you are delivering then when should we able to deliver it to you
    3. Should be concept of cart/wishlist
    4. Check out making payment and completing the order
    5. View Historical Orders

###Non Functional Requirements

    1. Low Latency
    2. High Availability
    3. High Consistency


    - Some of the components which are dealing with the payment and inventory counting, they need to be
    highly consistent at the cost of availability 
    - Components like search they need to be highly available , may be at cost of consistency at times.
    - And overall most of the user facing components should have a low latency

### Assumptions 
    - Components in Green - UI
    - Components in Blue - Service
    - Components in Red  - Databases/Clusters/
    - Components in Grey - Load Balancer - For Authorization and Authentication


### User Home Screen  and User Search Page
- It would by default have some recommendations based on past record of that user,
or in case of new user some general recommendations.
- In case of search page, it would be a text box where in user kept putting the text
and will give them the search results.


- So a company like Amazon would have various suppliers that they would have 
integrated with now.These suppliers would be managed by various services on the supplier 
  front. Abstracting out all of them as Inbound Service.

- ####InBound Service  
    - It basically talks to various supplier and get all the data.
Now let's say new item has come in. or Supplier is basically on-boarding a new item.
    - That information comes through a lot of services and through Inbound service
      into kafka.That is basically a supplier world coming into the whole search and user 
      side of things . 
    -   Now there are multiple consumers on that kafka, which will process that 
    particular piece of information to flow into the user world.
        

- ####Item Service
    - Will be consumer of Kafka. Listen to this kafka topic and what it does is
    it basically on board a new item.
    - Now it also is basically a source of truth for all items in the ecosystem.So it 
    will provide various APIs to get an item by item_id , add a new item , remove an item,
      update details of a particular item and it will also have an important API to bulk 
      Get a lot of items.So get a GET API with a lot of item IDs and it is in response it gives
      details about all of those items.
    - Now Item Service sits on top of MongoDB.Why do we need Mongo here?
     So item information is fundamentally very non-structured. Different item types 
      will have different attributes and all of that needs to be stored in a 
      queriable format.  
    - Now if we try to model that in a structured form into MySQL kind of database
    that will not be an optimal choice.So that's why we have used a Mongo.
    - To take an example, let's say if you look at the attributes of some products
    like a shirt, it would have size attribute, color attribute Like a large size
      t-shirt of red color. 
    - If you look at something like television , it will have a screen size ,saying 
    55 inch of TV with led display kind of thing.There could be other things like 
      bread with some type and weight lik 400gm.
    - So Clearly Non-Structured Data. So used MongoDB
    
        
- ####Search Consumer 
    - Consumer of Kafka.
    - Basically whenever a new item comes in, this search consumer is responsible for
    for making sure that item is now available for the users to query on.
    - So what it does is all the items that are coming in it basically reads through 
    all of those items.It puts that in a format that search system understands 
      and it stores it into its database.
    - Search uses a database called Elastic search, which is NoSQL , efficient at 
    doing text-based queries.Now this whole search will happen either on product name or 
      product description and maybe it will have some filters on the product attributes.

- ####Search Service   
    - On top of elastic search, there is something called as Search Service.This 
    search service is basically an interface that talks to the front end or any other 
      component that wants to search anything within the ecosystem.
    - It provides very kinds of APIs to filter products , to search by a particular 
    string or anything of that sort. And the contract between search service and 
      search consumers is fixed so both of them understand what is the type of data
      that is stored with elasticsearch.
    - That is the reason consumer is able to write it and the search service is able to 
    search for it. Now if a user wants to search something, there are two main things around it 
    - One is basically trying to figure out the right set of items that needs to 
    be displayed but there is also one important aspect that we should not show items
      that we cannot deliver to the customers 
    - So for example, if a customer is staying in a very remote location and if we are not 
    able to deliver big sized items like refrigrator to that pin code we should not 
      really show that search result to the user .because otherwise it's bad experience that he 
      will see the result but will not be able to order it.
      

- ####Serviceability and TAT(Turn Around Time ) Service
    - This basically first all of all tries to figure out that where exactly the product is  in what 
    all warehouses.
    - Now given one of those warehouses or some of those warehouses,
      it tries to see - do i have a way to deliver  products from this warehouse to the
      customer's pincode?   and If I have , then what kind of products can I carry on 
      on that route.Now certain routes can carry all kinds of products but 
      certain routes might not be able to carry big products or other kind of products.
    - so all of those filtering stays within the Serviceability and TAT service.
    - Now it also does one more thing that it tells you in how much time I will be 
    able to deliver . could in number of hours or days or weeks. (12 hours or 24 hours or  2 days etc)
    - Now if serviceability tells that I cannot deliver ,search will simply 
    filter those results and igore that and return the rest of the remaining things.
    
- Now search service might talk to user service. User service is basically a service that is 
    the source of truth for the user data and Search service can query user service
      to fetch some attributes of user probably a default address etc which can be passed as
    an argument to serviceability service to check whether I can deliver it or not.
  
- Search Service return the response to the user which can be rendered and the 
    people can see the result
  
- Now each time search happens , an event is basically put into kafka.
The reason - whenever somebody is searching for something they are basically 
  telling you intent to buy a kind of product.That's very good source for 
  building a recommendation.

    
    

      
      

    

