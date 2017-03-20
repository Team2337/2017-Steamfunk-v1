package org.usfirst.frc2337.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc2337.robot.Constants;
import org.usfirst.frc2337.robot.Robot;

/**
 *
 */
public class AutonCG_Shootfromwall extends CommandGroup {
	
    public AutonCG_Shootfromwall() {
    	
    	
    	
    	//addSequential(new Auton_wait(5));
    	//addParallel(new FuelShooter_speedSet(0, Robot.constants.kFuelShooter_autonMidGearShotSpeedRight));
    	addParallel(new FuelShooter_speedSet(Robot.constants.kFuelShooter_autonMidGearShotSpeedLeft,0));
    	//Both Shooters
    	//addParallel(new FuelShooter_speedSet(Robot.constants.kFuelShooter_autonMidGearShotSpeedLeft, Robot.constants.kFuelShooter_autonMidGearShotSpeedRight));
    	addSequential(new Auton_wait4Shooter(10));
    	//addParallel(new FuelFeeder_right(.5, .7));
    	addParallel(new FuelFeeder_left(.5, .7));
    	//Both SHooters
    	//addParallel(new FuelFeeder_setSpeedTimed(-Robot.constants.kFeeder_AutonDefaultEnableSpeed,90));
    	addSequential(new Auton_wait(90));
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