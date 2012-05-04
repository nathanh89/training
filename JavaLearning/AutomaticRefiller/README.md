This is an exercise to translate real-world objects into object oriented principles. 
Nathan noticed that in our environment there is an Odwalla cooler. 
He's noticed that it is capable of being turned on, turned off.
It can also have its door open, and door closed.
We've also noticed that the cooler has a capacity, which is defined as the total 
number of slots it has for bottles.


Feature: We can turn the cooler on
Scenario:
As a business owner who wants to keep my things cold, I require a cooler.
Sometimes I would like to turn the cooler on, other times I would like to turn it off.

To-Do List / BDD Record
<table>
	<thead>
		<tr>
		  <th>Feature</th>
		  <th>Story</th>
		  <th>Status</th>
		</tr>
	</thead>
	<tbody>
		<td>Toggle Power</td>
		<td>
		  <ul>
		     <li> Given: I have a cooler </li>
		     <li> And: It is off </li>
		     <li> When: I want toggle the power state </li>
		     <li> Then: The cooler should be on </li>
		</td>
		<td>DONE</td>
	</tbody>
	<tbody>
		<td>Operate Door</td>
		<td>
		  <ul>
		     <li> Given: I have a cooler </li>
		     <li> And: The door is closed </li>
		     <li> When: I want to open the door </li>
		     <li> Then: The door should be open </li>
		</td>
		<td>DONE</td>
	</tbody>
	<tbody>
		<td>Add Bottles</td>
		<td>
		  <ul>
		     <li> Given: I have a cooler </li>
		     <li> And: I want to manually add bottles to it </li>
		     <li> When: I add the bottles to the cooler </li>
		     <li> Then: The bottles should be present </li>
		     <li> Example: I have a cooler with 10 Monsters. When I add 10 more, there should be 20 Monsters total.
		</td>
		<td>DONE</td>
	</tbody>
	<tbody>
		<td>Remove Bottles</td>
		<td>
		  <ul>
		     <li> Given: I have a cooler stocked with bottles</li>
		     <li> And: I want to manually remove bottles from it </li>
		     <li> When: I remove the bottles from the cooler </li>
		     <li> Then: The removed bottles should not be present </li>
		     <li> Example: I have a cooler with 10 Monsters and I remove 3, only 7 should still be present </li>
		</td>
		<td>DONE</td>
	</tbody>
	<tbody>
		<td>Get Total Bottle Count</td>
		<td>
		  <ul>
		     <li> Given: I have a cooler stocked with bottles</li>
		     <li> And: I want to know how many bottles are in the cooler </li>
		     <li> When: I ask for the total number of bottles </li>
		     <li> Then: The correct amount should be given </li>
		     <li> Example: I have a cooler with 10 Monsters and 15 Rockstars, when I ask for the total bottle count, I should get 25 </li>
		</td>
		<td>DONE</td>
	</tbody>
	<tbody>
		<td>Get Bottle Count by Beverage</td>
		<td>
		  <ul>
		     <li> Given: I have a cooler stocked with bottles</li>
		     <li> And: I want to know how many bottles are in the cooler for a specific beverage</li>
		     <li> When: I ask how many bottles there are of that particular beverage in the cooler</li>
		     <li> Then: The correct amount should be given</li>
		     <li> Example: I have a cooler with 10 Monsters and 15 Rockstars. If I ask how many Rockstars there are, I should get 15
		</td>
		<td>DONE</td>
	</tbody>
	<tbody>
		<td>Order Bottles for Cooler Manually</td>
		<td>
		  <ul>
		     <li> Given: I have a cooler</li>
		     <li> And: I want to order bottles to be added to the cooler's stock</li>
		     <li> When: I place an order for bottles </li>
		     <li> Then: The bottles should be added to the cooler's stock</li>
		     <li> Example: I have a cooler with 10 Monsters and 15 Rockstars. After I order 10 more Monsters and 15 more Rockstars, I should have a total bottle count of 50, consisting of 20 Monsters and 30 Rockstars
		</td>
		<td>Implemented, test needs refactoring for clarity</td>
	</tbody>
	<tbody>
		<td>Get the Cooler's Capacity</td>
		<td>
		  <ul>
		     <li> Given: I have a new cooler</li>
		     <li> And: I want to check what it's capacity for holding bottles is</li>
		     <li> When: I ask how many bottles the cooler can hold</li>
		     <li> Then: It should return the correct physical capacity of bottles it can hold</li>
		     <li> Example: I have a new cooler that should hold 100 bottles. Upon asking it for capacity, I should confirm that it can indeed hold 100 bottles</li>
		</td>
		<td>DONE</td>
	</tbody>
	<tbody>
		<td>Set the Cooler's Custom Capacity (Desired Maximum Stock)</td>
		<td>
		  <ul>
		     <li> Given: I have a cooler</li>
		     <li> And: I don't want to use it's full physical capacity for stock</li>
		     <li> When: I define a custom capacity for the cooler</li>
		     <li> Then: I should be able to confirm the capacity is set correctly</li>
		     <li> Example: I have a cooler with a maximum physical capacity of 100 bottles. However, I want to keep my stock level at or below 50. After I set the custom capacity to 50, when I ask the cooler how many bottles it is able to hold, rather than returning what it can physically hold, 100, it should tell me it can only hold 50. </li>
		</td>
		<td>Implemented, need to check for possible refactoring after implementing a cooler constructor for potentially improved clarity</td>
	</tbody>
	<tbody>
		<td>Veto Invalid Custom Capacity</td>
		<td>
		  <ul>
		     <li> Given: I have a cooler</li>
		     <li> And: I don't want to use it's full physical capacity for stock</li>
		     <li> When: I define a custom capacity for the cooler that is greater than what it can physically hold</li>
		     <li> Then: I should be unable to the set the capacity to that level</li>
		     <li> Example: I have a cooler that can physically hold 100 bottles. If I try to set the custom capacity to 150 bottles, the cooler should spit in my face. Figuratively. It should reject the capacity setting.
		</td>
		<td>DONE</td>
	</tbody>
	<tbody>
		<td>Create a Cooler with Logical Predefined Characteristics</td>
		<td>
		  <ul>
		     <li> Given: I am a business owner, and I want to have a cooler</li>
		     <li> When: I acquire the cooler</li>
		     <li> Then: That cooler should come with certain predefined characteristics, specifically physical capacity, and the power state should be off initially, as well as the door closed. (Just like the state it would be in immediately after delivery from a potential cooler manufacturer)</li>
		</td>
		<td>Not Yet Implemented</td>
	</tbody>
