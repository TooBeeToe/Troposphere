# Troposphere
***Java Programming Assignment***

The following JSON represents a fee structure for courses in a
university.
[troposhpere.txt](https://github.com/TooBeeToe/Troposphere/files/11112753/troposhpere.txt)

Write a program using any language / framework of your choice that allows a user to determine the accurate fee to be paid based on the JSON above.


**Use Case**: The user **HAS** to select the fee first, after selecting that, the program shows the list of associated nationalities based on the inner keys of the selected fee. Once a nationality is selected, it shows the list of courses for that fee / nationality.

**Note**: If an entry is **ALL_COURSES**, then that needs to be substituted with the following list, and one can be chosen. Medical, Dental, Ayurveda
 

Once the course is selected, we select the level of the course based on the previous selection.

**Note** If an entry is **ALL_LEVEL**, then that needs to be substituted with the following list, and one can be chosen. UG, PG, DIPLOMA, Ph.D

Once all four options are selected, the resulting fee amount is to be shown.

**Note**: The expectation is that the above JSON will be parsed to arrive at the solution. A reference to the JSON above must exist in the solution.
