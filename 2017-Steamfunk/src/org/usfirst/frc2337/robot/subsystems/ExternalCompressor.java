package org.usfirst.frc2337.robot.subsystems;

import org.usfirst.frc2337.robot.Robot;
import org.usfirst.frc2337.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Compressor;

public class ExternalCompressor extends Subsystem{
	
	private Compressor compressor = RobotMap.compressor;
	boolean enabled = compressor.enabled();
	boolean pressureSwitch = compressor.getPressureSwitchValue();
	double current = compressor.getCompressorCurrent();
	
	protected void initDefaultCommand() {
		// New compressor code...
		compressor.start();
		if (compressor.getPressureSwitchValue()) {
		compressor.start();
		} else {
		compressor.stop();
		}
	}
}
