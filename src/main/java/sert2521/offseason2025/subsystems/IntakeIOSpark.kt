package sert2521.offseason2025.subsystems

import com.revrobotics.spark.SparkBase
import com.revrobotics.spark.SparkLowLevel.MotorType
import com.revrobotics.spark.SparkMax
import com.revrobotics.spark.config.SparkBaseConfig
import com.revrobotics.spark.config.SparkMaxConfig
import sert2521.offseason2025.IntakeConstants

class IntakeIOSpark:IntakeIO {
    private val rollersMotor = SparkMax(IntakeConstants.ROLLERS_ID, MotorType.kBrushless)
    private val alignmentMotor = SparkMax(IntakeConstants.ALIGNMENT_ID, MotorType.kBrushless)

    init{
        val rollersConfig = SparkMaxConfig()
        rollersConfig
            .idleMode(SparkBaseConfig.IdleMode.kBrake)
            .inverted(false)
            .smartCurrentLimit(40)

        rollersMotor.configure(rollersConfig, SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kPersistParameters)

        val alignmentConfig = SparkMaxConfig()
        alignmentConfig
            .idleMode(SparkBaseConfig.IdleMode.kBrake)
            .inverted(false)
            .smartCurrentLimit(30)

        rollersMotor.configure(alignmentConfig, SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kPersistParameters)
    }

    override fun updateInputs(inputs: IntakeIO.IntakeIOInputs) {
        inputs.rollersAppliedVoltage = rollersMotor.appliedOutput * rollersMotor.busVoltage
        inputs.rollersCurrentAmps = rollersMotor.outputCurrent

        inputs.alignmentAppliedVoltage = rollersMotor.appliedOutput * rollersMotor.busVoltage
        inputs.alignmentCurrentAmps = rollersMotor.outputCurrent
    }

    override fun setSpeedRollers(speed: Double) {
        rollersMotor.set(speed)
    }

    override fun setSpeedAlignment(speed: Double) {
        alignmentMotor.set(speed)
    }
}