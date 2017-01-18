package org.usfirst.frc2337.robot.subsystems;

import org.usfirst.frc2337.robot.RobotMap;
import org.usfirst.frc2337.robot.commands.*;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class GearLoader extends Subsystem {
	
	private final Solenoid gearPusher = RobotMap.gearLoader_pusher;
	
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
	public boolean isExtended() {
		return gearPusher.get();
	}
	
	public void extend() {
		gearPusher.set(true);
	}
	
	public void retract() {
		gearPusher.set(false);
	}
}

