package org.usfirst.frc2337.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc2337.robot.Constants;
import org.usfirst.frc2337.robot.Robot;

/**
 *
 */
public class AutonCG_blueSide40ball extends CommandGroup {
	
    public AutonCG_blueSide40ball() {
    	   //This is code for 40 ball don't detele or remove plz and thx you
    	addSequential(new Auton_resetEncoders());
    	addSequential(new Auton_resetGyro());
    	//addSequential(new Auton_turnGyro(90));
    	//addSequential(new Auton_wait(0.00));
    addSequential(new Auton_driveForwardTurnEncoder(-.6,11000,30,10));
    addSequential(new Auton_wait(0));
    addSequential(new Auton_driveForwardTurnEncoder(-.6,26000,0,10));
    addSequential(new HopperTrigger_extend());
    	//addSequential(new Auton_driveForwardGyro(-1.0,0.1));
    //	addSequential(new Auton_DriveForwardGyroWithEncoder());
    addSequential(new _DoNothing());
    
   
    	//addparallel(new start shooter) code still need
    	// kick wings out
    	// addSequential(new ) code still need
    	// target 
    	//addSequential(new ) code still need
    	// shoot 
    	//addparallel(new ) code still need
    	// start auger
    	// addparallel(new ) code still need
    	
    	
    	
    }
}