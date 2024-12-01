package adventofcode

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers._
import Day01._

class Day01Test extends AnyFlatSpec {

  private val exampleInput =
    """3   4
      |4   3
      |2   5
      |1   3
      |3   9
      |3   3
      |""".stripMargin

  behavior of "solutionPartOne"

  it should "return example result given example input" in {
    solutionPartOne(exampleInput) should be(11)
  }

  it should "return example result given problem input" in {
    solutionPartOne(problemInput) should be(2378066)
  }

  behavior of "solutionPartTwo"

  it should "return example result given example input" in {
    solutionPartTwo(exampleInput) should be(31)
  }

  it should "return example result given problem input" in {
    solutionPartTwo(problemInput) should be(18934359)
  }
}
