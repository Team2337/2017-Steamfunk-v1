package org.usfirst.frc2337.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc2337.robot.Constants;
import org.usfirst.frc2337.robot.Robot;

/**
 *
 */
public class AutonCG_redSide40ball extends CommandGroup {
	
    public AutonCG_redSide40ball() {
    	// turn 46
    	addSequential (new Auton_turnGyro(46));//Robot.constants.K40Ball));
    	//move forward 
    	addSequential(new Auton_driveForwardGyro(1.0,3));
    	// turn -46 
    	addSequential (new Auton_turnGyro(-46));//-Robot.constants.K40Ball));
    	// move forward 
    	addSequential(new Auton_driveForwardGyro(1.0,2));
    	//addparallel(new start shooter) code still need
    	// kick wings out
    	// code still need 
    	// target 
    	//addSequential(new ) code still need
    	// shoot 
    	//addparallel(new ) code still need
    	// start auger
    	// addparallel(new ) code still need
    	
    	
    	
    }
}