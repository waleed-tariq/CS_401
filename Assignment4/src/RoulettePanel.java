/* Waleed Tariq
 * RoulettePanel class
 * Assignment 4
 * Create panel for the user to play the roulette game
 */

import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RoulettePanel extends JPanel implements Activatable {

	//instance variables for the entire class
	private JPanel buttonPanel, wholePanel;
	private JTextArea info;
	private JButton makeBet, spin, showInfo, quit;
	RoulettePlayer pl;
	RouletteBet bet1;
	double bet, money;
	String bType, betVal;
	private GameInterface z;
	RBets betType;
	RPList r = new RPList("players.txt");
	private RouletteWheel wheel = new RouletteWheel(this);
	
	//constructor for roulette panel, calling in the roulette player and the game interface
	public RoulettePanel(RoulettePlayer p, GameInterface g) {
		
		// setting the game interface and the roulette player equal to the instance variables to pass them in
		z = g;
		pl = p;
		
		//creating large panel to contain all the buttons, text areas, and wheel
		wholePanel = new JPanel();
		wholePanel.setLayout(new GridLayout(1,2));
		
		
		//text area for the information of the user
		info = new JTextArea("Welcome " + p.getName());
		info.setColumns(15);
		info.setEditable(false);
		
		//panel for all of the buttons and text area
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(5,1));
		buttonPanel.add(info);
		//handler for the buttons
		thehandler handler = new thehandler();
		
		//creating the make bet button and adding it into the button panel
		makeBet = new JButton("Make Bet");
		makeBet.setFont(new Font("Serif", Font.BOLD, 35));
		makeBet.setPreferredSize(new Dimension(50,50));
		makeBet.addActionListener(handler);
		buttonPanel.add(makeBet);
		
		//creating the spin button and adding it into the button panel
		spin = new JButton("Spin Wheel");
		spin.setFont(new Font("Serif", Font.BOLD, 35));
		spin.setPreferredSize(new Dimension(50,50));
		spin.addActionListener(handler);
		spin.setEnabled(false);
		buttonPanel.add(spin);
		
		//creating the show info button and adding it into the button panel
		showInfo = new JButton("Show My Info");
		showInfo.setFont(new Font("Serif", Font.BOLD, 35));
		showInfo.setPreferredSize(new Dimension(50,50));
		showInfo.addActionListener(handler);
		buttonPanel.add(showInfo);
		
		//creating the quit button and adding it into the button panel
		quit = new JButton("Quit");
		quit.setFont(new Font("Serif", Font.BOLD, 35));
		quit.setPreferredSize(new Dimension(50,50));
		quit.addActionListener(handler);
		buttonPanel.add(quit);
				
		//adding the button panel to the whole panel
		wholePanel.add(buttonPanel);

		//adding the wheel made in roulette wheel to the whole panel
		wholePanel.add(wheel);
		//adding the entire panel to the roulette panel that is extended
		this.add(wholePanel);
		//welcoming the user with a JOPtionPane
		JOptionPane.showMessageDialog(null, "Welcome to Roulette " + pl.getName() + "!");

		
	}
	
	//activate method
	public void activate() {
				
		//displays the result of the spin
		JOptionPane.showMessageDialog(null, "Result:\nValue: " + wheel.square.getValue() + " Color: " + wheel.square.getColor() + " Parity: " + wheel.square.getParity() + " Range: " + wheel.square.getRange());
		
		//setting the roulette bet to the values and the type the user has chosen
		RouletteBet bet2 = new RouletteBet(betType, betVal);
		
		//setting the result of the check bet to the integer res
		int res = wheel.checkBet(bet2);

		
		//if statement checking what the integer res results in and displaying whatever occurs if they lost or won
		if (res == 0) {
			JOptionPane.showMessageDialog(null, "Your bet on " + betVal + " has lost!");
			JOptionPane.showMessageDialog(null, "You lost $" + bet);
			money = pl.getMoney();
			pl.updateMoney(-(bet));
			//if statement checking if the user has a debt to pay off
			if (pl.getDebt()>0) {
				int paybackLoop = 0;
				//if statement checking if the player has money or not
				if (pl.getMoney() == 0) {
					JOptionPane.showMessageDialog(null, "You have no money left");
				}
				else {
				JOptionPane.showMessageDialog(null, "You have some debt that you can pay off.\n" +
						 "\tYou owe: " + pl.getDebt() + "\n\tYou have: " + pl.getMoney());
				
				String paybackString;
				double payback = 0;
				//while loop for the payback 
				while (paybackLoop == 0) {
					//asking user to payback the money they owe
					paybackString = JOptionPane.showInputDialog("How much would you like to pay back (<= " + pl.getMoney() + "):");
					payback = Double.parseDouble(paybackString);
					//if statement checking if they have paid back a correct amount
					if (payback > pl.getDebt()) {
						paybackLoop = 0;
					}
					else {
						paybackLoop = 100;
					}
				}
					//updating the debt and the money they have
					pl.updateDebt(-payback);
					pl.updateMoney(-payback);
				}
			}
		}
		else if (res == 1) {
			JOptionPane.showMessageDialog(null, "Your bet on " + betVal + " has won!");
			JOptionPane.showMessageDialog(null, "You win $" + bet);
			money = pl.getMoney();
			pl.updateMoney(bet);
			//if statement checking if the user has a debt to pay off
			if (pl.getDebt()>0) {
				int paybackLoop = 0;
				//if statement checking if the player has money or not
				if (pl.getMoney() == 0) {
					JOptionPane.showMessageDialog(null, "You have no money left");
				}
				else {
				JOptionPane.showMessageDialog(null, "You have some debt that you can pay off.\n" +
						 "\tYou owe: " + pl.getDebt() + "\n\tYou have: " + pl.getMoney());
				
				String paybackString;
				double payback = 0;
				//while loop for the payback 
				while (paybackLoop == 0) {
					//asking user to payback the money they owe
					paybackString = JOptionPane.showInputDialog("How much would you like to pay back (<= " + pl.getMoney() + "):");
					payback = Double.parseDouble(paybackString);
					//if statement checking if they have paid back a correct amount
					if (payback > pl.getDebt()) {
						paybackLoop = 0;
					}
					else {
						paybackLoop = 100;
					}
				}
					//updating the debt and the money they have
					pl.updateDebt(-payback);
					pl.updateMoney(-payback);
				}
			}
		}
		else if (res == 35) {
			JOptionPane.showMessageDialog(null, "Your bet on " + betVal + " has won!");
			JOptionPane.showMessageDialog(null, "You win $" + 35*bet);
			money = pl.getMoney();
			pl.updateMoney(35*bet);
			//if statement checking if the user has a debt to pay off
			if (pl.getDebt()>0) {
				int paybackLoop = 0;
				//if statement checking if the player has money or not
				if (pl.getMoney() == 0) {
					JOptionPane.showMessageDialog(null, "You have no money left");
				}
				else {
				JOptionPane.showMessageDialog(null, "You have some debt that you can pay off.\n" +
						 "\tYou owe: " + pl.getDebt() + "\n\tYou have: " + pl.getMoney());
				
				String paybackString;
				double payback = 0;
				//while loop for the payback 
				while (paybackLoop == 0) {
					//asking user to payback the money they owe
					paybackString = JOptionPane.showInputDialog("How much would you like to pay back (<= " + pl.getMoney() + "):");
					payback = Double.parseDouble(paybackString);
					//if statement checking if they have paid back a correct amount
					if (payback > pl.getDebt()) {
						paybackLoop = 0;
					}
					else {
						paybackLoop = 100;
					}
				}
					//updating the debt and the money they have
					pl.updateDebt(-payback);
					pl.updateMoney(-payback);
				}
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "hello eric");
		}
		//setting the text in the text area to this updated data
		info.setText("You now have $" + pl.getMoney() + " left");
		//if statement checking if the user has money
		if (pl.getMoney() == 0) {
			info.setText("Sorry but you are out of money!");
			makeBet.setEnabled(false);
			spin.setEnabled(false);
			quit.setEnabled(true);
			
		}
		else {

			makeBet.setEnabled(true);
			quit.setEnabled(true);
		}
	}
	
	//class and method for the handler
	private class thehandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			//if statement for the buttons and which one is clicked
			if (e.getSource() == quit) {
				//calls on the game over interface
				z.gameOver();
			}
			else if (e.getSource() == makeBet) {
				int loop = 1;
				
				wheel.set();
				//while loop asking user to bet and checks if they have input a correct amount
				while (loop == 1) {
					String betString = JOptionPane.showInputDialog(null, "How much to bet? (<=" + pl.getMoney() + ")");
					bet = Double.parseDouble(betString);
					if (bet > pl.getMoney() || bet < 0) {
						loop = 1;
					}
					else {
						loop = 1000;
					}
					spin.setEnabled(true);
					
				}
				int typeLoop = 1;
				String bType = null;
				//while loop error checking the type of bet the user wants
				while (typeLoop == 1) {
					bType = JOptionPane.showInputDialog(null, "Please enter the type of your bet: [Value, Color, Range, Parity] ");
					//if statement checking if the bet type is one of the correct values
					if (bType.equals("Value") || bType.equals("Color") || bType.equals("Range") || bType.equals("Parity")) {
						typeLoop = 10000;
					}
					else {
						typeLoop = 1;
					}
					
				}
				int valLoop = 1;
				betType = RBets.valueOf(bType);
				//while loop error checking the bet type the user wants
				while (valLoop == 1) {
					//if statement to see what type of bet the user wants and the value
						if (betType == RBets.Color) {
							betVal = JOptionPane.showInputDialog(null, "Enter your color [Red, Black]: ");
							valLoop = 1000;
						}
						else if (betType == RBets.Parity) {
							betVal = JOptionPane.showInputDialog(null, "Enter your parity [Even, Odd]: ");
							valLoop = 1000;
						}
						
						else if (betType == RBets.Range) {
							betVal = JOptionPane.showInputDialog(null, "Enter your range [Low, High]: ");
							valLoop = 1000;
						}
						
						else if (betType == RBets.Value) {
							betVal = JOptionPane.showInputDialog(null, "Enter your number [0-36]: ");
							valLoop = 1000;
						}
						else {
							valLoop = 1;
						}		
				}
				//setting the text to the bet
				info.setText("You have bet $" + bet + " on " + betVal);
				
			}
			
			else if (e.getSource() == spin) {
				//enabling and unenabling the certain buttons
				makeBet.setEnabled(false);
				quit.setEnabled(false);
				spin.setEnabled(false);
				wheel.spin();
			}
			else if (e.getSource() == showInfo) {
				//displays the info of the user
				JOptionPane.showMessageDialog(null, "Here is your info:\n\n" + pl.toString());
				
			}
			
		}
		
	}
		

}


