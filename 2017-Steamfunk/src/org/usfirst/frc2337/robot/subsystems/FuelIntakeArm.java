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
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.Solenoid;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class FuelIntakeArm extends PIDSubsystem {

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	private final DoubleSolenoid fuelIntakeArm = RobotMap.fuelIntakeArm_solenoid;
	//private final AnalogPotentiometer stringPot = RobotMap.fuelIntakeArmstringPot;
	double extendSpeed = Robot.constants.kFuelIntakeArm_DefualtSpeed;
	double retractSpeed = Robot.constants.kFuelIntakeArm_RetractSpeed;
	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	
	// Initialize your subsystem here
	public FuelIntakeArm(double extendSpeed, double retractSpeed) {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PID
		super("FuelIntakeArm", 1.0, 0.0, 0.0);
		setAbsoluteTolerance(0.2);
		getPIDController().setContinuous(false);
		LiveWindow.addActuator("FuelIntakeArm", "PIDSubsystem Controller", getPIDController());
		this.extendSpeed = extendSpeed;
		this.retractSpeed = retractSpeed;

	}

	public void initDefaultCommand() {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	protected double returnPIDInput() {
		// Return your input value for the PID loop
		// e.g. a sensor, like a potentiometer:
		// yourPot.getAverageVoltage() / kYourMaxVoltage;

		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SOURCE
		return 1; //stringPot.get();

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SOURCE
	}

	protected void usePIDOutput(double output) {
		// Use output to drive your system, like a motor
		// e.g. yourMotor.set(output);

		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=OUTPUT
		((PIDOutput) fuelIntakeArm).pidWrite(output);

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=OUTPUT
	}
	public void extendIntakeArm() {
		fuelIntakeArm.set(DoubleSolenoid.Value.kForward);
	}
	
	public void retractIntakeArm() {
		fuelIntakeArm.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void stopIntakeArm() {
		fuelIntakeArm.set(DoubleSolenoid.Value.kOff);
	}
	
/*	public void extendIntakeArmS() {
    	fuelIntakeArm.set(true);
    }

	public void retractIntakeArmS() {
    	fuelIntakeArm.set(false);
    }*/
}
