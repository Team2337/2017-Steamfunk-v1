package org.usfirst.frc2337.robot.subsystems;

import org.usfirst.frc2337.robot.Robot;
import org.usfirst.frc2337.robot.RobotMap;
import org.usfirst.frc2337.robot.commands.*;


import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * CHASSIS - Drives the robot
 */
public class Chassis extends Subsystem {
	// Chassis drive motors
	private final CANTalon rightFront	= RobotMap.chassisPID_rightFront;
	private final CANTalon rightRear	= RobotMap.chassisPID_rightRear;
	private final CANTalon leftFront	= RobotMap.chassisPID_leftFront;
	private final CANTalon leftRear		= RobotMap.chassisPID_leftRear;
	private final RobotDrive robotDrive	= RobotMap.chassisPID_RobotDrive;
	
	private final AHRS gyro	= RobotMap.chassisPID_gyro;
	public PIDController LeftController;
	public PIDController RightController;
	
	// Initialize your subsystem here
	public Chassis() {
		LeftController = new PIDController(10, 0, 0, new LeftEncoder(), new PIDOutput() {
			public void pidWrite(double output) {
				SmartDashboard.putNumber("StraightPid Output", output);
		    	SmartDashboard.putData("leftPid", Robot.chassis.LeftController);
		    	
				// Don't output any values to the talons to make robot move
				// here. Instead use the outputs in other places so we can
				// combine multiple PID controllers.
			}
		});
		LeftController.setOutputRange(-.6, .6);
		
		RightController = new PIDController(10, 0, 0, new LeftEncoder(), new PIDOutput() {
			public void pidWrite(double output) {
				SmartDashboard.putNumber("StraightPid Output", output);
				SmartDashboard.putData("rightPid", Robot.chassis.RightController);
				// Don't output any values to the talons to make robot move
				// here. Instead use the outputs in other places so we can
				// combine multiple PID controllers.
			}
		});
		RightController.setOutputRange(-.6, .6);
	} 
    public void initDefaultCommand() {
		setDefaultCommand(new Chassis_driveMain());
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
	
	public void changeFollowerToVbus(){
		
		RobotMap.chassisPID_leftRearMiddle.changeControlMode(TalonControlMode.PercentVbus);
		RobotMap.chassisPID_rightRearMiddle.changeControlMode(TalonControlMode.PercentVbus);
		RobotMap.chassisPID_leftRear.changeControlMode(TalonControlMode.PercentVbus);
		RobotMap.chassisPID_rightRear.changeControlMode(TalonControlMode.PercentVbus);

	}
	public void changeVbusToFollower() {
		
		
		RobotMap.chassisPID_leftRearMiddle.changeControlMode(TalonControlMode.Follower);
		RobotMap.chassisPID_leftRearMiddle.set(RobotMap.chassisPID_leftFront.getDeviceID());
		RobotMap.chassisPID_rightRearMiddle.changeControlMode(TalonControlMode.Follower);
		RobotMap.chassisPID_rightRearMiddle.set(RobotMap.chassisPID_rightFront.getDeviceID());
		
		RobotMap.chassisPID_leftRear.changeControlMode(TalonControlMode.Follower);
		RobotMap.chassisPID_leftRear.set(RobotMap.chassisPID_leftFront.getDeviceID());
		RobotMap.chassisPID_rightRear.changeControlMode(TalonControlMode.Follower);
		RobotMap.chassisPID_rightRear.set(RobotMap.chassisPID_rightFront.getDeviceID());
	}
	  private class LeftEncoder implements PIDSource {

			@Override
			public void setPIDSourceType(PIDSourceType pidSource) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public PIDSourceType getPIDSourceType() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public double pidGet() {
				// TODO Auto-generated method stub
				return RobotMap.chassisPID_leftFront.getEncPosition();
			}
			  
			  
		  }
	  private class RightEncoder implements PIDSource {

			@Override
			public void setPIDSourceType(PIDSourceType pidSource) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public PIDSourceType getPIDSourceType() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public double pidGet() {
				// TODO Auto-generated method stub
				return RobotMap.chassisPID_rightFront.getEncPosition();
			}
			  
			  
		  }
	
}