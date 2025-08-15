package sert2521.offseason2025.subsystems

import com.revrobotics.spark.SparkBase
import com.revrobotics.spark.SparkLowLevel
import com.revrobotics.spark.SparkMax
import com.revrobotics.spark.config.SparkBaseConfig
import com.revrobotics.spark.config.SparkMaxConfig
import edu.wpi.first.wpilibj.DigitalInput
import sert2521.offseason2025.IndexerConstants

class IndexerIOSpark : IndexerIO {
    val motor = SparkMax(IndexerConstants.INDEXER_MOTOR_ID, SparkLowLevel.MotorType.kBrushless)

    val beambreak = DigitalInput(IndexerConstants.INDEXER_BEAMBREAK_ID)

    init {
        val config = SparkMaxConfig()
        config.inverted(false)
        config.idleMode(SparkBaseConfig.IdleMode.kBrake)
        config.smartCurrentLimit(40)

        motor.configure (config, SparkBase.ResetMode.kResetSafeParameters,SparkBase.PersistMode.kPersistParameters)
    }

    override fun updateInputs(inputs: IndexerIO.IndexerIOInputs) {
        inputs.currentAmps = motor.outputCurrent
        inputs.appliedVolts = motor.busVoltage * motor.appliedOutput

        inputs.beambreakClear = beambreak.get()
    }

    override fun setSpeed(speed: Double) {
        motor.set(speed)
    }
}