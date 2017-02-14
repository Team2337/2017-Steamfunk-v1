package org.usfirst.frc2337.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc2337.robot.Constants;
import org.usfirst.frc2337.robot.Robot;

/**
 *
 */
public class AutonCG_midGear extends CommandGroup {
	
    public AutonCG_midGear() {
    	
    	
    	
    	addSequential(new Auton_resetGyro());
    	addSequential(new Auton_wait(0));
    	addSequential(new GearLoader_retract());
    	addSequential(new Auton_resetEncoders());
    	addSequential(new Auton_wait(.1));
    	
    	//forward a little 
    	addSequential(new Auton_DriveForwardGyroWithEncoder(.55, 20000,4.5));  //was 1.0 speed
    	addSequential(new Auton_resetEncoders());
    	addSequential(new Auton_wait(.1));
    	
    	//forward a little 
    	addSequential(new Auton_DriveForwardGyroWithEncoder(.5, 5000,1));  //was 1.0 speed
    	
    	// open doors 
 
    	addSequential(new GearLoader_extend());
    	
    	
    	//back a little 
    	addSequential(new Auton_wait(.4));
    	addSequential(new Auton_resetEncoders());
    	addSequential(new Auton_wait(.1));
    	addSequential(new Auton_DriveForwardGyroWithEncoder(-.6,1000,2));
    	
    	//forward a little 
    	
    	addSequential(new Auton_resetEncoders());
    	addSequential(new Auton_wait(.1));
    	addSequential(new Auton_DriveForwardGyroWithEncoder(.6,3000,1));
    	
    	//back a little 
    	addSequential(new Auton_resetEncoders());
    	addSequential(new Auton_wait(.1));
    	addSequential(new Auton_DriveForwardGyroWithEncoder(-.6,2000,2));
    	/*
    	// code still need 
    	// move backward 
    	//addSequential(new Auton_driveForwardGyro(-1.0,2));
    	*/
    	
    }
}