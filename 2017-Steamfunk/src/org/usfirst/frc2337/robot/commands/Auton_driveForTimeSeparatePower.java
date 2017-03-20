package org.usfirst.frc2337.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc2337.robot.Robot;
import org.usfirst.frc2337.robot.RobotMap;

/**
 *
 */
public class Auton_driveForTimeSeparatePower extends Command {
	
	double time;
	double speed;
	double turn;
	
	/**
	 * drive forward or forward and turn for a time 
	 * @param speed from -1 to 1
	 * @param turn from -1 to 1 
	 * @param time in seconds
	 */
    public Auton_driveForTimeSeparatePower(double speed,double turn, double time) {
    	requires(Robot.chassis);
    	
    	this.speed = speed;
    	this.time = time;
    	this.turn = turn;
    }

	// Called just before this Command runs the first time
    protected void initialize() {

    	setTimeout(time);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	RobotMap.chassisPID_RobotDrive.arcadeDrive(speed, turn);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.chassisPID_RobotDrive.stopMotor();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
