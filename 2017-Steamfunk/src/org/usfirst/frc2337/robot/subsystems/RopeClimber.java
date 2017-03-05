package org.usfirst.frc2337.robot.subsystems;

import org.usfirst.frc2337.robot.Robot;
import org.usfirst.frc2337.robot.RobotMap;
import org.usfirst.frc2337.robot.commands.*;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *ROPE CLIMBER - Allows us to climb up the rope @ the end of the match
 *@author Jack E
 */
public class RopeClimber extends Subsystem {

    private final CANTalon climbMotor = RobotMap.ropeClimberscaleMotor;

    double speed = Robot.constants.kRopeClimber_defaultSpeed;

    public void initDefaultCommand() {
    
    }
    
    /**
     * Starts the climber
     */
    public void startClimber(){
    	//Robot.chassisPID.arcadeDrive(1, 0);
    	climbMotor.set(-1.0);
    }
    /**
     * Stops the climber
     */
    public void stopClimber(){
    	climbMotor.set(0);
    }
    /**
     * Reverses the climber - useful when the ratchet is not reset, allowing us to climb
     */
    public void reverseClimber(){
    	//Robot.chassisPID.arcadeDrive(1, 0);
    	climbMotor.set(1.0);
    }
    /**
     * Enable Brake Mode
     */
    public void enableBrakeMode() {
    	climbMotor.enableBrakeMode(true);
    	
    }
}

