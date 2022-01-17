/*
 * This is the record the inofrmation about the user's
 * to record all of the user filled choice informations
 * that will used to the finally list 
 */
public class Ticket {
	//Initialize the each of the information about user
	private String flight;
	private String departAirport;
	private String arriveAirport;
	
	private String departTime;
	private String departDay;
	private String departMonth;
	private String departYear;
	
	private String arriveTime;
	private String arriveDay;
	private String arriveMonth;
	private String arriveYear;
	
	private String seatRow;
	private String seatCol;
	private String seatClass;
	
	private String aircompany;
	private boolean isRoundTrip;
	private double price;

	//this is the constructor
	public Ticket() {
		this.flight = "";
		this.departAirport = "";
		this.arriveAirport = "";
		
		this.departTime = "";
		this.departDay = "";
		this.departMonth = "";
		this.departYear = "";
		
		this.arriveTime = "";
		this.arriveDay = "";
		this.arriveMonth = "";
		this.arriveYear = "";
		
		this.seatRow = "";
		this.seatCol = "";
		this.seatClass = "";
		
		this.aircompany = "";
		this.isRoundTrip = false;
		this.price = 0.0;
	}
	
	public boolean isRoundTripTicket() {
		return this.isRoundTrip;
	}
	
	public void setRoundTripticket() {
		this.isRoundTrip = true;
	}
	
	public String getBackDepartAirport() {
		if (isRoundTrip == false) return "";
		return this.arriveAirport;
	}
	
	public String getBackarriveAirport() {
		if (isRoundTrip == false) return "";
		return this.departAirport;
	}
	
	public String getFlight() {
		return this.flight;
	}
	
	public String getAircompany() {
		return this.aircompany;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public String getDepartTime() {
		return this.departTime;
	}
	
	public String getArriveTime() {
		return this.arriveTime;
	}
	
	public String getDepartDate() {
		return this.departYear + "-" + this.departMonth + "-" + this.departDay;
	}
	
	public String getArriveDate() {
		return this.arriveYear + "-" + this.arriveMonth + "-" + this.arriveDay;
	}
	
	public String getDepartAirport() {
		return this.departAirport;
	}
	
	public String getArriveAirport() {
		return this.arriveAirport;
	}
	
	public String getDepartDay() {
		return this.departDay;
	}
	
	public String getDepartMonth() {
		return this.departMonth;
	}
	
	public String getDepartYear() {
		return this.departYear;
	}
	
	public String getArriveDay() {
		return this.arriveDay;
	}
	
	public String getArriveMonth() {
		return this.arriveMonth;
	}
	
	public String getArriveYear() {
		return this.arriveYear;
	}
	
	public String getSeatRow() {
		return this.seatRow;
	}
	
	public String getSeatCol() {
		return this.seatCol;
	}
	
	public String getSeatClass() {
		return this.seatClass;
	}
	
	public String getSeat() {
		return this.seatClass + " " + this.getSeatRow() + "," + this.getSeatCol();
	}
	
	public void setDepartAirport(String deptAirport) {
		this.departAirport = deptAirport;
	}
	
	public void setArriveAirport(String arriveAirport) {
		this.arriveAirport = arriveAirport;
	}
	
	public void setDepartDay(String date) {
		this.departDay = date;
	}
	
	public void setDepartMonth(String month) {
		this.departMonth = month;
	}
	
	public void setDepartYear(String year) {
		this.departYear = year;
	}
	
	public void setArriveDay(String date) {
		this.arriveDay = date;
	}
	
	public void setArriveMonth(String month) {
		this.arriveMonth = month;
	}
	
	public void setArriveYear(String year) {
		this.arriveYear = year;
	}
	
	public void setSeatRow(String row) {
		this.seatRow = row;
	}
	
	public void setSeatCol(String col) {
		this.seatCol = col;
	}
	
	public void setSeatClass(String seatClass) {
		this.seatClass = seatClass;
	}
	
	public void setFlight(String flight) {
		this.flight = flight;
	}
	
	public void setAircompany(String aircompany) {
		this.aircompany = aircompany;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setDepartTime(String departTime) {
		this.departTime = departTime;
	}
	
	public void setArriveTime(String arriveTime) {
		this.arriveTime = arriveTime;
	}
}
