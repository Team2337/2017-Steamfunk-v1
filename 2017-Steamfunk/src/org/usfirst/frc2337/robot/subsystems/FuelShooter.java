package org.usfirst.frc2337.robot.subsystems;
import org.usfirst.frc2337.robot.Robot;
import org.usfirst.frc2337.robot.RobotMap;
import org.usfirst.frc2337.robot.commands.*;

import com.ctre.CANTalon;

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
	
	
	 double currentSpeed = -700;
	    double halfSpeed = 6;
	    //double maxSpeed = 2500;  //???
	    public double maxSpeed = 12;
	   	//close boiler shot: 8;    far shot: 9.6;
	    public double RPMLimit = 3650;			//was  9.60
	    double curRPM;
	    public boolean shooterPos;
	
	
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
	public void setRPM() {
		shooterMotorLeft.setSetpoint(currentSpeed);
    	
		shooterMotorRight.setSetpoint(currentSpeed);		//Second shooter
    	
    }
	    
	public void increaseRPMLeft() {
	    	//currentSpeed =+100;
		Robot.constants.VoltageLimitLeft += .15;
	}
	    
	public void decreaseRPMLeft() {
	    	//currentSpeed =-100;
		Robot.constants.VoltageLimitLeft -= .15;
	}
	/*
	public void maxRPM() {
		shooterMotorLeft.setSetpoint(maxSpeed);
		shooterMotorRight.setSetpoint(maxSpeed);
	}
	    
	public void longShotRPM() {
		shooterMotorLeft.setSetpoint(hopperShotSpeedLeft);
		shooterMotorRight.setSetpoint(hopperShotSpeedRight);
	}
	
	public void airshipShotRPM() {
		shooterMotorLeft.setSetpoint(airshipShotSpeedLeft);
		shooterMotorRight.setSetpoint(airshipShotSpeedRight);
	}
	
	public void halfRPM() {
		shooterMotorLeft.setSetpoint(halfSpeed);
		shooterMotorRight.setSetpoint(halfSpeed);
	}
	     */
	    
	public void increaseRPMRight() {
	    	//currentSpeed =+100;
		Robot.constants.VoltageLimitRight += .15;
	}
	    
	public void decreaseRPMRight() {
	    	//currentSpeed =-100;
		Robot.constants.VoltageLimitRight -= .15;
	}
	
	public void zeroRPM() {
		shooterMotorLeft.setSetpoint(0);
		shooterMotorRight.setSetpoint(0);
	}
}

