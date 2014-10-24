// read the text file
val file = sc.textFile("sample.txt") // returns a collection of lines

// split the words and then transform to (word,1)
val words = file.flatMap(line => line.split(" ")).map(word => (word, 1))

// aggregate by key (word)
val result = words.reduceByKey(_ + _)
result.collect.foreach(println)

// bonus
val sorted = result.map(_.swap).sortByKey(false)
sorted.collect.take(10).foreach(println)

