package org.usfirst.frc2337.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc2337.robot.Robot;

/**
 *
 */
public class autonChassis_driveForTime extends Command {
	
	double time;
	double speed;
	
	/**
	 * 
	 * @param speed from -1 to 1
	 * @param time in seconds
	 */
    public autonChassis_driveForTime(double speed, double time) {
    	requires(Robot.chassisPID);
    	
    	this.speed = speed;
    	this.time = time;
    }

	// Called just before this Command runs the first time
    protected void initialize() {
    	Robot.chassisPID.arcadeDrive(speed, 0);
    	setTimeout(time);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.chassisPID.stopMotors();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
