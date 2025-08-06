package sert2521.offseason2025.subsystems

import org.team9432.annotation.Logged

interface IntakeIO {
    @Logged
    open class IntakeIOInputs{
        var currentAmpsRollers = 0.0
        var currentAmpsAlignment = 0.0
        var appliedVoltsRollers = 0.0
        var appliedVoltsAlignment = 0.0
    }
    fun setSpeedRollers(speed:Double) {}
    fun setSpeedAlignment(speed:Double)
    fun updateInputs(inputs: IntakeIOInputs)
}