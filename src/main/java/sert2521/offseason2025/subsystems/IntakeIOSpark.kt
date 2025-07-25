package sert2521.offseason2025.subsystems

import com.revrobotics.spark.SparkBase
import com.revrobotics.spark.SparkLowLevel
import com.revrobotics.spark.SparkMax
import com.revrobotics.spark.config.SparkBaseConfig
import com.revrobotics.spark.config.SparkMaxConfig
import sert2521.offseason2025.IntakeConstants

class IntakeIOSpark:IntakeIO {
    private val rollersMotor = SparkMax(IntakeConstants.INTAKE_ROLLERS_ID, SparkLowLevel.MotorType.kBrushless)
    private val alignmentMotor = SparkMax(IntakeConstants.INTAKE_ALIGNMENT_ID, SparkLowLevel.MotorType.kBrushless)

    private val config = SparkMaxConfig()
    init{
        config.inverted(false)
        config.idleMode(SparkBaseConfig.IdleMode.kBrake)
        config.smartCurrentLimit(40)

        rollersMotor.configure(config, SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kPersistParameters)
        alignmentMotor.configure(config, SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kPersistParameters)
    }

    override fun updateInputs(inputs: IntakeIO.IntakeIOInputs) {
        inputs.rollersCurrentAmps = rollersMotor.outputCurrent
        inputs.rollersAppliedVolts = rollersMotor.busVoltage * rollersMotor.appliedOutput

        inputs.alignmentCurrentAmps = alignmentMotor.outputCurrent
        inputs.alignmentAppliedVolts = alignmentMotor.busVoltage * alignmentMotor.appliedOutput
    }
}