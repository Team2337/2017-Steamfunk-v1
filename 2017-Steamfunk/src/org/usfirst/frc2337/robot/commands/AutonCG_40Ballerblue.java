package org.usfirst.frc2337.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc2337.robot.Constants;
import org.usfirst.frc2337.robot.Robot;
import org.usfirst.frc2337.robot.RobotMap;

/**
 *
 */
public class AutonCG_40Ballerblue extends CommandGroup {
	
    public AutonCG_40Ballerblue() {
   
    	
    	addSequential(new ControlProfile40ball());
    	addSequential(new FuelIntakeArm_extend());
    	addParallel(new FuelShooter_speedSet(-Robot.constants.kFuelShooter_autonRedHopperShotSpeedLeft, Robot.constants.kFuelShooter_autonRedHopperShotSpeedRight));
    	//Driverstation.Alliance CurrentSide = ;
    	//if (Robot.AllianceColor == DriverStation.Alliance.Blue) {
    		addSequential(new Auton_driveRightWheel(-.8, 1.0));
    		System.out.println("Blue");
    		SmartDashboard.putString("Side:", "blue");
    	//} else { 
    	//	addSequential(new Auton_driveLeftWheel(.8, 1.5));
    		//System.out.println("Red");
    		//SmartDashboard.putString("Side:", "Red");
    	//}
    	
    	//addParallel(new Auton_driveRightWheel(.8, 1));
    	//addSequential(new Auton_wait(.8));
    	
    	addSequential(new Auton_wait(.2));
    	
    	addSequential(new Auton_driveForTime(-.5,0, .5));
    	addSequential(new HopperWings_extend());
    	addSequential(new Auton_wait(.2));
    	//addParallel(new Chassis_targetWithGyro()); // need 
    	
    	addSequential(new Auton_wait(.5));
    	addParallel(new FuelIntake_enabledReverse()); //XXX using Reverse on practicerobot, switch back to Forward, use Reverse for comp bot
    	addParallel(new FuelFeeder_setSpeedTimed(-Robot.constants.kFeeder_DefaultEnableSpeed,7));
    	//
    	   	
    	addSequential(new Auton_wait(6));
    	addSequential(new FuelIntakeArm_retract());
    	addSequential(new Auton_wait(3));
    	//addSequential(new FuelShooter_stopShooters());
    	 
    	//addSequential(new HopperWings_retract());
    	   //XXX add later
    	//addSequential(new FuelIntake_disable());

    	
    }
}