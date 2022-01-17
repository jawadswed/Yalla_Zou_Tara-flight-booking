/*
 * This is the method to store the all of the information about the user
 * This uses the arraylist (Vector)
 * Every JCheckBox's Item is stored in three arraylist
 */

import java.util.*;

public class Service {
	
	// Initializing the ArrayLists of type String
	private ArrayList<String> babyServices;
	private ArrayList<String> foodServices;
	private ArrayList<String> disableServices;
	
	// This is the class' constructor
	public Service() {
		this.foodServices = new ArrayList<>();
		this.disableServices = new ArrayList<>();
		this.babyServices = new ArrayList<>();
	}
	
	// Boolean function to return if a food service was booked
	public boolean isFoodBooked() {
		return foodServices.size() != 0;
	}
	
	// Boolean function to return if a baby/child service was booked
	public boolean isBabyBooked() {
		return babyServices.size() != 0;
	}
	
	// Boolean function to return if a disabled service was booked
	public boolean isDisableBooked() {
		return disableServices.size() != 0;
	}
	
	// Function to add booked food service into the ArrayList foodServices
	public void addBookedFood(String newFood ) {
		foodServices.add(newFood);
	}
	
	// Function to add booked disabled service into the ArrayList disableServices
	public void addDisableFacility(String newDF) {
		disableServices.add(newDF);
	}
	
	// Function to add booked baby/child service into the ArrayList babyServices
	public void addBabyService(String newBS) {
		babyServices.add(newBS);
	}
	
	// Getter method for booked foods
	public ArrayList<String> getBookedFoods() {
		return foodServices;
	}
	
	// Getter method for booked baby/child services 
	public ArrayList<String> getBookedBabyService() {
		return babyServices;
	}
	
	// Getter method for disabled services
	public ArrayList<String> getBookedDisabledFacilities() {
		return disableServices;
	}	
}
