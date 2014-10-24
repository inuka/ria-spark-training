:load lib/CDR.scala

val CDR_lines = sc.textFile("data/CDR_content.csv")

val CDRs_nosite = CDR_lines.map(line => new CDR(line))

val DIM_CELL_lines = sc.textFile("data/DIM_CELL_content.csv")
val DIM_CELL = DIM_CELL_lines.map(_.split(",")).map(line => (line(0), line(1)))

// val CDRs = CDRs_nosite.map(cdr => (cdr.cell, cdr)).join(DIM_CELL).map(x => x._2._1.copy(site = x._2._2))
val CDRs = CDRs_nosite.map(cdr => (cdr.cell, cdr)).join(DIM_CELL).map(x => {x._2._1.site = x._2._2; x._2._1})

val Value = CDRs.map(cdr => (cdr.a, cdr.value)).reduceByKey(_+_)
val MUS = CDRs.map(cdr => ((cdr.a, cdr.site), 1)).reduceByKey(_+_).map(x => (x._1._1, (x._1._2, x._2))).reduceByKey((x,y) => if (x._2 > y._2) x else y).map(x => (x._1, x._2._1))
val KYC = Value.join(MUS)

KYC.sortBy(_._2._1,false).take(10)
