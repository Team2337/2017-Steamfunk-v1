// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc2337.robot.subsystems;

import org.usfirst.frc2337.robot.Robot;
import org.usfirst.frc2337.robot.RobotMap;
import org.usfirst.frc2337.robot.commands.*;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class FuelFeeder extends Subsystem {
	private final CANTalon fuelFeederLeft = RobotMap.fuelFeederLeft;
	private final CANTalon fuelFeederRight = RobotMap.fuelFeederRight;
	private final CANTalon fuelShooterRight = RobotMap.shooterCANTalonRight;
	private final CANTalon fuelShooterLeft = RobotMap.shooterCANTalonLeft;

	double currentSpeed = Robot.constants.kFeeder_DefaultEnableSpeed;
	double speed = Robot.constants.kFeeder_DefaultEnableSpeed;
	double reverseSpeed = Robot.constants.kFeeder_DefaultReverseSpeed;
	public boolean lockingFeeder = false;

	public void initDefaultCommand() {

	}

	public void reverseAuger(double reversedSpeed) {
		fuelFeederLeft.set(speed);
		fuelFeederRight.set(-speed); // reversed
	}

	public void stopAuger() {
		fuelFeederLeft.set(0);
		fuelFeederRight.set(0);
	}

	public void updateSpeed() {
		fuelFeederLeft.set(currentSpeed);
		fuelFeederRight.set(-currentSpeed);
	}

	public void setSpeed(double speed) {
		currentSpeed = speed;
		// RobotMap.fuelFeederLeft.set(speed);
		// RobotMap.fuelFeederLeft.set(-speed);

		// if(currentSpeed > speed) currentSpeed = 0.5;
		// if(currentSpeed < speed) currentSpeed = 0;
		updateSpeed();
	}

	public void getVoltage() {
		fuelFeederLeft.getBusVoltage();
		fuelFeederRight.getBusVoltage();
	}

	public void lockFeeder(boolean state) {
		lockingFeeder = state;
	}

}
