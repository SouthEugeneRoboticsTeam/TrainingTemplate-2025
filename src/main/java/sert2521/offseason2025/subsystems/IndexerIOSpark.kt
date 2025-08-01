package sert2521.offseason2025.subsystems

import com.revrobotics.spark.SparkLowLevel
import com.revrobotics.spark.SparkMax
import edu.wpi.first.wpilibj.DigitalInput
import sert2521.offseason2025.IndexerConstants.INDEXER_BEAMBREAK_ID
import sert2521.offseason2025.IndexerConstants.INDEXER_MOTOR_ID

class IndexerIOSpark:IndexerIO {
    private val motor = SparkMax(INDEXER_MOTOR_ID,SparkLowLevel.MotorType.kBrushless)
    private val beambreak = DigitalInput(INDEXER_BEAMBREAK_ID)

    override fun updateInputs(inputs: IndexerIO.IndexerIOInputs) {
        inputs.currentAmps = motor.outputCurrent
        inputs.velocityRPM = motor.encoder.velocity
        inputs.appliedVolts = motor.busVoltage * motor.appliedOutput
        inputs.beambreakClear = beambreak.get()
    }

    override fun setMotor(speed: Double) {
        motor.set(speed)
    }

    override fun setVoltage(voltage: Double) {
        motor.set(voltage)
    }
}

