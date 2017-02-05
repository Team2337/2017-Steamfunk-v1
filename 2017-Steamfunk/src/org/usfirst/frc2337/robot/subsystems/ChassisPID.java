package org.usfirst.frc2337.robot.subsystems;

import org.usfirst.frc2337.robot.Robot;
import org.usfirst.frc2337.robot.RobotMap;
import org.usfirst.frc2337.robot.commands.*;

import com.ctre.CANTalon;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class ChassisPID extends PIDSubsystem {
	
	private final CANTalon rightFront	= RobotMap.chassisPID_rightFront;
	private final CANTalon rightRear	= RobotMap.chassisPID_rightRear;
	private final CANTalon leftFront	= RobotMap.chassisPID_leftFront;
	private final CANTalon leftRear		= RobotMap.chassisPID_leftRear;
	private final RobotDrive robotDrive	= RobotMap.chassisPID_RobotDrive;
	public boolean reverse = false;
	//private final AHRS gyro	= RobotMap.chassisPID_gyro;
	
	private final AHRS gyro	= RobotMap.chassisPID_gyro;
	
	// Initialize your subsystem here
	public ChassisPID() {
		// PID LOOP
		super("ChassisPID", 0.03, 0.0, 0.0);
		setAbsoluteTolerance(0.2); //1 degree
		getPIDController().setContinuous(true);

		//LiveWindow.addActuator("ChassisPID Gyro", "Gyro", gyro);
		LiveWindow.addActuator("ChassisPID", "PIDSubsystem Controller", getPIDController());
	
		// Disable brake mode on the motors
		setBrakeMode(true);
		
		// Use these to get going:
		// setSetpoint() -  Sets where the PID controller should move the system to
		// enable() - Enables the PID controller.
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		//setDefaultCommand(new MySpecialCommand());
		
		setDefaultCommand(new ChassisPID_driveCheesy());
		
	}

	public void tankDrive(double leftValue, double rightValue) {
		robotDrive.tankDrive(leftValue, rightValue, true);
	}
	
	/**
	 * Uses RobotDrive to move using a speed and rotation rate.
	 * 
	 * @param speedValue The speed at which to move.
	 * @param turnValue The speed at which to turn.
	 */
	public void arcadeDrive(double speedValue, double turnValue) {
		robotDrive.arcadeDrive(speedValue, turnValue, true);
	}
	
	/**
	 * Sets the mode of the CANTalons to Brake or Coast
	 * @param mode true = brake, false = coast
	 */
	public void setBrakeMode(boolean mode) {
		rightFront.enableBrakeMode(mode);
		rightRear.enableBrakeMode(mode);
		leftFront.enableBrakeMode(mode);
		leftRear.enableBrakeMode(mode);
	}
	
	/**
	 * Resets the current angle of the Gyro to 0.
	 */
	public void resetGyro() {
		gyro.reset();
	}
	/**
	 * Get yaw angle of gyro
	 * @return Yaw of gyro
	 */
    public double getGyroYaw() {
    	return gyro.getYaw();
    }
	
	public void stopMotors() {
		robotDrive.stopMotor();
	}
	
	protected double returnPIDInput() {
		// Return your input value for the PID loop
		// e.g. a sensor, like a potentiometer:
		// yourPot.getAverageVoltage() / kYourMaxVoltage;
		
		return getGyroYaw(); //Convert from continuous scale (360 -> 361) to rollover scale (360 -> 1).
		
	}
	
	protected void usePIDOutput(double output) {
		// Use output to drive your system, like a motor
		// e.g. yourMotor.set(output);
		
	}
	 public void setReverse() {
		 reverse = true;
		 
		 
	    /*	rightFront.set(Robot.constants.kChassisPID_MoveSensitivity * reverseSpeed);
	    	rightRear.set(Robot.constants.kChassisPID_MoveSensitivity * reverseSpeed);
	    	leftFront.set(Robot.constants.kChassisPID_MoveSensitivity * reverseSpeed);
	    	leftRear.set(Robot.constants.kChassisPID_MoveSensitivity * reverseSpeed);*/
	    }
	 public void setNormal() {
		 reverse = false;
	 }
}
