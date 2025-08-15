package sert2521.offseason2025.subsystems

import com.revrobotics.spark.SparkBase
import com.revrobotics.spark.SparkLowLevel
import com.revrobotics.spark.SparkMax
import com.revrobotics.spark.config.SparkBaseConfig
import com.revrobotics.spark.config.SparkMaxConfig
import sert2521.offseason2025.IntakeConstants

class IntakeIOSpark : IntakeIO {
    val motorRollers = SparkMax(IntakeConstants.INTAKE_ROLLERS_MOTOR_ID,SparkLowLevel.MotorType.kBrushless)
    val motorAlignment = SparkMax(IntakeConstants.INTAKE_ALIGNMENT_MOTOR_ID,SparkLowLevel.MotorType.kBrushless)

    init {
        val config = SparkMaxConfig()

        config.inverted(false)
        config.idleMode(SparkBaseConfig.IdleMode.kBrake)
        config.smartCurrentLimit(40)

        motorRollers.configure(config, SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kPersistParameters)
        motorAlignment.configure(config, SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kPersistParameters)
    }

    override fun updateInputs(inputs: IntakeIO.IntakeIOInputs) {
        inputs.currentAmpsRollers = motorRollers.outputCurrent
        inputs.currentAmpsAlignment = motorAlignment.outputCurrent
        inputs.appliedVoltsRollers = motorRollers.outputCurrent
        inputs.appliedVoltsAlignment = motorAlignment.outputCurrent
    }

    override fun setSpeedRollers(speed: Double) {
        motorRollers.set(speed)
    }

    override fun setSpeedAlignment(speed: Double) {
        motorAlignment.set(speed)
    }
}
