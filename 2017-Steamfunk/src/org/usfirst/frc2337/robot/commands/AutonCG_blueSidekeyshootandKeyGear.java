package org.usfirst.frc2337.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc2337.robot.Constants;
import org.usfirst.frc2337.robot.Robot;

/**
 *
 */
public class AutonCG_blueSidekeyshootandKeyGear extends CommandGroup {
	
    public AutonCG_blueSidekeyshootandKeyGear() {
    	// target 
    	//addSequential(new ) code still need
    	// shoot 
    	//addparallel(new ) code still need
    	// move forward and turn 
    	addSequential (new Auton_driveForTime(.5,1.0,4));
    	// turn 90
    	addSequential (new Auton_turnGyro(90));
    	//move forward 
    	addSequential(new Auton_driveForwardGyro(1.0,3));//113 in 
    	// turn 270
    	addSequential (new Auton_turnGyro(270));
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