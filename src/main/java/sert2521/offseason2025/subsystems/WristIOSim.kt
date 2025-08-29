package sert2521.offseason2025.subsystems

import edu.wpi.first.wpilibj.simulation.SingleJointedArmSim
import org.ironmaple.simulation.motorsims.MapleMotorSim
import sert2521.offseason2025.WristConstants.MOI
import sert2521.offseason2025.WristConstants.armLengthMeters
import sert2521.offseason2025.WristConstants.gearbox
import sert2521.offseason2025.WristConstants.gearing
import kotlin.math.PI

class WristIOSim: WristIO {
    val armSim = SingleJointedArmSim(gearbox, gearing, MOI, armLengthMeters, -PI/2, PI/2, true, 0.0)

    var currentVolts = 0.0
    override fun updateInputs(inputs: WristIO.WristIOInputs) {
        armSim.update(0.02)

        inputs.currentAmps = armSim.currentDrawAmps
        inputs.appliedVolts = currentVolts
        inputs.position = armSim.angleRads
    }

    override fun setSpeed(speed: Double) {
        armSim.setInputVoltage(speed * 12.0)
        currentVolts = speed * 12.0
    }

    override fun setVoltage(volts: Double) {
        armSim.setInputVoltage(volts)
        currentVolts = volts
    }

    fun reset(){
        armSim.setState(0.0, 0.0)
    }
}