package sert2521.offseason2025.subsystems

import org.team9432.annotation.Logged

interface WristIO {
    @Logged
    open class WristIOInputs{
        var currentAmpsLeftMotor = 0.0
        var appliedVoltsLeftMotor = 0.0

        var currentAmpsRightMotor = 0.0
        var appliedVoltsRightMotor = 0.0

        var absoluteEncoderRadians = 0.0
    }

    fun setVoltageLeftMotor(volts:Double) {}

    fun setVoltageRightMotor(volts: Double) {}

    fun updateInputs(inputs: WristIOInputs) {}
}