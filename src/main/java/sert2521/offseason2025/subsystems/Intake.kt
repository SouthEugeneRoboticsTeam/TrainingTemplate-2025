package sert2521.offseason2025.subsystems

import edu.wpi.first.wpilibj2.command.Command
import edu.wpi.first.wpilibj2.command.SubsystemBase
import org.littletonrobotics.junction.Logger

object Intake : SubsystemBase() {
    val io = IntakeIOSpark()
    val ioInputs = LoggedIntakeIOInputs()

    init {
        defaultCommand = run {
            io.setSpeedRollers(0.0)
            io.setSpeedAlignment(0.0)
        }
    }

    override fun periodic() {
        io.updateInputs(ioInputs)
        Logger.processInputs("Intake", ioInputs)
    }

    fun intakeCommand(): Command {
        return run {
            io.setSpeedRollers(0.5)
            io.setSpeedAlignment(0.5)
        }
    }
}