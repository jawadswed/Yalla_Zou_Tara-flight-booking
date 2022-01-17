/*
 * This the sub JPanel for the JPanel list the searched fight numbers and price
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

//This is the class of the JPanelsearched fight numbers and price
public class FlightList extends JPanel implements ActionListener, ItemListener{
	
	//Initialize all of the JLable, JButton,JComboBox and JPanel
	
	
	private JLabel label2            = new JLabel(" Plaese choice");
	private JLabel label3            = new JLabel("        Flight Number               Price($)               Air Company");
	

	private JButton next             = new JButton("Next-->>");
	private JButton backHome         = new JButton("<<--Back Home");
	
	private JLabel image  = new JLabel(" ");

	
	private JPanel main   = new JPanel();
	private JPanel panelC = new JPanel();
	private JPanel panelN = new JPanel();
	private JPanel panelW = new JPanel();
	private JPanel panelE = new JPanel();
	private JPanel panelS = new JPanel();
	
    private ImageIcon Picture;
	private Image Img;
	
	private ButtonGroup grouplist = new ButtonGroup();
	
	
	private Fly flyContainer;
	private DBManager dbManager;
	
	private ArrayList<JCheckBox> checkBoxes = new ArrayList<>();
	/*
	 * This is the constructor  of this class
	 *this consturctor setting the all of the JLabel's
	 *JButton's, JPanel's font,backgound, size and layout 
	 */
	public FlightList(Fly container, DBManager dbmgr) {
		
		flyContainer = container;
		this.dbManager = dbmgr;
		
		setSize(800,800);
		setLayout(new BorderLayout());
		
		
		label2.setFont(new Font("Arial", Font.BOLD, 25));
		label3.setFont(new Font("Arial", Font.BOLD, 15));
		label3.setToolTipText("航班号( شماره پروا )                          价格(قیمت )                                 航空公司(شرکت هوا)\n");
		next.setToolTipText("下一步" + "بعد");
		backHome.setToolTipText("返回" + "بازگشت");

		setJButtonBackGround(next, Color.BLACK,new Color(255,240,245));
		setJButtonBackGround(backHome, Color.BLACK,new Color(255,240,245));
		
		Picture = new ImageIcon("resources/Images/subtitle.png");
		Img = Picture.getImage().getScaledInstance(900, 250, java.awt.Image.SCALE_SMOOTH);
		image.setIcon(new ImageIcon(Img));
		
		panelW.setBackground(new Color(255,240,245));
		main.setLayout(new BorderLayout());
		
		panelN.add(image);
		
		
		panelC.setBackground(new Color(255,240,245));
		panelC.setLayout(new GridLayout(7,1));
		panelC.add(label2);
		panelC.add(label3);
		
		panelW.setLayout(new GridLayout(2, 1));
		panelW.add(next);
		panelW.add(backHome);
		
		
		
		main.add(panelN, BorderLayout.NORTH);
		main.add(panelS, BorderLayout.SOUTH);
		main.add(panelW, BorderLayout.WEST);
		main.add(panelE, BorderLayout.EAST);
		main.add(panelC, BorderLayout.CENTER);
		
		add(main);
		
		next.addActionListener(this);
		backHome.addActionListener(this);
		
	}
	/*
	 * This is the actionperformed to execute the button's action 
	 * if the user click the different ItemSelect go to the  different Select
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		Object source = e.getSource();
		int select = e.getStateChange();	
	}
	/*
	 * This is the actionperformed to execute the button's action 
	 * if the user click the different buttonSelect go to the  different Select action
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
		
		if(source == next){
			Ticket curTicket = flyContainer.getCurTicket();
			for (JCheckBox jc : this.checkBoxes) {
				if (jc.isSelected()) {
					String[] flightInfo = jc.getText().split(" +");
					curTicket.setFlight(flightInfo[0]);
					//curTicket.setDepartTime(flightInfo[1]);
					curTicket.setPrice(Double.valueOf(flightInfo[1]));
					curTicket.setAircompany(flightInfo[2]);
				}
			}
			
			ArrayList<List<String>> reservedSeats = getReservedSeatsForFlight(curTicket.getFlight());
			flyContainer.setReservedSeatsMap(reservedSeats);
			flyContainer.markReservedSeats();
			
			CardLayout flyCardLayout = flyContainer.getCardLayout();
			flyCardLayout.show(flyContainer.getContentPane(),"seatPanel");
		 }else if(source == backHome) {
			
			CardLayout flyCardLayout = flyContainer.getCardLayout();
			flyCardLayout.show(flyContainer.getContentPane(), "HomePanel");
			//reset the information
			flyContainer.reset();
		}
		
	}
	/*
	 * This is the method to set the JButton Background 
	 * This is the method to set the JLabel Background 
	 * This is the method to set the JTextArea Background 
	 */
	public void setJButtonBackGround(JButton b, Color FC,Color BC) {
		
		b.setForeground(FC);       
		b.setBackground(BC);       
		b.setOpaque(true);               
		b.setBorderPainted(false);        
	}
   public void setJLableBackGround(JLabel l, Color FC,Color BC) {
		l.setOpaque(true);  
		l.setBackground(BC);
		l.setForeground(FC);
		
	}
   public void setJTextAreaBackGround(JTextArea t, Color FC,Color BC) {
		t.setOpaque(true);  
		t.setBackground(BC);
		t.setForeground(FC);
		
	}
   
   public void updateFlightList(ArrayList<String> flightList) {
	   if (this.checkBoxes.size() != 0) {
		   this.checkBoxes = new ArrayList<JCheckBox>();
	   } else {
		   this.checkBoxes.clear();
	   }

	   for (int i = 0; i < flightList.size(); i++) {
		   JCheckBox jc = new JCheckBox(flightList.get(i),false);
		   this.checkBoxes.add(jc);
		   panelC.add(jc);
		   grouplist = new ButtonGroup();
		   grouplist.add(jc);
		   jc.addItemListener(this);
	   }
	   
	   main.add(panelC, BorderLayout.CENTER);
   }
   
   public ArrayList<List<String>> getReservedSeatsForFlight(String flight) {
		ArrayList<List<String>> reservedSeats = dbManager.queryReservedSeatsForFlight(flight);
		
		return reservedSeats;
	}
   
   //This is the reset mothed to reset the information
   public void reset() {
	   	for (JCheckBox c : this.checkBoxes) {
	   		c.setSelected(false);
	   	}
   }
	

}
