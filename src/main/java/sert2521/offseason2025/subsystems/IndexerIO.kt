package sert2521.offseason2025.subsystems

import org.team9432.annotation.Logged

interface IndexerIO {
    @Logged
    open class IndexerIOInputs{
        var currentAmps = 0.0
        var appliedVolts = 0.0

        var beambreakClear = false
    }

    fun setSpeed(speed:Double) {}

    fun updateInputs(inputs: IndexerIOInputs) {}
}