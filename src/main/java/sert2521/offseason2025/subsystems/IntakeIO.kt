package sert2521.offseason2025.subsystems

import org.team9432.annotation.Logged

interface IntakeIO {
    @Logged
    open class IntakeIOInputs {
        var alignmentAppliedVolts = 0.0
        var alignmentCurrentAmps = 0.0
        var alignmentVelocityRPM = 0.0

        var rollerAppliedVolts = 0.0
        var rollerCurrentAmps = 0.0
        var rollerVelocityRPM = 0.0

    }

    fun updateInputs(inputs: IntakeIOInputs){}

    fun setRollerSpeed(speed: Double){}

    fun setRollerVoltage(voltage: Double){}

    fun setAlignmentSpeed(speed: Double){}

    fun setAlignmentVoltage(voltage: Double){}

}