package org.usfirst.frc2337.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc2337.robot.Constants;
import org.usfirst.frc2337.robot.Robot;

/**
 *
 */
public class AutonCG_midGear extends CommandGroup {
	
    public AutonCG_midGear() {
    	
    	
 
    	addSequential(new ControlProfile());
    	//System.out.println("MIDGEAR_PRO");
    
    	addSequential(new Auton_wait(1));
   
    	addSequential(new GearLoader_extend());
    
    	addSequential(new Auton_wait(1));
    	addSequential(new Auton_driveForTime(-.6,0,.5)); // was 1.5
    	/* shooting stuff need testing 
    	addParallel(new FuelShooter_speedSet(-Robot.constants.kFuelShooter_hopperShotSpeedLeft, Robot.constants.kFuelShooter_hopperShotSpeedRight));
    	addSequential(new Auton_turnGyro(-75));
    	//addParallel(new Chassis_targetWithGyro()); no target rn
    	addSequential(new Auton_wait(1));
    	addParallel(new FuelFeeder_setSpeedTimed(-Robot.constants.kFeeder_DefaultEnableSpeed,8));
    
    	addSequential(new Auton_wait(8));
    	addSequential(new FuelShooter_stopShooters());
    	*/
    }
}