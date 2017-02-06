package org.usfirst.frc2337.robot.subsystems;

import org.usfirst.frc2337.robot.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 * TARGETING LED - Runs LED's used for indication.
 */
public class TargetingLED extends Subsystem {

    private final Solenoid targetingLeftLED = RobotMap.targetingLEDtargetingLeftLED;
    private final Solenoid targetingCenterLED = RobotMap.targetingLEDtargetingCenterLED;
    private final Solenoid targetingRightLED = RobotMap.targetingLEDtargetingRightLED;
    private final Solenoid targetingBottomLED = RobotMap.targetingLEDtargetingBottomLED;
    private final Solenoid targetingFrontLED = RobotMap.targetingLEDtargetingFrontLED;

    public void initDefaultCommand() {

    }
}

