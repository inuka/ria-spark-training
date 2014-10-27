object FancyWrapper extends Serializable {
  
  case class CDR( 
      val a: String = "",
      val b: String = "",
      val value: Float = 0,
      val cell: String = "",
      val site: String = "",
      val time: String = "",
      val date: String = "",
      val duration: Int = 0,
      val way: String = "" 
    ) extends Serializable {

    override def toString(): String = {
      if (way == "OUTGOING")
        this.a + " -> " + this.b + " @" + this.cell + "-" + this.site
      else
        this.a + " <- " + this.b + " @" + this.cell + "-" + this.site
    }
  }

  object CDR {
    def apply(s: String): CDR = {
      apply(s.split(","))
    }

    def apply(a: Array[String]): CDR = {
      new CDR(
        a = a(0),
        b = a(1),
        value = a(2).toFloat,
        cell = a(3),
        site = "",
        time = a(4),
        date = a(5),
        duration = a(6).toInt,
        way = a(7) 
      )
    }
  }

}
import CDRImport._