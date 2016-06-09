import scala.io.StdIn

trait Item {
  def price: Double
}

object Apple extends Item {
  val price = 0.60
}

object Orange extends Item {
  val price = 0.25
}

case class ShoppingCart(items: Seq[Item], offers: Seq[Offer] = Seq.empty) {

  val sum = items.foldLeft(0.0)(_ + _.price)
  val discount = offers.map(_.discount(items)).sum
  val total = ShoppingCart.round2dp(sum - discount)

}

object ShoppingCart {

  val todaysOffers = Seq(BogofApples)

  def round2dp(d:Double) = math.round(100 * d) / 100.0

  def main(args: Array[String]): Unit = {
    println("Enter a list containing Apple and Orange:")
    val input = StdIn.readLine()

    val items = input.split("[\\s,]").collect {
        case "Apple" => Apple
        case "Orange" => Orange
    }.toSeq

    val total = ShoppingCart(items, todaysOffers).total

    println(s"The total for ($input) is $total")
  }


}

