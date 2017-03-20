package org.usfirst.frc2337.robot.commands;

import org.usfirst.frc2337.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Auton_shootThenMidGear extends CommandGroup {
	
	public Auton_shootThenMidGear() {
		
		addSequential(new Auton_resetGyro());
		//shoot on
		addParallel(new FuelShooter_speedSet(Robot.constants.kFuelShooter_autonMidGearShotSpeedLeft, Robot.constants.kFuelShooter_autonMidGearShotSpeedRight));
		
		addSequential(new Auton_wait(5));
		
		addSequential(new Auton_driveForTime(.5, 0, 0.5)); // forward
		
		
		addSequential(new Auton_turnGyro(80)); // turn -90
		
		addSequential(new Auton_wait(5));
		
		addSequential(new Chassis_targetWithGyro()); // target 
		
		/*
		
		addSequential(new Auton_turnGyro(0));
		
		addSequential(new Auton_driveForTime(.6, 0, 0.5));
		*/
	}

}
