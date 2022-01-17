/*
 * Class_362_Final_Project
 ****               Yalla Zou Tara                          ****
 *****************************************************************
 *This Project works as a flight ticket reservation system. The 
 *user can use this system to book One Way or Round Trip flights
 *****************************************************************
 ****             Functions within this program:              ****
 *****************************************************************
 *The user can reserve their seat by clicking their seat of choice
 *The user can reserve a disabled service
 *The user can reserve a baby/child service.
 *The user can reserve a food service
 *The user can search a city's weather
 *The user can change/refund their flight ticket by this system
 *The user can correct their user information by going back to the 
 *home page to change it 
 *The user can send an email confirmation of their produced
 *flight ticket information
 ******************************************************************
 */

// This is the main function to operate the program
public class DriverFly {
	public static void main(String[] args) {
		DBManager dbMgr = DBManager.getDBManager();
		
		Fly f =  new Fly(dbMgr);
		f.setVisible(true);
	}
}
