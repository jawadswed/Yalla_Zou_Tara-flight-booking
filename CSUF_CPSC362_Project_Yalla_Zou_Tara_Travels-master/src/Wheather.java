/*
 * This the sub JPanel for the JPanel weahter
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//This is the class of the JPanel Weather and implements ActionListener
public class Wheather extends JPanel implements ActionListener{
		//Initialize all of the JLable, JButton,JComboBox and JPanel
	    JLabel label1 = new JLabel("  The Weather Information ");
	    JLabel label2 = new JLabel("  Enter City and Date agina ");
		
		
		JButton wheather              = new JButton(" Getting the Weather");
		JButton enterWheather         = new JButton(" Enter the city again");
		JButton shareWithEmail          = new JButton("<< Share to my email >>");
		JButton backSevice            = new JButton("<<--Back Information Home");
		JButton backHome              = new JButton("<<--Back Home");
		
		JTextField userEnter1;
		JTextField userEnter2;
		JTextField userEnter3;
		JTextField userEnter4;
		
		JTextArea weatherTextArea = new JTextArea("");
		
		
		JLabel image  = new JLabel(" ");
		JLabel image2 = new JLabel(" ");
		
		
		JPanel main   = new JPanel();
		JPanel panelC = new JPanel();
		JPanel panelN = new JPanel();
		JPanel panelW = new JPanel();
		JPanel panelS = new JPanel();
		JPanel panelEnter = new JPanel();
		JPanel panelShow = new JPanel();
		
		//private CardLayout card = new CardLayout();
		
	    private ImageIcon Picture;
		private Image Img;
		private ImageIcon Picture2;
		private Image Img2;
		
		
		private Fly flyContainer;
		private DBManager dbManager;
		
		private String destCity;
		
		/*
		 * This is the constructor  of this class
		 *this consturctor setting the all of the JLabel's
		 *JButton's, JPanel's font,backgound, size and layout 
		 */
		public Wheather(Fly container, DBManager dbmgr) {
			
			flyContainer = container;
			dbManager    = dbmgr;
			destCity     = "";
			
			setSize(800,800);
			setLayout(new BorderLayout());
			
			 label1.setFont(new Font("Arial", Font.BOLD, 25));
			 setJLableBackGround(label1, Color.BLACK,new Color(135,206,250));
			 label2.setFont(new Font("Arial", Font.BOLD, 25));
			 setJLableBackGround(label1, Color.BLACK,new Color(135,206,250));
			 
			 weatherTextArea.setFont(new Font("Arial", Font.PLAIN, 17));
			 setJTextAreaBackGround(weatherTextArea, Color.BLACK,new Color(135,206,250));
			 
			 setJButtonBackGround(wheather, Color.BLACK,new Color(135,206,250));
			 setJButtonBackGround(enterWheather, Color.BLACK,new Color(135,206,250));
			 setJButtonBackGround(shareWithEmail, Color.BLACK,new Color(135,206,250));
			 setJButtonBackGround(backSevice, Color.BLACK,new Color(135,206,250));
			 setJButtonBackGround(backHome, Color.BLACK,new Color(135,206,250));
			 
			userEnter1= new JTextField("Please enter the City/Airport",12);
		 	userEnter2= new JTextField("Please enter the month",12);
		 	userEnter3= new JTextField("Please enter the day",12);
		 	userEnter4= new JTextField("Please enter the year",12);
			 
		 	Picture = new ImageIcon("resources/Images/titleImage.png");
			Img = Picture.getImage().getScaledInstance(900, 250, java.awt.Image.SCALE_SMOOTH);
			image.setIcon(new ImageIcon(Img));
			
			Picture2 = new ImageIcon("resources/Images/infoImageSorth.png");
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
			panelEnter.setLayout(new GridLayout(5,1));
			panelEnter.add(label2);
			panelEnter.add(userEnter1);
			panelEnter.add(userEnter2);
			panelEnter.add(userEnter3);
			panelEnter.add(userEnter4);
			
			panelShow.setBackground(new Color(135,206,250));
			panelShow.add(weatherTextArea,BorderLayout.CENTER);
			
			panelC.setBackground(new Color(135,206,250));
			panelC.add(panelEnter,BorderLayout.CENTER);
			panelC.add(panelShow,BorderLayout.CENTER);
			
			
			
			
			panelW.setLayout(new GridLayout(6, 1));
			panelW.add(label1);
			panelW.add(enterWheather);
			panelW.add(wheather);
			panelW.add(shareWithEmail);
			panelW.add(backSevice);
			panelW.add(backHome);
			
			main.add(panelN, BorderLayout.NORTH);
			main.add(panelS, BorderLayout.SOUTH);
			main.add(panelW, BorderLayout.WEST);
			main.add(panelC, BorderLayout.CENTER);
			
			add(main);
			
			
			wheather.addActionListener(this);
			enterWheather.addActionListener(this);
			backHome.addActionListener(this);
			backSevice.addActionListener(this);
			
		}
		/*
		 * This is the actionperformed to execute the button's action 
		 * if the user click the different buttonSelect go to the  different Selectaction
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
	        Object source = e.getSource();
			
			if(source == wheather){
				this.destCity = userEnter1.getText();
				userEnter1.setVisible(false);
				userEnter2.setVisible(false);
				userEnter3.setVisible(false);
				userEnter4.setVisible(false);
				enterWheather.setVisible(false);
				weatherTextArea.setVisible(true);

				String dest = "";
				if (!this.destCity.equals("Please enter the City/Airport")) {
					dest = this.destCity;
				} else {
					dest = dbManager.queryCityNameFromAirportCode(flyContainer.getCurTicket().getArriveAirport());	
				}
				String weatherInfo = WeatherRequestAPI.getCityWeatherInfo(dest);
				weatherTextArea.setText(weatherInfo);
				
			}else if(source == enterWheather) {
				weatherTextArea.setVisible(false);
				userEnter1.setVisible(true);
				userEnter2.setVisible(true);
				userEnter3.setVisible(true);
				userEnter4.setVisible(true);
				enterWheather.setVisible(true);
			}else if(source == backSevice) {
				
				CardLayout flyCardLayout = flyContainer.getCardLayout();
				flyCardLayout.show(flyContainer.getContentPane(),"informationHomePanel");
				
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
	
		public void reset() {
			userEnter1.setText("Please enter the City/Airport");
		 	userEnter2.setText("Please enter the month");
		 	userEnter3.setText("Please enter the day");
		 	userEnter4.setText("Please enter the year");
		 	
			weatherTextArea.setVisible(false);
			userEnter1.setVisible(true);
			userEnter2.setVisible(true);
			userEnter3.setVisible(true);
			userEnter4.setVisible(true);
		}
}
