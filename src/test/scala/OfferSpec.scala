import org.specs2.mutable.Specification

class OfferSpec extends Specification {

  "the offer calculates a discount for the cart" >> {

    "buy one get one free Apples" >> {
      "[ Apple ] should have no discount" >> {
        BogofApples.discount(Seq(Apple)) must_== 0
      }

      "[ Apple, Apple ] discount should be £0.60" >> {
        BogofApples.discount(Seq(Apple, Apple)) must_== 0.60
      }

      "[ Apple, Apple, Apple ] discount should be £0.60" >> {
        BogofApples.discount(Seq(Apple, Apple, Apple)) must_== 0.60
      }

      "[ Apple, Apple, Apple, Orange ] discount should be £0.60" >> {
        BogofApples.discount(Seq(Apple, Apple, Apple, Orange)) must_== 0.60
      }

    }

  }


}


