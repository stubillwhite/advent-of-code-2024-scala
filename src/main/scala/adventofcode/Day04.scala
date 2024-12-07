package adventofcode

import adventofcode.Utils.loadResourceAsString

object Day04 {

  case class Location(x: Int, y: Int) {
    def *(n: Int): Location = {
      Location(x * n, y * n)
    }

    def +(other: Location): Location = {
      Location(x + other.x, y + other.y)
    }
  }

  private type Grid = Map[Location, Char]

  val problemInput: String =
    loadResourceAsString("day-04-input.txt")

  def solutionPartOne(input: String): Long = {
    val grid = parseInput(input)
    grid.keys.toList.map(xmasLineMatches(grid, _)).sum
  }

  def solutionPartTwo(input: String): Long = {
    val grid = parseInput(input)
    grid.keys.toList.map(xmasCrossMatches(grid, _)).sum
  }

  def main(args: Array[String]): Unit = {
    println(s"Part one: ${solutionPartOne(problemInput)}")
    println(s"Part two: ${solutionPartTwo(problemInput)}")
    println("Done")
  }

  private def parseInput(input: String): Grid = {
    input.split("\n").zipWithIndex.flatMap { case (line, y) =>
      line.zipWithIndex.map { case (ch, x) =>
        Location(x, y) -> ch
      }
    }.toMap
  }

  private def xmasLineMatches(grid: Grid, loc: Location): Long = {
    val desiredWord = "XMAS"

    val deltas = for {
      x <- Range.inclusive(-1, 1)
      y <- Range.inclusive(-1, 1)
    } yield Location(x, y)

    val slices = deltas.map(delta => Range(0, desiredWord.length).map(n => loc + (delta * n)))
    val words = slices.map(slice => slice.map(loc => grid.getOrElse(loc, "")).mkString)

    words.count(_ == desiredWord)
  }

  private def xmasCrossMatches(grid: Grid, loc: Location): Long = {
    val deltas = List(
      List(Location(-1, -1), Location(0, 0), Location(1, 1)),
      List(Location(1, -1), Location(0, 0), Location(-1, 1))
    )

    val slices = deltas.map(diagonal => diagonal.map(loc + _))
    val words = slices.map(slice => slice.map(loc => grid.getOrElse(loc, "")).mkString)

    if words.forall(w => w == "MAS" || w == "SAM") then 1 else 0
  }
}
