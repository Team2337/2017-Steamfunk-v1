package org.usfirst.frc2337.robot.commands;


import org.usfirst.frc2337.robot.Robot;
import org.usfirst.frc2337.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *  Drives forward/reverse at 'speed' to a given 'target', either forward or reverse,
 *  using the encoder(reset to 0) for distance and gyro to drive straight.
 *  Can also inout a timeout, otherwise it will default to 5 seconds.
 */
public class Auton_DriveForwardGyroWithEncoder extends Command {
	
	
	double kMaxCorrectionRatio = 0.30; /* cap corrective turning throttle to 30 percent of forward throttle */
	public double Kp = 0.04; /* percent throttle per degree of error */
	public double Kd = 0.04; /* percent throttle per degree of error */
	public double yaw;
	public int m_target;
	public double m_speed;
	public double m_timeout;
	
	public double targetAngle, currentAngle, turnThrottle, maxThrottle, forwardThrottle;
	public double currentAngularRate = 0;
	
	public double baseAngle;


	public Auton_DriveForwardGyroWithEncoder() {
	   	requires(Robot.chassis);
	   	setTimeout(5);
	   	m_speed = 0.3;
	   	//m_target = Robot.prefs.getInt("AutonEncDist", 60);
	   	m_target = 60;
	}	
	public Auton_DriveForwardGyroWithEncoder(double speed) {
	   	requires(Robot.chassis);
	   	setTimeout(5);
	   	m_speed = speed;
	   	//m_target = Robot.prefs.getInt("AutonEncDist", 60);
	   	m_target = 60;
	}
	  public Auton_DriveForwardGyroWithEncoder(double speed, int encoderTarget) {
	   	requires(Robot.chassis);
    	setTimeout(5);
    	m_target = encoderTarget;
    	m_speed = speed;
    }
	  
	  public Auton_DriveForwardGyroWithEncoder(double speed, double timeout) {
	   	requires(Robot.chassis);
	   	m_timeout = timeout;
    	m_speed = speed;
    }
		 
	  public Auton_DriveForwardGyroWithEncoder(double speed, int encoderTarget, double timeout) {
	   	requires(Robot.chassis);
	   	m_timeout = timeout;
    	m_target = encoderTarget;
    	m_speed = speed;
    }
    

    // Called just before this Command runs the first time
    protected void initialize() {
    	
		setTimeout(m_timeout);
		baseAngle = RobotMap.chassisPID_gyro.getYaw();
		RobotMap.chassisPID_rightFront.setEncPosition(0);
		/**if (m_target > 0 ){
			m_speed = - m_speed;
			}
		**/
	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	yaw = -RobotMap.chassisPID_gyro.getYaw();
    	Robot.chassis.arcadeDrive(m_speed,0);//baseAngle-yaw*Kp);
    	
    	
    	//////////////////////find angulAr rate.........................
    	
    	
		/* very simple Proportional and Derivative (PD) loop with a cap,
		 * replace with favorite close loop strategy or leverage future Talon <=> Pigeon features. */
	//	turnThrottle = (targetAngle - currentAngle) * Kp - (currentAngularRate) * Kd;
		/* the max correction is the forward throttle times a scalar,
		 * This can be done a number of ways but basically only apply small turning correction when we are moving slow
		 * and larger correction the faster we move.  Otherwise you may need stiffer pgain at higher velocities. */
		
		/* make it positive */
	//	maxThrottle = (turnThrottle < 0 ? -turnThrottle: turnThrottle);
		/* max correction is the current forward throttle scaled down */
	//	maxThrottle *= kMaxCorrectionRatio;
		/* ensure caller is allowed at least 10% throttle,
		 * regardless of forward throttle */
    //	if(maxThrottle < 0.10){maxThrottle = 0.10;}
		
		// Cap turnThrottle
	//	turnThrottle = (turnThrottle > maxThrottle ? maxThrottle: turnThrottle);
	//	turnThrottle = (turnThrottle < -maxThrottle ? -maxThrottle: turnThrottle);
    	
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return (RobotMap.chassisPID_rightFront.getEncPosition() > m_target|| isTimedOut()); //|| Robot.chassis.isStopped());
    	//return false;
    	//RobotMap.chassisPID_leftFront.getEncPosition()
    }

    // Called once after isFinished returns true
    protected void end() {
    	//Robot.chassis.stopMotors();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}

