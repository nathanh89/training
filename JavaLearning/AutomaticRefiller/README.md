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
Given: I have a cooler
And: It is off
When: I want toggle the power state
Then: The cooler should be on

Feature: We can turn the cooler off

Feature: We can open the door
Feature: We can close the door
Feature: We can put bottles in the cooler
Feature: We can take bottles out of the cooler
Feature: We an calculate how full the cooler is
EPIC WIN Feature: The cooler can automatically re-order when capacity falls below a threshold
SUPER EPIC WIN Feature: The cooler vetoes the door being open more than 10 degrees 