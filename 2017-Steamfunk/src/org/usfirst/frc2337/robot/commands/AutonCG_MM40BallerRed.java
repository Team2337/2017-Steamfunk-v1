package org.usfirst.frc2337.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc2337.robot.Constants;
import org.usfirst.frc2337.robot.Robot;

/**
 * AutonCG_MM40BallRed - Gets 40 balls in auton mode (hopefully);
 */
public class AutonCG_MM40BallerRed extends CommandGroup {
	
    public AutonCG_MM40BallerRed() {
    	addParallel(new FuelShooter_speedSetRPM(Robot.constants.kFuelShooter_autonRedHopperShotSpeedLeftRPM, Robot.constants.kFuelShooter_autonRedHopperShotSpeedRightRPM));
    	addSequential(new Auton_MMMoveForward(Robot.constants.kAuton_InitialDistanceRed));//, 1)); was -6.971
    	addSequential(new FuelIntakeArm_extend()); // arm out then below is the shooters
    	addSequential(new Auton_MMTurnRed());
    	
    	addSequential(new Chassis_targetWithMotionRev());
    	
    	
    	addSequential(new Auton_MMMoveForward(Robot.constants.kAuton_DriveToHopperDistanceRed));//, .8));
    	addSequential(new HopperWings_extend());
    	
    	addParallel(new FuelIntake_enabledReverse()); //XXX using Reverse on practicerobot, switch back to Forward, use Reverse for comp bot
    	addParallel(new FuelFeeder_setSpeedTimed(-Robot.constants.kFeeder_AutonDefaultEnableSpeed,15));
    	addParallel(new Chassis_targetWithMotionRev());
    	addSequential(new Auton_wait(5.5));
    	addSequential(new FuelIntakeArm_retract());
    	
    	
    }
}
