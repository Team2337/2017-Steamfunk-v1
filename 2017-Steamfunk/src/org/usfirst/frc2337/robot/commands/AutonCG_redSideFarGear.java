package org.usfirst.frc2337.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc2337.robot.Constants;
import org.usfirst.frc2337.robot.Robot;

/**
 *
 */
public class AutonCG_redSideFarGear extends CommandGroup {
	
    public AutonCG_redSideFarGear() {
    	
    	//move forward 
    	addSequential(new Auton_driveForwardGyro(1.0,3));// 83.6 in 
    	// turn 63.67
    	addSequential(new Auton_turnGyro(-63.67));
    	// move forward 
    	addSequential(new Auton_driveForwardGyro(1.0,2));
    	// line up 
    	//code still need 
    	// move forward 
    	addSequential(new Auton_driveForwardGyro(1.0,2));
    	// open doors 
    	// code still need 
    	// move backward 
    	addSequential(new Auton_driveForwardGyro(-1.0,1));
    	
    	
    }
}