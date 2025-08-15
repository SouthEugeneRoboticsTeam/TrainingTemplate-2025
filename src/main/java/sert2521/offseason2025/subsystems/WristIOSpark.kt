package sert2521.offseason2025.subsystems

import com.revrobotics.spark.SparkBase
import com.revrobotics.spark.SparkLowLevel
import com.revrobotics.spark.SparkMax
import com.revrobotics.spark.config.SparkBaseConfig
import com.revrobotics.spark.config.SparkMaxConfig
import sert2521.offseason2025.WristConstants

class WristIOSpark : WristIO {

    val leftMotor = SparkMax(WristConstants.WRIST_LEFT_MOTOR_ID,SparkLowLevel.MotorType.kBrushless)

    val rightMotor = SparkMax(WristConstants.WRIST_RIGHT_MOTOR_ID,SparkLowLevel.MotorType.kBrushless)

    init {
        val leftConfig = SparkMaxConfig()

        leftConfig.inverted(false)
        leftConfig.idleMode(SparkBaseConfig.IdleMode.kBrake)
        leftConfig.smartCurrentLimit(40)

        leftMotor.configure(leftConfig, SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kPersistParameters)

        val rightConfig = SparkMaxConfig()
        rightConfig.apply(leftConfig)
        rightConfig.inverted(true)

        rightMotor.configure(rightConfig,SparkBase.ResetMode.kResetSafeParameters,SparkBase.PersistMode.kPersistParameters)
    }

    override fun updateInputs(inputs: WristIO.WristIOInputs) {
        inputs.currentAmpsLeftMotor = leftMotor.outputCurrent
        inputs.appliedVoltsLeftMotor = leftMotor.busVoltage * leftMotor.appliedOutput
        inputs.currentAmpsRightMotor = rightMotor.outputCurrent
        inputs.appliedVoltsRightMotor = rightMotor.busVoltage * rightMotor.appliedOutput

        inputs.absoluteEncoderRadians = leftMotor.absoluteEncoder.position
    }

    override fun setVoltageLeftMotor(volts: Double) {
        leftMotor.setVoltage(volts)
    }
    override fun setVoltageRightMotor(volts: Double) {
        rightMotor.setVoltage(volts)
    }
}