package org.usfirst.frc2337.robot.subsystems;
import org.usfirst.frc2337.robot.Robot;
import org.usfirst.frc2337.robot.RobotMap;
import org.usfirst.frc2337.robot.commands.*;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * FUEL SHOOTER
 * - BEING IMPROVED BY GUS (RPM)
 */
public class FuelShooter extends Subsystem {
	
	private final CANTalon motorLeft = RobotMap.fuelShooter_motorLeft;
	private final CANTalon motorRight = RobotMap.fuelShooter_motorRight;
	
	private double currentSpeed = Robot.constants.kFuelShooter_DefaultSpeed;
	double incrementSpeed = Robot.constants.kFuelShooter_IncrementSpeed;
	
	double shooterLeftEncPos = RobotMap.fuelShooter_motorLeft.getSpeed();
	double shooterRightEncPos = RobotMap.fuelShooter_motorRight.getSpeed();
	double error;
	double shooterThresh = 10;
	double fLeft = 0;
	double pLeft = 0;
	double iLeft = 0;
	double dLeft = 0;
	double fRight = 0;
	double pRight = 0;
	double iRight = 0;
	double dRight = 0;
	
	public FuelShooter() {
		motorLeft.enableBrakeMode(false);
		motorRight.enableBrakeMode(false);
	}
	
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		
	}
	
	/**
	 * Updates Speed via SmartDashboard
	 */
	public void updateSpeed() {
		motorLeft.set(currentSpeed);
		motorRight.set(currentSpeed);
		SmartDashboard.putNumber("Shooter Speed:", currentSpeed);
	}
	/**
	 * Set speeds of shooter
	 * @param speed Sets speed of shooter
	 */
	public void setShooterSpeed(double speed) {
		currentSpeed = speed;
		if(currentSpeed > 1.0) currentSpeed = 1;
		if(currentSpeed < 0.0) currentSpeed = 0;
		updateSpeed();
	}
	
	/**
	 * Stopps Shooter
	 */
	public void stopShooter() {
		motorLeft.set(0);
		motorRight.set(0);
	}
	
	/**
	 * Increases Shooter speed
	 */
	public void incrementSpeed() {
		setShooterSpeed(currentSpeed += incrementSpeed);
	}
	
	/**
	 * Decreases Shooter speed
	 */
	public void decrementSpeed() {
		setShooterSpeed(currentSpeed -= incrementSpeed);
	}
	
	public void setRPMMode(double speedLeft,  double speedRight){
		motorLeft.changeControlMode(TalonControlMode.Speed);
		motorLeft.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Absolute);
		motorLeft.setProfile(0);
		motorLeft.setF(0.0);
		motorLeft.setP(0.0);
        motorLeft.setI(0); 
        motorLeft.setD(0);
        motorLeft.set(speedLeft);;
        
        motorRight.changeControlMode(TalonControlMode.Speed);
        motorRight.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Absolute);
        motorRight.setProfile(0);
        motorRight.setF(0.0);
        motorRight.setP(0.0);
        motorRight.setI(0); 
        motorRight.setD(0);
        motorRight.set(speedRight);
        
	}
	
	public boolean shooterOnTargetLeft(){
		error = motorLeft.getEncVelocity() - motorLeft.getSetpoint();
		
		if(Math.abs(error) < shooterThresh)
			return false;
		else
			return true;
		
	}
	
	public boolean shooterOnTargetRight(){
		error = motorRight.getEncVelocity() - motorRight.getSetpoint();
		
		if(Math.abs(error) < shooterThresh)
			return false;
		else
			return true;
		
	}
}

