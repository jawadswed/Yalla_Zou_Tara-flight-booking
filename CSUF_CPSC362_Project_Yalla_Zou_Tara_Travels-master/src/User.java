/*
 * This is the User class. It declares the getter and setter methods
 * for the user's first name, last name, passsport ID and email
 */
public class User {
	
	// Initializing the String variables
	private String firstName;
	private String lastName;
	private String passport;
	private String email;
	
	// This is the class' constructor
	public User() {
		this.firstName = "nobody";
		this.lastName = "nobody";
		this.passport = "00000000";
		this.email = "";
	}
	
	// Getter method for first name
	public String getFirstName() {
		return this.firstName;
	}
	
	// Getter method for last name
	public String getLastName() {
		return this.lastName;
	}
	// Getter method for passport ID
	public String getPassport() {
		return this.passport;
	}
	
	// Setter method for first name
	public void setFirstName(String fname) {
		this.firstName = fname;
	}
	
	// Setter method for last name 
	public void setLastName(String lname) {
		this.lastName = lname;
	}
	
	// Setter method for passport ID
	public void setPassport(String passport) {
		this.passport = passport;
	}
	
	// Getter method for user's email
	public String getEmail() {
		return this.email;
	}
	
	// Setter method for email
	public void setEmail(String email) {
		this.email = email;
	}
	
	// Method to check if the user has an account already 
	public boolean isSameUser(User userToCompare) {
		String firstNameToCompare = userToCompare.getFirstName();
		String lastNameToCompare = userToCompare.getLastName();
		String passportToCompare = userToCompare.getPassport();
		String emailToCompare = userToCompare.getEmail();
		
		return firstNameToCompare.equals(this.firstName) 
				&& lastNameToCompare.equals(this.lastName) 
				&& passportToCompare.equals(this.passport)
				&& emailToCompare.equals(this.email);
	}
}
