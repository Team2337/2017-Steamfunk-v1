package org.usfirst.frc2337.robot.commands;


import org.usfirst.frc2337.robot.Robot;
import org.usfirst.frc2337.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.PIDController;


/**
 *  PID CODE
 */

public class Auton_driveForwardEncoderTwoWheel extends Command {
	
	public PIDController LeftController;
	public PIDController RightController;
	public double m_timeout;
	public double leftDistance;
	public double rightDistance;
	
/**
 * 
 * @param leftDistance
 * @param rightDistance
 * @param timeout
 */

	  public Auton_driveForwardEncoderTwoWheel( int leftDistance, int rightDistance, double timeout) {
	   	requires(Robot.chassis);
	
	   	m_timeout = timeout;
	   	this.leftDistance = leftDistance;
	   	this.rightDistance = rightDistance;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
		setTimeout(m_timeout);
		RobotMap.chassisPID_leftFront.setEncPosition(0);
		RobotMap.chassisPID_rightFront.setEncPosition(0);
		
		Robot.chassis.LeftController.setSetpoint(leftDistance);
		Robot.chassis.RightController.setSetpoint(rightDistance);
		
		Robot.chassis.LeftController.enable();
		Robot.chassis.RightController.enable();

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	


    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return ( isTimedOut() || (Robot.chassis.RightController.onTarget() && Robot.chassis.LeftController.onTarget())); //|| Robot.chassis.isStopped());
   
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.chassis.LeftController.disable();
    	Robot.chassis.RightController.disable();
    	Robot.chassis.arcadeDrive(0,0);

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	
    	end();
    }
  
}

