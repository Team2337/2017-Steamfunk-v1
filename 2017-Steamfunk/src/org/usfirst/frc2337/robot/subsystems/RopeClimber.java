package org.usfirst.frc2337.robot.subsystems;

import org.usfirst.frc2337.robot.Robot;
import org.usfirst.frc2337.robot.RobotMap;
import org.usfirst.frc2337.robot.commands.*;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *ROPE CLIMBER
 *@author Jack E. 
 */
public class RopeClimber extends Subsystem {

    private final CANTalon scaleMotor = RobotMap.ropeClimberscaleMotor;

    double speed = Robot.constants.kRopeClimber_defaultSpeed;

    public void initDefaultCommand() {
    
    }
    /**
     * Starts the climber
     */
    public void startClimber(){
    	scaleMotor.set(speed);
    }
    /**
     * Stops the climber
     */
    public void stopClimber(){
    	scaleMotor.set(0);
    }
}

