package sert2521.offseason2025.subsystems

import edu.wpi.first.wpilibj2.command.Command
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.littletonrobotics.junction.Logger

object Indexer : SubsystemBase() {
    val io = IndexerIOSpark()
    val ioInputs = LoggedIndexerIOInputs()

    init {
        defaultCommand = run {
            io.setSpeed(0.0)
        }
    }

    override fun periodic() {
        io.updateInputs(ioInputs)
        Logger.processInputs("Indexer", ioInputs)
    }

    fun intakeCommand(): Command {
        return run {
            io.setSpeed(0.5)
        }.until {
            !ioInputs.beambreakClear
        }
    }
}