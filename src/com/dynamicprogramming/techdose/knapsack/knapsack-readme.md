What is Knapsack problem?

 Knapsack means a bag.
 
 - Given: Items with price and weight
 - Goal: Fill the bag to get max profit
 - Input: Given items with weight & profit
 
 
wt :    w1  w2  w3  ......... wn

profit: p1  p2  p3  ......... pn

Bag w


Example 

3  2  4  - wt(Kg)

8  5  9  - profit 

7  - Bag 


Note : How you fill the bag is defined by knapsack type


Conditions:

    i) The Capacity of bag does not exceed 
    ii) Maximize the profit


Knapsack Classification - 1:

- 0/1 -  0  -> item included 1-> item excluded   ---> can not have multiple instance of same item. 
  Either 0 or 1 instance.
- Bounded  - Include an item - 1,2,3....N --> can have multiple instances.N max instances.
  cannot be infinity.
- Unbounded - If no such bounds as above, then it is unbounded.


Knapsack Classification - 2:

- Fractional(greedy) - can pick part of an item. Example - I -> 3 kg so 1/3 can be included.
  Then profit will be 1/3.
- Integer - can't pick part of an item.Example - I -> 3 kg .If 2 kg space left cannot be included then.
  Can include entirely or completely exclude it.
  


#### 0/1 Knapsack 
INPUT: Items with wt. and profit and a bag(wt = w)
GOAL: Maximize the profit by picking elements and fill bag.
CONSTRAINT: 
 - Each item can be picked once.We have the choice to either pick or reject on.
 - We can't pick more than size of knapsack.

wt. ->     3   4   1
profit ->  5   6   2
bag -> 6 

max profit with  (4,1)  = 8 as only one instance can be included of each.


#### Fractional & Integer Knapsack 

wt(kg)  ---> 3  4  2 

profit  ---> 5  6  4 

Rate ->    5/3(1.67)   6/4(1.5)   4/2(2)



