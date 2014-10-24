class CDR() extends java.io.Serializable {

  var a: String = ""
  var b :String = ""
  var value: Float = 0
  var cell: String = ""
  var site: String = ""
  var time: String = ""
  var date: String = ""
  var duration: Int = 0
  var way: String = ""

  def this(a: Array[String]) {
    this()
    this.a = a(0);
    this.b = a(1);
    this.value = a(2).toFloat;
    this.cell = a(3);
    if (a.length == 8) {
      this.site = ""; // no site
      this.time = a(4);
      this.date = a(5);
      this.duration = a(6).toInt;
      this.way = a(7);
    } else {
      this.site = a(4);
      this.time = a(5);
      this.date = a(6);
      this.duration = a(7).toInt;
      this.way = a(8);
    }
  }

  def this(s: String) {
    this(s.split(","))
  }

  override def toString() = {
    if (way == "OUTGOING")
      this.a + " -> " + this.b + " @" + this.cell + "-" + this.site
    else
      this.a + " <- " + this.b + " @" + this.cell + "-" + this.site
  }
}
