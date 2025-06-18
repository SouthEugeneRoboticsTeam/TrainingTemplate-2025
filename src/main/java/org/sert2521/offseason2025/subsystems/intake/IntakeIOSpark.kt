package org.sert2521.offseason2025.subsystems.intake

import com.revrobotics.spark.SparkLowLevel
import com.revrobotics.spark.SparkMax
import com.revrobotics.spark.SparkSim

class IntakeIOSpark : IntakeIO {
    val rollersMotor = SparkMax(0, SparkLowLevel.MotorType.kBrushless)

    override fun updateInputs(inputs: IntakeIO.IntakeIOInputs) {
        inputs.currentAmpsRollers = 0.0
        inputs.appliedVoltsRollers = 0.0

        inputs.currentAmpsAlignment = 0.0
        inputs.appliedVoltsAlignment = 0.0
    }
}