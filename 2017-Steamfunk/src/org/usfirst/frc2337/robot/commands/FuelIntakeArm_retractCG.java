package org.usfirst.frc2337.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
/**
 * Fuel Intake Arm COMMAND GROUP - Command group for the intake arm 
 *
 */
public class FuelIntakeArm_retractCG extends CommandGroup {

	public FuelIntakeArm_retractCG() {
		addParallel(new FuelIntakeArm_retract());
		addParallel(new FuelIntake_disable());
	}

}
