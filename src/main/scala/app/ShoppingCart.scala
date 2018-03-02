package app

object ShoppingCart extends App{

  val bread = new Product("Bread", "Food", 80)
  val milk = new Product("Milk", "Food", 60)
  val washingUpLiquid = new Product("Washing up liquid", "Household", 100)
  val bleach = new Product("Bleach", "Household", 70)
  val basket = List(bread, milk, milk, washingUpLiquid, bleach)

  def totalPrice(basket : List[Product], salePercent: Int = 0): Int = {
    val getPrices = "[0-9]+".r.findAllIn(basket.toString).toList
    getPrices.map(_.toInt).sum * (100 - salePercent) / 100
  }

  def foodPrice(basket : List[Product]): Int = {
    val getFood = "(Food)..[0-9]+".r.findAllIn(basket.toString).toList
    val getPrices = "[0-9]+".r.findAllIn(getFood.toString).toList
    getPrices.map(_.toInt).sum
  }

  def voucherDiscount(basket : List[Product], item : Product, voucherPercent : Int): Int = {
    val getItem = basket.filter(_ == item)
    val getPrices = "[0-9]+".r.findAllIn(getItem.toString).toList
    getPrices.map(_.toInt).sum * voucherPercent / 100
  }

  def MakeShoppingList(basket : List[Product]) = {
    val stringLength = basket.map(_.toString.length)
    val spacers = stringLength.map(x => " " * (38 - x))
    val newList = basket.zip(spacers).flatMap{ case (a,b) => List(a+b) }

    println(" _______________________________________")
    println("|                                       |")
    println("|            SHOPPING LIST              |")
    println("|_______________________________________|")
    println("|                                       |")
    println("| " + newList.mkString("|\n| ")+"|")
    println("|_______________________________________|\n")
    println("Total Price: " + totalPrice(basket))
    println("Total Price of Food: " + foodPrice(basket))
    println("Total Price with 10% Off: " + totalPrice(basket, 10))
    println("Total Price with 50% off voucher for Washing up Liquid: " + (totalPrice(basket) - voucherDiscount(basket, washingUpLiquid, 50)))
  }
  MakeShoppingList(basket)
}


class Product(val name: String, val category: String, val price: Int) {
  override def toString(): String = {
    s"$name - $category ($price)"
  }
}

