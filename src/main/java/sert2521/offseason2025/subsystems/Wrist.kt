package sert2521.offseason2025.subsystems

import edu.wpi.first.wpilibj2.command.Command
import edu.wpi.first.wpilibj2.command.SubsystemBase
import org.littletonrobotics.junction.Logger

object Wrist : SubsystemBase() {
    val io = WristIOSpark()
    val ioInputs = LoggedWristIOInputs()

    init {
        defaultCommand = run {
            io.setSpeedLeftMotor(0.0)
            io.setSpeedRightMotor(0.0)
        }
    }

    override fun periodic() {
        io.updateInputs(ioInputs)
        Logger.processInputs("Wrist", ioInputs)
    }

    fun intakeCommand(): Command {
        return run {
            io.setSpeedLeftMotor(0.5)
            io.setSpeedRightMotor(0.5)
        }
    }
}