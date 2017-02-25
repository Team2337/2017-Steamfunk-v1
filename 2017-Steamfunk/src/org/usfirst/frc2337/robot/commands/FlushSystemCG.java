package org.usfirst.frc2337.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class FlushSystemCG extends CommandGroup {

	public FlushSystemCG() {
		addParallel(new FlushFeeder());
		addParallel(new FlushShooter());
	}
}
