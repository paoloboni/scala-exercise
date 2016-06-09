import org.specs2.mutable.Specification

class ShoppingCartSpec extends Specification {

  "the checkout system takes a list of items and outputs the cost" >> {

    "no items should be £0.00" >> {
      val cart = ShoppingCart(List.empty)

      cart.total must_== 0
    }
    "[ Apple ] should be £0.60" >> {
      val cart = ShoppingCart(List(Apple))

      cart.total must_== 0.60
    }
    "[ Orange ] should be £0.25" >> {
      val cart = ShoppingCart(List(Orange))

      cart.total must_== 0.25
    }
    "[ Apple, Apple, Orange, Apple ] should be £2.05" >> {
      val cart = ShoppingCart(List(Apple, Apple, Orange, Apple))

      cart.total must_== 2.05
    }

  }
}


