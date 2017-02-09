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

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class Auger extends Subsystem {
   private final CANTalon fuelAgitatorfuelDeGunker = RobotMap.fuelIntake_motor;
   private final Solenoid augerS = RobotMap.augerS;
   double currentSpeed = Robot.constants.kAuger_DefaultEnableSpeed;
   double speed = Robot.constants.kAuger_DefaultEnableSpeed;
   double incrementSpeed = Robot.constants.kAuger_incrementSpeed;
   double reverseSpeed = Robot.constants.kAuger_DefaultReverseSpeed;
   double ballSensor = Robot.constants.kAuger_BallSensor;
    private final CANTalon auger = RobotMap.fuelIntake_motor;

    
    public void initDefaultCommand() {
		
    }
    public void startAuger(double speed) {
    	auger.set(speed);
    }
    public void reverseAuger(double reversedSpeed) {
		auger.set(-speed);
	}
    public void stopAuger(){
    	auger.set(0);
    }
    public void updateSpeed() {
    	fuelAgitatorfuelDeGunker.set(currentSpeed);
    }
    
    public void setSpeed(double speed) {
    	currentSpeed = speed;
    	if(currentSpeed > speed) currentSpeed = 0.5;
    	if(currentSpeed < speed) currentSpeed = 0;
    	updateSpeed();
    }
    public void incrementSpeed() {
		setSpeed(currentSpeed += incrementSpeed);
	}
	
	public void decrementSpeed() {
		setSpeed(currentSpeed -= incrementSpeed);
	}
	
	public void  emptyHopper (){
		augerS.set(true);
	}
	public void notEmptyHopper() {
		augerS.set(false);
	}
	
	public void getVoltage() {
		auger.getBusVoltage();
	}
	
	public boolean getHopperSolenoid() {
		return augerS.get();		
	}
}

