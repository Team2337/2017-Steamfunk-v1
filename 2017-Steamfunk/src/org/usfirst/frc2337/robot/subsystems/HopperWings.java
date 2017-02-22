package org.usfirst.frc2337.robot.subsystems;

import org.usfirst.frc2337.robot.RobotMap;
import org.usfirst.frc2337.robot.commands.*;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * HOPPER TRIGGER - Dumps hopper on field
 */
public class HopperTrigger extends Subsystem {
	
	
	public final Solenoid trigger = RobotMap.hopperTrigger_solenoid;
	
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
		
    }
	
	/**
	 * Is trigger hopper extended
	 */
	public boolean isExtended() {
		return trigger.get();
	}
	
	/**
	 * Extends Hopper Trigger
	 */
	public void extend() {
		trigger.set(true);
	}
	
	/**
	 * Retracts Hopper Trigger
	 */
	public void retract() {
		trigger.set(false);
	}
}
