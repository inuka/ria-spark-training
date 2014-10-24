# Exercise 0: Log Analysis

In this exercise, you will use Spark to analyze the contents of the log file ``log.txt``. Use Spark to answer the following:

* How many errors were there?
* What were the errors?
* How many errors related to Oracle?
* How many errors related to Anatella?

## Hints

* Read a textfile using ``sc.textFile("filename.txt")``
* Filter a line by using the ``filter`` function
	* startsWith("string")
	* contains("string")
* Split tab delimited lines with split("\t")
* Return only the second element by using ``map(r => r(1))``