</table>

-----------------------------------------DONE
Feature: We an calculate how full the cooler is
Given: A cooler with a specified capacity and some stock
When: I want to know how full the cooler is
Then: I should be able to get the percentage of capacity used

-----------------------------------------DONE
Feature: We need the ability to set the retail price of a beverage in the cooler. It does not make
sense to pass that into the order from the manufacturer, as they do not set the final sell price.
The ability to set retail price needs to be independent of the ordering process.
Given: A cooler with some stock
When: I want to set the price of a particular beverage type
Then: The price will be applied to all beverages of that type

-----------------------------------------DONE
Feature: Know the value of the total stock inside of the cooler
Given: One bottle of Monster is worth 3.95, and one bottle of rockstar is worth 2.95
When: Asked for the value of the bottles in the cooler
Then: The correct value should be given

-----------------------------------------DONE
Feature: Know the value of the stock in the cooler, but by type
Given: A cooler with some stock
When: Asked for the stock value of a particular beverage type
Then: The correct amount should be given

-----------------------------------------DONE
Feature: Simplify the ordering process by allowing the cooler to place orders to the manufacturer directly
Given: An empty cooler
When: Placing an order for bottles directly from the cooler
Then: The bottles will be in the cooler

-----------------------------------------Needs refacor, in a mintue
Feature: The cooler should not be able to order enough bottles to have more stock than capacity
Given: A cooler with a set capacity
And: some stock
When: Placing an order for more bottles that will cause the cooler to be over capacity
Then: The order should be rejected

-----------------------------------------DONE
Feature: We need to be able to create order objects for placing an order with the manufacturer
Given:I need to place an order
When:I specify what is needed on an order
Then: The order contains what I needed

-----------------------------------------DONE
Feature: Orders should be able to contain multiple beverage requests
When: I place an order for 5 mountain dews and 10 blue machines
Then: The order should contain 5 mountain dews and 10 blue machines

-----------------------------------------DONE
Feature: BottleManufacturers should be able to fulfill orders
When: I give a Bottle Manufacturer an order for 5 mountain dews and 10 blue machines
Then: It should give me back 15 bottles, 5 of which are mountain dew and 10 of which are blue machine

-----------------------------------------
Feature: The cooler should have a constructor, because a cooler CANNOT exist with no capacity, so capacity should be defined at the set up of the cooler.
Given:I want to have a cooler
When: I create a cooler
Then: It should have a defined capacity
(but keep the feature where you can set capacity, just modify it so it cannot be set to be higher than the capacity defined at the cooler's creation)

Feature: The cooler should store information for the bottles removed every time a bottle is removed
Given: A cooler with some stock
When:I remove a bottle
Then: The cooler stores that bottle information in a list
(So that when the cooler gets say, 10 percent capacity, it knows what to reorder. Not quite sure how to write this out yet, but, say you have a cooler with a capacity of 100. You order 40 OJs, 40 milks, and 20 gatorades. You want it to reorder when it reaches 50 percent capacity. Well, there are a lot of ways for it to reach 50 percent capacity. You could sell all the milk, and 10 each of OJ and gatorade, for example. Or...well, you get it, right? The other, messier way to do it would be set stock levels, and compare whats in the cooler to those stock levels, ugh, bloated. Eff that. By storing a list of what's been removed from the cooler will know exactly what to reorder when the capacity threshhold is reached)

Ahead: allow the owner to adjust the levels the cooler fills too, somehow, without breaking the elegance of that above method.

EPIC WIN Feature: The cooler can automatically re-order to given stock levels for each beverage type when capacity falls below a threshold
Given: A cooler with some stock
When: The cooler falls below a set capacity threshold for any particular beverage type
Then: A new order is placed to add bottles to the cooler

SUPER EPIC WIN Feature: The cooler vetoes the door being open more than 10 degrees 

Make it so when finding price by type, the loop stops when the first element meeting the condition of bevarage name is hit and returns price.

Explore the concept of backstock, and how that might affect the ordering/stocking process. LATER.
