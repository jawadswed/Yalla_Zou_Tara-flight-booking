// This is the subJPanel for the JPanel FoodService 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// This is the class of the JPanel FoodService. It implements ActionListener and Itemlistener 
public class FoodService extends JPanel implements ActionListener, ItemListener{
	
	// Initializing all of the JLabels, JButtons, JPanels, ImageIcons, Images, and JCheckBoxes 
	private JLabel label1            = new JLabel("The Food Service ");
	private JLabel label2            = new JLabel(" Please Select One ");
	private JLabel label3            = new JLabel(" Which food platter would you like to reserve?");
	private JButton finish           = new JButton(" Finish or Skip to next -->>");
	private JButton backMoreSevice   = new JButton("<<--Back More Sevice");
	private JButton backHome         = new JButton("<<--Back Home");
	
	private JLabel image  = new JLabel(" ");
	private JLabel image2 = new JLabel(" ");
	private JLabel image3 = new JLabel(" ");
	
	private JPanel main   = new JPanel();
	private JPanel panelC = new JPanel();
	private JPanel panelN = new JPanel();
	private JPanel panelW = new JPanel();
	private JPanel panelE = new JPanel();
	private JPanel panelS = new JPanel();
	
    	private ImageIcon Picture;
	private Image Img;
	private ImageIcon Picture2;
	private Image Img2;
	private ImageIcon Picture3;
	private Image Img3;
	
	private JCheckBox BBML; 
	private JCheckBox FPML;
	private JCheckBox LFML;
	private JCheckBox VGML;
	private JCheckBox SFML;
	
	// Making a container of type Fly
	private Fly flyContainer;
	
	/*
	 * This is the constructor of this class.
	 * The consturctor sets all of the JLabels, JButtons, 
	 * JPanels, JCheckBoxes, Images, font, backgound, size and layout 
	 */
	public FoodService(Fly container) {
		
		flyContainer = container;
		setSize(800,800);
		setLayout(new BorderLayout());
		
		label1.setFont(new Font("Arial", Font.BOLD, 25));
		setJLableBackGround(label1, Color.BLACK,new Color(255,240,245));
		label2.setFont(new Font("Arial", Font.BOLD, 25));
		setJLableBackGround(label1, Color.BLACK,new Color(255,240,245));
		label3.setFont(new Font("Arial", Font.BOLD, 15));
		setJLableBackGround(label1, Color.BLACK,new Color(255,240,245));
		 
		setJButtonBackGround(finish, Color.BLACK,new Color(255,240,245));
		setJButtonBackGround(backMoreSevice, Color.BLACK,new Color(255,240,245));
		setJButtonBackGround(backHome, Color.BLACK,new Color(255,240,245));
		
		Picture = new ImageIcon("resources/Images/subtitle.png");
		Img = Picture.getImage().getScaledInstance(900, 250, java.awt.Image.SCALE_SMOOTH);
		image.setIcon(new ImageIcon(Img));
		
		Picture2 = new ImageIcon("resources/Images/service-imgey.png");
		Img2 = Picture2.getImage().getScaledInstance(900, 150, java.awt.Image.SCALE_SMOOTH);
		image2.setIcon(new ImageIcon(Img2));
		
		Picture3 = new ImageIcon("resources/Images/foodImage.png");
		Img3 = Picture3.getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
		image3.setIcon(new ImageIcon(Img3));
		
		BBML = new JCheckBox("Baby Meal",false);
		FPML = new JCheckBox("Fruit Platter Meal",false);
		LFML = new JCheckBox("Low Fat Meal",false);
		VGML = new JCheckBox("Vegetarian Meal",false);
		SFML = new JCheckBox("Seafood Meal",false);
		
		panelW.setBackground(new Color(255,240,245));
		main.setLayout(new BorderLayout());
		
		panelN.add(image);
		panelS.add(image2);
		
		panelC.setBackground(new Color(255,240,245));
		panelC.setLayout(new GridLayout(7,1));
		panelC.add(label2);
		panelC.add(label3);
		panelC.add(BBML);
		panelC.add(FPML);
		panelC.add(LFML);
		panelC.add(VGML);
		panelC.add(SFML);
		
		panelW.setLayout(new GridLayout(4, 1));
		panelW.add(label1);
		panelW.add(finish);
		panelW.add(backMoreSevice);
		panelW.add(backHome);
		
		panelE.add(image3);
		
		main.add(panelN, BorderLayout.NORTH);
		main.add(panelS, BorderLayout.SOUTH);
		main.add(panelW, BorderLayout.WEST);
		main.add(panelE, BorderLayout.EAST);
		main.add(panelC, BorderLayout.CENTER);
		
		add(main);
		
		finish.addActionListener(this);
		backHome.addActionListener(this);
		backMoreSevice.addActionListener(this);
		BBML.addItemListener(this);
		FPML.addItemListener(this);
		LFML.addItemListener(this);
		VGML.addItemListener(this);
		SFML.addItemListener(this);
	}
	
