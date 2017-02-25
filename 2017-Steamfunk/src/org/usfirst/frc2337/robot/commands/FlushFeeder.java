package org.usfirst.frc2337.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc2337.robot.Robot;

/**
 *
 */
public class FlushFeeder extends Command {
	// DECLARE VARIABLES
	 double speed = 0.3;
	
    public FlushFeeder() {
       requires(Robot.feeder);
    }
    
    public FlushFeeder(double speed) {
    	requires(Robot.feeder);
    	this.speed = speed;
    }

	// Called just before this Command runs the first time
    protected void initialize() {
    	Robot.feeder.reverseAuger(speed);
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
    	Robot.feeder.setSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
