# Lehnen_James_LMS
Module 2 SDLC Assignment
# Defining Requirements 
Requirements for the LMS Software are as follows:
1. The ability to add new books to the collection from a text file based on each book’s unique ID number, title, and author.
2. The ability to remove a book from the collection using said ID number.
3. The ability to list all books currently in the collection's stock.
4. The ability to check in and check out books as needed.

System must be easy to access and use and must be able to withstand times of high usage stress when used from multiple sources. Users will be of staff attempting to locate items, manage checkouts and ins, or just attempting to do inventory.
# Gathering Requirements 
Potential users are staff of the library. Requirements are the ability to access the LMS quickly and easily without hindering other users. An example of such is being able to add or remove a book without causing a problem for either end.
# Implementation
The implementation process can be broken down into the three main Java classes and the text file that holds the list.
1. Book Class manages the ID, Title and Author of the Book that is added via the file and stores the information for usage.
2. Library Class holds the information of the Book Class for storage and search.
3. Main Class runs the program itself that allows the Java Classes to be able to add, remove or search from the information provided in the Books.txt.
# Testing
Code should be debugged before testing to ensure all paths connect, and then ran to ensure the seamless packaging and usage of the Java Classes in the src. Errors will need to be addressed both before and after, especially if marked errors cause the incapability for the launcher to run the program.
