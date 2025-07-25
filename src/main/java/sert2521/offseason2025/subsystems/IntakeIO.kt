package sert2521.offseason2025.subsystems

import org.team9432.annotation.Logged

interface IntakeIO {
    @Logged
    open class IntakeIOInputs {
        var rollersCurrentAmps = 0.0
        var rollersAppliedVolts = 0.0

        var alignmentCurrentAmps = 0.0
        var alignmentAppliedVolts = 0.0
    }

    fun updateInputs(inputs:IntakeIOInputs) {}

    fun setSpeedRollers(speed: Double) {}

    fun setSpeedAlignment(speed: Double) {}
}