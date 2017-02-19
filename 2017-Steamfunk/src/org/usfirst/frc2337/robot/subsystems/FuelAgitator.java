package org.usfirst.frc2337.robot.subsystems;

import org.usfirst.frc2337.robot.OI;
import org.usfirst.frc2337.robot.RobotMap;
import org.usfirst.frc2337.robot.commands.*;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 * BEING REPLACED BY AUGER
 */
public class FuelAgitator extends Subsystem {
	
    private final CANTalon fuelDeGunkerRight = RobotMap.fuelAgitator_motorRight;
    private final CANTalon fuelDeGunkerLeft = RobotMap.fuelAgitator_motorLeft;
    private double loaderYValue;
    private double loaderThreshold = .1;
    
    
    public void initDefaultCommand() {
    	//setDefaultCommand(new Loader_enable());
    }
    
    public void driveAgitator(){
    	//loaderYValue = OI.operatorJoystick.getRawAxis(5);
    	loaderYValue = .4;
    	if(java.lang.Math.abs(loaderYValue) > loaderThreshold){
    		fuelDeGunkerRight.set(loaderYValue);
    		fuelDeGunkerLeft.set(-loaderYValue);
    	}
    	else{
    		fuelDeGunkerRight.set(0);
    		fuelDeGunkerLeft.set(0);
    	}
    		
    }

	public void setRPM(double speed) {
		// TODO Auto-generated method stub
		fuelDeGunkerRight.set(speed);
		fuelDeGunkerLeft.set(-speed);
	}
}

