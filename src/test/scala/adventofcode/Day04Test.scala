package adventofcode

import adventofcode.Day04.*
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.*

class Day04Test extends AnyFlatSpec {

  private val exampleInput =
    """MMMSXXMASM
      |MSAMXMSMSA
      |AMXSXMAAMM
      |MSAMASMSMX
      |XMASAMXAMM
      |XXAMMXXAMA
      |SMSMSASXSS
      |SAXAMASAAA
      |MAMMMXMMMM
      |MXMXAXMASX
      |""".stripMargin

  behavior of "solutionPartOne"

  it should "return example result given example input" in {
    solutionPartOne(exampleInput) should be(18)
  }

  it should "return example result given problem input" in {
    solutionPartOne(problemInput) should be(2560)
  }

  behavior of "solutionPartTwo"

  it should "return example result given example input" in {
    solutionPartTwo(exampleInput) should be(9)
  }

  it should "return example result given problem input" in {
    solutionPartTwo(problemInput) should be(1910)
  }
}
