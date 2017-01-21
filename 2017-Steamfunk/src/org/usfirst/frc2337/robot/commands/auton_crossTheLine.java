package org.usfirst.frc2337.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc2337.robot.Robot;

/**
 *
 */
public class auton_crossTheLine extends CommandGroup {
	
    public auton_crossTheLine() {
    	
    	addSequential(new autonChassis_driveForTime(0.5, 5.0));
    	
    }
}
