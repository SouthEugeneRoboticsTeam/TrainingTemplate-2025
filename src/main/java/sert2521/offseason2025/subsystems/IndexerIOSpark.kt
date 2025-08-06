package sert2521.offseason2025.subsystems

import com.revrobotics.spark.SparkLowLevel
import com.revrobotics.spark.SparkMax
import edu.wpi.first.wpilibj.DigitalInput
import sert2521.offseason2025.IndexerConstants

class IndexerIOSpark : IndexerIO {
    val motor = SparkMax(IndexerConstants.INDEXER_MOTOR_ID, SparkLowLevel.MotorType.kBrushless)

    val beambreak = DigitalInput(IndexerConstants.INDEXER_BEAMBREAK_ID)

    override fun updateInputs(inputs: IndexerIO.IndexerIOInputs) {
        inputs.currentAmps = motor.outputCurrent
        inputs.appliedVolts = motor.busVoltage * motor.appliedOutput

        inputs.beambreakClear = beambreak.get()
    }

    override fun setSpeed(speed: Double) {
        motor.set(speed)
    }
}