import app.{Product, _}
import org.scalatest.{MustMatchers, WordSpec}

class ShoppingCartSpec extends WordSpec with MustMatchers{

  "ShoppingCart" must {

    "return 80 for total price of bread" in {
      ShoppingCart.totalPrice(List(new Product("Bread", "Food", 80))) mustEqual 80
    }

    "return 140 for total price of bread and milk" in {
      ShoppingCart.totalPrice(List(new Product("Bread", "Food", 80), new Product("Milk", "Food", 60))) mustEqual 140
    }

    "return 126 for total price of bread and milk with a 10% off sale" in {
      ShoppingCart.totalPrice(List(new Product("Bread", "Food", 80), new Product("Milk", "Food", 60)),10) mustEqual 126
    }
  }
}
