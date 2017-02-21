package org.usfirst.frc2337.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc2337.robot.Robot;

/**
 * Fuel Feeder REVERSE - Reverses the feeder
 */
public class Feeder_reverse extends Command {
	// DECLARE VARIABLES
	 double speed = Robot.constants.kFeeder_DefaultReverseSpeed;
	
    public Feeder_reverse() {
       requires(Robot.fuelFeeder);
    }
    
    public Feeder_reverse(double speed) {
    	requires(Robot.fuelFeeder);
    	this.speed = speed;
    }

	// Called just before this Command runs the first time
    protected void initialize() {
    	Robot.fuelFeeder.reverseAuger(speed);
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
    	Robot.fuelFeeder.setSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
