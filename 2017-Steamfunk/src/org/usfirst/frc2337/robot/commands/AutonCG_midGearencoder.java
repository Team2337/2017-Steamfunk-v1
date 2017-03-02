package org.usfirst.frc2337.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc2337.robot.Constants;
import org.usfirst.frc2337.robot.Robot;

/**
 *
 */
public class AutonCG_midGearencoder extends CommandGroup {
	
    public AutonCG_midGearencoder() {
    	
    	
    	
    	addSequential(new Auton_resetGyro());
    	addSequential(new Auton_wait(0));
    
    	addSequential(new Auton_resetEncoders());
    	addSequential(new Auton_wait(.1));
    	
    	//forward a little 
    	
    //	addSequential(new ControlProfile());
    	addSequential(new Auton_driveForwardGyroWithEncoder(.55, 24000,4.5));  //was 1.0 speed
    	// addSequential(new Auton_driveForwardGyroWithEncoderPID(20000,6));
    	addSequential(new Auton_wait(1));
    addSequential(new Auton_resetEncoders());
    addSequential(new Auton_wait(.1));
    	//addSequential(new GearLoader_extend());
    	//forward a little 
    	addSequential(new Auton_driveForwardGyroWithEncoder(.5, 5000,1));  //was 1.0 speed
    	
    	// open doors 
    addSequential(new Auton_wait(1));
    	//addSequential(new Auton_driveForTime(-.6,0,1.5));
    	
    	
    	//addSequential(new Auton_turnGyro(-120, 2));
    	//addParallel(new FuelFeeder_forward());
    	//addParallel(new FuelShooter_speedSet(Robot.constants.kFuelShooter_airshipShotSpeedLeft, Robot.constants.kFuelShooter_airshipShotSpeedLeft));
    	//addSequential(new Auton_wait(3));
    	//addSequential(new )
    addSequential(new GearLoader_extend());
    	//back a little 
    	
    	addSequential(new Auton_wait(.4));
    	addSequential(new Auton_resetEncoders());
    	addSequential(new Auton_wait(.1));
    	addSequential(new Auton_driveForwardGyroWithEncoder(-.6,1000,2));
    	
    	//forward a little 
    	
    	addSequential(new Auton_resetEncoders());
    	addSequential(new Auton_wait(.1));
    	addSequential(new Auton_driveForwardGyroWithEncoder(.6,3000,1));
    	
    	//back a little 
    	addSequential(new Auton_resetEncoders());
    	addSequential(new Auton_wait(.1));
    	addSequential(new Auton_driveForwardGyroWithEncoder(-.6,2000,2));
    	/*
    	// code still need 
    	// move backward 
    	//addSequential(new Auton_driveForwardGyro(-1.0,2));
    	*/
    	
    }
}