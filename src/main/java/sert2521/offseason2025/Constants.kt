package sert2521.offseason2025

import edu.wpi.first.math.system.plant.DCMotor
import edu.wpi.first.wpilibj.DriverStation
import edu.wpi.first.wpilibj.RobotBase

object IndexerConstants {
    const val INDEXER_MOTOR_ID = 9
    const val INDEXER_BEAMBREAK_ID = 4
}

object IntakeConstants {
    const val INTAKE_ROLLERS_MOTOR_ID = 10
    const val INTAKE_ALIGNMENT_MOTOR_ID = 13
}

object WristConstants {
    const val WRIST_MOTOR_ID = 0

    const val WRIST_P = 10.0
    const val WRIST_I = 0.0
    const val WRIST_D = 1.0

    const val WRIST_S = 0.0
    const val WRIST_V = 0.0
    const val WRIST_G = 1.692
    const val WRIST_A = 0.0


    val gearbox = DCMotor.getNEO(1)
    val gearing = 8.0
    val MOI = 0.1
    val armLengthMeters = 0.5
}

object MetaConstants {
    enum class Mode {
        REAL,
        SIM,
        REPLAY
    }

    val currentMode = if(RobotBase.isReal()){
        Mode.REAL
    } else {
        Mode.SIM
    }
}