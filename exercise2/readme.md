# Exercice 2: Mini-KYC

In this exercice, you will build a mini KYC to understand where your high-value customers are located.

## Import the Data

1. Import CDRs
  * Load `data/cdr.csv` into an RDD. It contains one CDR per line (fields are comma-separated). These CDRs have a cell associated to them, but no site yet.
  * Tranform the RDD of `String` into an RDD of `CDR` objects.
2. Import the cell-site lookup table
  * Load `data/sites.csv`, into an RDD. It contains a cell and its corresponding site per line.

## Mine the Data

1. We are trying to identify high-value customers.
 * Compute the revenue associated to each customer.
2. We want to locate each user based on his most used site (and not most used cell).
 * Update each CDR with the site corresponding to its cell.
3. We want to know where a customer lives.
 * Compute the most used site of each customer.
4. We want to build a big datamart with information on each user.
 * Create a RDD that contains the revenue and the most used site of each customer.
5. We want to know where the high-value customers live.
 * Output a list of the most used sites by the top 10 high-value customers.


## Hints

* To create a `CDR` object based on a line of `CDR_content.csv`, use `CDR(line)`
* To import a couple of values `a` and `b`, you can import them as a tuple `(a,b)`. To access elements of a tuple `x`, you can use `x._1`, `x._2`, ...
