package org.usfirst.frc2337.robot.subsystems;
import org.usfirst.frc2337.robot.commands.UltraSonicSensor_run;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc2337.robot.RobotMap;

import edu.wpi.first.wpilibj.Ultrasonic;

public class UltraSonicSensor extends Subsystem {

	Ultrasonic sensor1 = RobotMap.distanceSensor1;
	Ultrasonic sensor2 = RobotMap.distanceSensor2;

	public UltraSonicSensor() {
		
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new UltraSonicSensor_run());
	}

	public void setup(){
		sensor1.setEnabled(true);
		sensor1.setAutomaticMode(true);
		sensor2.setEnabled(true);
		sensor2.setAutomaticMode(true);
	}
	
	public double[] getDistance() {
		double[]ultraSonicSensorRange = new double[2];
		
		ultraSonicSensorRange[0]=sensor1.getRangeInches() ;
		ultraSonicSensorRange[1]=sensor2.getRangeInches() ;
			return ultraSonicSensorRange;
	}
	
}