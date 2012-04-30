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

-----------------------------------------
Feature: We can take bottles out of the cooler
Given: I have a cooler
And: I want to remove bottles from it
When: I remove the bottles from the cooler
Then: The bottles should not be present

Feature: We an calculate how full the cooler is

EPIC WIN Feature: The cooler can automatically re-order when capacity falls below a threshold

SUPER EPIC WIN Feature: The cooler vetoes the door being open more than 10 degrees 
