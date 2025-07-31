package sert2521.offseason2025.subsystems

import org.team9432.annotation.Logged

interface IndexerIO {
    @Logged
    open class IndexerIOInputs{
        // Add all inputs
    }

    fun updateInputs(inputs:IndexerIOInputs){}

    // Add all needed functions
}