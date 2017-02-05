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

	public void extendIntakeArm() {
		fuelIntakeArm.set(DoubleSolenoid.Value.kForward);
	}
	
	public void retractIntakeArm() {
		fuelIntakeArm.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void stopIntakeArm() {
		fuelIntakeArm.set(DoubleSolenoid.Value.kOff);
	}
	
}
