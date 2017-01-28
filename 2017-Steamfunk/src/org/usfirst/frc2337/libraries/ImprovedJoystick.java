package org.usfirst.frc2337.libraries;

import edu.wpi.first.wpilibj.Joystick;

public class ImprovedJoystick extends Joystick {
	public Timer rumbleTimer;
	public ImprovedJoystick(int port) {
		super(port);
		// TODO Auto-generated constructor stub
	}
	/**
	 * Makes the controller rumble.
	 * @param l The left rumble value.
	 * @param r The right rumble value.
	 */
	public void rumble(float l, float r) {
		setRumble(RumbleType.kLeftRumble, l);
		setRumble(RumbleType.kRightRumble, r);
	}
	/**
	 * Sets Rumble via seconds
	 * @param l The left rumble value.
	 * @param r The right rumble value.
	 * @param seconds Time to rumble for.
	 */
	public void rumble(float l, float r, double seconds) {
		rumble(l, r);
		rumbleTimer = new Timer(seconds, false, new TimerBase() {
			public void timer() {
				rumble(0, 0);
			}
			public void timerStop() {
				rumbleTimer = null;
			}
		}).start();
	}

}

//Heavily cut-down version of explodingbacon's 2015 rumble code