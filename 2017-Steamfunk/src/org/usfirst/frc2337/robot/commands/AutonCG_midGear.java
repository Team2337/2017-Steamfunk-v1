package org.usfirst.frc2337.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc2337.robot.Constants;
import org.usfirst.frc2337.robot.Robot;

/**
 *
 */
public class AutonCG_midGear extends CommandGroup {
	
    public AutonCG_midGear() {
    	
    	//move forward 
    //	addSequential(new Auton_driveForwardGyro(1.0,3));
    	// line up 
    	//code still need 
    	// move forward 
    //	addSequential(new Auton_driveForwardGyro(1.0,2));
    	// put gear on time !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    	
    	//addSequential(new Auton_driveForwardGyro(.6,3));  //was 2 seconds
    	
    	
    	
    	addSequential(new Auton_resetGyro());
    	addSequential(new Auton_resetEncoders());
    	//forward a little 
    	// code still need 
    	addSequential(new Auton_DriveForwardGyroWithEncoder(1,500,3));
    	// open doors 
    	// code still need 
    	//back a little 
    	/*
    	addSequential(new Auton_wait(4));
    	addSequential(new Auton_resetEncoders());
    	addSequential(new Auton_DriveForwardGyroWithEncoder(-.6,500,3));
    	//forward a little 
    	
    	addSequential(new Auton_resetEncoders());
    	addSequential(new Auton_DriveForwardGyroWithEncoder(.5,-500,3));
    	//back a little 
    	addSequential(new Auton_resetEncoders());
    	addSequential(new Auton_DriveForwardGyroWithEncoder(-.6,-500,3));
    	// code still need 
    	// move backward 
    	//addSequential(new Auton_driveForwardGyro(-1.0,2));
    	*/
    	
    }
}