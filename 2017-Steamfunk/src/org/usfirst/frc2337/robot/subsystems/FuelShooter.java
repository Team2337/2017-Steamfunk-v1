package org.usfirst.frc2337.robot.subsystems;
import org.usfirst.frc2337.robot.Robot;
import org.usfirst.frc2337.robot.RobotMap;
import org.usfirst.frc2337.robot.commands.*;

import com.ctre.CANTalon;


import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * FUEL SHOOTER
 * - BEING IMPROVED BY GUS (RPM)
 * Best code ever.
 */
public class FuelShooter extends Subsystem {
	
	private final CANTalon shooterMotorLeft = RobotMap.shooterCANTalonLeft;
	private final CANTalon shooterMotorRight = RobotMap.shooterCANTalonRight;
	private final Relay shooterLight = RobotMap.shooterLight;
	
	private double currentSpeed = Robot.constants.kFuelShooter_DefaultSpeed;
	//double incrementSpeed = Robot.constants.kFuelShooter_IncrementSpeed;
	
	public FuelShooter() {
		shooterMotorLeft.enableBrakeMode(false);
		shooterMotorRight.enableBrakeMode(false);
	}

	public void initDefaultCommand() {
		// setDefaultCommand(new MySpecialCommand());
		
	}

	/**
	 * Updates Speed via SmartDashboard
	 */
	public void updateSpeed() {
		shooterMotorLeft.set(currentSpeed);
		shooterMotorRight.set(currentSpeed);
		SmartDashboard.putNumber("Shooter Speed:", currentSpeed);
	}
	
	public void updateSpeedRPM() {
		shooterMotorLeft.setSetpoint(currentSpeed);
		shooterMotorRight.setSetpoint(currentSpeed);
		SmartDashboard.putNumber("Shooter Speed:", currentSpeed);
	}
	
	/**
	 * Set speeds of shooter
	 * @param speed Sets speed of shooter
	 */
	public void setVoltage(double speedLeft, double speedRight) {
		System.out.println("YOU ARE IN VOLTAGE MODE");
		shooterMotorLeft.set(speedLeft);
		shooterMotorRight.set(speedRight);
	}
	
	public void setRPM(double speedLeft, double speedRight) {
		shooterMotorLeft.setSetpoint(speedLeft);
		shooterMotorRight.setSetpoint(speedRight);
	}
	    
	/**
	 * Stop both shooters
	 */    
	public void stopMotorsVoltage() {
		shooterMotorLeft.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		shooterMotorRight.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		shooterMotorLeft.changeControlMode(CANTalon.TalonControlMode.Voltage);
		shooterMotorRight.changeControlMode(CANTalon.TalonControlMode.Voltage);
	}
	
	public void stopMotorsRPM() {
		shooterMotorLeft.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		shooterMotorRight.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		shooterMotorLeft.changeControlMode(CANTalon.TalonControlMode.Speed);
		shooterMotorRight.changeControlMode(CANTalon.TalonControlMode.Speed);
	}
	
	/**
	 * Increase RPM of Left Shooter
	 */ 
	public void increaseShooterLeft() {
    	//currentSpeed =+100;
		shooterMotorLeft.set(shooterMotorLeft.get() + .1);
	}
	
	public void increaseShooterLeftRPM() {
    	//currentSpeed =+100;
		shooterMotorLeft.set(shooterMotorLeft.get() + 25);
	}
	
	/**
	 * Decrease RPM of Left Shooter
	 */
	public void decreaseShooterLeft() {
	    	//currentSpeed =-100;
		shooterMotorLeft.set(shooterMotorLeft.get() - .1);
	}
	
	public void decreaseShooterLeftRPM() {
    	//currentSpeed =-100;
	shooterMotorLeft.set(shooterMotorLeft.get() - 25);
	}
	
	/**
	 * Increase RPM of Right Shooter
	 */    
	public void increaseShooterRight() {
	    	//currentSpeed =+100;
		shooterMotorRight.set(shooterMotorRight.get() + .1);
	}
	
	public void increaseShooterRightRPM() {
    	//currentSpeed =+100;
	shooterMotorRight.set(shooterMotorRight.get() + 25);
	}
	/**
	 * Decrease RPM of Right Shooter
	 */
	public void decreaseShooterRight() {
	    	//currentSpeed =-100;
		shooterMotorRight.set(shooterMotorRight.get() - .1);	
	}
	
	public void decreaseShooterRightRPM() {
    	//currentSpeed =-100;
	shooterMotorRight.set(shooterMotorRight.get() - 25);	
	}
	/**
	 * Turns relay on
	 */
	public void lightOn() {
		shooterLight.set(Relay.Value.kOn);
	}
	/**
	 * Turns relay off
	 */
	public void lightOff() {
		shooterLight.set(Relay.Value.kOff);
	}
}

