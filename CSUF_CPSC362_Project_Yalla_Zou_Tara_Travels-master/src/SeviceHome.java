/*
 * This is the class of the Service Home JPanel. 
 * It allows the user to navigate the Service Home and 
 * select different services to customize their flight details 
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//This is the class of the JPanel ServiceHome. It implements ActionListener
public class SeviceHome extends JPanel implements ActionListener{
	
	// Initializing all of the JLabels, JButtons, JPanels 
	// Imaages and ImageIcons
	private JLabel label1 = new JLabel("             Special assistance. ");
	
	private JButton disableHelp     = new JButton("Disability Support");
	private JButton seviceBaby      = new JButton("Services for Baby/child");
	private JButton seviceFood      = new JButton("Meal Plan");
	private JButton backHome        = new JButton("<<--Back Service");
	
	private JLabel image = new JLabel(" ");
	private JLabel image2 = new JLabel(" ");
	private JLabel image3 = new JLabel(" ");
	
	private JPanel main = new JPanel();
	private JPanel panelC = new JPanel();
	private JPanel panelN = new JPanel();
	private JPanel panelW = new JPanel();
	private JPanel panelS = new JPanel();
	
	private ImageIcon Picture;
	private Image Img;
	private ImageIcon Picture2;
	private Image Img2;
	private ImageIcon Picture3;
	private Image Img3;
	
	// Making a container of type Fly
	private Fly flyContainer;
	
	/*
	 * This is the constructor of this class.
	 * The constructor sets all of the JLabels,JButtons,
	 * ImageIcons, JPanels, font, backgound, size and layout 
	 */
	public SeviceHome(Fly container) {
		flyContainer = container;
		setSize(800,800);
		setLayout(new BorderLayout());
		
		 label1.setFont(new Font("Arial", Font.BOLD, 25));
		
		 setJLableBackGround(label1, Color.BLACK,new Color(230,230,250));
		 setJButtonBackGround(disableHelp, Color.BLACK,new Color(230,230,250));
		 setJButtonBackGround(seviceBaby, Color.BLACK,new Color(230,230,250));
		 setJButtonBackGround(seviceFood, Color.BLACK,new Color(230,230,250));
		 setJButtonBackGround(backHome, Color.BLACK,new Color(230,230,250));
		
		Picture = new ImageIcon("resources/Images/subtitle.png");
		Img = Picture.getImage().getScaledInstance(900, 250, java.awt.Image.SCALE_SMOOTH);
		image.setIcon(new ImageIcon(Img));
		
		Picture2 = new ImageIcon("resources/Images/ServiceImageSorth.png");
		Img2 = Picture2.getImage().getScaledInstance(900, 150, java.awt.Image.SCALE_SMOOTH);
		image2.setIcon(new ImageIcon(Img2));
		
		Picture3 = new ImageIcon("resources/Images/selectImageWest.png");
		Img3 = Picture3.getImage().getScaledInstance(300, 400, java.awt.Image.SCALE_SMOOTH);
		image3.setIcon(new ImageIcon(Img3));
	
		panelW.setBackground(new Color(230,230,250));
		main.setLayout(new BorderLayout());
		panelN.add(image);
		panelS.add(image2);
		panelW.add(image3);
		
		panelC.setLayout(new GridLayout(5, 1));
		panelC.add(label1);
		panelC.add(disableHelp);
		panelC.add(seviceBaby);
		panelC.add(seviceFood);
		panelC.add(backHome);
		
		main.add(panelN, BorderLayout.NORTH);
		main.add(panelS, BorderLayout.SOUTH);
		main.add(panelW, BorderLayout.WEST);
		main.add(panelC, BorderLayout.CENTER);
		
		add(main);
	
		disableHelp.addActionListener(this);
		seviceBaby.addActionListener(this);
		seviceFood.addActionListener(this);
		backHome.addActionListener(this);
		
	}
	// This is the actionperformed method to execute the user's action 
	// when selecting a JButton 
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		// If the user selects the "Disable Help" Button, "disableHelpPanel" appears 
		if(source == disableHelp){
			CardLayout flyCardLayout = flyContainer.getCardLayout();
			flyCardLayout.show(flyContainer.getContentPane(),"disableHelpPanel");
		}
		
		// If the user selects the "Service Baby" button, "babyHelpPanel" appears
		else if(source == seviceBaby){
			CardLayout flyCardLayout = flyContainer.getCardLayout();
		        flyCardLayout.show(flyContainer.getContentPane(),"babyHelpPanel");
		}
		
		// If the user selects the "Service Food" button, "foodHelpPanel" appears
		else if(source == seviceFood) {
		        CardLayout flyCardLayout = flyContainer.getCardLayout();
			flyCardLayout.show(flyContainer.getContentPane(),"foodHelpPanel");
		}
		
		// If user selects the "Back Home" button, "HomePanel" appears 
		else if(source == backHome) {
			CardLayout flyCardLayout = flyContainer.getCardLayout();
			flyCardLayout.show(flyContainer.getContentPane(), "HomePanel");
			
			// Information resets
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
}
