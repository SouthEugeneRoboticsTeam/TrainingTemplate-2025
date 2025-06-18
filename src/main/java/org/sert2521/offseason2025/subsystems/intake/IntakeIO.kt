package org.sert2521.offseason2025.subsystems.intake

import org.sert2521.offseason2025.utils.Logged

interface IntakeIO {

    @Logged
    open class IntakeIOInputs {
        var appliedVoltsRollers = 0.0
        var currentAmpsRollers = 0.0

        var appliedVoltsAlignment = 0.0
        var currentAmpsAlignment = 0.0
    }

    fun updateInputs(inputs: IntakeIOInputs) {}

    fun setMotors(speedRollers: Double, speedAlignment: Double) {}
}