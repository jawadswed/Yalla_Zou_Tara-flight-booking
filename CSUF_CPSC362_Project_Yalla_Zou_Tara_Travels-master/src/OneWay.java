/*
 * This is the sub JPanel for the JPanel Select
 * The user can enter the TO and FROM city for travel
 * and the day of departure for a one way trip
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

// This is the class of the JPanel oneWay. It implements ActionListener
public class OneWay extends JPanel implements ActionListener{
	
	// Initializing all of the JLabels, JTextFields, 
	// JButtons, JPanels, JComboBoxes and String arrays
	
	private JLabel label1 = new JLabel("One Way Trip");
	private JLabel from1  = new JLabel("                                            From*"); 
	private JLabel to     = new JLabel("                                                To*");
	
	private JTextField fromCity = new JTextField("City/Airport",20);
	private JTextField toCity   = new JTextField("City/Airport",20);
	private String[] dayarray   = {"DAY","1","2","3","4","5","6","7","8","9","10",
			               "11","12","13","14","15","16","17","18","19","20",
			               "21","22","23","24","25","26","27","28","29","30",};
	private JComboBox day       = new JComboBox(dayarray);
	
	private String[] montharray = {"Month","1","2","3","4","5","6","7","8","9","10","11","12"};
	private JComboBox month     = new JComboBox(montharray);
	
	private String[] yeararray  = {"Year","2019","2020","2021"};
	private JComboBox year      = new JComboBox(yeararray);
	
	private JButton backHome    = new JButton("<<--Back Home");
	private JButton backSclect  = new JButton("<<--Back Select");
	private JButton next        = new JButton("Next-->>");
	
	private JPanel panel1       = new JPanel();
	private JPanel panel2       = new JPanel();
	private JPanel panel3       = new JPanel();
	
	// Making a container of type fly
	private Fly flyContainer;
	private DBManager dbManager;
	
	/*
	 * This is the constructor of this class.
	 * The constructor sets all of the JLabels,
	 * JButtons, JPanels, font, backgound, size and layout 
	 */
	public OneWay(Fly container, DBManager dbmgr){
		flyContainer = container;
		dbManager = dbmgr;
		
		setSize(1000,800);
		setLayout(new GridLayout(4,1));
		
		Font arial20 = new Font("Arial", Font.BOLD, 20);
		
		label1 = new JLabel("Please Enter from City/Airport  and arrival City/Airport");
	    	label1.setFont(new Font("Apple Chancery", Font.BOLD, 25));
	    	setJLableBackGround(label1, Color.BLACK,new Color(135,206,250));
	    
	   	from1.setFont(arial20);
	    	setJLableBackGround(  from1, Color.BLACK,new Color(100,149,237));
	    	
		from1.setToolTipText("出发地" +"از جایی که؟");
	    
	    	to.setFont(arial20);
	    	setJLableBackGround(to, Color.BLACK,new Color(100,149,237));
	    	to.setToolTipText("到达" +"به کجا؟");
	    
	    	backHome.setFont(arial20);
	    	setJButtonBackGround(backHome, Color.BLACK,new Color(240,128,128));
	    	backHome.setToolTipText("返回主页" + "بازگشت");
		
	    	backSclect.setFont(arial20);
	    	setJButtonBackGround(backSclect, Color.BLACK,new Color(225,218,155));
	    	backSclect.setToolTipText("返回选择" + "برگشت انتخاب کنید");
		
	    	next.setFont(arial20);
	    	setJButtonBackGround(next, Color.BLACK,new Color(124,252,0));
	    	next.setToolTipText("下一步" + "بعد");
	    
	    	panel1.setLayout(new GridLayout(2,2,2,2));
	    	panel1.setBackground(new Color(100,149,237));
	    	panel1.add(from1);
	    	panel1.add(fromCity);
	    	panel1.add(to);
	    	panel1.add(toCity);
	    	panel2.setBackground(new Color(135,206,250));
	    	panel2.setLayout(new GridLayout(1,3,2,2));
	    	panel2.add(month);
	    	panel2.add(day);
	    	panel2.add(year);
	    
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
	   	backHome.addActionListener(this);
	    	backSclect.addActionListener(this);
	    	next.addActionListener(this);
		
	}
	
	// This is the actionperformed method to execute the user's action 
	// when selecting a JComboBox or JButton 
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		// When the user selects the month JComboBox, it records the month the user selects 
		if(source == month ) {
			String betChoice = month.getSelectedItem().toString();
			if (!betChoice.equals("Month")) {
				//Betmoney.setText(betChoice.replace("$", ""));
			}	
		}
		
		// When selects the day JComboBox, it records the day the user selects 
		if(source == day ) {
			String betChoice = day.getSelectedItem().toString();
			if (!betChoice.equals("Day")) {
				//Betmoney.setText(betChoice.replace("$", ""));
			}	
		}
		
		// When the user selects the year JComboBox, it records the year the user selects 
		if(source == year ) {
			String betChoice = year.getSelectedItem().toString();
			if (!betChoice.equals("Year")) {
				//Betmoney.setText(betChoice.replace("$", ""));
			}
			
		}
		
		// If user selects the "Back Home" button, "HomePanel" appears 
		if(source == backHome ) {
			CardLayout flyCardLayout = flyContainer.getCardLayout();
			flyCardLayout.show(flyContainer.getContentPane(), "HomePanel");
			
			// The information resets
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
			//****
			//flyCardLayout.show(flyContainer.getContentPane(), "seatPanel");
			String departCode = fromCity.getText();
			String arriveCode = toCity.getText();
			ArrayList<String> flightList = dbManager.queryFlightInfo(departCode, arriveCode);
			flyContainer.updateFlightListPanel(flightList);
			flyCardLayout.show(flyContainer.getContentPane(), "FlightListPanel");
			
			// The user's selections of To/From airport 
			// and departing day is translated to a string
			Ticket t = flyContainer.getCurTicket();
			t.setDepartAirport(fromCity.getText());
			t.setArriveAirport(toCity.getText());
			t.setDepartDay(day.getSelectedItem().toString());
			t.setDepartMonth(month.getSelectedItem().toString());
			t.setDepartYear(year.getSelectedItem().toString());
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
    		day.setSelectedIndex(0);
    		month.setSelectedIndex(0);
    		year.setSelectedIndex(0);
    		fromCity.setText("City/Airport");
    		toCity.setText("City/Airport");
	}
}
