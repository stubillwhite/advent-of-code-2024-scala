package adventofcode

import adventofcode.Utils.loadResourceAsString

import scala.math.abs

object Day02 {

  val problemInput: String =
    loadResourceAsString("day-02-input.txt")

  def solutionPartOne(input: String): Long = {
    val levels = parseInput(input)
    levels.count(isSafe)
  }

  def solutionPartTwo(input: String): Long = {
    def dampen(xs: Seq[Long]): Seq[Seq[Long]] = {
      List(xs) ++ xs.indices.map { n => xs.patch(n, Nil, 1) }
    }

    val levels = parseInput(input)
    levels.count(x => dampen(x).exists(isSafe))
  }

  def main(args: Array[String]): Unit = {
    println(s"Part one: ${solutionPartOne(problemInput)}")
    println(s"Part two: ${solutionPartTwo(problemInput)}")
    println("Done")
  }

  private def parseInput(input: String): Array[Array[Long]] = {
    input.split("\n").map(x => x.split("\\s+").map(y => y.toLong))
  }

  private def isSafe(xs: Seq[Long]): Boolean = {
    val isIncreasing = xs.sliding(2).forall { case Seq(a, b) => a <= b }
    val isDecreasing = xs.sliding(2).forall { case Seq(a, b) => a >= b }
    val smallDeltas = xs.sliding(2).forall { case Seq(a, b) => 1 <= abs(a - b) && abs(a - b) <= 3 }

    (isIncreasing || isDecreasing) && smallDeltas
  }
}
