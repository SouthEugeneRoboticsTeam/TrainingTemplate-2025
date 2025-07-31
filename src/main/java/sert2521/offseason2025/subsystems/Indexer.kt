package sert2521.offseason2025.subsystems

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.littletonrobotics.junction.Logger

object Indexer : SubsystemBase() {
    private val io = IndexerIOSpark()
    private val ioInputs = LoggedIndexerIOInputs()

    override fun periodic() {
        io.updateInputs(ioInputs)
        Logger.processInputs("Indexer", ioInputs)
    }

    // Add all commands
}