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

    private final CANTalon climbMotorL = RobotMap.ropeClimberscaleMotorLeft;
    private final CANTalon climbMotorR = RobotMap.ropeClimberscaleMotorRight;

    double speed = Robot.constants.kRopeClimber_defaultSpeed;

    public void initDefaultCommand() {
    	setDefaultCommand(new RopeClimber_runWithJoystick());
    }
    
    /**
     * Starts the climber
     */
    public void startClimber(){
    	//Robot.chassisPID.arcadeDrive(1, 0);
    	climbMotorL.set(1.0);
    	climbMotorR.set(-1.0); //1.0
    }
    public void joystickClimber(double joystick){
    	if(joystick < -0.2){
    		climbMotorL.set(-joystick);
    		climbMotorR.set(joystick);
    	} else {
    		climbMotorL.set(0);
        	climbMotorR.set(0);
    	}
    }
    /**
     * Stops the climber
     */
    public void stopClimber(){
    	climbMotorL.set(0);
    	climbMotorR.set(0);
    }
    /**
     * Enable Brake Mode
     */
    public void enableBrakeMode() {
    	climbMotorL.enableBrakeMode(true);
    	climbMotorR.enableBrakeMode(true);
    }
}

