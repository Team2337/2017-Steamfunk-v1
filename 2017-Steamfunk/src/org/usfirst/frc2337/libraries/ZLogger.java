package org.usfirst.frc2337.libraries;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
/***
 * ZLogger: a FRC based logging system that runs on the DriverStatiom 
 * @author Import-Python/Brendan Fuller (OnoUtilities)
 *
 */
public class ZLogger {

	public String nt = "ZLogger"; //Main Table
	public NetworkTable table; //NT when starts
	public ZLogger() {
		table = NetworkTable.getTable(nt);
	}
	/***
	 * setEnabled()
	 * Enabled State of the Robot
	 */
	public void setEnabled() {
		table.putBoolean("status", true);
	}
	/***
	 * setAutonEnabled()
	 * Enabled State of the Robot and make State to 'auton' 
	 */
	public void setAutonEnabled() {
		setEnabled();
		table.putString("state", "auton");
	}
	/***
	 * setTelopEnabled()
	 * Enabled State of Robot and make State to 't' 
	 */
	public void setTelopEnabled() {
		setEnabled();
		table.putString("state", "teleop");
	}
	/***
	 * setTelopEnabled()
	 * Disable State the Robot  
	 */
	public void setDisabled() {
		table.putString("state", "disabled");
	}
	/**
	 * sendDebug(<message>)
	 * @param msg - message
	 * 
	 * Sends the message
	 */
	public void sendDebug(String msg) {
		table.putString("debugMSG", msg);
	}
	
}