	/*
	 * This is the itemStateChanged. If an item is selected,
	 * it logs it in as SELECTED
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		Object source = e.getSource();
		int select = e.getStateChange();
		if(source == BBML) {
			if (select ==ItemEvent.SELECTED) {}
		}
		else if (source == FPML) {
			if (select == ItemEvent.SELECTED) {}
		}
		else if (source == LFML) {
			if (select == ItemEvent.SELECTED) {}
		}
		else if (source == VGML) {
			if (select == ItemEvent.SELECTED) {}
		}
		else if (source == SFML) {
			if (select == ItemEvent.SELECTED) {}
		}
	}
	
	// This is the actionperformed method to execute the button's action when selected 
	@Override
	public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
		
		// If user selects the "Finish" button, "peronalInfo" panel appears
		if(source == finish){
			CardLayout flyCardLayout = flyContainer.getCardLayout();
			flyCardLayout.show(flyContainer.getContentPane(),"personalInfo");
			Service curService = flyContainer.getCurService();
			
			// If a food type is selected, that item is added to the current user's information 
			if (BBML.isSelected()) {
				curService.addBookedFood("Baby Meal");
			}
			if (FPML.isSelected()) {
				curService.addBookedFood("Fruit Platter Meal");
			}
			if (LFML.isSelected()) {
				curService.addBookedFood("Low Fat Meal");
			}
			if (VGML.isSelected()) {
				curService.addBookedFood("Vegetarian Meal");
			}
			if (SFML.isSelected()) {
				curService.addBookedFood("Seafood Meal");
			}
		}
		
		// If user selects the "Back More Service" button, "serviceHomePanel" appears 
		else if(source == backMoreSevice) {
			CardLayout flyCardLayout = flyContainer.getCardLayout();
			flyCardLayout.show(flyContainer.getContentPane(),"seviceHomePanel");	
		}
		
		// If user selects the "Back Home" button, "HomePanel" appears
		else if(source == backHome) {
			CardLayout flyCardLayout = flyContainer.getCardLayout();
			flyCardLayout.show(flyContainer.getContentPane(), "HomePanel");
			
			// The information resets 
			flyContainer.reset();
		}
	}
	
	// Method to set JButton background
	public void setJButtonBackGround(JButton b, Color FC,Color BC) {
		b.setForeground(FC);       
		b.setBackground(BC);       
		b.setOpaque(true);               
		b.setBorderPainted(false);        
	}
	
	// Method to set JLabel background 
   	public void setJLableBackGround(JLabel l, Color FC,Color BC) {
		l.setOpaque(true);  
		l.setBackground(BC);
		l.setForeground(FC);
	}
	
	// Method to set JTextArea background 
  	public void setJTextAreaBackGround(JTextArea t, Color FC,Color BC) {
		t.setOpaque(true);  
		t.setBackground(BC);
		t.setForeground(FC);	
	}
   
  	// Method to reset the JCheckBox item selections
	public void reset() {
		BBML.setSelected(false); 
		FPML.setSelected(false); 
		LFML.setSelected(false); 
		VGML.setSelected(false); 
		SFML.setSelected(false); 
	}
}
