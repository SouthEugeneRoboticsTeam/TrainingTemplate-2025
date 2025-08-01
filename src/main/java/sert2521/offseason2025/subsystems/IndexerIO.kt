package sert2521.offseason2025.subsystems

import org.team9432.annotation.Logged

interface IndexerIO {
    @Logged
    open class IndexerIOInputs{
        var appliedVolts = 0.0
        var currentAmps = 0.0
        var velocityRPM = 0.0

        var beambreakClear = true
    }

    fun updateInputs(inputs:IndexerIOInputs){}

    fun setMotor(speed: Double) {}

    fun setVoltage(voltage: Double) {}
}