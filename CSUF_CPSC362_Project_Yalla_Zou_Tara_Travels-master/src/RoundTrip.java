/*
 * This is the sub JPanel for the JPanel Select
 * The user can enter the TO and FROM city for travel
 * and the day of departure and return for a round trip
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//This is the class of the JPanel roundtrip. It implements ActionListener
public class RoundTrip extends JPanel implements ActionListener{
	
	// Initializing all of the JLabels, JTextFields, 
	// JButtons, JPanels, JComboBoxes and String arrays
	private JLabel label1    = new JLabel("Round Trip");
	
	private JLabel label2    = new JLabel("          &");
	private JLabel label3    = new JLabel("      <<----->>");
	private JLabel Departure = new JLabel("Departure");
	private JLabel Return    = new JLabel("Return");
	
	private JLabel from1     = new JLabel("From*");
	private JLabel to        = new JLabel("To*");
	
	private JTextField fromCity = new JTextField("City/Airport",20);
	private JTextField toCity = new JTextField("City/Airport",20);
	private String[] dayarray = {"Day","1","2","3","4","5","6","7","8","9","10",
			               "11","12","13","14","15","16","17","18","19","20",
			               "21","22","23","24","25","26","27","28","29","30",};
	
	private JComboBox day = new JComboBox(dayarray);
	private JComboBox day2 = new JComboBox(dayarray);

	private String[] montharray = {"Month","1","2","3","4","5","6","7","8","9","10","11","12"};
	private JComboBox month = new JComboBox(montharray);
	private JComboBox month2= new JComboBox(montharray);
	
	private String[] yeararray = {"Year","2019","2020","2021"};
	private JComboBox year = new JComboBox(yeararray);
	private JComboBox year2 = new JComboBox(yeararray);
	
	private JButton backHome = new JButton("<<--Back Home");
	private JButton backSclect  = new JButton("<<--Back Sclect");
	private JButton next = new JButton("Next-->>");
	
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	
	// Making a container of type Fly
	private Fly flyContainer;
	
	/*
	 * This is the constructor of this class.
	 * The constructor sets all of the JLabels,
	 * JButtons, JPanels, font, backgound, size and layout 
	 */
	RoundTrip(Fly container){
		
		flyContainer = container;
		
		setSize(1000,800);
		setLayout(new GridLayout(4,1));
		
		Font apple35 = new Font("Arial", Font.BOLD, 35);
		Font arial20 = new Font("Arial", Font.BOLD, 20);
		
		label1 = new JLabel("Please Enter Departing City/Airport and Arriving City/Airport");
	    	label1.setFont(apple35);
	    	setJLableBackGround(label1, Color.BLACK,new Color(135,206,250));
	    	label2.setFont(apple35);
	    	setJLableBackGround(label2, Color.BLACK,new Color(100,149,237));
	    	label3.setFont(apple35);
	    	setJLableBackGround(label3, Color.BLACK,new Color(100,149,237));
	    
	    	from1.setFont(arial20);
	    	setJLableBackGround(  from1, Color.BLACK,new Color(100,149,237));
	    	to.setFont(arrial20);
	    	setJLableBackGround(to, Color.BLACK,new Color(100,149,237));
	    
	    	Departure = new JLabel("Departure");
	    	Departure.setFont(apple35);
	    	setJLableBackGround(Departure, Color.BLACK,new Color(135,206,250));
	    	Return = new JLabel("Return");
	    	Return.setFont(apple35);
	    	setJLableBackGround(Return, Color.BLACK,new Color(135,206,250));
	    
		backHome.setFont(arial20);
	    	setJButtonBackGround(backHome, Color.BLACK,new Color(240,128,128));
	    	backSclect.setFont(arial20);
	    	setJButtonBackGround(backSclect, Color.BLACK,new Color(225,218,155));
	    	next.setFont(arial20);
	    	setJButtonBackGround(next, Color.BLACK,new Color(124,252,0));
	    
	    	panel1.setLayout(new GridLayout(2,3,2,2));
	    	panel1.setBackground(new Color(100,149,237));
	    	panel1.add(from1);
	    	panel1.add(label2);
	    	panel1.add(to);
	    	panel1.add(fromCity);
	    	panel1.add(label3);
	    	panel1.add(toCity);
	    
	    	panel2.setBackground(new Color(135,206,250));
	    	panel2.setLayout(new GridLayout(4,2,2,2));
	    	panel2.add(Departure);
	    	panel2.add(Return);
	    	panel2.add(month);
	    	panel2.add(month2);
	    	panel2.add(day);
	    	panel2.add(day2);
	    	panel2.add(year);
	    	panel2.add(year2);
	    
	    	panel3.setLayout(new GridLayout(1,3,2,2));
	    	panel3.add(backHome);
	    	panel3.add(backSclect);
	    	panel3.add(next);
	   
	   	add(label1);
	    	add(panel1);
	    	add(panel2);
	    	add(panel3);
	    
	    	month.addActionListener(this);
	    	day.addActionListener(this);
	    	year.addActionListener(this);
	    	month2.addActionListener(this);
	    	day2.addActionListener(this);
	    	year2.addActionListener(this);
	    	backHome.addActionListener(this);
	    	backSclect.addActionListener(this);
	    	next.addActionListener(this);
	}
	
	// This is the actionperformed method to execute the user's action 
	// when selecting a JComboBox or JButton 
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		// When the user selects the month, day and year JComboBoxes
		// it records the month, day and year for depature
		if(source == month ) {
			String betChoice = month.getSelectedItem().toString();
			if (!betChoice.equals("Month")) {
				//Betmoney.setText(betChoice.replace("$", ""));
			}
		}
		if(source == day ) {
			String betChoice = day.getSelectedItem().toString();
			if (!betChoice.equals("Day")) {
				//Betmoney.setText(betChoice.replace("$", ""));
			}
		}
		if(source == year ) {
			String betChoice = year.getSelectedItem().toString();
			if (!betChoice.equals("Year")) {
				//Betmoney.setText(betChoice.replace("$", ""));
			}
		}
		
		// When the user selects the month2, day2 and year2 JComboBoxes
		// it records the month, day and year for arrival
		if(source == month2 ) {
			String betChoice = month2.getSelectedItem().toString();
			if (!betChoice.equals("Month")) {
				//Betmoney.setText(betChoice.replace("$", ""));
			}
		}
		if(source == day2 ) {
			String betChoice = day2.getSelectedItem().toString();
			if (!betChoice.equals("Day")) {
				//Betmoney.setText(betChoice.replace("$", ""));
			}	
		}
		if(source == year2 ) {
			String betChoice = year2.getSelectedItem().toString();
			if (!betChoice.equals("Year")) {
				//Betmoney.setText(betChoice.replace("$", ""));
			}	
		}
		
		// If user selects the "Back Home" button, "HomePanel" appears 
		if(source == backHome ) {
			CardLayout flyCardLayout = flyContainer.getCardLayout();
			flyCardLayout.show(flyContainer.getContentPane(), "HomePanel");
			
			// Reset the information
			flyContainer.reset();	
		}
		
		// If user selects the "Back Select" button, "SelectButtonsHomePanel" appears 
		if(source == backSclect) {
			CardLayout flyCardLayout = flyContainer.getCardLayout();
			flyCardLayout.show(flyContainer.getContentPane(),"SelectButtonsHomePanel");
		}
		
		// If user selects the "Next" button, "seatPanel" appears
		if(source == next) {
			CardLayout flyCardLayout = flyContainer.getCardLayout();
			//flyCardLayout.show(flyContainer.getContentPane(), "seatPanel");
			flyCardLayout.show(flyContainer.getContentPane(), "FightListPanel");
			
			// The user's selections of To/From airport 
			// and departing & arrival date are translated to a string
			Ticket t = flyContainer.getCurTicket();
			t.setDepartAirport(fromCity.getText());
			t.setArriveAirport(toCity.getText());
			t.setDepartDay(day.getSelectedItem().toString());
			t.setDepartMonth(month.getSelectedItem().toString());
			t.setDepartYear(year.getSelectedItem().toString());
			t.setArriveDay(day2.getSelectedItem().toString());
			t.setArriveMonth(month2.getSelectedItem().toString());
			t.setArriveYear(year2.getSelectedItem().toString());
			t.setRoundTripticket();	
		}
	}
	
	// Method to set JLabel background
	public void setJLableBackGround(JLabel l, Color FC,Color BC) {
		l.setOpaque(true);  
		l.setBackground(BC);
		l.setForeground(FC);
	}
	
	// Method to set JButton background
    	public void setJButtonBackGround(JButton b, Color FC,Color BC) {
		b.setForeground(FC);       
		b.setBackground(BC);       
		b.setOpaque(true);               
		b.setBorderPainted(false);        
	}
	
	// Method to reset the JCheckBoxes and JTextFields
    	public void reset() {
    		fromCity.setText("City/Airport"); 
    		toCity.setText("City/Airport"); 
    	
    		day.setSelectedIndex(0);
    		day2.setSelectedIndex(0);
    
    		month.setSelectedIndex(0);
    		month2.setSelectedIndex(0);
    	
    		year.setSelectedIndex(0);
    		year2.setSelectedIndex(0);
	}
}
