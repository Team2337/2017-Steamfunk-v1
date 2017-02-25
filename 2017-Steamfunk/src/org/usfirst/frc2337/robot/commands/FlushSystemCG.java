package org.usfirst.frc2337.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class FlushSystemCG extends CommandGroup {	//THIS SHOULD BE CALLED AS A WHILEHELD

	public FlushSystemCG() {
		addParallel(new FlushFeeder(0.3));		//Speed is set here, modifying the default 0.5 speed
		addParallel(new FlushShooter(0.3));	//Same here, the shooter motors' mode is set to PercentVBus for the duration of the command.
	}
}
