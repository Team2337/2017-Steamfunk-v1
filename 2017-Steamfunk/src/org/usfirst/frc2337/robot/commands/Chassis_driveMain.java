package org.usfirst.frc2337.robot.commands;

import org.usfirst.frc2337.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Joystick;

/**
 * Chassis DRIVEMAIN - Main drive train thats based of off HALO/CHEESY drive.
 */
public class Chassis_driveMain extends Command {
	
	final Joystick driverJoystick = Robot.oi.getDriverJoystick();
	
	double deadband = Robot.constants.kChassisPID_DriverDeadband;
	double moveSensitivity = Robot.constants.kChassisPID_MoveSensitivity;
	double turnSensitivity = Robot.constants.kChassisPID_TurnSensitivity;
	

	
	public Chassis_driveMain() {
		requires(Robot.chassis);
	}
	
	// Called just before this Command runs the first time
	protected void initialize() {
		
	}
	
	/* When the command is executed, this will constantly check the deadband to update the speed
	 according to the deadband. */
	protected void execute() {
		double moveSpeed = driverJoystick.getRawAxis(1); //Left Y
		double turnSpeed = driverJoystick.getRawAxis(4); //Right X
		
		if (Math.abs(moveSpeed) < deadband) moveSpeed = 0;
		if (Math.abs(turnSpeed) < deadband) turnSpeed = 0;
		
		moveSpeed *= moveSensitivity;
		turnSpeed *= turnSensitivity;
		
		
		if (driverJoystick.getRawButton(5)) {
			moveSpeed = moveSpeed/2;
			turnSpeed = turnSpeed/1.7;
		}
		
    	Robot.chassis.arcadeDrive(moveSpeed, turnSpeed);
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
