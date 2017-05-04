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
    	//addSequential(new ControlProfile());
    	//addSequential(new Auton_MMMoveForward(-7.361));
    	//addSequential(new Auton_DFGwE(-.5, -7.361, 4));
    	//addSequential(new Auton_MMMoveForwardTest(-7.361));
    //	addSequential(new HopperWings_extend());
    	//addSequential(new HopperWings_retractTimed());
    	addSequential(new ControlProfile40ball()); 
    //	addSequential(new Auton_MMTurnBlue());
   // 	addSequential(new HopperWings_extendBlue());
    	
    	
    	

    	 
    
    }
}
