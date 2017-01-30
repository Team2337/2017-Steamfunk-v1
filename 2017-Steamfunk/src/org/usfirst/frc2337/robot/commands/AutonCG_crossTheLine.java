package org.usfirst.frc2337.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc2337.robot.Constants;
import org.usfirst.frc2337.robot.Robot;

/**
 *
 */
public class AutonCG_crossTheLine extends CommandGroup {
	
    public AutonCG_crossTheLine() {
    	//addSequential(new Auton_turnGyro3(90));
    	//addSequential(new Auton_turnGyro2());
    	addSequential(new Auton_driveForwardGyro(0.2,2.0));
    	
    }
}
