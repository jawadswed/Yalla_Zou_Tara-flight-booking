/*
 * This is the JPanel that appears when the 
 * user selects the "Change" option from Select 
 * JMenuItem the JMenuBar
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//This is the class of the JPanel Change and implements ActionListener
public class Change extends JPanel implements ActionListener{
	
	//Initialize all of the JLable, JButton,JComboBox and JPanel
	private JLabel label1 = new JLabel("  Change Ticket ");
	private JLabel label2 = new JLabel("  Enter Name and date ");
		
	private JButton subMit                = new JButton(" < SubMit >");
	private JButton reEnter               = new JButton(" < ReEnter >");
	private JButton backSevice            = new JButton("<<--Back Information Home");
	private JButton backHome              = new JButton("<<--Back Home");
		
	private JTextField userEnter1;
	private JTextField userEnter2;
	private JTextField userEnter3;
	private JTextField userEnter4;
	private JTextField userEnter5;
	
	private JTextArea ChangeTextArea = new JTextArea("");
	
	private JLabel image  = new JLabel(" ");
	private JLabel image2 = new JLabel(" ");
		
	private JPanel main   = new JPanel();
	private JPanel panelC = new JPanel();
	private JPanel panelN = new JPanel();
	private JPanel panelW = new JPanel();
	private JPanel panelS = new JPanel();
	private JPanel panelEnter = new JPanel();
	private JPanel panelShow = new JPanel();
		
	//private CardLayout card = new CardLayout();
		
	private ImageIcon Picture;
	private Image Img;
	private ImageIcon Picture2;
	private Image Img2;
	
	// Making a container of type Fly
	private Fly flyContainer;
	
	/* 
	* This is the constructor of this class.
	* The consturctor sets all of the JLabels, JTextFields, JButtons, 
	* JPanels, ImageIcons, font, backgound, size and layout 
	*/
	public Change(Fly container) {
		flyContainer = container;
		setSize(800,800);
		setLayout(new BorderLayout());
			
		label1.setFont(new Font("Arial", Font.BOLD, 20));
		setJLableBackGround(label1, Color.BLACK,new Color(135,206,250));
		label2.setFont(new Font("Arial", Font.BOLD, 20));
		setJLableBackGround(label2, Color.BLACK,new Color(135,206,250));
			 
		ChangeTextArea.setFont(new Font("Arial", Font.PLAIN, 17));
		setJTextAreaBackGround(ChangeTextArea, Color.BLACK,new Color(135,206,250));
		 
		setJButtonBackGround(subMit, Color.BLACK,new Color(135,206,250));
		setJButtonBackGround(reEnter, Color.BLACK,new Color(135,206,250));
		setJButtonBackGround(backSevice, Color.BLACK,new Color(135,206,250));
		setJButtonBackGround(backHome, Color.BLACK,new Color(135,206,250));
			 
		userEnter1= new JTextField("Please enter your name",12);
		userEnter5= new JTextField("Please enter your tiket number",12);
		userEnter2= new JTextField("Please enter the month",12);
		userEnter3= new JTextField("Please enter the day",12);
		userEnter4= new JTextField("Please enter the year",12);
			 
		Picture = new ImageIcon("resources/Images/subtitle.png");
		Img = Picture.getImage().getScaledInstance(900, 250, java.awt.Image.SCALE_SMOOTH);
		image.setIcon(new ImageIcon(Img));
			
		Picture2 = new ImageIcon("resources/Images/selectImageSorth.png");
		Img2 = Picture2.getImage().getScaledInstance(900, 150, java.awt.Image.SCALE_SMOOTH);
		image2.setIcon(new ImageIcon(Img2));
			
		userEnter1.setVisible(true);
		userEnter2.setVisible(true);
		userEnter3.setVisible(true);
		userEnter4.setVisible(true);
			
		panelW.setBackground(new Color(135,206,250));
		main.setLayout(new BorderLayout());
		panelN.add(image);
		panelS.add(image2);
			
		panelEnter.setBackground(new Color(135,206,250));
		panelEnter.setLayout(new GridLayout(6,1));
		panelEnter.add(label2);
		panelEnter.add(userEnter1);
		panelEnter.add(userEnter5);
		panelEnter.add(userEnter2);
		panelEnter.add(userEnter3);
		panelEnter.add(userEnter4);
			
		panelShow.setBackground(new Color(135,206,250));
		panelShow.add(ChangeTextArea,BorderLayout.CENTER);
		
		panelC.setBackground(new Color(135,206,250));
		panelC.add(panelEnter,BorderLayout.CENTER);
		panelC.add(panelShow,BorderLayout.CENTER);
		
		panelW.setLayout(new GridLayout(5, 1));
		panelW.add(label1);
		panelW.add(subMit);
		panelW.add(reEnter);
		panelW.add(backSevice);
		panelW.add(backHome);
			
		main.add(panelN, BorderLayout.NORTH);
		main.add(panelS, BorderLayout.SOUTH);
		main.add(panelW, BorderLayout.WEST);
		main.add(panelC, BorderLayout.CENTER);
		
		add(main);
		
		subMit.addActionListener(this);
		reEnter.addActionListener(this);
		backHome.addActionListener(this);
		backSevice.addActionListener(this);
	}
	
	// This is the actionperformed method to execute a button's action when selected 
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		// If user selects the "Submit" button, a message appears fpr successful 
		// cancelation of the user's flight ticket
		if(source == subMit){
			userEnter1.setVisible(false);
			userEnter2.setVisible(false);
			userEnter3.setVisible(false);
			userEnter4.setVisible(false);
			userEnter5.setVisible(false);
			ChangeTextArea.setVisible(true);
			ChangeTextArea.setText("On "+ userEnter2.getText()+ " - " +userEnter3.getText()+" - "+
					       userEnter4.getText()+"\n"+ "The "+ userEnter1.getText() + "\n"+
					       "Thanks you choice Holiday Air Company\n"+
					       "Your tickit cancel successful.\n"+
					       "Hope you will choice our Company next time.\n"+
					       "Have a nice day. =^.^= ");
		}
		
		// If user selects "Re enter" button, then the JTextFields are set to visible
		else if(source == reEnter) {
			ChangeTextArea.setVisible(false);
			userEnter1.setVisible(true);
			userEnter2.setVisible(true);
			userEnter3.setVisible(true);
			userEnter4.setVisible(true);
			userEnter5.setVisible(true);			
		}
		
		// If user selects "Back Service" button, "SelectButtonsHomePanel" appears 
		else if(source == backSevice) {		
			CardLayout flyCardLayout = flyContainer.getCardLayout();
			flyCardLayout.show(flyContainer.getContentPane(),"SelectButtonsHomePanel");
		}
		
		// If user selects "Back Home" button, "HomePanel" appears
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
	
	// Method to set JTextArea background 
	public void setJTextAreaBackGround(JTextArea t, Color FC,Color BC) {
		t.setOpaque(true);  
		t.setBackground(BC);
		t.setForeground(FC);	
	}
	
	// Method to reset the JTextFields
	public void reset() {
		userEnter1.setText("Please enter your name"); 
		userEnter5.setText("Please enter your tiket number");
		userEnter2.setText("Please enter the month");
		userEnter3.setText("Please enter the day");
		userEnter4.setText("Please enter the year");
	}
}
