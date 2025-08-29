package sert2521.offseason2025.subsystems

import org.team9432.annotation.Logged

interface WristIO {
    @Logged
    open class WristIOInputs {
        var currentAmps = 0.0
        var appliedVolts = 0.0
        var position = 0.0
    }

    fun setSpeed(speed: Double) {}
    fun setVoltage(volts: Double)

    fun updateInputs(inputs: WristIOInputs) {}
}