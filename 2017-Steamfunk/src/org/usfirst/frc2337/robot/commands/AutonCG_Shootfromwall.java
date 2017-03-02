package org.usfirst.frc2337.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc2337.robot.Constants;
import org.usfirst.frc2337.robot.Robot;

/**
 *
 */
public class AutonCG_Shootfromwall extends CommandGroup {
	
    public AutonCG_Shootfromwall() {
    	
    	
    	
    	
    	addParallel(new FuelShooter_speedSet(-Robot.constants.kFuelShooter_hopperShotSpeedLeft, Robot.constants.kFuelShooter_hopperShotSpeedRight));
    	addSequential(new Auton_wait(1));
    	addParallel(new FuelFeeder_setSpeedTimed(-Robot.constants.kFeeder_DefaultEnableSpeed,10));
   
    	addSequential(new Auton_wait(10));
    	addSequential(new FuelShooter_stopShooters());
    	
    	//addSequential(new )
    	
    	//back a little 
    	/*
    	addSequential(new Auton_wait(.4));
    	addSequential(new Auton_resetEncoders());
    	addSequential(new Auton_wait(.1));
    	addSequential(new Auton_driveForwardGyroWithEncoder(-.6,1000,2));
    	/*
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