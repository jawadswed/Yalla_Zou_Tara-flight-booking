
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class DBManager {
  private static DBManager dbmgr = null;
  private static Connection connect = null;
  
  private Statement statement = null;
  private PreparedStatement preparedStatement = null;
  private ResultSet resultSet = null;

  final private String host = "ec2-52-14-56-213.us-east-2.compute.amazonaws.com:3306/flight_booking_system";
  final private String user = "root";
  final private String passwd = "CPSC362!";
  
  private DBManager() {
	  try {
		  connect = DriverManager.getConnection("jdbc:mysql://" + host, user, passwd );  
	  } catch (SQLException e) {
		  System.out.println("Error: Failed to connect db on AWS ec2.");
      }	  
  }
  
  synchronized public static DBManager getDBManager() {
	  if (dbmgr == null) {
		  dbmgr = new DBManager();
	  }
	  return dbmgr;
  }
  
  private void close() {
    try {
      if (connect != null) {
        connect.close();
      }
    } catch (Exception e) {

    }
  }

  public boolean isUserInfoInDB(String username, String password) {
	  boolean result = false;
	  
	  try {
	      preparedStatement = connect
                            .prepareStatement("select * from user_info where user_name=\"" + username + "\" and pass=\"" + password + "\"");
	      resultSet = preparedStatement.executeQuery();
		  if  (resultSet.next()) {
			  result = true;
		  }
      
	  } catch (Exception e) {
		  System.out.println("Error: Failed to get user info data from DB!");
		  return false;
	  }
	  return result;
  }
  
  public boolean insertUserEntryToDB(String username, String password, String email) {
	  boolean result = false;
	  try {
		  preparedStatement = connect
				  .prepareStatement("insert into user_info (user_id, user_name, pass, email) values (default, \"" + username + "\", \"" + password + "\", \"" + email + "\")");
		  if (preparedStatement.executeUpdate() > 0) {
			  result = true;
		  }
	  } catch (Exception e) {
		  System.out.println("Error: Failed to insert user " + username + " into DB!");
		  return false;  
	  }
	  return result;
  }
  
  public String queryAirportCode(String cityName) {
	  String result = "";
	  String queryStr = "select * from Airport_Info where City_Name=\"" + cityName + "\"";
	  try {
		  preparedStatement = connect
				  .prepareStatement(queryStr);
		  resultSet = preparedStatement.executeQuery();
		  while (resultSet.next()) {
			  return resultSet.getString("Airport_Code");
		  }
	  } catch (Exception e) {
		  System.out.println("Error: Failed to query airport code from DB!");
		  return result;  
	  }
	  return result;
  }
  
  public String queryCityNameFromAirportCode(String AirportCode) {
	  String result = "";
	  String queryStr = "select * from Airport_Info where Airport_Code=\"" + AirportCode + "\"";
	  try {
		  preparedStatement = connect
				  .prepareStatement(queryStr);
		  resultSet = preparedStatement.executeQuery();
		  while (resultSet.next()) {
			  return resultSet.getString("City_Name");
		  }
	  } catch (Exception e) {
		  System.out.println("Error: Failed to query city name from DB!");
		  return result;  
	  }
	  return result;
  }
  
  public ArrayList<String> queryFlightInfo(String departCode, String arriveCode){
	  ArrayList<String> result = new ArrayList<String>();
	  String queryStr = "select * from Flight_Info where Depart_Airport=\"" + departCode + "\"" + " and Arrive_Airport=\"" + arriveCode +"\"";
	  try {
		  preparedStatement = connect
				  .prepareStatement(queryStr);
		  resultSet = preparedStatement.executeQuery();
		  while (resultSet.next()) {
			  String ticketInfo = "";
			  ticketInfo += resultSet.getString("Flight") + "                              ";
			  ticketInfo += resultSet.getDouble("Price") + "                    ";
			  ticketInfo += resultSet.getString("Aircompany") + " ";
			  
			  result.add(ticketInfo);
		  }
	  } catch (Exception e) {
		  System.out.println("Error: Failed to insert booking info into DB!");
		  return result;  
	  }
	  return result;
  }
  
  public boolean insertBookingInfo(Ticket curTicket, Service curService, User curUser) {
	  boolean result = false;
	  
	  String fname = curUser.getFirstName();
	  fname = fname.length() == 0 ? "N/A" : fname;
		
	  String lname = curUser.getLastName();
	  lname = lname.length() == 0 ? "N/A" : lname;
		
	  String passport = curUser.getPassport();
	  passport = passport.length() == 0 ? "N/A" : passport;
		
	  String email = curUser.getEmail();
	  email = email.length() == 0 ? "N/A" : email;
		
	  String departAirport = curTicket.getDepartAirport();
	  departAirport = departAirport.length() == 0 ? "N/A" : departAirport;
		
	  String arriveAirport = curTicket.getArriveAirport();
	  arriveAirport = arriveAirport.length() == 0 ? "N/A" : arriveAirport;
		
	  String flight = curTicket.getFlight();
	  flight = flight.length() == 0 ? "N/A" : flight;
		
	  String departDate = curTicket.getDepartDate();
	  departDate = departDate.length() == 0 || departDate.equals("--") ? "2019-01-01" : departDate;
		
	  String departTime = curTicket.getDepartTime();
	  departTime = departTime.length() == 0 ? "2019-01-01 00:00:00" : departTime;
		
	  String arriveDate = curTicket.getArriveDate();
	  arriveDate = arriveDate.length() == 0 || arriveDate.equals("--") ? "2019-01-01" : arriveDate;
		
	  String arriveTime = curTicket.getArriveTime();
	  arriveTime = arriveTime.length() == 0 ? "2019-01-01 00:00:00" : arriveTime;
		
	  double price = curTicket.getPrice();
	  
	  String aircompany = curTicket.getAircompany();
	  aircompany = aircompany.length() == 0 ? "N/A" : aircompany;
		
	  String seat = curTicket.getSeat();
	  seat = seat.length() == 0 ? "N/A" : seat;
		
	  String bookedFoods = "";
	  for(String b : curService.getBookedFoods()) {
		  bookedFoods += b + "|";
	  }	
	  if (bookedFoods.length() != 0) {
		  bookedFoods = bookedFoods.substring(0, bookedFoods.length() - 1);
	  }
	  bookedFoods = bookedFoods.length() == 0 ? "N/A" : bookedFoods;
		
	  String bookedBabyService = "";
	  for(String b : curService.getBookedBabyService()) {
		  bookedBabyService += b + "|";
	  }
	  if (bookedBabyService.length() != 0) {
		  bookedBabyService = bookedBabyService.substring(0, bookedBabyService.length() - 1);
	  }
	  bookedBabyService = bookedBabyService.length() == 0 ? "N/A" : bookedBabyService;
		
	  String bookedDisabledFacilities = "";
	  for(String b : curService.getBookedDisabledFacilities()) {
		  bookedDisabledFacilities += b + "|";
	  }
	  if (bookedDisabledFacilities.length() != 0) {
		  bookedDisabledFacilities = bookedDisabledFacilities.substring(0, bookedDisabledFacilities.length() - 1);
	  }
	  bookedDisabledFacilities = bookedDisabledFacilities.length() == 0 ? "N/A" : bookedDisabledFacilities;
	
	  String queryStr = "INSERT INTO Booking_Info (" +
							"Booking_ID, Passenger_Name, Passenger_Passport, Passenger_Email, Depart_Airport, Arrive_Airport," +
							"Flight, Depart_Date, Depart_Time, Arrive_Date, Arrive_Time, Price, Aircompany, Seat," +
							"Food_Service, Baby_Service, Disable_Service)" +
			  			"VALUES (" +
			  				"default," + "\"" + fname + " " + lname + "\"," +
			  				"\"" + passport + "\","  +
			  				"\"" + email + "\","  +
			  				"\"" + departAirport + "\","  +
			  				"\"" + arriveAirport + "\","  +
			  				"\"" + flight + "\","  +
			  				"\"" + departDate + "\","  +
			  				"\"" + departTime + "\","  +
			  				"\"" + arriveDate + "\","  +
			  				"\"" + arriveTime + "\","  +
			  				"\"" + price + "\","  +
			  				"\"" + aircompany + "\","  +
			  				"\"" + seat + "\","  +
			  				"\"" + bookedFoods + "\","  +
			  				"\"" + bookedBabyService + "\","  +
			  				"\"" + bookedDisabledFacilities + "\""  +
			  				" );";
	  try {
		  preparedStatement = connect
				  .prepareStatement(queryStr);
		  if (preparedStatement.executeUpdate() > 0) {
			  result = true;
		  }
	  } catch (Exception e) {
		  System.out.println("Error: Failed to insert booking info into DB!");
		  return false;  
	  }
	  return result;
  }
  
  public ArrayList<List<String>> queryReservedSeatsForFlight(String flight) {
	  ArrayList<List<String>> reservedSeats = new ArrayList<>();
		
	  ArrayList<String> reservedFirstClassSeats = new ArrayList<String>();
	  ArrayList<String> reservedEconomyClassSeats = new ArrayList<String>();
	  String queryStr = "select * from Booking_Info where Flight=\"" + flight + "\"";
	  try {
		  preparedStatement = connect
				  .prepareStatement(queryStr);
		  resultSet = preparedStatement.executeQuery();
		  while (resultSet.next()) {
			  String[] seatInfo = resultSet.getString("Seat").split(" +");
			  if (seatInfo[0].equals("First")) {
				  reservedFirstClassSeats.add(seatInfo[2]); 
			  } else if (seatInfo[0].equals("Economy")) {
				  reservedEconomyClassSeats.add(seatInfo[2]);
			  }
		  }
		  
		  reservedSeats.add(reservedFirstClassSeats);
		  reservedSeats.add(reservedEconomyClassSeats);
	  } catch (Exception e) {
		  System.out.println("Error: Failed to insert booking info into DB!");
		  return reservedSeats;  
	  }

	  return reservedSeats;
  }
  
  public Map<String, String> queryBookingInfo(String name, String flight) {
	  Map<String, String> result = new HashMap<>();
	  String queryStr = "select * from Booking_Info where Passenger_Name=\"" + name + "\"" + " and Flight=\"" + flight +"\"";
	  try {
		  preparedStatement = connect
				  .prepareStatement(queryStr);
		  resultSet = preparedStatement.executeQuery();
		  while (resultSet.next()) {
			  result.put("Booking_ID", resultSet.getString("Booking_ID"));
			  result.put("Passenger_Name", resultSet.getString("Passenger_Name"));
			  result.put("Passenger_Passport", resultSet.getString("Passenger_Passport"));
			  result.put("Passenger_Email", resultSet.getString("Passenger_Email"));
			  result.put("Depart_Airport", resultSet.getString("Depart_Airport"));
			  result.put("Arrive_Airport", resultSet.getString("Arrive_Airport"));
			  result.put("Flight", resultSet.getString("Flight"));
			  result.put("Depart_Date", resultSet.getString("Depart_Date"));
			  result.put("Depart_Time", resultSet.getString("Depart_Time"));
			  result.put("Arrive_Date", resultSet.getString("Arrive_Date"));
			  result.put("Arrive_Time", resultSet.getString("Arrive_Time"));
			  result.put("Price", resultSet.getString("Price"));
			  result.put("Aircompany", resultSet.getString("Aircompany"));
			  result.put("Seat", resultSet.getString("Seat"));
			  result.put("Food_Service", resultSet.getString("Food_Service"));
			  result.put("Baby_Service", resultSet.getString("Baby_Service"));
			  result.put("Disable_Service", resultSet.getString("Disable_Service"));
			  break;
		  }
	  } catch (Exception e) {
		  System.out.println("Error: Failed to query booking info from DB!");
		  return result;  
	  }
	  
	  return result;
  }
  
  public boolean deleteBookingInfo(String name, String flight) {
	  boolean result = false;
	  String queryStr = "delete from Booking_Info where Passenger_Name=\"" + name + "\"" + " and Flight=\"" + flight +"\"";
	  try {
		  preparedStatement = connect
				  .prepareStatement(queryStr);
		  if (preparedStatement.executeUpdate() > 0) {
			  result = true;
		  }
	  } catch (Exception e) {
		  System.out.println("Error: Failed to query booking info from DB!");
		  return result;  
	  }
	  
	  return result;
  }
}