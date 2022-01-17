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

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/*
 * This is the Home class
 */
public class Signup extends JPanel implements ActionListener{
	//Initialize the JPanel panelHome and panelButton
	private JPanel panelHome         = new JPanel();
	private JPanel panelSignup       = new JPanel();
    //Initialize the JLabel title
	private JLabel title             = new JLabel();
	private JLabel username          = new JLabel("     Username >>>");
	private JLabel password    		 = new JLabel("     Password >>>");
	private JLabel email           	 = new JLabel("     Email    >>>");
	private JTextField userText 	 = new JTextField("",20);
	private JTextField passText 	 = new JTextField("",20);
	private JTextField emailText 	 = new JTextField("",20);
	
	//Initialize the JButton 
	private JButton buttonSignup     = new JButton("Signup");
	private JButton buttonBack       = new JButton("Back");

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
	
	private DBManager dbmgr;
	
	private String passwordStr = "";
	
	CardLayout cardLayout = new CardLayout();
	//This is the constructor
	public Signup(Fly container, DBManager dbmgr) {
		//setting the Layout and Size
		flyContainer = container;
		
		this.dbmgr = dbmgr;
		
		setLayout(cardLayout);
		setSize(1000,800);
		//create the title and set the font and background
		title = new JLabel("        Yalla Zou Tara Travels Login ");
	    title.setFont(new Font("PilGi", Font.BOLD, 40));
	    setJLableBackGround(title, Color.BLACK,new Color(135,206,250));
	    
	    //setting the Button's font 
	    buttonBack.setFont(new Font("Arial", Font.BOLD, 25));
	    buttonBack.setToolTipText("返回\n"+ " بازگشت");
	    buttonSignup.setFont(new Font("Arial", Font.BOLD, 25));
	    buttonSignup.setToolTipText("注册\n"+ "ثبت نام");
	    

	    username.setFont(new Font("Arial", Font.BOLD, 25));
	    username.setToolTipText("用户名\n"+ "نام کاربری");
	    
	    password.setFont(new Font("Arial", Font.BOLD, 25));
	    password.setToolTipText("密码\n" + "کلمه عبور");
	    
	    email.setFont(new Font("Arial", Font.BOLD, 25));
	    email.setToolTipText("电子邮箱\n" + "پست الکترونیک");
	    
	    setJLableBackGround(username, Color.BLACK,new Color(176,224,230));
	    setJLableBackGround(password, Color.BLACK,new Color(95,158,160));
	    setJLableBackGround(email, Color.BLACK,new Color(32,178,170));

        //settong the Button's background color
	    setJButtonBackGround(buttonBack, Color.BLACK,Color.YELLOW);
	    setJButtonBackGround(buttonSignup, Color.BLACK,Color.PINK);

	    //Creating the ImageIcon and fixed it size
        Picture = new ImageIcon("resources/Images/HomeImagenorth.png");
		Img = Picture.getImage().getScaledInstance(900, 300, java.awt.Image.SCALE_SMOOTH);
		image.setIcon(new ImageIcon(Img));
		//Creating the ImageIcon and fixed it size
		Picture2 = new ImageIcon("resources/Images/HomeImageSorth.png");
		Img2 = Picture2.getImage().getScaledInstance(900, 300, java.awt.Image.SCALE_SMOOTH);
		image2.setIcon(new ImageIcon(Img2));
		//setting the button's layout and adding it
		panelSignup.setLayout(new GridLayout(4, 2));
		panelSignup.add(username);
		panelSignup.add(userText);
		panelSignup.add(password);
		panelSignup.add(passText);
		panelSignup.add(email);
		panelSignup.add(emailText);
		panelSignup.add(buttonBack);
		panelSignup.add(buttonSignup);
		//setting the panelHome's layout and adding it
		panelHome.setLayout(new GridLayout(4, 1));
		panelHome.add(image);
		panelHome.add(title); 
		panelHome.add(panelSignup);
		panelHome.add(image2);
		add(panelHome,"Panel1");
		//Adding the button's action
		buttonBack.addActionListener(this);
		buttonSignup.addActionListener(this);
		
	    KeyListener keyListener = new KeyListener() {
	        public void keyPressed(KeyEvent keyEvent) {}

	        public void keyReleased(KeyEvent keyEvent) {
	        	char key = keyEvent.getKeyChar();
	        	if (Character.isAlphabetic(key) || Character.isDigit(key)) {
		            JTextField textField = (JTextField) keyEvent.getSource();
		            String text = textField.getText();
		            if (text.length() == 1) {
		            	passwordStr = "";
		            }
		            
		            passwordStr += text.substring(text.length() - 1);
		            String newText = text.substring(0, text.length() - 1) + "*";
		            textField.setText(newText);	
	        	}
		    }

	        public void keyTyped(KeyEvent keyEvent) {}
	      };
	      
	      passText.addKeyListener(keyListener);
	
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
		if(source == buttonBack){
			CardLayout flyCardLayout = flyContainer.getCardLayout();
			flyCardLayout.show(flyContainer.getContentPane(), "LoginPanel");
		}else if(source == buttonSignup){
			String username = userText.getText();
			String password = passwordStr;
			String email    = emailText.getText();
			
			if (! validateUsername(username) || ! validatePassword(password) || ! validateEmail(email)) {
				return;
			}
			
			if (dbmgr.insertUserEntryToDB(username, password, email)) {
				int clicked = JOptionPane.showOptionDialog(null, "Sign up succeed! Now navigate to log in.", "Congratulations!", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

				if(clicked == JOptionPane.OK_OPTION)
				{
					CardLayout flyCardLayout = flyContainer.getCardLayout();
					flyCardLayout.show(flyContainer.getContentPane(), "LoginPanel");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Sorry, sign up failed, please try again.");
			}
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
  
	private boolean validateUsername(String username) {
		boolean result = false;
		if (username != null && username.length() > 0) {
			result = true;
		} else {
			JOptionPane.showMessageDialog(null, "Username could not be empty, please enter a username!");
		}
		
		return result;
	}
	
	private boolean validatePassword(String password) {
		boolean result = false;
		if (password != null && password.length() > 0) {
			result = true;
		} else {
			JOptionPane.showMessageDialog(null, "Password could not be empty, please enter a password!");
		}
		
		return result;
	}
	
	private boolean validateEmail(String email) {
		boolean result = false;
		if (email != null && email.length() > 0) {
			result = true;
		} else {
			JOptionPane.showMessageDialog(null, "Email could not be empty, please enter an email!");
		}
		
		return result;
	}

}
