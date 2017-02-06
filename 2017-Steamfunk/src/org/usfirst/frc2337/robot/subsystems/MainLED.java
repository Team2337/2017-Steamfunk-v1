package org.usfirst.frc2337.robot.subsystems;

import org.usfirst.frc2337.robot.RobotMap;
import org.usfirst.frc2337.robot.commands.*;

import edu.wpi.first.wpilibj.Solenoid;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 * MAINLED - Runs LED's used for indication.
 */
public class MainLED extends Subsystem {
    private final Solenoid feedbackLED = RobotMap.mainLEDfeedbackLED;
    public void initDefaultCommand() {
    }
}

