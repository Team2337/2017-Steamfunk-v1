package org.usfirst.frc2337.robot;

import edu.wpi.first.wpilibj.Joystick;

public class ImprovedJoystick extends Joystick {
	/**
	 * 
	 * @author SomeNerd
	 * @param josh Constant, annoying rumble.
	 * @param shortBurst A small burst of weak vibration
	 * @param shortBurstTwice Two shortBursts
	 */
	public enum RumbleMode {shortBurst, josh, shortBurstTwice}
	public ImprovedJoystick(int port) {
		super(port);
		
		// TODO Auto-generated constructor stub
	}
}