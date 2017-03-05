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
	
	double halfSpeed = 6.0;
    double hopperShotSpeedLeft = 8.9;		//8.9
    double hopperShotSpeedRight = 9.4;		//9.4
    double airshipShotSpeedLeft = 10.15;
    double airshipShotSpeedRight = 10.45;
    double maxSpeed = 12.0;  //???
    double curRPM;
    double speed;
	
	public FuelShooter() {
		shooterMotorLeft.enableBrakeMode(false);
		shooterMotorRight.enableBrakeMode(false);
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
		shooterMotorLeft.set(currentSpeed);
		shooterMotorRight.set(currentSpeed);
		SmartDashboard.putNumber("Shooter Speed:", currentSpeed);
	}
	/**
	 * Set speeds of shooter
	 * @param speed Sets speed of shooter
	 */
	public void setRPM(double speedLeft, double speedRight) {
		shooterMotorLeft.setSetpoint(speedLeft);
		shooterMotorRight.setSetpoint(speedRight);
	}
	    
	/**
	 * Sets the shooters to a max RPM          
	 */
	public void maxRPM() {
		shooterMotorLeft.setSetpoint(maxSpeed);
		shooterMotorRight.setSetpoint(maxSpeed);
	}
	/**
	 * Far shot from constants for RPM speed
	 */
	public void longShotRPM() {
		shooterMotorLeft.setSetpoint(hopperShotSpeedLeft);
		shooterMotorRight.setSetpoint(hopperShotSpeedRight);
	}
	/**
	 * Uses airship constants for RPM speed
	 */
	public void airshipShotRPM() {
		shooterMotorLeft.setSetpoint(airshipShotSpeedLeft);
		shooterMotorRight.setSetpoint(airshipShotSpeedRight);
	}
	/**
	 * Set RPM to half of the speed it is
	 */
	public void halfRPM() {
		shooterMotorLeft.setSetpoint(halfSpeed);
		shooterMotorRight.setSetpoint(halfSpeed);
	}
	/**
	 * Stop both shooters
	 */    
	public void zeroRPM() {
		shooterMotorLeft.setSetpoint(0);
		shooterMotorRight.setSetpoint(0);
	}
	/**
	 * Increase RPM of Left Shooter
	 */ 
	public void increaseRPMLeft() {
    	//currentSpeed =+100;
		shooterMotorLeft.setSetpoint(shooterMotorLeft.getSetpoint() + .1);
	}
	/**
	 * Decrease RPM of Left Shooter
	 */
	public void decreaseRPMLeft() {
	    	//currentSpeed =-100;
		shooterMotorLeft.setSetpoint(shooterMotorLeft.getSetpoint() - .1);
	}
	/**
	 * Increase RPM of Right Shooter
	 */    
	public void increaseRPMRight() {
	    	//currentSpeed =+100;
		shooterMotorRight.setSetpoint(shooterMotorRight.getSetpoint() + .25);
	}
	/**
	 * Decrease RPM of Right Shooter
	 */
	public void decreaseRPMRight() {
	    	//currentSpeed =-100;
		shooterMotorRight.setSetpoint(shooterMotorRight.getSetpoint() - .25);
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

