package org.usfirst.frc2337.robot.subsystems;
import org.usfirst.frc2337.robot.RobotMap;
import org.usfirst.frc2337.robot.commands.*;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 * BEING REPLACED BY AUGER
 */
public class FuelAgitator extends Subsystem {
    private final CANTalon fuelDeGunker = RobotMap.fuelAgitatorfuelDeGunker; 
    public void initDefaultCommand() {}
}

