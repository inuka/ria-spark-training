// load error messages from a log into memory
// then interactively search for various patterns
 
// base RDD
val lines = sc.textFile("log.txt")
 
// How many errors were there?
val errors = lines.filter(_.startsWith("ERROR"))
errors.count()

// What were the errors?
val messages = errors.map(_.split("\t")).map(r => r(1))
messages.cache()
messages.collect.foreach(println)
 
// How many errors related to MySQL?
messages.filter(_.contains("mysql")).count()

// How many errors related to PHP?
messages.filter(_.contains("php")).count()