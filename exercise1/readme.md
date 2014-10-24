# Exercise 1: Word count

In this exercise, you will complete the basic word count example. You have been provided a file called ``sample.txt`` that contains a short essay by Paul Graham. To complete this exercise you need to:

* Read the text file provided
* Count the number of occurences of each word
* _Bonus: Sort the occurences in descending order_


## Hints

* Read the textfile using ``sc.textFile("sample.txt")``
* Split a string into words by using ``split(" ")``
* What is the difference between ``map`` and ``flatMap``?
* You can transform data structures by using the ``map`` function and specifying the transformation as the function
* You can aggregate by using ``reduceByKey`` 