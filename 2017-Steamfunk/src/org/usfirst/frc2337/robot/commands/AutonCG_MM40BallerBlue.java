package org.usfirst.frc2337.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc2337.robot.Constants;
import org.usfirst.frc2337.robot.Robot;

/**
 * AutonCG_MM40BallRed - Gets 40 balls in auton mode (hopefully);
 */
public class AutonCG_MM40BallerBlue extends CommandGroup {
	
    public AutonCG_MM40BallerBlue() {
    	addParallel(new FuelShooter_speedSetRPM(Robot.constants.kFuelShooter_autonBlueHopperShotSpeedLeftRPM, Robot.constants.kFuelShooter_autonBlueHopperShotSpeedRightRPM));
    	//addSequential(new Auton_MMMoveForward(Robot.constants.kAuton_InitialDistanceBlue));
    	addSequential(new ControlProfile40ball()); 
    	addSequential(new FuelIntakeArm_extend()); // arm out then below is the shooters
    	addSequential(new Auton_MMTurnBlue());
    	addSequential(new HopperWings_extendBlue());
    	//addSequential(new Chassis_targetWithMotionRev());
    	
    	
    	addSequential(new Auton_MMMoveForward(Robot.constants.kAuton_DriveToHopperDistanceBlue));//,.8));
    	
    	addParallel(new FuelIntake_enabledReverse()); //XXX using Reverse on practicerobot, switch back to Forward, use Reverse for comp bot
    	addParallel(new FuelFeeder_setSpeedTimed(-Robot.constants.kFeeder_AutonDefaultEnableSpeed,15));
    	addParallel(new Chassis_targetWithMotionRev());
    	addSequential(new Auton_wait(5.5));
    	addSequential(new FuelIntakeArm_retract());
    	
    }
}
