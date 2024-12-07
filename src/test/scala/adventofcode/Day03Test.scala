package adventofcode

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.*
import adventofcode.Day03.*

class Day03Test extends AnyFlatSpec {

  private val exampleInputOne =
    "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))"


  private val exampleInputTwo =
    "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))"

  behavior of "solutionPartOne"

  it should "return example result given example input" in {
    solutionPartOne(exampleInputOne) should be(161)
  }

  it should "return example result given problem input" in {
    solutionPartOne(problemInput) should be(184122457)
  }

  behavior of "solutionPartTwo"

  it should "return example result given example input" in {
    solutionPartTwo(exampleInputTwo) should be(48)
  }

  it should "return example result given problem input" in {
    solutionPartTwo(problemInput) should be(107862689)
  }
}
