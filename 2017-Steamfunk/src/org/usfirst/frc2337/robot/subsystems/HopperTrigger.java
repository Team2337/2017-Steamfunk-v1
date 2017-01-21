package org.usfirst.frc2337.robot.subsystems;

import org.usfirst.frc2337.robot.RobotMap;
import org.usfirst.frc2337.robot.commands.*;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class HopperTrigger extends Subsystem {
	
	public final Solenoid trigger = RobotMap.hopperTrigger_solenoid;
	
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
		
    }
	
	public boolean isExtended() {
		return trigger.get();
	}
	
	public void extend() {
		trigger.set(true);
	}
	
	public void retract() {
		trigger.set(false);
	}
}
