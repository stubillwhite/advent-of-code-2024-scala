package adventofcode

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers._
import Day02._

class Day02Test extends AnyFlatSpec {

  private val exampleInput =
    """7 6 4 2 1
      |1 2 7 8 9
      |9 7 6 2 1
      |1 3 2 4 5
      |8 6 4 4 1
      |1 3 6 7 9
      |""".stripMargin

  behavior of "solutionPartOne"

  it should "return example result given example input" in {
    solutionPartOne(exampleInput) should be(2)
  }

  it should "return example result given problem input" in {
    solutionPartOne(problemInput) should be(306)
  }

  behavior of "solutionPartTwo"

  it should "return example result given example input" in {
    solutionPartTwo(exampleInput) should be(4)
  }

  it should "return example result given problem input" in {
    solutionPartTwo(problemInput) should be(366)
  }
}
