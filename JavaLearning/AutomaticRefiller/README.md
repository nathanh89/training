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

-----------------------------------------DONE
Given: I have a cooler
And: It is off
When: I want toggle the power state
Then: The cooler should be on

-----------------------------------------DONE
Feature: We can turn the cooler off
Given: I have a cooler
And: It is on
When:I want to toggle the power state
Then: The cooler should be off

-----------------------------------------DONE
Feature: We can open the door
Given: I have a cooler
And: The door is closed
When: I want to open the door
Then: The door should be open

-----------------------------------------DONE
Feature:We can close the door
Given: I have a cooler
And: The door is open
When: I want to close the door
Then: The door should be closed

-----------------------------------------DONE
Feature: We can put bottles in the cooler
Given: I have a cooler
And: I want to add bottles to it
When: I add the bottles to the cooler
Then: The bottles should be present

-----------------------------------------DONE
Feature: We can take bottles out of the cooler
Given: I have a cooler
And: I want to remove bottles from it
When: I remove the bottles from the cooler
Then: The bottles should not be present

-----------------------------------------DONE
Feature: We can tell how many bottles we have of each type of beverage
-- For example: 10 Green Monsters, 5 Blue Machines
Given: I have a cooler containing 15 bottles
And: I know there are 10 Green Monsters and 5 Blue Machine
When: I want to check the amount a given drink
Then: The amount of that particular drink should be given

-----------------------------------------DONE
Feature: We want to have the ability to manufacture bottles of a given type
Given: I want to have 10 Green Monsters and 5 Rockstars
When: I ask a manufacturer to create bottles of a number and type
Then: The manufacturer should give me my order

-----------------------------------------DONE
Feature:We want to be able to set and get the capacity in bottles for a cooler
Given: I have cooler
When: I want to specify it's capacity
Then: I should be able to do so, and confirm it is correct

-----------------------------------------DONE
Feature: We an calculate how full the cooler is
Given: A cooler with a specified capacity and some stock
When: I want to know how full the cooler is
Then: I should be able to get the percentage of capacity used

-----------------------------------------
Feature: Know the value of the stock inside of the cooler
Given: One bottle of Monster is worth 3.95, and one bottle of rockstar is worth 2.95
When: Asked for the value of the bottles in the cooler
Then: The correct value should be given

EPIC WIN Feature: The cooler can automatically re-order when capacity falls below a threshold
SUPER EPIC WIN Feature: The cooler vetoes the door being open more than 10 degrees 
