package org.usfirst.frc2337.robot.commands;

import org.usfirst.frc2337.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Joystick;

/**
 *
 */
public class ChassisPID_driveCheesy extends Command {
	
	final Joystick driverJoystick = Robot.oi.getDriverJoystick();
	
	double deadband = 0;
	double moveSensitivity = 1;
	double turnSensitivity = 1;
	
	double moveSpeed;
	double turnSpeed;
	
	public ChassisPID_driveCheesy() {
		requires(Robot.chassisPID);
	}
	
	// Called just before this Command runs the first time
	protected void initialize() {
		
	}
	
	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		moveSpeed = driverJoystick.getRawAxis(1); //Left Y
		turnSpeed = driverJoystick.getRawAxis(4); //Right X
		
		if (Math.abs(moveSpeed) < deadband) moveSpeed = 0;
		if (Math.abs(turnSpeed) < deadband) turnSpeed = 0;
		
		moveSpeed *= moveSensitivity;
		turnSpeed *= turnSensitivity;
		
    	Robot.chassisPID.arcadeDrive(moveSpeed, turnSpeed);
	}
	
	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}
	
	// Called once after isFinished returns true
	protected void end() {
	}
	
	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
