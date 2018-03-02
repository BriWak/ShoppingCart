package app

object ShoppingCart extends App{

  val bread = new Product("Bread", "Food", 80)
  val milk = new Product("Milk", "Food", 60)
  val washingUpLiquid = new Product("Washing up liquid", "Household", 100)
  val bleach = new Product("Bleach", "Household", 70)
  val basket = List(bread, milk, milk, washingUpLiquid, bleach)

  println(basket)
  println(totalPrice(basket))
  println(foodPrice(basket))
  println(totalPrice(basket,10))

  def totalPrice(basket : List[Product], salePercent: Int = 0): Int = {
    val getPrices = "[0-9]+".r.findAllIn(basket.toString).toList
    (getPrices.map(_.toInt).sum.toDouble / 100 * (100 - salePercent)).toInt
  }

  def foodPrice(basket : List[Product]): Int = {
    val getFood = "(Food)..[0-9]+".r.findAllIn(basket.toString).toList
    val getPrices = "[0-9]+".r.findAllIn(getFood.toString).toList
    getPrices.map(_.toInt).sum
  }
}


class Product(val name: String, val category: String, val price: Int) {
  override def toString(): String = {
    s"$name - $category ($price)"
  }
}

