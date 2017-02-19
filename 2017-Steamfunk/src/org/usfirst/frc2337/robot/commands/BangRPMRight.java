package org.usfirst.frc2337.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc2337.robot.Robot;
import org.usfirst.frc2337.robot.RobotMap;

/**
 *
 */
public class BangRPMRight extends Command {

	 

    public BangRPMRight() {

        requires(Robot.fuelShooter);

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	RobotMap.t = new Thread(() -> {
    		while (!Thread.interrupted()) {
	         	if (RobotMap.shooterCANTalonRight.getOutputVoltage() < (Robot.constants.VoltageLimitRight - .1))  {
	        		RobotMap.shooterCANTalonRight.set(12);
	         	} else {
	         		RobotMap.shooterCANTalonRight.set(0);
	         	}
    		}
    		try {
    			RobotMap.t.sleep(1);
    			} catch (InterruptedException e) {
				
    				e.printStackTrace();
    			}
    	});
    	RobotMap.t.setPriority(8);
    	RobotMap.t.start();
/*
    	//shooter 2 code
    	RobotMap.t2 = new Thread(() -> 
    	{
    		while (!Thread.interrupted()) 
    		{
    			if (RobotMap.shooterCANTalon2.getOutputVoltage() < (Robot.shooter.RPMLimit - .1))  
    			{
    				RobotMap.shooterCANTalon2.set(12);
    			} 
    			else 
    			{
    				RobotMap.shooterCANTalon2.set(0);
    			}
    		}
    		try 
    		{
    			RobotMap.t2.sleep(1);					//sleep may interfer with shooters. Further testing required
    		} 
    		catch (InterruptedException e) 
    		{
				e.printStackTrace();
    		}
    	});
   	 	RobotMap.t2.setPriority(9);				//previous priority: 8
   	 	RobotMap.t2.start();
     */
    
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {


    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	//RobotMap.shooterCANTalon1.set(0);
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.end();
    }
}
