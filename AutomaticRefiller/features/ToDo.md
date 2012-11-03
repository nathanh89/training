This is an exercise to translate real-world objects into object oriented principles. 
Nathan noticed that in our environment there is an Odwalla cooler. 
He's noticed that it is capable of being turned on, turned off.
It can also have its door open, and door closed.
We've also noticed that the cooler has a capacity, which is defined as the total 
number of slots it has for bottles.

And then we started writing the program. And noticed a whole lot more the cooler should be able to do. This is what's still To-Do.

To-Do List 
<a href="/features/DONE.md">Done List</a>
/ BDD Record
<table>
	<thead>
		<tr>
		  <th>Feature</th>
		  <th>Story</th>
		  <th>Status</th>
		</tr>
	</thead>
	<tbody>
		<tr>
		  <td>Automatic Reorder!</td>
		  <td>
		    <ul>
		       <li> Given: A cooler with some stock</li>
		       <li> When: A bottle or bottles are removed</li>
		       <li> And: The stock % full reaches a lower limit threshold
		       <li> Then: The cooler should automatically place a new order to the BottleManufacturer</li>
		  </td>
		  <td>Never Stop Refactoring</td>
		</tr>
		<tr>
		  <td>Inventory Management</td>
		  <td>
		    <ul>
		       <li> Given: A cooler with some stock</li>
		       <li> When: A bottle or bottles are removed</li>
		       <li> And: The stock % full reaches a lower limit threshold
		       <li> Then: The cooler should automatically place a new order to the BottleManufacturer, via an inventory manager</li>
		  </td>
		  <td>Not Yet Implemented</td>
		</tr>
		</tbody>
	<tfoot>
	</tfoot>
</table>
------------------------
Coming up in the future: (Ideas for features and refactoring not fully fleshed out yet or just otherwise not added to the above feature list)


- SUPER EPIC WIN Feature: The cooler vetoes the door being open more than 10 degrees
- Abstract the Manufacturer class...then the order process could be valid for more than just bottles
- Refactor the tests with more consistent stock levels so you can avoid the duplication of having to add bottles to the cooler every time before a test, if at all possibl
- Factor out the Beverage from the Bottle.
- We should probably be able to use the cooler as something besides a Pez dispenser :D
- Remove Bottles by type
- Read about abstract classes, think about using interfaces and abstract classes to push some functionality out of cooler.