trait Offer {
  def discount(items: Seq[Item]): Double
}

object BogofApples extends Offer {
  def discount(items: Seq[Item]): Double = {
    val freebies = items.count(_ == Apple) / 2
    freebies * Apple.price
  }
}
