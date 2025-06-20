package sert2521.offseason2025.subsystems

import org.littletonrobotics.junction.LogTable
import org.littletonrobotics.junction.inputs.LoggableInputs

interface IntakeIO {

    class IntakeIOInputs:LoggableInputs{
        var rollersAppliedVoltage = 0.0
        var rollersCurrentAmps = 0.0

        var alignmentAppliedVoltage = 0.0
        var alignmentCurrentAmps = 0.0

        override fun toLog(table: LogTable) {
            table.put("rollersAppliedVoltage",rollersAppliedVoltage)
            table.put("rollersCurrentAmps",rollersCurrentAmps)

            table.put("alignmentAppliedVoltage",alignmentAppliedVoltage)
            table.put("alignmentCurrentAmps",alignmentCurrentAmps)
        }

        override fun fromLog(table: LogTable) {
            rollersAppliedVoltage = table.get("rollersAppliedVoltage",rollersAppliedVoltage)
            rollersCurrentAmps = table.get("rollersCurrentAmps",rollersCurrentAmps)

            alignmentAppliedVoltage = table.get("alignmentAppliedVoltage",alignmentAppliedVoltage)
            alignmentCurrentAmps = table.get("alignmentCurrentAmps",alignmentCurrentAmps)
        }
    }

    fun updateInputs(inputs:IntakeIOInputs){}

    fun setSpeedRollers(speed:Double){}

    fun setSpeedAlignment(speed:Double){}
}