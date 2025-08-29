package sert2521.offseason2025.subsystems

import edu.wpi.first.math.controller.ArmFeedforward
import edu.wpi.first.math.controller.PIDController
import edu.wpi.first.wpilibj.smartdashboard.Mechanism2d
import edu.wpi.first.wpilibj.smartdashboard.MechanismLigament2d
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import edu.wpi.first.wpilibj2.command.Command
import edu.wpi.first.wpilibj2.command.SubsystemBase
import org.littletonrobotics.junction.Logger
import org.littletonrobotics.junction.mechanism.LoggedMechanism2d
import org.littletonrobotics.junction.mechanism.LoggedMechanismLigament2d
import sert2521.offseason2025.MetaConstants
import sert2521.offseason2025.WristConstants.WRIST_A
import sert2521.offseason2025.WristConstants.WRIST_D
import sert2521.offseason2025.WristConstants.WRIST_G
import sert2521.offseason2025.WristConstants.WRIST_I
import sert2521.offseason2025.WristConstants.WRIST_P
import sert2521.offseason2025.WristConstants.WRIST_S
import sert2521.offseason2025.WristConstants.WRIST_V
import kotlin.math.PI

object Wrist : SubsystemBase() {
    val io = WristIOSim()
    val ioInputs = LoggedWristIOInputs()

    val pid = PIDController(WRIST_P, WRIST_I, WRIST_D)
    val feedforward = ArmFeedforward(WRIST_S, WRIST_G, WRIST_V, WRIST_A)

    val wristMechanism2d = LoggedMechanism2d(2.0, 2.0)
    val wristRoot = wristMechanism2d.getRoot("Wrist", 0.0, 1.0)
    val wristLigament2d = LoggedMechanismLigament2d("Wrist Main", 1.0, 0.0)

    init {
        wristRoot.append(wristLigament2d)

        defaultCommand = setWristCommand(0.0)
    }

    override fun periodic() {
        io.updateInputs(ioInputs)
        Logger.processInputs("Wrist", ioInputs)

        wristLigament2d.angle = 360 * ioInputs.position / (2* PI)

        Logger.recordOutput("Wrist Mechanism2d", wristMechanism2d)
    }


    fun setWristCommand(setpoint: Double): Command {
        return run {
            io.setVoltage(
                pid.calculate(ioInputs.position, setpoint)
                        + feedforward.calculate(setpoint, 0.0)
            )
        }
    }

    fun resetSim():Command{
        return runOnce{io.reset()}
    }
}