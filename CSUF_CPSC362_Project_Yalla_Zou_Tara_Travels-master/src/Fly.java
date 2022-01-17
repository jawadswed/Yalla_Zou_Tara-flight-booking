/*
 * This the Class of main JFrame
 * Home calss extends JPanel
 * This class include the all the sub Jpanel
 * This class set the layout of JFrame and 
 * Setting the JMenuBar
 * connetting all of the JPanel of this Program
 */
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

//This is the class of JFrame Fly it is the main class
public class Fly extends JFrame implements ActionListener {
	
	/* Initialize the member is curUser is the class of the curuser*/
	private User curUser       = new User();
	/*Initialize the curTicket is curUser is the class of the Ticket*/
	private Ticket curTicket   = new Ticket();
	/*Initialize the curService is curUser is the class of the Service*/
	private Service curService = new Service();
	
	private Map<Integer, Set<Integer>> reservedFirstClassSeatsMap = new HashMap<>();
	private Map<Integer, Set<Integer>> reservedEconomyClassSeatsMap = new HashMap<>();
	
	//Initialize the JMenuBar and JMenu
	JMenuBar mainbar    = new JMenuBar();
	JMenu menu1         = new JMenu("File");
	JMenu menu2         = new JMenu("Select");
	JMenu menu21        = new JMenu("Fight");
	JMenu menu3         = new JMenu("Information");
	JMenu menu4         = new JMenu("Service ");
	JMenu menu5         = new JMenu("personal ");

	//first JMenuItem
	JMenuItem exit = new JMenuItem("Exit");
	JMenuItem home = new JMenuItem("Home");
	//SecondJMenuItem
	JMenuItem change  = new JMenuItem("Change");
	JMenuItem refund  = new JMenuItem("Online refund");

	JMenuItem oneWay    = new JMenuItem("oneWay");
	JMenuItem roundTrip = new JMenuItem("roundTrip");
	
	//ThirdlyJ MenuItem
	JMenuItem luggage  = new JMenuItem("Luggage");
	JMenuItem wheather = new JMenuItem("Weather");
	JMenuItem seat     = new JMenuItem("Seat");
	//fourth JMenuItem
	JMenuItem disable = new JMenuItem("Disability Support");
	JMenuItem baby    = new JMenuItem("Child Services");
	JMenuItem food    = new JMenuItem("Meal Plan");
	//five JMenuItem
	JMenuItem  personalInformation = new JMenuItem("Personal Information");
	JMenuItem  currentlyFlight     = new JMenuItem("Current Flight");
	
	//Creating the all of the JPanel class in this program 
	Login loginPanel;
	Signup signupPanel;
	
	Home homePanel                          = new Home(this);
	
	OneWay oTrip;
	RoundTrip rTrip 					    = new RoundTrip(this);
	
	Change cTrip                            = new Change(this);
	OnlineRefound onlineReTrip;    
	
	Luggage luggagePanel 					= new Luggage(this); 
	Wheather wheatherPanel;
	Seat seatPanel							= new Seat(this);
	FlightList FlightListPanel;
	
	DisableHelp disableHelpPanel 			= new DisableHelp(this);
	BabyHelp babyHelpPanel 			        = new BabyHelp(this);
	FoodService foodHelpPanel			    = new FoodService(this);
	
	PerInfo personalInfo;
	CurrentlyFightInfo currentlyFightInfo 	= new CurrentlyFightInfo(this);
	
