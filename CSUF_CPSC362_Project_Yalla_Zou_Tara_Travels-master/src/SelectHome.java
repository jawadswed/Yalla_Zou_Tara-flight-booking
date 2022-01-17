/*
 * This is the class of the select homeJPanel 
 * this class set the some choice button
 * let the user can choice any of them to go to 
 * subJpanle of the select JPanle
 * and can enter or select what thing they want 
 * booking or to see or want to choice.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//This is the class of the JPanel SelectHome and implements ActionListener
public class SelectHome extends JPanel implements ActionListener{
	//Initialize the Jlabel
	private JLabel label1 = new JLabel("             Please choice one. ");
	//Initialize the JButton
	private JButton oneWay        = new JButton("OneWay-Trip");
	
	private JButton change        = new JButton("Change-Trip");
	private JButton onlineRefound = new JButton("Refund-Trip");
	private JButton backHome      = new JButton("<<--Back Service");
	//Initialize the JLabel
	private JLabel image = new JLabel(" ");
	private JLabel image2 = new JLabel(" ");
	private JLabel image3 = new JLabel(" ");
	//Initialize the JPanel
	private JPanel main = new JPanel();
	private JPanel panelC = new JPanel();
	private JPanel panelN = new JPanel();
	private JPanel panelW = new JPanel();
	private JPanel panelS = new JPanel();
	//Initialize the Image and Image
    private ImageIcon Picture;
	private Image Img;
	private ImageIcon Picture2;
	private Image Img2;
	private ImageIcon Picture3;
	private Image Img3;
	
	private Fly flyContainer;
	//constructor SeviceHome
	public SelectHome(Fly container) {
		flyContainer = container;
		setSize(800,800);
		setLayout(new BorderLayout());
		//setting the label1 font
		 label1.setFont(new Font("Arial", Font.BOLD, 25));
		 
		 oneWay.setToolTipText("单程票"+ " یک طرفه");
		 change.setToolTipText("改签"+ "پرواز را تغییر دهید");
		 onlineRefound.setToolTipText("退票" + "بازپرداخت");
		 backHome .setToolTipText("返回"+"بازگشت");

		//setting the JButton's and JLabel's background
		 setJLableBackGround(label1, Color.BLACK,new Color(135,206,250));
		 setJButtonBackGround(oneWay, Color.BLACK,new Color(135,206,250));
		 
		 setJButtonBackGround(change, Color.BLACK,new Color(135,206,250));
		 setJButtonBackGround(onlineRefound, Color.BLACK,new Color(135,206,250));
		 setJButtonBackGround(backHome, Color.BLACK,new Color(135,206,250));
		//setting the the picture fxed the size  adding the Icon to each picture
		Picture = new ImageIcon("resources/Images/subtitle.png");
		Img = Picture.getImage().getScaledInstance(900, 250, java.awt.Image.SCALE_SMOOTH);
		image.setIcon(new ImageIcon(Img));
		
		Picture2 = new ImageIcon("resources/Images/selectImageSorth.png");
		Img2 = Picture2.getImage().getScaledInstance(900, 150, java.awt.Image.SCALE_SMOOTH);
		image2.setIcon(new ImageIcon(Img2));
		
		Picture3 = new ImageIcon("resources/Images/selectImageWest.png");
		Img3 = Picture3.getImage().getScaledInstance(300, 400, java.awt.Image.SCALE_SMOOTH);
		image3.setIcon(new ImageIcon(Img3));
		/*
		* setting the subPanel's layout and adding the button label to each one
		* setting the PanelW/panelN/PanelS/PanelC
		* and adding all of the button and label to dfferent part
		*/
		panelW.setBackground(new Color(135,206,250));
		main.setLayout(new BorderLayout());
		panelN.add(image);
		panelS.add(image2);
		panelW.add(image3);
		
		panelC.setLayout(new GridLayout(5, 1));
		panelC.add(label1);
		panelC.add(oneWay);
		//panelC.add(roundTrip);
		panelC.add(change);
		panelC.add(onlineRefound);
		panelC.add(backHome);
		
		main.add(panelN, BorderLayout.NORTH);
		main.add(panelS, BorderLayout.SOUTH);
		main.add(panelW, BorderLayout.WEST);
		main.add(panelC, BorderLayout.CENTER);
		
		add(main);
		//Adding the action listenner for each button
		oneWay.addActionListener(this);
		//roundTrip.addActionListener(this);
		change.addActionListener(this);
		onlineRefound.addActionListener(this);
		backHome.addActionListener(this);
		
		
	}
	/*
	 * This is the actionperformed to execute the button's action 
	 * if the user click the different buttonSelect go to the  different Select subPanel
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source == oneWay){
			CardLayout flyCardLayout = flyContainer.getCardLayout();
			flyCardLayout.show(flyContainer.getContentPane(), "oneWayPanel");
//		}else if(source == roundTrip){
//			CardLayout flyCardLayout = flyContainer.getCardLayout();
//			flyCardLayout.show(flyContainer.getContentPane(), "roundWayPanel");
//		}
		}else if(source == change) {
			CardLayout flyCardLayout = flyContainer.getCardLayout();
			flyCardLayout.show(flyContainer.getContentPane(),"ChangeTripPanel");
		}else if(source == onlineRefound) {
			CardLayout flyCardLayout = flyContainer.getCardLayout();
			flyCardLayout.show(flyContainer.getContentPane(),"RefoundTripPanel");
		}else if(source == backHome) {
			CardLayout flyCardLayout = flyContainer.getCardLayout();
			flyCardLayout.show(flyContainer.getContentPane(), "HomePanel");
			//reset the information
			flyContainer.reset();
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


