# SweetSuite
## Java program for splitting bills with roomates 

**Note:** Currently working on functionality for data storage by learning MySQL, so that a Suite's data and Student's data may be accessed again after reruning the program. Might also try to save each class' data in different txt files as a temporary solution.

## Purchase Class

- Composed of:
    - Name of purchase
    - Name of buyer
    - Double amount
    - Boolean paid
- Should be able to:
    - [x]  change paid status
    - [x]  Return name of buyer
    - [x]  Return name of Purchase
    - [x]  Return paid status

## Student Class

- Composed of:
    - Name
    - ID
    - Hashmap Debt <Integer ID, Double amount>
    - Stack of Purchases
- Should be able to:
    - [x]  Return Name and ID
    - [x]  Print Debt table
    - [x]  Return recent purchase
    - [x]  Return oldest owed purchase (oldest with purchase paid == false)
    - [x]  pay purchase off + update debt table
    - [x]  add purchase

## Suite Class

- Composed of:
    - Name of Suite
    - List of students
- Should be able to:
    - [x]  return list of students
    - [x]  return name of suite

## Main

- [x]  First asks for ID number (like a sign in)
- [x]  Suite Setup
- [x]  To add purchase ⇒ 1
    - [x]  Enter name of purchase and total
    - [x]  Who is splitting the total? # of people and ID’s of students
    - [x]  returns “ID2 and ID3 each owe ID1 x amt
- [x]  To see your balance ⇒ 2
    - [x]  Prints debt table that belongs to student ID
- [x]  To see your most recent purchase ⇒ 3
    - [x]  Prints top of purchase stack: name + total of __ shared amount _____ bought by _____
- [x]  To pay off purchase ⇒ 4
    - [x]  gets + prints purchase stack
    - [x]  which debt do you want to pay? ⇒ enter index (item 0, 1 , 2)
    - [x]  Gets purchase item in stack
        - gets buyerName and Amount
        - prints “owe ___ person ___ amount”
        - paid gets set to true ⇒ prints “purchase paid!”
        - student.map.put(buyer, debt - amountPaid)
- [x]  To exit ⇒ 5
