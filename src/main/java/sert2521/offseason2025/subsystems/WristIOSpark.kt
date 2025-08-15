package sert2521.offseason2025.subsystems

import com.revrobotics.spark.SparkLowLevel
import com.revrobotics.spark.SparkMax
import sert2521.offseason2025.WristConstants

class WristIOSpark : WristIO {

    val leftMotor = SparkMax(WristConstants.WRIST_LEFT_MOTOR_ID,SparkLowLevel.MotorType.kBrushless)

    val rightMotor = SparkMax(WristConstants.WRIST_RIGHT_MOTOR_ID,SparkLowLevel.MotorType.kBrushless)

    override fun updateInputs(inputs: WristIO.WristIOInputs) {
        inputs.currentAmpsLeftMotor = leftMotor.outputCurrent
        inputs.appliedVoltsLeftMotor = leftMotor.busVoltage * leftMotor.appliedOutput
        inputs.currentAmpsRightMotor = rightMotor.outputCurrent
        inputs.appliedVoltsRightMotor = rightMotor.busVoltage * rightMotor.appliedOutput

        inputs.absoluteEncoderRadians = leftMotor.absoluteEncoder.position
    }

    override fun setSpeedLeftMotor(speed: Double) {
        leftMotor.set(speed)
    }
    override fun setSpeedRightMotor(speed: Double) {
        rightMotor.set(speed)
    }
}