package org.usfirst.frc2337.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc2337.robot.Constants;
import org.usfirst.frc2337.robot.Robot;
import org.usfirst.frc2337.robot.RobotMap;

/**
 *
 */
public class AutonCG_40Baller extends CommandGroup {
	
    public AutonCG_40Baller() {
   
    	
    	addSequential(new ControlProfile40ball());
    	addSequential(new FuelIntakeArm_extend());
    	addParallel(new FuelShooter_speedSet(-Robot.constants.kFuelShooter_hopperShotSpeedLeft, Robot.constants.kFuelShooter_hopperShotSpeedRight));
    	//Driverstation.Alliance CurrentSide = ;
    	if (Robot.AllianceColor == DriverStation.Alliance.Blue) {
    		addSequential(new Auton_driveRightWheel(-.8, 2));
    		System.out.println("Blue");
    	} else { 
    		addSequential(new Auton_driveLeftWheel(.8, 2));
    		System.out.println("Red");
    	}
    	
    	//addParallel(new Auton_driveRightWheel(.8, 1));
    	addSequential(new Auton_wait(.8));
    	addSequential(new HopperWings_extend());
    	addSequential(new Auton_wait(.2));
    	
    	addSequential(new Auton_driveForTime(-.5,0, .5));
    	addSequential(new Auton_wait(.2));
    	//addParallel(new Chassis_targetWithGyro()); // need 
    	
    	addSequential(new Auton_wait(.5));
    	addParallel(new FuelIntake_enabledReverse()); //XXX using Reverse on practicerobot, switch back to Forward
    	addParallel(new FuelFeeder_setSpeedTimed(-Robot.constants.kFeeder_DefaultEnableSpeed,7));
    	//addSequential(new FuelIntakeArm_retract());   //XXX add later
    	
    	addSequential(new Auton_wait(7));
    	addSequential(new FuelShooter_stopShooters());
    	
    	
    }
}