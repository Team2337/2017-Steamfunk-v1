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
    	addSequential(new Auton_resetGyro());
    	//addSequential(new Auton_turnGyro(90));
    	//addSequential(new Auton_wait(0.00));
    addSequential(new Auton_driveForwardTurn(0,10000,46,5));
    	//addSequential(new Auton_driveForwardGyro(-1.0,0.1));
    //	addSequential(new Auton_DriveForwardGyroWithEncoder());
    addSequential(new _DoNothing());
    	
    }
}
