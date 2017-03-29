package org.usfirst.frc2337.robot.commands;

import org.usfirst.frc2337.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class FuelShooter_VoltageToRPM extends Command {

	public FuelShooter_VoltageToRPM() {
		
	}
	// Called just before this Command runs the first time
    protected void initialize() {
    	
    	
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	RobotMap.RPMandVoltageSwitch = false;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}



