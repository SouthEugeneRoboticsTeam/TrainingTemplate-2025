package sert2521.offseason2025.subsystems

import edu.wpi.first.wpilibj2.command.Command
import edu.wpi.first.wpilibj2.command.Commands
import edu.wpi.first.wpilibj2.command.SubsystemBase;

object Intake : SubsystemBase() {
    private val io = IntakeIOSpark()
    private val ioInputs = IntakeIO.IntakeIOInputs()

    init{
        defaultCommand = Commands.none() // Put your command here
    }

    fun intakeCommand(): Command {
        return Commands.none() // Put your command here
    }

    fun reverseCommand(): Command {
        return Commands.none() // Put your command here
    }
}