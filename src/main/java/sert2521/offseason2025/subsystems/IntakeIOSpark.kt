package sert2521.offseason2025.subsystems

import com.revrobotics.spark.SparkLowLevel
import com.revrobotics.spark.SparkMax
import sert2521.offseason2025.IntakeConstants.INTAKE_ALIGNMENT_ID
import sert2521.offseason2025.IntakeConstants.INTAKE_ROLLER_ID


class IntakeIOSpark:IntakeIO {
    private val rollerMotor = SparkMax(INTAKE_ROLLER_ID, SparkLowLevel.MotorType.kBrushless)
    private val alignmentMotor = SparkMax(INTAKE_ALIGNMENT_ID, SparkLowLevel.MotorType.kBrushless)
}