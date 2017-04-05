package org.usfirst.frc2337.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
/**
 * Fuel Intake Arm COMMAND GROUP - Command group for the intake arm 
 *
 */
public class Chassis_visionLockdownCG extends CommandGroup {

	public Chassis_visionLockdownCG() {
		//addSequential(new Chassis_targetWithGyro());
		addSequential(new Lockdown(0));
	}

}
