/*
 * This is the Reservation class. It declares the getter and setter methods
 * for the using the classes User, Ticket and Service 
 */
public class Reservation {
	
	// Initializing variables of classes User, Ticket and Service 
	private User user;
	private Ticket ticket;
	private Service service;
	
	// This is the class' constructor
	public Reservation() {
		this.ticket = null;
		this.service = null;
	}
	
	// Getter method of info from User class
	public User getUser() {
		return this.user;
	}
	
	// Getter method of info from Ticket class
	public Ticket getTicket() {
		return this.ticket;
	}
	
	// Getter method of info from Service class
	public Service getService() {
		return this.service;
	}
	
	// Setter method for User 
	public void setUser(User u) {
		this.user = u;
	}
	
	// Setter method for Ticket 
	public void setTicket(Ticket t) {
		this.ticket = t;
	}
	
	// Setter method for service 
	public void setService(Service s) {
		this.service = s;
	}
}
