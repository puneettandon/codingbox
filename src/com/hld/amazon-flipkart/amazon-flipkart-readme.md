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

- ####Wishlist Service and Cart Service
    - So each user query goes into kafka, saying this userid searched for this particular product.
Now from search screen user could be able to wishlist a product or add it to cart
and buy it. All of those could be done using wishlist and cart service.
    - Wishlist service is the repository of all the wishlists in the ecosystem and 
    the cart service is the repository of all the carts in the ecosystem.
    - Carts are basically shopping bag, which when people put product into it and 
    then checkout.
    - Both services are built in exactly same way. They provide APIs to add a product into 
    user's cart or wishlist.Get a user's Cart or Wishlist or delete a particular 
      item from that.And they would have similar data model and they are both sitting on 
      their own MySql databases.
    - Keep both hardwares separate.Just in case, for example, wishlist size becomes too 
     big and it needs to scale out so we can scale this particular cluster accordingly.
    - But otherwise functionally both of them are totally same.   
   - Now each time, a person is putting a product into wishlist , they are again giving you signal .
    Each time they are adding something into their cart they are again giving a signal about their 
     preferences , things that they like that they want to buy and all of that .
     All of those could again be put into kafka for a very similar kind of analytics.
   - So from this kafka , there would be something like a spark streaming consumer.
    one of the very first thing that it does is - kind of come up with some kind 
     of reports on what products people are buying right now.Those would be things like
     coming up with report saying what was the most bought item in the last 30 minutes, or 
     what was the most wishlisted item in last 30 minutes, or in electronics category
     what which product is the most sought-after product.so all of those would 
     be inferred by this spark streaming. Other than that it also puts all 
     the data to hadoop saying this user has liked this product, this user
     has searched for this product anything that happens. On top of it, we
     could run various ML algorithms.Given a user and a certain kind of products that they
     like, we could be able to figure of two kinds of information.
     - one is what other products this user might like
     - Other is how similar is this user to other users and based on products 
    that others users have already purchased we would recommend a particular product
       product to the user. 
       
- ####Recommendation Service
    - So all of those is calculated by this spark cluster on top of which we can ran
    various ML jobs to come up with this data. once we calculate those recommendations
       this spark cluster basically talks to something called Recommendation Service.
     - which is basically the repository of all the recommendations, and it has 
    various kinds of recommendations.
     -  One is given a userId, if you store general recommendations saying what 
    are the most recommended products for this user. and it will also store the 
        same information for each category.Saying for electronics for this user 
        these are the recommendations.For the food kind of a thing, for this user,
        these are the recommendations.So when a person is actually on home page they 
        will first see all in just general recommendations and if they navigate into a 
        particular category they will see the specific recommendations which are specific 
        to the category. 
       
- #### User Service
    - User Service - repository of all the users.It provides various API is to 
    GET details of a user, update details of user.
    - Sits on top of MySQL and redis cache on top of it.
    - Search service wants to get details of user, it will first query redis to get 
    details of the user.If not found , it will query MySQL, get the user information 
      store it in redis , and return it back.
      
- #### Logistic Service and Warehouse Service
    - Normally these two components come in once the order is placed.But in this 
    scenario this serviceability service might query either of these two services not 
      a runtime , but before caching  the information to fetch various attributes.
      So for example it might query this warehouse service to get a repository of all 
      items that are in the warehouse or it might query Logistic service to get 
      details of all the pin codes that are existing or may be details about or the 
      courier partners that work in a particular locality and with all of that information 
      this serviceability service will basically create a graph kind of thing 
      saying what is the shortest path to go  from point A to point B and in how 
      much time can I get there.(For more details see implementation of Google Maps)
    - This does not really do any calculation at runtime. You store all the 
    information in a cache and whenever anybody queries , it will query the cache and 
      return the results from cache itself, and no runtime calculations because those 
      would be slow.
    - It will precalculate all possible requests that can come to it.Basically if there 
    are N pincodes and M warehouses , it will  do M * N and calculate all possible  combinations
      of requests that can come to the service, and store it in a cache. 
      

- ### What happens user place an order?


       
    
    

      
      

    

