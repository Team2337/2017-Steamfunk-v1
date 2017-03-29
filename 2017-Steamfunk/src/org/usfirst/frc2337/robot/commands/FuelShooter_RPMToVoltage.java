package org.usfirst.frc2337.robot.commands;

import org.usfirst.frc2337.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class FuelShooter_RPMToVoltage extends Command {

	public FuelShooter_RPMToVoltage() {
		
	}
	// Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	RobotMap.RPMandVoltageSwitch = true;
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



