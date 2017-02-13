package org.usfirst.frc2337.robot.commands;
import org.usfirst.frc2337.robot.Robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TargetingLED_default extends Command {

    public TargetingLED_default() {


    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	UsbCamera cam0 = Robot.cam0;
    	SmartDashboard.putNumber("camBrightness", 10);
		int exposure = (int) SmartDashboard.getNumber("camExposure");
		int brightness = (int) SmartDashboard.getNumber("camBrightness");

		if (brightness <= 100 && brightness >=0)
			cam0.setBrightness(brightness);

		if (exposure <=100 && exposure >= 0)
			cam0.setExposureManual(exposure);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
