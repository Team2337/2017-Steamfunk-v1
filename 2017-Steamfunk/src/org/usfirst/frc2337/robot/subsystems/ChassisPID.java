package org.usfirst.frc2337.robot.subsystems;

import org.usfirst.frc2337.robot.RobotMap;
import org.usfirst.frc2337.robot.commands.*;

import com.ctre.CANTalon;
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
	
	//private final AnalogGyro analogGyro	= RobotMap.chassisPID_analogGyro;
	
	// Initialize your subsystem here
	public ChassisPID() {
		// PID LOOP
		super("ChassisPID", 1.0, 0.0, 0.0);
		setAbsoluteTolerance(1); //1 degree
		setInputRange(0, 360);
		getPIDController().setContinuous(true);

		//LiveWindow.addActuator("ChassisPID Gyro", "Gyro", analogGyro);
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
		//analogGyro.reset();
	}
	
	/**
	 * Gets the current angle of the Gyro from 0 to 360 degrees
	 */
	public double getGyroAngle() {
		return 0; //(analogGyro.getAngle() % 360);
	}
	
	/**
	 * Gets the current angle of the Gyro on a continuous scale (over 360 degrees)
	 */
	public double getGyroAngleContinuous() {
		return 1; //analogGyro.getAngle();
	}
	
	public void stopMotors() {
		robotDrive.stopMotor();
	}
	
	protected double returnPIDInput() {
		// Return your input value for the PID loop
		// e.g. a sensor, like a potentiometer:
		// yourPot.getAverageVoltage() / kYourMaxVoltage;
		
		return getGyroAngle(); //Convert from continuous scale (360 -> 361) to rollover scale (360 -> 1).
		
	}
	
	protected void usePIDOutput(double output) {
		// Use output to drive your system, like a motor
		// e.g. yourMotor.set(output);
		
	}
}
