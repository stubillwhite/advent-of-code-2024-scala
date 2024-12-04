package adventofcode

import adventofcode.Utils.loadResourceAsString

object Day03 {

  val problemInput: String =
    loadResourceAsString("day-03-input.txt")

  sealed trait Instruction
  case class Mul(arg1: Long, arg2: Long) extends Instruction
  case object Do extends Instruction
  case object Dont extends Instruction

  case class State(total: Long = 0,
                   canDisable: Boolean = true,
                   isDisabled: Boolean = false)

  def solutionPartOne(input: String): Long = {
    val instructions = parseInput(input)
    val state = State(canDisable = false)
    instructions.foldLeft(state)(executeInstruction).total
  }

  def solutionPartTwo(input: String): Long = {
    val instructions = parseInput(input)
    val state = State()
    instructions.foldLeft(state)(executeInstruction).total
  }

  def main(args: Array[String]): Unit = {
    println(s"Part one: ${solutionPartOne(problemInput)}")
    println(s"Part two: ${solutionPartTwo(problemInput)}")
    println("Done")
  }

  private def parseInput(input: String): Seq[Instruction] = {

    def parseInstruction(s: String): Instruction = {
      val instrPattern = """(.+)\((.*)\)""".r
      s match {
        case instrPattern(opcode, argStr) => {
          opcode match {
            case "mul" =>
              val args = argStr.split(",").map(_.toLong).toList
              Mul(args(0), args(1))

            case "do" => Do
            case "don't" => Dont
          }
        }
      }
    }

    val regex = """(mul\(\d+,\d+\))|(do\(\)|(don't\(\)))""".r
    regex.findAllIn(input).toList.map(parseInstruction)
  }

  private def executeInstruction(state: State, instr: Instruction): State = {
    instr match
      case Mul(arg1, arg2) => if (state.isDisabled) state else state.copy(total = state.total + arg1 * arg2)
      case Do => state.copy(isDisabled = false)
      case Dont => state.copy(isDisabled = state.canDisable)
  }
}
