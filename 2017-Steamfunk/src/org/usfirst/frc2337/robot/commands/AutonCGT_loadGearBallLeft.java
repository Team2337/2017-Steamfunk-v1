package org.usfirst.frc2337.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc2337.robot.Constants;
import org.usfirst.frc2337.robot.Robot;

/**
 *
 */
public class AutonCGT_loadGearBallLeft extends CommandGroup {
	
    public AutonCGT_loadGearBallLeft() {
    	
   
    	addSequential(new Auton_resetEncoders());
    	addSequential(new Auton_resetGyro());
    	addSequential(new AutonT_turnGyroOverFlow(90));
       	addSequential(new Auton_resetGyro());
       	addSequential(new Auton_resetEncoders());
    	addSequential(new Auton_driveForwardTurnEncoder(-.6,5000,0,5));
    }
}
