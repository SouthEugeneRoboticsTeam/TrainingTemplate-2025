package sert2521.offseason2025.subsystems

import com.revrobotics.spark.SparkLowLevel
import com.revrobotics.spark.SparkMax
import edu.wpi.first.wpilibj.DigitalInput
import sert2521.offseason2025.IndexerConstants
import sert2521.offseason2025.WristConstants

class WristIOSpark : WristIO {
    val motor = SparkMax(WristConstants.WRIST_MOTOR_ID, SparkLowLevel.MotorType.kBrushless)

    override fun updateInputs(inputs: WristIO.WristIOInputs) {
        inputs.currentAmps = motor.outputCurrent
        inputs.appliedVolts = motor.busVoltage * motor.appliedOutput
        inputs.position = motor.encoder.position
    }

    override fun setSpeed(speed: Double) {
        motor.set(speed)
    }

    override fun setVoltage(volts: Double) {
        motor.set(volts)
    }
}