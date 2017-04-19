package org.usfirst.frc2337.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc2337.robot.Constants;
import org.usfirst.frc2337.robot.Robot;

/**
 *
 */
public class AutonCG_crossTheLine extends CommandGroup {
	
    public AutonCG_crossTheLine() {
    	//addSequential(new ControlProfile40ballRed());
    	addSequential(new ControlProfile());
    	//addSequential(new Auton_MMMoveForward(-7.361));
    	//addSequential(new Auton_DFGwE(-.5, -7.361, 4));
    	//addSequential(new Auton_MMMoveForwardTest(-7.361));
    	/*
    	addSequential(new Auton_MMTurnRed());
    	addSequential(new Chassis_targetWithMotionRev());
    	Auton_MMMoveForwardTest
    	addSequential(new HopperWings_extend());
    	
    	
    	addSequential(new Auton_MMMoveForward(0.820));
    	
    	addSequential(new Auton_wait(1.1));
    	addSequential(new FuelIntakeArm_retract());
    	//addSequential(new Auton_driveForTime(.7,0,3)); // need to change back motion pro
    	 */
    	 
    
    }
}
