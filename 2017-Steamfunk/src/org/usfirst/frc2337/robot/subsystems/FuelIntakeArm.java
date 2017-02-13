package org.usfirst.frc2337.robot.subsystems;

import org.usfirst.frc2337.robot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class FuelIntakeArm extends Subsystem {


	private final DoubleSolenoid fuelIntakeArm = RobotMap.fuelIntakeArm_solenoid;

	public FuelIntakeArm() {

	}

	public void initDefaultCommand() {

	}

	/**
	 * Extends Intake Arm
	 */
	public void extendIntakeArm() {
		fuelIntakeArm.set(DoubleSolenoid.Value.kForward);
	}
	
	/**
	 * Retracts Intake Arm
	 */
	public void retractIntakeArm() {
		fuelIntakeArm.set(DoubleSolenoid.Value.kReverse);
	}
	
	/**
	 * Stops Intake Arm
	 */
	public void neutralIntakeArm() {
		fuelIntakeArm.set(DoubleSolenoid.Value.kOff);
	}
	
}
