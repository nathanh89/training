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
		  <td>Toggle Power</td>
		  <td>
		    <ul>
		       <li> Given: I have a cooler </li>
		       <li> And: It is off </li>
		       <li> When: I want toggle the power state </li>
		       <li> Then: The cooler should be on </li>
		    </ul>
		  </td>
		  <td>DONE</td>
		</tr>
		<tr>
		  <td>Operate Door</td>
		  <td>
		    <ul>
		       <li> Given: I have a cooler </li>
		       <li> And: The door is closed </li>
		       <li> When: I want to open the door </li>
		       <li> Then: The door should be open </li>
		    </ul>
		  </td>
		  <td>DONE</td>
		</tr>
		<tr>
		  <td>Add Bottles</td>
		  <td>
		    <ul>
		       <li> Given: I have a cooler </li>
		       <li> And: I want to manually add bottles to it </li>
		       <li> When: I add the bottles to the cooler </li>
		       <li> Then: The bottles should be present </li>
		       <li> Example: I have a cooler with 10 Monsters. When I add 10 more, there should be 20 Monsters total.
		    </ul>
		  </td>
		  <td>DONE</td>
		</tr>
		<tr>
		  <td>Remove Bottles</td>
		  <td>
		    <ul>
		       <li> Given: I have a cooler stocked with bottles</li>
		       <li> And: I want to manually remove bottles from it </li>
		       <li> When: I remove the bottles from the cooler </li>
		       <li> Then: The removed bottles should not be present </li>
		       <li> Example: I have a cooler with 10 Monsters and I remove 3, only 7 should still be present </li>
		    </ul>
		  </td>
		  <td>DONE</td>
		</tr>
		<tr>
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
		</tr>
		<tr>
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
		</tr>
		<tr>
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
		</tr>
		<tr>
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
		</tr>
		<tr>
		  <td>Calculate how full the cooler is, %</td>
		  <td>
		    <ul>
		       <li> Given: A cooler with some stock</li>
		       <li> When: I ask how full the cooler is</li>
		       <li> Then: I should get the correct % of capacity being used by bottles</li>
		       <li> Example: If I have a cooler with a physical capacity of 37 bottles, and I have 10 Monsters and 15 Rockstars in the cooler, when I ask how full the cooler is, I should get 68%</li>
		  </td>
		  <td>DONE</td>
		</tr>
		<tr>
		  <td>Set Beverage Price at Cooler</td>
		  <td>
		    <ul>
		       <li> Given: A cooler with some stock</li>
		       <li> When: I want to set the price for a beverage</li>
		       <li> Then: That price should be applied to all beverages of that type</li>
		       <li> Example: If I have a cooler with 10 Monsters and 15 Rockstars, I should be able to set the prices at 3.95 and 2.95, respectively</li>
		  </td>
		  <td>DONE</td>
		</tr>
		<tr>
		  <td>Calculate Total Stock Value</td>
		  <td>
		    <ul>
		       <li> Given: A cooler with some stock</li>
		       <li> And: The prices have been set for the beverages in the cooler</li>
		       <li> When: I want to find the value of the current stock</li>
		       <li> Then: I should get the correct amount, the sum of all the individual bottle's prices in the cooler</li>
		       <li> Example: If I have a cooler with 10 Monsters and 15 Rockstars priced at $3.95 and $2.95, respectively, when I ask for the Total Stock Value, it should be 83.75</li>
		  </td>
		  <td>DONE</td>
		</tr>
		<tr>
		  <td>Calculate Stock Value For a Beverage</td>
		  <td>
		    <ul>
		       <li> Given: A cooler with some stock</li>
		       <li> And: The prices have been set for the beverages in the cooler</li>
		       <li> When: I want to find the value of a particular beverage's current stock</li>
		       <li> Then: I should get the correct amount</li>
		       <li> Example: If I have a cooler with 10 Monsters and 15 Rockstars priced at $3.95 and $2.95, respectively, when I ask for the value of the Monsters, it should be 39.50, and for the Rockstars it should be 44.25</li>
		  </td>
		  <td>DONE</td>
		</tr>
		<tr>
		  <td>BottleManufacturer Fulfills Orders</td>
		  <td>
		    <ul>
		       <li> Given: A cooler with some stock</li>
		       <li> When: I want to place an order for additional stock</li>
		       <li> Then: The responsibility for fulfilling that order should lie with the BottleManufacturer</li>
		  </td>
		  <td>DONE</td>
		</tr>
		<tr>
		  <td>Set Cooler's Desired Minimum Stock for a Beverage</td>
		  <td>
		    <ul>
		       <li> Given: A cooler</li>
		       <li> When: I would like to define a lower stock threshold for a beverage</li>
		       <li> Then: That threshold should be set correctly</li>
		  </td>
		  <td>DONE</td>
		</tr>
		<tr>
		  <td>Cooler can send completed orders to BottleManufacturer</td>
		  <td>
		    <ul>
		       <li> Given: A cooler in need of some stock</li>
		       <li> When: I create an order for additional stock</li>
		       <li> Then: The order can be sent to BottleManufacturer</li>
		  </td>
		  <td>DONE</td>
		</tr>
	</tbody>
</table>
