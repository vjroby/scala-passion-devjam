package reactoring

object AfterRefactoring {


  def unique(input: Set[List[Int]]): Set[List[Int]] = ???

  def toEvenSet(luckyNumbers: List[Int]): Set[List[Int]] = ???
}

object BeforeRefactoring {

  def uniqueLists(input: Set[List[Int]]): Set[List[Int]] = {
    val foundBuffer = collection.mutable.Set[Int]()
    input.toList
      .sortBy(-_.length)
      .filterNot(list =>
        if (list.exists(foundBuffer.contains)) {
          // we don't care
          true
        } else {
          // update the buffer
          foundBuffer ++= list
          false
        })
      .toSet
  }

  def toEvenSet(luckyNumbers: List[Int]): Set[List[Int]] = {
    var remainingNumbers = luckyNumbers
    var result: Set[List[Int]] = Set()
    while (remainingNumbers.nonEmpty) {
      remainingNumbers = processLuckyNumbers(remainingNumbers)
      if (remainingNumbers.nonEmpty && remainingNumbers.length % 2 == 0) {
        result += remainingNumbers
      }
    }
    result
  }

  /**
   * Dummy processing, discards first element
   */
  def processLuckyNumbers(luckyNumbers: List[Int]): List[Int] = luckyNumbers.tail
}