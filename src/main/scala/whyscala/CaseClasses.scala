package whyscala


object CaseClasses extends App {
  println(s"${getClass.getName} is running")
  val myCar = Car("Audi", "blue", " A3", 3, 250)
  val mySecondCar = Car(brand = "Fiat", color = "white", model = "500", horsePower = 120)

  println(s"""My car is: $myCar""")
  println(s"""My second car is: $mySecondCar""")
}

case class Car(brand: String, color: String, model: String, nDoors: Int, horsePower: Int)

object Car {
  // default nDoors
  def apply(brand: String, color: String, model: String, nDoors: Int = 4, horsePower: Int): Car =
    new Car(brand, color, model, nDoors, horsePower)
}

/**
 * Java version
 * public class Car{
 *  private final String brand;
 *  private final String color;
 *  private final String model;
 *  private final int nDoors;
 *  private final int horsePower; // try to use immutable list
 *
 *  public Car(String brand, String color, String model, int nDoors, int horsePower){
 *    return new Car(brand, color, model, nDoors, horsePower);
 *  }
 *
 *  public String toString(){...}
 *  public boolean equal(){...}
 *  public int hashCode equal(){...}
 *
 *  // Because private we need getters
 *  public String getBrand() {
 *    return brand;
 *  }
 *  ...
 * }
 */

