package whyscala

// you can think of it as Java's interface
trait Animal {
  val name:String
  def isDangerousToHumans: Boolean
}

trait IsDangerousToHumans {
  def isDangerousToHumans: Boolean = true
}

trait IsNotDangerousToHumans {
  def isDangerousToHumans: Boolean = false
}

// Example with mixin
class Dog(override val name: String) extends Animal with IsNotDangerousToHumans

class Lion(override val name:String) extends Animal with IsDangerousToHumans

object SomeOOP extends App{
  val myDog = new Dog("Butch")
  val myLion = new Lion("Simba")

  // Pattern matching
  def sayHello(animal: Animal): Unit = {
    println(s"Hi, ${animal.name}!")
    if(animal.isDangerousToHumans) println("I'll keep my distance.")
    else println("So, it's safe to come closer")
  }

  sayHello(myDog)
  sayHello(myLion)

  //  myDog.name = "Roger" // fails
}