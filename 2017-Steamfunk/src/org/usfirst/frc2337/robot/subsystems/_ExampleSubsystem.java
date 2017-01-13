package org.usfirst.frc2337.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc2337.robot.commands.*;

/**
 *
 */
public class _ExampleSubsystem extends Subsystem {
	
	// DECLARE CONSTANTS
	
	
	// DECLARE VARIABLES
	
	
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
		
        setDefaultCommand(new _ExampleCommand());
    }
}
