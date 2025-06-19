package sert2521.offseason2025

import edu.wpi.first.wpilibj2.command.Commands
import edu.wpi.first.wpilibj2.command.button.CommandJoystick
import edu.wpi.first.wpilibj2.command.button.CommandXboxController

object Input {
    private val driverController = CommandXboxController(0)
    private val gunnerController = CommandJoystick(1)

    private val exampleDriverButton = driverController.a()
    private val exampleGunnerButton = gunnerController.button(5)

    init{
        exampleDriverButton.whileTrue(Commands.none())
        exampleGunnerButton.whileTrue(Commands.none())
    }
}