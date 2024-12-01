package adventofcode

import adventofcode.Utils.loadResourceAsString

import scala.math.abs

object Day01 {

  val problemInput: String =
    loadResourceAsString("day-01-input.txt")

  def solutionPartOne(input: String): Long = {
    val Array(l1, l2) = parseInput(input)

    l1.sorted.zip(l2.sorted)
      .map { case (a, b) => abs(a - b) }
      .sum
  }

  def solutionPartTwo(input: String): Long = {
    val Array(l1, l2) = parseInput(input)

    val frequencies = l2.groupBy(identity).view.mapValues(vs => vs.length)

    l1
      .map { x => x * frequencies.getOrElse(x, 0) }
      .sum
  }

  def main(args: Array[String]): Unit = {
    println(s"Part one: ${solutionPartOne(problemInput)}")
    println(s"Part two: ${solutionPartTwo(problemInput)}")
    println("Done")
  }

  private def parseInput(input: String): Array[Array[Long]] = {
    val parsedLines = input.split("\n").map(x => x.split("\\s+").map(y => y.toLong))
    parsedLines.transpose
  }
}
