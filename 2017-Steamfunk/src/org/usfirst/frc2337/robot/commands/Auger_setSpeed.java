package org.usfirst.frc2337.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc2337.robot.Robot;

/**
 *
 */
public class Auger_setSpeed extends Command {
	// DECLARE VARIABLES
	 double speed = Robot.constants.kFuelIntake_DefaultSpeed;
	
    public Auger_setSpeed() {
       requires(Robot.fuelIntake);
    }
    
    public Auger_setSpeed(double speed) {
    	requires(Robot.fuelIntake);
    	this.speed = speed;
    }

	// Called just before this Command runs the first time
    protected void initialize() {
    	Robot.auger.setSpeed(speed);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
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
