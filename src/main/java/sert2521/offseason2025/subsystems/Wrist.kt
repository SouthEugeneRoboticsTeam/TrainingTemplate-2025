package sert2521.offseason2025.subsystems

import edu.wpi.first.math.controller.PIDController
import edu.wpi.first.wpilibj2.command.Command
import edu.wpi.first.wpilibj2.command.SubsystemBase
import org.littletonrobotics.junction.Logger
import sert2521.offseason2025.WristConstants

object Wrist : SubsystemBase() {
    val io = WristIOSpark()
    val ioInputs = LoggedWristIOInputs()

    val pid = PIDController(WristConstants.WRIST_P, 0.0, WristConstants.WRIST_D)

    init {
        defaultCommand = run {
            io.setVoltageLeftMotor(0.0)
            io.setVoltageRightMotor(0.0)
        }
    }

    override fun periodic() {
        io.updateInputs(ioInputs)
        Logger.processInputs("Wrist", ioInputs)
    }


    fun setWrist(setpoint:Double):Command{
        return runOnce {
            pid.setpoint = setpoint
        }.andThen(
            run {
                val pidResult = pid.calculate(ioInputs.absoluteEncoderRadians)
                io.setVoltageLeftMotor(pidResult)
                io.setVoltageRightMotor(pidResult)
            }
        )
    }
}