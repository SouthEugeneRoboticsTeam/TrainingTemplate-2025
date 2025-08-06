package sert2521.offseason2025.subsystems

import com.revrobotics.spark.SparkMax
import sert2521.offseason2025.IntakeConstants

class IntakeIOSpark : IntakeIO {
    val motorRollers = SparkMax(IntakeConstants.INTAKE_ROLLERS_MOTOR_ID)
    val motorAlignment = SparkMax(IntakeConstants.INTAKE_ALIGNMENT_MOTOR_ID)

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
