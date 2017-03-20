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
    	addSequential(new ControlProfile());
    	addSequential(new Auton_wait(.5));
    	addSequential(new GearLoader_extend());
    	//addParallel(new FuelShooter_speedSet(Robot.constants.kFuelShooter_hopperShotSpeedLeft, Robot.constants.kFuelShooter_hopperShotSpeedRight));
    	addSequential(new Auton_wait(1));
    	addSequential(new GearLoader_retract());
    	addSequential(new Auton_wait(.5));
    	/////////////////////////////////////
    	//addSequential(new Auton_driveForTime(-.6, 0, .5)); // was 1.5
    	//addSequential(new Auton_wait(3));
    	//addSequential(new Auton_turnGyro(66));
    	//addSequential(new Auton_wait(3));
    	//addSequential(new Chassis_targetWithGyroAndDrive(-.6, 2.2));
    	////////////////////////////////////////
    	addSequential(new Auton_driveForTime(-.6, .6, 2)); // was 1.5
    	//addSequential(new Chassis_targetWithGyroAndDrive(-.6, 1.1));
    	addSequential(new Auton_driveForTime(-.6, 0, 1.1));
    	addSequential(new Auton_wait(.2));
    	addSequential(new Auton_resetGyro());
    	addSequential(new Auton_wait(.2));
    	addSequential(new Chassis_targetWithGyro());
    	addSequential(new Auton_wait(1));
    	addParallel(new FuelFeeder_setSpeedTimed(-Robot.constants.kFeeder_AutonDefaultEnableSpeed,10));
    	
    	
    	
    }
}