	SelectHome selectHome                   = new SelectHome(this);
	PersoniallyInfoHome personiallyInfoHome = new PersoniallyInfoHome(this);
	InformationHome informationHome         = new InformationHome(this);
	SeviceHome seviceHome                   = new SeviceHome(this);
	
	
	CardLayout cardLayout 					= new CardLayout();
	
	
	//this is the fly constuctor
	public Fly(DBManager dbmgr) {
		//seting the jFrame's title, layout, size and Default colose
		super(" Yalla Zou Tara Travels ");
		
		this.loginPanel      = new Login(this, dbmgr);
		this.signupPanel     = new Signup(this, dbmgr);
		this.oTrip           = new OneWay(this, dbmgr);
		this.personalInfo    = new PerInfo(this, dbmgr);
		this.wheatherPanel   = new Wheather(this, dbmgr);
		this.FlightListPanel = new FlightList(this, dbmgr);
		this.onlineReTrip    = new OnlineRefound(this, dbmgr); 
		
		setLayout(cardLayout);
		setSize(800,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//seting the JMenuBar
		setJMenuBar(mainbar);
		//seting the maibar
		mainbar.add(menu1);
		mainbar.add(menu2);
		mainbar.add(menu3);
		mainbar.add(menu4);
		mainbar.add(menu5);
		//seting the menu1 and add the JMenuItem
		menu1.add(exit);
		menu1.add(home);
		//seting the menu21 and add the JMenuItem
		menu21.add(oneWay);
		menu21.add(roundTrip);
		menu2.add(menu21);
		menu2.add(change);
		menu2.add(refund);
		//seting the menu3 and add the JMenuItem
		menu3.add(luggage);
		menu3.add(wheather);
		menu3.add(seat);
		//seting the menu4 and add the JMenuItem
		menu4.add(disable);
		menu4.add(baby);
		menu4.add(food);
		//seting the menu5 and add the JMenuItem
		menu5.add(personalInformation);
		menu5.add(currentlyFlight);
		//adding the all of the JPanel i this programe 
		add(loginPanel, "LoginPanel");
		add(signupPanel, "SignupPanel");
		
		
		add(homePanel, "HomePanel");
		
		add(selectHome, "SelectButtonsHomePanel");
		add(personiallyInfoHome,"personiallyInfoHomePanel");
		add(informationHome,"informationHomePanel");
		add(seviceHome,"seviceHomePanel");
		
		add(oTrip, "oneWayPanel");
		add(rTrip, "roundWayPanel");
		
		add(cTrip, "ChangeTripPanel");
		add(onlineReTrip, "RefoundTripPanel");
		
		add(luggagePanel, "LuggagePanel");
		add(wheatherPanel, "wheatherPanel");
		add(seatPanel, "seatPanel");
		add(FlightListPanel, "FlightListPanel");
		
		add(disableHelpPanel, "disableHelpPanel");
		add(babyHelpPanel, "babyHelpPanel");
		add(foodHelpPanel, "foodHelpPanel");
		
		add(personalInfo,"personalInfo");
		add(currentlyFightInfo,"currentlyFightInfo");
		//adding the all of the Button action 
		exit.addActionListener(this);
		home.addActionListener(this);
		
		oneWay.addActionListener(this);
		roundTrip.addActionListener(this);
		change.addActionListener(this);
		refund.addActionListener(this);
		
		luggage.addActionListener(this);
		wheather.addActionListener(this);
		seat.addActionListener(this);
		
		disable.addActionListener(this);
		baby.addActionListener(this);
		food.addActionListener(this);
		
		personalInformation.addActionListener(this);
		currentlyFlight.addActionListener(this);
				
	}
	/*
	 * This is the actionperformed to execute the button's action 
	 * if click the home go to the home Panel
	 * if click the oneWay go to the oneWay Panel
	 * if click the roundTrip go to  the roundTrip Panel
	 * if click the change go to the change Panel
	 * if click the refound go to the refound Panel
	 * if click the luggage go to the luggage Panel
	 * if click the weather go to the weather Panel
	 * if click the seat go to the seat Panel
	 * if click the disable go to the disable Panel
	 * if click the baby go to the baby Panel
	 * if click the food go to the food Panel
	 * if click the personally informtion go to the personally Panel
	 * if click the currently fight go to the currently fight Panel
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == exit) {
			System.exit(0);
		}//back the home
		else if(source == home){
			cardLayout.show(getContentPane(), "HomePanel");	
			
			///////////////
		}else if(source == oneWay){
			cardLayout.show(getContentPane(), "oneWayPanel");	
		}else if(source == roundTrip){
			cardLayout.show(getContentPane(), "roundWayPanel");	
		}else if(source == change){
			cardLayout.show(getContentPane(), "ChangeTripPanel");	
		}else if(source == refund){
			cardLayout.show(getContentPane(), "RefoundTripPanel");
			
			///////////////////
		}else if(source == luggage){
			cardLayout.show(getContentPane(), "LuggagePanel");	
		}else if(source == wheather){
			cardLayout.show(getContentPane(), "wheatherPanel");	
		}else if(source == seat){
			cardLayout.show(getContentPane(), "seatPanel");	
			
			//**************
		}else if(source == seat){
			cardLayout.show(getContentPane(), "seatPanel");	
			
			/////////////////////////////
		}else if(source == disable){
			
			cardLayout.show(getContentPane(), "disableHelpPanel");	
		}else if(source == baby){
			cardLayout.show(getContentPane(), "babyHelpPanel");	
		}else if(source == food){
			cardLayout.show(getContentPane(),  "foodHelpPanel");
			
			
			//////////////////////////////
		}else if(source == personalInformation){
			
			cardLayout.show(getContentPane(), "personalInfo");	
		}else if(source == currentlyFlight){
			cardLayout.show(getContentPane(), "currentlyFightInfo");	
		}
		
	}
	//this is the method to get the CardLayout 
	public CardLayout getCardLayout() {
		return this.cardLayout;
	}
	//this is the method to get the currently user 
	public User getCurUser() {
		return curUser;
	}
	//this is the method to get the currently ticket
	public Ticket getCurTicket() {
		return curTicket;
	}
	//this is the method to get the currently service
	public Service getCurService() {
		return curService;
	}
	//this is the method to get the currently fight tickit information 
	public void setCurFlightInfo(String info) {
		currentlyFightInfo.setDisplayedInfo(info);
	}
	
	
	
	public void updateFlightListPanel(ArrayList<String> flightList) {
		this.FlightListPanel.updateFlightList(flightList);
	}
	
	
	public void setReservedSeatsMap(ArrayList<List<String>> reservedSeats) {
		this.reservedFirstClassSeatsMap.clear();
		this.reservedEconomyClassSeatsMap.clear();
		
		List<String> reservedFirstClassSeats = reservedSeats.get(0);
		List<String> reservedEconomyClassSeats = reservedSeats.get(1);
		
		for (String seatInfo : reservedFirstClassSeats) {
			String[] seatPos = seatInfo.split(",");
			int row = Integer.parseInt(seatPos[0]);
			int col = Integer.parseInt(seatPos[1]);
			if (!reservedFirstClassSeatsMap.containsKey(row)) {
				reservedFirstClassSeatsMap.put(row, new HashSet<Integer>());
			}
			reservedFirstClassSeatsMap.get(row).add(col);
		}
		
		for (String seatInfo : reservedEconomyClassSeats) {
			String[] seatPos = seatInfo.split(",");
			int row = Integer.parseInt(seatPos[0]);
			int col = Integer.parseInt(seatPos[1]);
			if (!reservedEconomyClassSeatsMap.containsKey(row)) {
				reservedEconomyClassSeatsMap.put(row, new HashSet<Integer>());
			}
			reservedEconomyClassSeatsMap.get(row).add(col);	
		}
		
	}

	public void markReservedSeats() {
		this.seatPanel.markReservedSeats(reservedFirstClassSeatsMap, reservedEconomyClassSeatsMap);
	}
	
	//this is the method to rest all of the actions
	public void reset() {
		oTrip.reset();                      
		rTrip.reset(); 					  
		
		cTrip.reset();                         
		onlineReTrip.reset();             
		
		luggagePanel.reset(); 					
		wheatherPanel.reset(); 					
		seatPanel.reset();							
		
		disableHelpPanel.reset(); 			
		babyHelpPanel.reset(); 			    
		foodHelpPanel.reset();			 
		
		personalInfo.reset(); 				
		currentlyFightInfo.reset(); 	
		
		curUser = new User();
		curTicket = new Ticket();
		curService = new Service();
	}
}






























