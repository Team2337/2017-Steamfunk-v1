package org.usfirst.frc2337.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc2337.robot.Constants;
import org.usfirst.frc2337.robot.Robot;
import org.usfirst.frc2337.robot.RobotMap;

/**
 * 40 BALL - It shooter 40 balls from triggering the hopper.
 */
public class AutonCG_40Baller extends CommandGroup {
	
    public AutonCG_40Baller() {
   
    	
    	addSequential(new ControlProfile40ballRed());
    	addSequential(new Auton_driveForTime(.7, 0, 0.12));// added at troy after #2  match
    	addSequential(new FuelIntakeArm_extend());
    	addParallel(new FuelShooter_speedSetRPM(Robot.constants.kFuelShooter_autonRedHopperShotSpeedLeftRPM, Robot.constants.kFuelShooter_autonRedHopperShotSpeedRightRPM));
    	//Driverstation.Alliance CurrentSide = ;
    	if (Robot.AllianceColor == DriverStation.Alliance.Blue) {
    		addSequential(new Auton_driveRightWheel(.8, 1.5));
    	//	System.out.println("Blue");
    	//	SmartDashboard.putString("Side:", "blue");
    	} else { 
    		addSequential(new Auton_driveLeftWheel(1.0, 1.6));// was 1.4 troy p match was .8 before #3 of troy
    	//	System.out.println("Red");
    	//	SmartDashboard.putString("Side:", "Red");
    	}
    	
    	//addParallel(new Auton_driveRightWheel(.8, 1));
    	//addSequential(new Auton_wait(.8));
    	
    	addSequential(new Auton_wait(.2));
    	addParallel(new AutonHopperWings_extend()); //  added  at kettering after match 3 
    	addSequential(new Auton_driveForTime(-.5, 0, 0.5)); //changed from .5 after qual 25 at Troy
    	//addSequential(new HopperWings_extend());
    	//addSequential(new Auton_wait(.2));
    	//addParallel(new Chassis_targetWithGyro()); // need 
    	
    	//addSequential(new Auton_wait(.5));
    	addParallel(new FuelIntake_enabledReverse()); //XXX using Reverse on practicerobot, switch back to Forward, use Reverse for comp bot
    	addParallel(new FuelFeeder_setSpeedTimed(-Robot.constants.kFeeder_AutonDefaultEnableSpeed,10));
    	//
    	   	
    	addSequential(new Auton_wait(5.5));
    	addSequential(new FuelIntakeArm_retract());
    	//addSequential(new Auton_wait(3));
    	//addSequential(new FuelShooter_stopShooters());
    	 
    	//addSequential(new HopperWings_retract());
    	   //XXX add later
    	//addSequential(new FuelIntake_disable());

    	
    }
}