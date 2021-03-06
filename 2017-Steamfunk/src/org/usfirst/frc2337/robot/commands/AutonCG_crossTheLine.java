package org.usfirst.frc2337.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc2337.robot.Constants;
import org.usfirst.frc2337.robot.Robot;

/**
 *
 */
public class AutonCG_crossTheLine extends CommandGroup {
	
    public AutonCG_crossTheLine() {
    	
    addSequential(new Auton_resetEncoders());
    addSequential(new Auton_wait(0));
    addSequential(new Auton_resetGyro());
    addSequential(new Auton_wait(0));
   addSequential(new Auton_driveForwardGyroWithEncoderPID(26500,6));
    
    
    }
}
