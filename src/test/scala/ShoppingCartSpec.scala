import app.{Product, _}
import org.scalatest.{MustMatchers, WordSpec}

class ShoppingCartSpec extends WordSpec with MustMatchers{

  "ShoppingCart" must {

    "return 310 for total price of all items in basket" in {
      ShoppingCart.totalPrice(List(new Product("Bread", "Food", 80))) mustEqual 80
    }
  }
}
