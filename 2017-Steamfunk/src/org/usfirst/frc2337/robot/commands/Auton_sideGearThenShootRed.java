package org.usfirst.frc2337.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc2337.robot.Constants;
import org.usfirst.frc2337.robot.Robot;

/**
 *
 */
public class Auton_sideGearThenShootRed extends CommandGroup {
	
    public Auton_sideGearThenShootRed() {

          addSequential(new Auton_resetGyro());
          addSequential(new ControlProfile());
          addSequential (new Auton_turnMotionMagic(70));
          addSequential(new Auton_MMMoveForward(Robot.constants.kAuton_DriveToSideGearRed));
          addParallel(new FuelShooter_speedSetRPM(Robot.constants.kFuelShooter_autonRedHopperShotSpeedLeftRPM, Robot.constants.kFuelShooter_autonRedHopperShotSpeedRightRPM));
          addSequential(new Auton_wait(3));
          addSequential(new Auton_MMMoveForward(2.0));
          addSequential(new Chassis_targetWithMotionRev());
          addSequential(new Auton_MMMoveForward(2.8));
          addSequential(new Chassis_targetWithMotionRev());
          addParallel(new FuelFeeder_setSpeedTimed(-Robot.constants.kFeeder_AutonDefaultEnableSpeed,10));
          
    	
    }
}