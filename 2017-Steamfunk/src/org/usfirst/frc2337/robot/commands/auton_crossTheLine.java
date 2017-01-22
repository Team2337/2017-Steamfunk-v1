package org.usfirst.frc2337.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc2337.robot.Constants;
import org.usfirst.frc2337.robot.Robot;

/**
 *
 */
public class auton_crossTheLine extends CommandGroup {
	
    public auton_crossTheLine() {
    	addSequential(new Auton_turnGyro2());
    	//addSequential(new Auton_driveForwardGyro(0.2,10.0));
    	
    }
}
