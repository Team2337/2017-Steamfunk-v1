package org.usfirst.frc2337.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc2337.robot.Constants;
import org.usfirst.frc2337.robot.Robot;
import org.usfirst.frc2337.robot.RobotMap;

/**
 *
 */
public class AutonCG_CrossTest extends CommandGroup {
	
    public AutonCG_CrossTest() {
   
    	addParallel(new FuelShooter_speedSet(-Robot.constants.kFuelShooter_autonRedHopperShotSpeedLeft, Robot.constants.kFuelShooter_autonRedHopperShotSpeedRight));
    	addSequential(new ControlProfile40ball());
    	
    	
    }
}