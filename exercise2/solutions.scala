case class CDR(A: String, B: String, VALUE: Float, CELL: String, SITE: String, TIME: String, DATE: String, DURATION: Int, WAY: String)

val CDR_lines = sc.textFile("data/CDR_content.csv")

val CDRs_nosite = CDR_lines.map(_.split(",")).map(l => new CDR(l(0), l(1), l(2).toFloat, l(3), "", l(4), l(5), l(6).toInt, l(7)))

val DIM_CELL_lines = sc.textFile("data/DIM_CELL_content.csv")
val DIM_CELL = DIM_CELL_lines.map(_.split(",")).map(line => (line(0), line(1)))

val CDRs = CDRs_nosite.map(cdr => (cdr.CELL, cdr)).join(DIM_CELL).map(a => a._2._1.copy(SITE = a._2._2))

val Value = CDRs.map(cdr => (cdr.A, cdr.VALUE)).reduceByKey(_+_)
val MUS = CDRs.map(cdr => ((cdr.A, cdr.SITE), 1)).reduceByKey(_+_).map(a => (a._1._1, (a._1._2, a._2))).reduceByKey((a,b) => if (a._2 > b._2) a else b).map(a => (a._1, a._2._1))
val KYC = Value.join(MUS)

KYC.sortBy(_._2._1,false).take(10)
