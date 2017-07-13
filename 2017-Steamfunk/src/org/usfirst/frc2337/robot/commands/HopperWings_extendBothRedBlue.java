package org.usfirst.frc2337.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc2337.robot.Robot;

/**
 * Hopper Trigger EXTEND - Moves out the solenoid
 */
public class HopperWings_extendBothRedBlue extends Command {
	
	public HopperWings_extendBothRedBlue() {
		requires(Robot.hopperWings);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		if (Robot.AllianceColor == DriverStation.Alliance.Blue) {
			Robot.hopperWings.extendBlue(); //Calls 'retract' method form hopperTrigger subsystem
    	} else { 
    		Robot.hopperWings.extendRed(); //Calls 'retract' method form hopperTrigger subsystem
    	}
		
		
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.hopperWings.retract(); //Calls 'retract' method form hopperTrigger subsystem
		Robot.hopperWings.retractBlue(); //Calls 'retract' method form hopperTrigger subsystem
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
