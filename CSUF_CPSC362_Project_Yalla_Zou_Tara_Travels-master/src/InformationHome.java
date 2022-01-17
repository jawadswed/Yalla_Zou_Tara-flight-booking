/*
 * This is the class of the information homeJPanel 
 * this class sets the buttons users can choose from.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// This is the class of the JPanel "InformationHome". It implements ActionListener
public class InformationHome extends JPanel implements ActionListener{
	
	// Initializing all of the JLabels, JButtons, JPanels, 
	// ImageIcons and Images
	private JLabel label1 = new JLabel("             Please Select One. ");
	
	private JButton luggage    = new JButton("Luggage");
	private JButton wheather   = new JButton("Weather");
	private JButton  seat      = new JButton("Select Seat");
	private JButton backHome   = new JButton("<<--Back Service");
	
	JLabel image  = new JLabel(" ");
	JLabel image2 = new JLabel(" ");
	JLabel image3 = new JLabel(" ");
	
	JPanel main   = new JPanel();
	JPanel panelC = new JPanel();
	JPanel panelN = new JPanel();
	JPanel panelW = new JPanel();
	JPanel panelS = new JPanel();
	
	private ImageIcon Picture;
	private Image Img;
	private ImageIcon Picture2;
	private Image Img2;
	private ImageIcon Picture3;
	private Image Img3;
	
	// Making a container of type "Fly"
	private Fly flyContainer;
	
	/*
	 * This is the constructor of this class.
	 * The consturctor sets all of the JLabels, JButtons, 
	 * JPanels, ImageIcons, font, backgound, size and layout 
	 */
	public InformationHome(Fly container) {
		
		flyContainer = container;
		setSize(800,800);
		setLayout(new BorderLayout());
		
		 label1.setFont(new Font("Arial", Font.BOLD, 25));
		
		 setJLableBackGround(label1, Color.BLACK,new Color(135,206,250));
		 setJButtonBackGround(luggage, Color.BLACK,new Color(135,206,250));
		 setJButtonBackGround(seat, Color.BLACK,new Color(135,206,250));	
		 setJButtonBackGround(wheather, Color.BLACK,new Color(135,206,250));
		 setJButtonBackGround(backHome, Color.BLACK,new Color(135,206,250));
		
		Picture = new ImageIcon("resources/Images/subtitle.png");
		Img = Picture.getImage().getScaledInstance(900, 250, java.awt.Image.SCALE_SMOOTH);
		image.setIcon(new ImageIcon(Img));
		
		Picture2 = new ImageIcon("resources/Images/infoImageSorth.png");
		Img2 = Picture2.getImage().getScaledInstance(900, 150, java.awt.Image.SCALE_SMOOTH);
		image2.setIcon(new ImageIcon(Img2));
		
		Picture3 = new ImageIcon("resources/Images/selectImageWest.png");
		Img3 = Picture3.getImage().getScaledInstance(300, 400, java.awt.Image.SCALE_SMOOTH);
		image3.setIcon(new ImageIcon(Img3));
		
		panelW.setBackground(new Color(135,206,250));
		main.setLayout(new BorderLayout());
		panelN.add(image);
		panelS.add(image2);
		panelW.add(image3);
		
		panelC.setLayout(new GridLayout(5, 1));
		panelC.add(label1);
		panelC.add(luggage);
		panelC.add(wheather);
		panelC.add(seat);
		panelC.add(backHome);
		
		main.add(panelN, BorderLayout.NORTH);
		main.add(panelS, BorderLayout.SOUTH);
		main.add(panelW, BorderLayout.WEST);
		main.add(panelC, BorderLayout.CENTER);
		
		add(main);
		
		luggage.addActionListener(this);
		wheather.addActionListener(this);
		seat.addActionListener(this);
		backHome.addActionListener(this);
	}
	
	// This is the actionperformed method to execute the button's action when selected 
	@Override
	public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
		// If user selects the "luggage" button, "LuggagePanel" appears
		if(source == luggage){
			CardLayout flyCardLayout = flyContainer.getCardLayout();
			flyCardLayout.show(flyContainer.getContentPane(),"LuggagePanel");
		}

		// If user selects the "weather" button. "weatherPanel" appears
		else if(source == wheather){
			CardLayout flyCardLayout = flyContainer.getCardLayout();
			flyCardLayout.show(flyContainer.getContentPane(), "wheatherPanel");
		}
		
		// If user selects the "seat" button, "seatPanel" appears
		else if(source == seat) {
			CardLayout flyCardLayout = flyContainer.getCardLayout();
			flyCardLayout.show(flyContainer.getContentPane(),"seatPanel");
		}
		
		// If user selects the "backHome" button, "HomePanel" appears
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
