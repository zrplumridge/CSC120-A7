Use this file to record your reflection on this assignment.

Which methods did you decide to overload, and why?
What worked, what didn't, what advice would you give someone taking this course in the future?

A7:
Please document which methods you overloaded (and why!) in your `reflection.md`.


I overloaded the Library, House, and Cafe constructors so that basic versions of each of these buildings can be created with just a name and an address. I kept the original versions, where additional information can be added if desired. House also has a second constructor that only requires an address, because some of the houses are known by their addresses instead of the name of a donor. 

I overloaded the isAvailable() method in Library.java so that when no book title is entered, all of the books in the library are printed so that the user can see all of the titles. 

I overloaded the sellCoffee() and restock() methods in Cafe.java to have a default coffee order and a way to just restock everything instead of specific ingredients when they run out.

This project was a bit overwhelming to look at initially, so I broke it down into smaller steps and wrote them down on paper. I also started early enough that I could take a couple days off after a particularly annoying issue, which gave me the chance to approach the goal from a new direction and completely sidestep the original issue. Add javadoc comments (or at least inline comments) as you go to avoid having to do them all at the end. 