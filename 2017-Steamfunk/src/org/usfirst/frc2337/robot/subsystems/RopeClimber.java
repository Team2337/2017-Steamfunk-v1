package org.usfirst.frc2337.robot.subsystems;

import org.usfirst.frc2337.robot.RobotMap;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 * ROPECLIMBER
 *  - BEING IMPROVED BY JACK
 */
public class RopeClimber extends Subsystem {

    private final CANTalon scaleMotor = RobotMap.ropeClimberscaleMotor;




    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {

        // setDefaultCommand(new MySpecialCommand());
    }
}

