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
	
	private final CANTalon rightFront	= RobotMap.chassisPIDrightFront;
	private final CANTalon rightRear	= RobotMap.chassisPIDrightRear;
	private final CANTalon leftFront	= RobotMap.chassisPIDleftFront;
	private final CANTalon leftRear		= RobotMap.chassisPIDleftRear;
	private final RobotDrive robotDrive	= RobotMap.chassisPIDRobotDrive;
	
	private final AnalogGyro analogGyro	= RobotMap.chassisPIDanalogGyro;
	
	// Initialize your subsystem here
	public ChassisPID() {
		// PID LOOP
		super("ChassisPID", 1.0, 0.0, 0.0);
		setAbsoluteTolerance(1); //1 degree
		setInputRange(0, 360);
		getPIDController().setContinuous(true);

		LiveWindow.addActuator("ChassisPID Gyro", "Gyro", analogGyro);
		LiveWindow.addActuator("ChassisPID", "PIDSubsystem Controller", getPIDController());
		
		// Disable brake mode on the motors
		setBrakeMode(false);
		
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
	
	public void resetGyro() {
		analogGyro.reset();
	}
	
	/**
	 * Gets the current angle of the Gyro from 0 to 360 degrees
	 */
	public double getGyroAngle() {
		return (analogGyro.getAngle() % 360);
	}
	
	/**
	 * Gets the current angle of the Gyro on a continuous scale (over 360 degrees)
	 */
	public double getGyroAngleContinuous() {
		return analogGyro.getAngle();
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
		
		rightFront.pidWrite(output);
		rightRear.pidWrite(output);
		leftFront.pidWrite(output);
		leftRear.pidWrite(output);
	}
}
