package org.usfirst.frc2337.robot.commands;

import org.usfirst.frc2337.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;
/**
 * Fuel Intake Arm COMMAND GROUP - Command group for the intake arm 
 *
 */
public class Chassis_backupVisionLockdownCG extends CommandGroup {

	public Chassis_backupVisionLockdownCG() {
		addSequential(new Chassis_backoffFromBoiler());
		addSequential(new Chassis_targetWithMotionRev());
		addSequential(new Lockdown(0));
	}

}
