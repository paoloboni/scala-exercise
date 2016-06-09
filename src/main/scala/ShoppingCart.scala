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

case class ShoppingCart(items: Seq[Item]) {

  val total = items.foldLeft(0.0)(_ + _.price)

}

object ShoppingCart {

  def main(args: Array[String]): Unit = {
    println("Enter a list containing Apple and Orange:")
    val input = StdIn.readLine()

    val items = input.split("[\\s,]").collect {
        case "Apple" => Apple
        case "Orange" => Orange
    }.toSeq

    val total = ShoppingCart(items).total

    println(s"The total for ($input) is $total")
  }


}

