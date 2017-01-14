package org.usfirst.frc2337.robot.subsystems;

import org.usfirst.frc2337.robot.RobotMap;
import org.usfirst.frc2337.robot.commands.*;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class FuelShooter extends Subsystem {
	
    private final CANTalon motorLeft = RobotMap.fuelShooter_motorLeft;
    private final CANTalon motorRight = RobotMap.fuelShooter_motorRight;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    	
    }
    
    public void setShooterSpeed(double speed) {
    	motorLeft.set(speed);
    	motorRight.set(speed);
    }
    
    public void stopShooter() {
    	motorLeft.set(0);
    	motorRight.set(0);
    }
}

