/*
 * This the Class of main JPanel Home
 * Home calss extends JPanel
 * This class include the four subhome Button
 * and it can go one of the other sub four home class
 * by click button
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
/*
 * This is the Home class
 */
public class Home extends JPanel implements ActionListener{
	//Initialize the JPanel panelHome and panelButton
	private JPanel panelHome         = new JPanel();
	private JPanel panelButton       = new JPanel();
    //Initialize the JLabel title
	private JLabel title             = new JLabel();
	//Initialize the JButton 
	private JButton buttonSelect     = new JButton("Book a Flight");
	//**
	//private JButton buttonInfomation = new JButton("Flight Information");
    //private JButton buttonSevice     = new JButton("More Services");
	
	private JButton buttonPersinal   = new JButton("Personal Information");
	//Initialize the JLabel for insert the image
	private JLabel image             = new JLabel(" ");
	private JLabel image2            = new JLabel(" ");
	//Initialize the ImageIcon and Image
    private ImageIcon Picture;
	private Image Img;
	private ImageIcon Picture2;
	private Image Img2;
	//Initialize the JFrame flyContainer is the Fly
	private Fly flyContainer;
	
	CardLayout cardLayout = new CardLayout();
	//This is the constructor
	public Home(Fly container) {
		//setting the Layout and Size
		flyContainer = container;
		setLayout(cardLayout);
		setSize(1000,800);
		//create the title and set the font and background
		title = new JLabel("        Yalla Zou Tara Travels ");
	    title.setFont(new Font("PilGi", Font.BOLD, 40));
	    setJLableBackGround(title, Color.BLACK,new Color(135,206,250));
	    //setting the Button's font 
	    buttonSelect.setFont(new Font("Arial", Font.BOLD, 25));
	    buttonSelect.setToolTipText("航班选择\n" + "پروازها");
//	    buttonInfomation.setFont(new Font("Arial", Font.BOLD, 25));
//	    buttonSevice.setFont(new Font("Arial", Font.BOLD, 25));
	    buttonPersinal.setFont(new Font("Arial", Font.BOLD, 25));
	    buttonPersinal.setToolTipText("个人信息\n" + "اطلاعات شخصی");
	    
        //settong the Button's background color
	    setJButtonBackGround(buttonSelect, Color.BLACK,Color.YELLOW);
//	    setJButtonBackGround(buttonInfomation, Color.BLACK,Color.PINK);
//	    setJButtonBackGround(buttonSevice, Color.BLACK,new Color(50,205,50));
	    setJButtonBackGround(buttonPersinal, Color.BLACK,new Color(32,178,170));
	    //Creating the ImageIcon and fixed it size
        Picture = new ImageIcon("resources/Images/HomeImagenorth.png");
		Img = Picture.getImage().getScaledInstance(900, 300, java.awt.Image.SCALE_SMOOTH);
		image.setIcon(new ImageIcon(Img));
		//Creating the ImageIcon and fixed it size
		Picture2 = new ImageIcon("resources/Images/HomeImageSorth.png");
		Img2 = Picture2.getImage().getScaledInstance(900, 300, java.awt.Image.SCALE_SMOOTH);
		image2.setIcon(new ImageIcon(Img2));
		//setting the button's layout and adding it
		panelButton.setLayout(new GridLayout(1, 2));
		panelButton.add(buttonSelect);
//		panelButton.add(buttonInfomation);
//		panelButton.add(buttonSevice);
		panelButton.add(buttonPersinal);
		//setting the panelHome's layout and adding it
		panelHome.setLayout(new GridLayout(4, 1));
		panelHome.add(image);
		panelHome.add(title); 
		panelHome.add(panelButton);
		panelHome.add(image2);
		add(panelHome,"Panel1");
		//Adding the button's action
		buttonSelect.addActionListener(this);
//		buttonInfomation.addActionListener(this);
//		buttonSevice.addActionListener(this);
		buttonPersinal.addActionListener(this);
	
	}
	/*
	 * This is the actionperformed to execute the button's action 
	 * if click the buttonSelect go to the Select HomePanel
	 * if click the buttonInfomation go to the Infomation HomePanel
	 * if click the buttonSevice go to the Sevice HomePanel
	 * if click the buttonPersinal go to the Persinal HomePanel
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == buttonSelect){
			CardLayout flyCardLayout = flyContainer.getCardLayout();
			flyCardLayout.show(flyContainer.getContentPane(), "SelectButtonsHomePanel");
//		}else if(source == buttonInfomation){
//			CardLayout flyCardLayout = flyContainer.getCardLayout();
//			flyCardLayout.show(flyContainer.getContentPane(),"informationHomePanel");
//		}else if(source == buttonSevice) {
//			CardLayout flyCardLayout = flyContainer.getCardLayout();
//			flyCardLayout.show(flyContainer.getContentPane(), "seviceHomePanel");
		}else if(source == buttonPersinal) {
			CardLayout flyCardLayout = flyContainer.getCardLayout();
			flyCardLayout.show(flyContainer.getContentPane(),"personiallyInfoHomePanel");
		}
	}
	/*
	 * This is the method to set the JButton Background 
	 */
   public void setJButtonBackGround(JButton b, Color FC,Color BC) {
		
		b.setForeground(FC);       
		b.setBackground(BC);       
		b.setOpaque(true);               
		b.setBorderPainted(false);        
	}
   /*
	 * This is the method to set the JLabel Background 
	 */
   public void setJLableBackGround(JLabel l, Color FC,Color BC) {
		l.setOpaque(true);  
		l.setBackground(BC);
		l.setForeground(FC);
		
	}
  
	

}
