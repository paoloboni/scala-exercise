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

  "the checkout system adjust the price depending on special offers applied" >> {

    "buy one get one free on Apples" >> {
      "[ Apple, Apple, Orange, Apple ] should be £1.45" >> {
        val cart = ShoppingCart(List(Apple, Apple, Orange, Apple), List(BogofApples))

        cart.total must_== 1.45
      }
    }
    "3 for 2 on Oranges" >> {
      "[ Orange, Orange, Orange, Apple ] should be £1.10" >> {
        val cart = ShoppingCart(List(Orange, Orange, Orange, Apple), List(Three4TwoOranges))

        cart.total must_== 1.10
      }
    }
    "Apple and Orange offers" >> {
      "[ Orange, Orange, Orange, Apple, Apple, Apple ] should be £1.70" >> {
        val cart = ShoppingCart(List(Orange, Orange, Orange, Apple, Apple, Apple), List(BogofApples, Three4TwoOranges))

        cart.total must_== 1.70
      }
    }
  }
}


