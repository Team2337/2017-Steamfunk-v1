package org.usfirst.frc2337.robot.commands;

import org.usfirst.frc2337.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class UltraSonicSensor_run extends Command {
	double[]ultraSonicSensorRange;

		public UltraSonicSensor_run() {
			requires(Robot.ultrasonic);
		}

		@Override
		protected void initialize() {
			Robot.ultrasonic.setup();
			ultraSonicSensorRange = Robot.ultrasonic.getDistance();
		}

		@Override
		protected void execute() {
			System.out.println(Robot.ultrasonic.getDistance());
		}

		@Override
		protected boolean isFinished() {
			return false;
		}

		@Override
		protected void end() {
		}

		@Override
		protected void interrupted() {
			end();
		}

	}


