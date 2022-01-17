/*
 * This the sub JPanel for the JPanel Disabled help
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//This is the class of the JPanel DisableHelp. It mplements ActionListener and ITemListener
public class DisableHelp extends JPanel implements ActionListener, ItemListener{
	
	// Initializing all of the JLabels, JButtons,  JPanels, 
	// ImageIcons, Images, and JCheckBoxes 
	
	private JLabel label1            = new JLabel("The Disabled Help Service ");
	private JLabel label2            = new JLabel(" Please Select a Service");
	private JLabel label3            = new JLabel(" What service do you want to reserve? ");
	private JButton finish             = new JButton(" Finish or Skip to next -->>");
	private JButton backMoreSevice       = new JButton("<<--Back More Service");
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
	
	private JCheckBox crutches;
	private JCheckBox Braces;
	private JCheckBox Wheelchairs;
	private JCheckBox Hearingaids;
	
	// Making a container of type Fly
	private Fly flyContainer;
	/*
	 * This is the constructor of this class. It sets all of the JLabels,
	 * JButtons, JPanels, ImageIcons, JCheckboxes font, backgound, size and layout 
	 */
	public DisableHelp(Fly container) {
		
		flyContainer = container;
		setSize(800,800);
		setLayout(new BorderLayout());
		
		Font arial25 = new Font("Arial", Font.BOLD, 25);
	
		label1.setFont(arial25);
		setJLableBackGround(label1, Color.BLACK,new Color(255,240,245));
		label2.setFont(arial25);
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
		
		Picture3 = new ImageIcon("resources/Images/disableImage.png");
		Img3 = Picture3.getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
		image3.setIcon(new ImageIcon(Img3));
		
	        crutches    = new JCheckBox("Crutches, Canes, and Walkers",false);
		Braces      = new JCheckBox("Braces/Prosthetics",false);
		Wheelchairs = new JCheckBox("Wheelchairs",false);
		Hearingaids = new JCheckBox("Hearing aids",false);
	
		main.setLayout(new BorderLayout());
		
		panelN.add(image);
		panelS.add(image2);
		
		panelC.setBackground(new Color(255,240,245));
		panelC.setLayout(new GridLayout(6,1));
		panelC.add(label2);
		panelC.add(label3);
		panelC.add(crutches);
		panelC.add(Braces);
		panelC.add(Wheelchairs);
		panelC.add(Hearingaids);
		
		panelW.setBackground(new Color(255,240,245));
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
		
		crutches.addItemListener(this);
		Braces.addItemListener(this);
		Wheelchairs.addItemListener(this);
		Hearingaids.addItemListener(this);	
	}
	
	/*
	 * This is the itemStateChanged. If an item is selected, it is saved 
	 * into the current user's info for their flight
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		Object source = e.getItem();
		int select = e.getStateChange();
		
		if (source == crutches) {
			if(select == ItemEvent.SELECTED) {   
	    		}
	    	else if (source == Braces) {
	    		if(select == ItemEvent.SELECTED) {
	        	}
	    	}
	    	else if(source == Wheelchairs) {
	    		if(select == ItemEvent.SELECTED) {
	    		}
	    	}
	    	else if (source == Hearingaids) {
	    		if (select == ItemEvent.SELECTED) {
	    		}
	    	}	
	    }	
	}

	// This is the actionperformed method to execute the button's action when selected 
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		// If user selects the "Finish" button, babyHelpPanel appears 
		if(source == finish){
			CardLayout flyCardLayout = flyContainer.getCardLayout();
			flyCardLayout.show(flyContainer.getContentPane(),"babyHelpPanel");
			
			Service curService = flyContainer.getCurService();
			if (crutches.isSelected()) {
				curService.addDisableFacility("Crutches, Canes, and Walkers");
			}
			if (Braces.isSelected()) {
				curService.addDisableFacility("Braces/Prosthetics");
			}
			if (Wheelchairs.isSelected()) {
				curService.addDisableFacility("Wheelchairs");
			}
			if (Hearingaids.isSelected()) {
				curService.addDisableFacility("Hearing aids");
			} 
		}
		
		// If user selects the "Back More Service" button, serviceHomePanel appears 
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
  
	// Method to reset the information
   	public void reset() {
		crutches.setSelected(false);   
		Braces.setSelected(false);      
		Wheelchairs.setSelected(false); 
		Hearingaids.setSelected(false); 
	}
}
