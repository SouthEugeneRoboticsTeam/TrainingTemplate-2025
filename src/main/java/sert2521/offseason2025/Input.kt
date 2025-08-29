package sert2521.offseason2025

import edu.wpi.first.wpilibj2.command.Commands
import edu.wpi.first.wpilibj2.command.button.CommandJoystick
import edu.wpi.first.wpilibj2.command.button.CommandXboxController
import sert2521.offseason2025.subsystems.Indexer
import sert2521.offseason2025.subsystems.Wrist

object Input {
    private val driverController = CommandXboxController(0)
    private val gunnerController = CommandJoystick(1)

    private val exampleDriverButton = driverController.a()
    private val exampleGunnerButton = gunnerController.button(5)
    private val indexerIntakeButton = driverController.b()
    init{
        exampleDriverButton.onTrue(Wrist.setWristCommand(1.0))
        indexerIntakeButton.onTrue(Wrist.resetSim())

    }
}