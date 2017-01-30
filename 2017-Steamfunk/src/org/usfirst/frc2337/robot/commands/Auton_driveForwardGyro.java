package org.usfirst.frc2337.robot.commands;

import org.usfirst.frc2337.robot.Robot;
import org.usfirst.frc2337.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;


	
public class Auton_driveForwardGyro extends Command {

	public double speed;
	public double Kp = 0.03;
	public double yaw;
	public double time;
	public double baseAngle;

    public Auton_driveForwardGyro(double speed, double time) {
    	requires(Robot.chassis);
    	this.time = time;
    	this.speed = speed;
    	setTimeout(time);

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(time);
    	baseAngle = RobotMap.chassisPID_gyro.getYaw();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	yaw = RobotMap.chassisPID_gyro.getYaw();
    	RobotMap.chassisPID_RobotDrive.drive(speed, baseAngle-yaw*Kp);
    	    	
    } 
    

	protected boolean isFinished() {

		return isTimedOut();
	}
	 // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
  
}
	  