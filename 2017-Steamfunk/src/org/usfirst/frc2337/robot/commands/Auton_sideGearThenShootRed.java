package org.usfirst.frc2337.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc2337.robot.Constants;
import org.usfirst.frc2337.robot.Robot;

/**
 *
 */
public class Auton_sideGearThenShootRed extends CommandGroup {
	
    public Auton_sideGearThenShootRed() {
    	////// THIS IS BLUE SIDE ////////////////////////////////////////////////////////////////////////////
    	  addSequential(new Auton_resetGyro());
          addSequential(new ControlProfile());
         // addSequential(new Auton_wait(1));
         // addSequential(new Auton_wait(.2));
          addSequential (new Auton_turnMotionMagic(53));
          addSequential(new Auton_MMMoveForward(Robot.constants.kAuton_DriveToSideGearRed));
          /*
          addParallel(new GearLoader_extend());
          addParallel(new Auton_driveForTime(-.6, .62, 2)); // was 1.5
          addSequential(new Auton_wait(1));
          addSequential(new Auton_driveForTime(.6,0,1)); // was 1.5
          addParallel(new FuelShooter_speedSet(Robot.constants.kFuelShooter_autonMidGearShotSpeedLeft, Robot.constants.kFuelShooter_autonMidGearShotSpeedRight));
          addSequential (new Auton_turnMotionMagic(-10));
          /*
          addSequential(new Auton_wait(.4));
          addSequential(new Auton_driveForTime(-.6, .62, 2)); // was 1.5
          addSequential(new GearLoader_retract());
          addSequential(new Auton_driveForTime(-.6, 0, 1.0));
          addSequential(new Auton_wait(.2));
          addSequential(new Auton_resetGyro());
          addParallel(new FuelFeeder_setSpeedTimed(-Robot.constants.kFeeder_AutonDefaultEnableSpeed,10));
          addSequential(new Auton_driveForTime(0, 0, .5));
          */

    	
    }
}