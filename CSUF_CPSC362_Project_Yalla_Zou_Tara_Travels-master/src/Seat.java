/*
 * This the sub JPanel for the JPanel select seat
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

//This is the class of the JPanel  Seat and implements ActionListener
public class Seat extends JPanel implements ActionListener, MouseListener{
	//Initialize all of the JLable, JButton,JComboBox and JPanel
		private JLabel label1 = new JLabel("  The Seat information ");
		
		private JButton firstBusinessClass        = new JButton("First Class/Business Class Seat");
		private JButton economyClass              = new JButton(" Economy Class Seat");
		private JButton next                      = new JButton("Next-->>");
		private JButton backSevice                = new JButton("<<--Back Sevice Home");
		private JButton backHome                  = new JButton("<<--Back Home");
		
		private JLabel image  = new JLabel(" ");
		private JLabel image2 = new JLabel(" ");
		private int ROW1 = 4, COL1 = 5;
		private int ROW2 = 10,COL2 = 7;
		private int SPACE = 2;
		
		private JPanel firstBoard   = new JPanel(new GridLayout(ROW1,COL1,SPACE,SPACE));
		private JPanel economyBoard = new JPanel(new GridLayout(ROW2,COL2,SPACE,SPACE));
		private JPanel firstCell[][] = new JPanel[ROW1][COL1];
		private JPanel ecomCell[][]  = new JPanel[ROW2][COL2];
		private boolean firstCellReserved[][] = new boolean[ROW1][COL1];
		private boolean econCellReserved[][] = new boolean[ROW2][COL2]; 
		
		
		private boolean isFirstBoardSelected = false;
		private boolean isEcomBoardSelected = false;
		
		private int curFirstCellSelectedRow = -1;
		private int curFirstCellSelectedCol = -1;
		
		private int curEcomCellSelectedRow = -1;
		private int curEcomCellSelectedCol = -1;
		
		private JPanel main   = new JPanel();
		private JPanel panelC = new JPanel();
		private JPanel panelN = new JPanel();
		private JPanel panelW = new JPanel();
		private JPanel panelS = new JPanel();
	
		CardLayout seatCardLayout = new CardLayout();
		
	    private ImageIcon Picture;
		private Image Img;
		private ImageIcon Picture2;
		private Image Img2;
		
		
		private Fly flyContainer;
		/*
		 * This is the constructor  of this class
		 *this consturctor setting the all of the JLabel's
		 *JButton's, JPanel's font,backgound, size and layout 
		 */
		public Seat(Fly container) {
			
			flyContainer = container;
			setSize(800,800);
			setLayout(new BorderLayout());
			
			 label1.setFont(new Font("Arial", Font.BOLD, 25));
			 setJLableBackGround(label1, Color.BLACK,new Color(135,206,250));
			 
			 setJButtonBackGround(firstBusinessClass, Color.BLACK,new Color(135,206,250));
			 firstBusinessClass.setToolTipText("商务舱" + "کلاس تجاری");
			 setJButtonBackGround(economyClass, Color.BLACK,new Color(135,206,250));
			 economyClass.setToolTipText("经济舱" + "کلاس اقتصاد");
			 
			 setJButtonBackGround(next, Color.BLACK,new Color(135,206,250));
			 next.setToolTipText("下一步" + "بعد");
			 setJButtonBackGround(backSevice, Color.BLACK,new Color(135,206,250));
			 backSevice.setToolTipText("返回 服务" + "خدمات برگشت");
			 setJButtonBackGround(backHome, Color.BLACK,new Color(135,206,250));
			 backHome.setToolTipText("返回主页" + "بازگشت");
			Picture = new ImageIcon("resources/Images/subtitle.png");
			Img = Picture.getImage().getScaledInstance(900, 250, java.awt.Image.SCALE_SMOOTH);
			image.setIcon(new ImageIcon(Img));
				
			Picture2 = new ImageIcon("resources/Images/infoImageSorth.png");
			Img2 = Picture2.getImage().getScaledInstance(900, 150, java.awt.Image.SCALE_SMOOTH);
			image2.setIcon(new ImageIcon(Img2));
			
			for(int i = 0; i < ROW1 ; i++) {
				for(int j = 0; j <COL1; j++) {
					firstCell[i][j] = new JPanel();
					if(j== 2) {
						firstCell[i][j].setBackground(new Color(105,105,105));
					}else {
						firstCell[i][j].setBackground(new Color(127,255,0));
					}
					firstBoard.add(firstCell[i][j]);
					firstCell[i][j].addMouseListener(this);
				}
			}
			
			for(int i = 0; i < ROW2 ; i++) {
				for(int j = 0; j <COL2; j++) {
					ecomCell[i][j] = new JPanel();
					if(j== 3) {
						ecomCell[i][j].setBackground(new Color(105,105,105));
					}else {
						ecomCell[i][j].setBackground(new Color(127,255,0));
					}
					economyBoard.add(ecomCell[i][j]);
					ecomCell[i][j].addMouseListener(this);
				}
			}
			
			
			panelW.setBackground(new Color(135,206,250));
			main.setLayout(new BorderLayout());
			panelN.add(image);
			panelS.add(image2);
			
			firstBoard.setVisible(false);
			economyBoard.setVisible(false);
			
			panelC.setLayout(seatCardLayout);
			panelC.setBackground(new Color(135,206,250));
			panelC.add(firstBoard, "firstClassBoard");
			panelC.add(economyBoard, "economyClassBoard");
			
			panelW.setLayout(new GridLayout(6, 1));
			panelW.add(label1);
			panelW.add(firstBusinessClass);
			panelW.add(economyClass);
			panelW.add(next);
			panelW.add(backSevice);
			panelW.add(backHome);
			
			main.add(panelN, BorderLayout.NORTH);
			main.add(panelS, BorderLayout.SOUTH);
			main.add(panelW, BorderLayout.WEST);
			main.add(panelC, BorderLayout.CENTER);
			
			add(main);
			next.addActionListener(this);
			firstBusinessClass.addActionListener(this);
			economyClass.addActionListener(this);
			backHome.addActionListener(this);
			backSevice.addActionListener(this);
			
		}
		/*
		 * This is the actionperformed to execute the button's action 
		 * if the user click the different buttonSelect go to the  different Select action
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
	        Object source = e.getSource();
			
			if(source == firstBusinessClass){
				seatCardLayout.show(panelC, "firstClassBoard");
				
			}else if(source == economyClass){
				seatCardLayout.show(panelC, "economyClassBoard");
				
			}else if (source == next) {
				CardLayout flyCardLayout = flyContainer.getCardLayout();
				flyCardLayout.show(flyContainer.getContentPane(),"disableHelpPanel");
				Ticket curTicket = flyContainer.getCurTicket();
				if (isFirstBoardSelected) {
					curTicket.setSeatClass("First Class");
					curTicket.setSeatRow(String.valueOf(curFirstCellSelectedRow));
					curTicket.setSeatCol(String.valueOf(curFirstCellSelectedCol));
				} else {
					curTicket.setSeatClass("Economy Class");
					curTicket.setSeatRow(String.valueOf(curEcomCellSelectedRow));
					curTicket.setSeatCol(String.valueOf(curEcomCellSelectedCol));	
				}
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
	   /*
		 * This is the actionperformed to execute the mouse's action 
		 * if the user click the mouse  to choice the seat
		 */
	@Override
	public void mouseClicked(MouseEvent e) {
		for(int i = 0; i < ROW1 ; i++) {
			for(int j = 0; j <COL1; j++) {
				if (j == 2) continue;
				
				if (e.getSource() == firstCell[i][j] && !isFirstReserved(i, j)) {
					//reset cell color in ecom board
					if (isEcomBoardSelected) {
						isEcomBoardSelected = false;
						ecomCell[curEcomCellSelectedRow][curEcomCellSelectedCol].setBackground(new Color(127,255,0));
						curEcomCellSelectedRow = -1;
						curEcomCellSelectedCol = -1;
						
					}
					//reset color for previous selected first board cell
					if (curFirstCellSelectedRow != -1 && curFirstCellSelectedCol !=-1 && (curFirstCellSelectedRow != i || curFirstCellSelectedCol !=j)) { 
						firstCell[curFirstCellSelectedRow][curFirstCellSelectedCol].setBackground(new Color(127,255,0));
					}
					
					//set current clicked cell color to red
					firstCell[i][j].setBackground(Color.RED);
					curFirstCellSelectedRow = i;
					curFirstCellSelectedCol = j;
					isFirstBoardSelected = true;
				}
			}
		}
		//Test choice the ecom class or not
		for(int i = 0; i < ROW2 ; i++) {
			for(int j = 0; j <COL2; j++) {
				if (j == 3) continue;
				
				if (e.getSource() == ecomCell[i][j] && !isEconReserved(i, j)) {
					//reset cell color in first board
					if (isFirstBoardSelected) {
						isFirstBoardSelected = false;
						firstCell[curFirstCellSelectedRow][curFirstCellSelectedCol].setBackground(new Color(127,255,0));
						curFirstCellSelectedRow = -1;
						curFirstCellSelectedCol = -1;
						
					}
					//reset color for previous selected ecom board cell
					if (curEcomCellSelectedRow != -1 && curEcomCellSelectedCol !=-1 && (curEcomCellSelectedRow != i || curEcomCellSelectedCol !=j)) { 
						ecomCell[curEcomCellSelectedRow][curEcomCellSelectedCol].setBackground(new Color(127,255,0));
					}
					
					//set current clicked cell color to red
					ecomCell[i][j].setBackground(Color.RED);
					curEcomCellSelectedRow = i;
					curEcomCellSelectedCol = j;
					isEcomBoardSelected = true;
				}
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void markReservedSeats(Map<Integer, Set<Integer>> reservedFirstClassSeatsMap, Map<Integer, Set<Integer>> reservedEconomyClassSeatsMap) {
		for (Map.Entry<Integer, Set<Integer>> e : reservedFirstClassSeatsMap.entrySet()) {
			int row = e.getKey();
			Set<Integer> cols = e.getValue();
			for (Integer c : cols) {
				int cInt = c.intValue();
				if (cInt >= 0 && cInt < firstCell[0].length) {
					firstCell[row][c.intValue()].setBackground(Color.RED);
					firstCellReserved[row][c.intValue()] = true;		
				}
			}
		}
		
		for (Map.Entry<Integer, Set<Integer>> e : reservedEconomyClassSeatsMap.entrySet()) {
			int row = e.getKey();
			Set<Integer> cols = e.getValue();
			for (Integer c : cols) {
				int cInt = c.intValue();
				if (cInt >= 0 && cInt < ecomCell[0].length) {
					ecomCell[row][c.intValue()].setBackground(Color.RED);
					econCellReserved[row][c.intValue()] = true;
				}
			}
		}
	}
	
	private boolean isFirstReserved(int row, int col) {
		boolean result = false;
		if (firstCellReserved[row][col] == true) {
			JOptionPane.showMessageDialog(null, "This seat has been reserved, please select another seat!");
			result = true;
		}
		return result;
	}
	
	private boolean isEconReserved(int row, int col) {
		boolean result = false;
		if (econCellReserved[row][col] == true) {
			JOptionPane.showMessageDialog(null, "This seat has been reserved, please select another seat!");
			result = true;
		}
		return result;
	}
	
	 //This is the reset mothed to reset the information
	public void reset() {
		if (isFirstBoardSelected == true) {
			firstCell[curFirstCellSelectedRow][curFirstCellSelectedCol].setBackground(new Color(127,255,0));
		} else if (isEcomBoardSelected == true) {
			ecomCell[curEcomCellSelectedRow][curEcomCellSelectedCol].setBackground(new Color(127,255,0));
		}
		
		isFirstBoardSelected = false;
		isEcomBoardSelected = false;
		
		curFirstCellSelectedRow = -1;
		curFirstCellSelectedCol = -1;
		
		curEcomCellSelectedRow = -1;
		curEcomCellSelectedCol = -1;
		
		
	}
}
