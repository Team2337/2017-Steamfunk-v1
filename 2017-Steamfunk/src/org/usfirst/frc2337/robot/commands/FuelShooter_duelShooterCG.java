package org.usfirst.frc2337.robot.commands;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class FuelShooter_duelShooterCG extends CommandGroup{
	
	public FuelShooter_duelShooterCG(){
		addSequential(new BangRPMLeft());
		addSequential(new BangRPMRight());
	}

}
