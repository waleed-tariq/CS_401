// Waleed Tariq
// COE 401 
// 12/4/18
// Assignment 4
// RouletteWheel Class

import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RouletteWheel extends JPanel {
	
	//instance variables
	private int spinResult;
	private RColors color;
	private String color1;
	private RParities parity;
	private String parity1;
	private RRanges range;
	private String range1;
	private String value;
	
	private JPanel wheelPanel;
	private RouletteSquare [] squares;
	
	RouletteSquare square;
	private Activatable x;
	
	//constructor passing in activatable
	public RouletteWheel(Activatable act) {
		
		//setting the instance variable equal to the passing variable
		x = act;
		//creating panel for all of the numbers
		wheelPanel = new JPanel();
		wheelPanel.setLayout(new GridLayout(5,8));
		wheelPanel.setPreferredSize(new Dimension(700, 415));
		
		//setting the squares equal to an array of size 37
		squares = new RouletteSquare[37];
		
		//text area for each of the buttons spacing
		JTextArea space = new JTextArea("\t ");
		//for loop adding all of the numbers to the panel
		for (int i = 0; i<37; i++) {
			squares[i] = new RouletteSquare(i);
			wheelPanel.add(squares[i]);
			wheelPanel.add(space);
		}
		
		this.add(wheelPanel);
		
	}
	//spin method
	public void spin() {
		//using the runnable interface and creating a thread
		Runnable color = new wheelColor();
		new Thread(color).start();
	}
	//setting all of the squares background color to white
	public void set() {
		for (int i = 0; i < 37; i++) {
			squares[i].unChosen();
		}
		
	}
	//class that implements the runnable
	public class wheelColor implements Runnable {
		
		int index = 0;
		long delay, duration;
		//method to set wheel color but mainly to create the duration and delay
		public wheelColor()
		{
			//setting it to a random number between 8 and 2 seconds
			long durationCheck = (long) (Math.random() * 8000 + 2000);
			delay =100;
			duration = durationCheck;
		}
		
		//run method
		public void run()
		{

			long start = System.nanoTime();
			long end = System.nanoTime();
			long delta = end - start;  // this is the elapsed time
			long durNano = duration * 1000000;  // convert to nanoTime
			// Loop until the elapsed time is more than the requested duration
			while (delta <= durNano)  // keep iterating as long as the elapsed
			{						  // time is less than the duration
				
				if (squares[index].isChosen()) {
					squares[index].unChoose();
					index = (index + 1) % squares.length;
					squares[index].chosen();
				}
				else {
					squares[index].chosen();
				}
				
				try {
					Thread.sleep(delay);  // sleep between changes
				}
				catch (InterruptedException e)
				{  System.out.println("Problem with Thread!"); }
				
				end = System.nanoTime();  // recalculate elapsed time
				delta = end - start;
				
			}
			//setting all the squares to the correct number
			square = squares[index];
			//calling on activate
			x.activate();
		}

		
	}
	
	
	public RouletteResult spinWheel() {
		
		
		//internal storage of the random number
		setSpinResult((int) (Math.random() * 36));		
		//if statement to assign each instance variable with the proper value that will result on the roulette wheel
		
		if (getSpinResult() == 0)
		{
			color=RColors.Green;
			color1 = RColors.Green.name();
			parity1 = RParities.None.name();
			range1 = RRanges.None.name();
			setValue("0");
			parity = RParities.None;
			range = RRanges.None;
		}
		else if (getSpinResult() == 1)
		{
			color1 = RColors.Red.name();
			parity1 = RParities.Odd.name();
			range1 = RRanges.Low.name();

			color = RColors.Red;
			setValue("1");
			parity = RParities.Odd;
			range = RRanges.Low;
		}
		else if (getSpinResult() == 2)
		{
			setValue("2");
			color1 = RColors.Black.name();
			parity1 = RParities.Even.name();
			range1 = RRanges.Low.name();

			color = RColors.Black;
			parity = RParities.Even;
			range = RRanges.Low;
		}
		else if (getSpinResult() == 3)
		{
			setValue("3");
			color1 = RColors.Red.name();
			parity1 = RParities.Odd.name();
			range1 = RRanges.Low.name();

			color = RColors.Red;
			parity = RParities.Odd;
			range = RRanges.Low;
		}
		else if (getSpinResult() == 4)
		{
			setValue("4");
			color1 = RColors.Black.name();
			parity1 = RParities.Even.name();
			range1 = RRanges.Low.name();

			color = RColors.Black;
			parity = RParities.Even;
			range = RRanges.Low;
			}
		else if (getSpinResult() == 5)
		{
			setValue("5");
			color1 = RColors.Red.name();
			parity1 = RParities.Odd.name();
			range1 = RRanges.Low.name();

			color = RColors.Red;
			parity = RParities.Odd;
			range = RRanges.Low;
		}
		else if (getSpinResult() == 6)
		{
			setValue("6");
			color1 = RColors.Black.name();
			parity1 = RParities.Even.name();
			range1 = RRanges.Low.name();

			color = RColors.Black;
			parity = RParities.Even;
			range = RRanges.Low;
		}
		else if (getSpinResult() == 7)
		{
			setValue("7");
			color1 = RColors.Red.name();
			parity1 = RParities.Odd.name();
			range1 = RRanges.Low.name();

			color = RColors.Red;
			parity = RParities.Odd;
			range = RRanges.Low;
		}
		else if (getSpinResult() == 8)
		{
			setValue("8");
			color1 = RColors.Black.name();
			parity1 = RParities.Even.name();
			range1 = RRanges.Low.name();

			color = RColors.Black;
			parity = RParities.Even;
			range = RRanges.Low;
		}
		else if (getSpinResult() == 9)
		{
			setValue("9");
			color1 = RColors.Red.name();
			parity1 = RParities.Odd.name();
			range1 = RRanges.Low.name();

			color = RColors.Red;
			parity = RParities.Odd;
			range = RRanges.Low;
		}
		else if (getSpinResult() == 10)
		{
			setValue("10");
			color1 = RColors.Red.name();
			parity1 = RParities.Even.name();
			range1 = RRanges.Low.name();

			color = RColors.Red;
			parity = RParities.Even;
			range = RRanges.Low;
		}
		else if (getSpinResult() == 11)
		{
			setValue("11");
			color1 = RColors.Black.name();
			parity1 = RParities.Odd.name();
			range1 = RRanges.Low.name();

			color = RColors.Black;
			parity = RParities.Odd;
			range = RRanges.Low;
		}
		else if (getSpinResult() == 12)
		{
			setValue("12");
			color1 = RColors.Red.name();
			parity1 = RParities.Even.name();
			range1 = RRanges.Low.name();

			color = RColors.Red;
			parity = RParities.Even;
			range = RRanges.Low;
		}
		else if (getSpinResult() == 13)
		{
			setValue("13");
			color1 = RColors.Black.name();
			parity1 = RParities.Odd.name();
			range1 = RRanges.Low.name();

			color = RColors.Black;
			parity = RParities.Odd;
			range = RRanges.Low;
		}
		else if (getSpinResult() == 14)
		{
			setValue("14");
			color1 = RColors.Red.name();
			parity1 = RParities.Even.name();
			range1 = RRanges.Low.name();

			color = RColors.Red;
			parity = RParities.Even;
			range = RRanges.Low;
		}
		else if (getSpinResult() == 15)
		{
			setValue("15");
			color1 = RColors.Black.name();
			parity1 = RParities.Odd.name();
			range1 = RRanges.Low.name();

			color = RColors.Black;
			parity = RParities.Odd;
			range = RRanges.Low;
		}
		else if (getSpinResult() == 16)
		{
			setValue("16");
			color1 = RColors.Red.name();
			parity1 = RParities.Even.name();
			range1 = RRanges.Low.name();

			color = RColors.Red;
			parity = RParities.Even;
			range = RRanges.Low;
		}
		else if (getSpinResult() == 17)
		{
			setValue("17");
			color1 = RColors.Black.name();
			parity1 = RParities.Odd.name();
			range1 = RRanges.Low.name();

			color = RColors.Black;
			parity = RParities.Odd;
			range = RRanges.Low;
		}
		else if (getSpinResult() == 18)
		{
			setValue("18");
			color1 = RColors.Red.name();
			parity1 = RParities.Even.name();
			range1 = RRanges.Low.name();

			color = RColors.Red;
			parity = RParities.Even;
			range = RRanges.Low;
		}
		else if (getSpinResult() == 19)
		{
			setValue("19");
			color1 = RColors.Red.name();
			parity1 = RParities.Odd.name();
			range1 = RRanges.High.name();

			color = RColors.Red;
			parity = RParities.Odd;
			range = RRanges.High;
		}
		else if (getSpinResult() == 20)
		{
			setValue("20");
			color1 = RColors.Black.name();
			parity1 = RParities.Even.name();
			range1 = RRanges.High.name();

			color = RColors.Black;
			parity = RParities.Even;
			range = RRanges.High;
		}
		else if (getSpinResult() == 21)
		{
			setValue("21");
			color1 = RColors.Red.name();
			parity1 = RParities.Odd.name();
			range1 = RRanges.High.name();

			color = RColors.Red;
			parity = RParities.Odd;
			range = RRanges.High;
		}
		else if (getSpinResult() == 22)
		{
			setValue("22");
			color1 = RColors.Black.name();
			parity1 = RParities.Even.name();
			range1 = RRanges.High.name();

			color = RColors.Black;
			parity = RParities.Even;
			range = RRanges.High;
		}
		else if (getSpinResult() == 23)
		{
			setValue("23");
			color1 = RColors.Red.name();
			parity1 = RParities.Odd.name();
			range1 = RRanges.High.name();

			color = RColors.Red;
			parity = RParities.Odd;
			range = RRanges.High;
		}
		else if (getSpinResult() == 24)
		{
			setValue("24");
			color1 = RColors.Black.name();
			parity1 = RParities.Even.name();
			range1 = RRanges.High.name();

			color = RColors.Black;
			parity = RParities.Even;
			range = RRanges.High;
		}
		else if (getSpinResult() == 25)
		{
			setValue("25");
			color1 = RColors.Red.name();
			parity1 = RParities.Odd.name();
			range1 = RRanges.High.name();

			color = RColors.Red;
			parity = RParities.Odd;
			range = RRanges.High;
		}
		else if (getSpinResult() == 26)
		{
			setValue("26");
			color1 = RColors.Black.name();
			parity1 = RParities.Even.name();
			range1 = RRanges.High.name();

			color = RColors.Black;
			parity = RParities.Even;
			range = RRanges.High;
		}
		else if (getSpinResult() == 27)
		{
			setValue("27");
			color1 = RColors.Red.name();
			parity1 = RParities.Odd.name();
			range1 = RRanges.High.name();

			color = RColors.Red;
			parity = RParities.Odd;
			range = RRanges.High;
		}
		else if (getSpinResult() == 28)
		{
			setValue("28");
			color1 = RColors.Black.name();
			parity1 = RParities.Even.name();
			range1 = RRanges.High.name();

			color = RColors.Black;
			parity = RParities.Even;
			range = RRanges.High;
		}
		else if (getSpinResult() == 29)
		{
			setValue("29");
			color1 = RColors.Black.name();
			parity1 = RParities.Odd.name();
			range1 = RRanges.High.name();

			color = RColors.Black;
			parity = RParities.Odd;
			range = RRanges.High;
		}
		else if (getSpinResult() == 30)
		{
			setValue("30");
			color1 = RColors.Red.name();
			parity1 = RParities.Even.name();
			range1 = RRanges.High.name();

			color = RColors.Red;
			parity = RParities.Even;
			range = RRanges.High;
		}
		else if (getSpinResult() == 31)
		{
			setValue("31");
			color1 = RColors.Black.name();
			parity1 = RParities.Odd.name();
			range1 = RRanges.High.name();

			color = RColors.Black;
			parity = RParities.Odd;
			range = RRanges.High;
		}
		else if (getSpinResult() == 32)
		{
			setValue("32");
			color1 = RColors.Red.name();
			parity1 = RParities.Even.name();
			range1 = RRanges.High.name();

			color = RColors.Red;
			parity = RParities.Even;
			range = RRanges.High;
		}
		else if (getSpinResult() == 33)
		{
			setValue("33");
			color1 = RColors.Black.name();
			parity1 = RParities.Odd.name();
			range1 = RRanges.High.name();

			color = RColors.Black;
			parity = RParities.Odd;
			range = RRanges.High;
		}
		else if (getSpinResult() == 34)
		{
			setValue("34");
			color1 = RColors.Red.name();
			parity1 = RParities.Even.name();
			range1 = RRanges.High.name();

			color = RColors.Red;
			parity = RParities.Even;
			range = RRanges.High;
		}
		else if (getSpinResult() == 35)
		{
			setValue("35");
			parity1 = RParities.Odd.name();
			range1 = RRanges.High.name();

			color = RColors.Black;
			color1 = RColors.Black.name();
			parity = RParities.Odd;
			range = RRanges.High;
		}
		else if (getSpinResult() == 36)
		{
			setValue("36");
			color1 = RColors.Red.name();
			parity1 = RParities.Even.name();
			range1 = RRanges.High.name();

			color = RColors.Red;
			parity = RParities.Even;
			range = RRanges.High;
		}
		//sets the variables for the RouletteResult class 
		RouletteResult x = new RouletteResult (color, range, parity, spinResult);
		//returns the RouletteResult constructor above	
		return x;
		
	}
	//getters and setters for each of the instance variables
	public String getColor() {
		return color1;
	}
	
	public String getRange() {
		return range1;
	}
	
	public String getParity() {
		return parity1;
	}

	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value=value;
	}

	public int getSpinResult() {
		return spinResult;
	}

	public void setSpinResult(int spinResult) {
		this.spinResult = spinResult;
	}
	
	//checkBet method to check the bets outcome and the wheels
	public int checkBet(RouletteBet b) {
		
		int res = 0;		
		RBets betType = b.getBetType();
		
		// if statement checking what type of bet the user has selected
		if ((betType).equals((RBets.Value))) {
			//if statement checking if the user has chosen the correct value
			if ((b.getBetValue()).equals(square.getValue())) {
				res = 35;
			}
		
			else {
				res = 0;
			}
		}
		
		else if ((betType).equals((RBets.Color))) {
			//if statement checking if the user has chosen the correct color
			if ((b.getBetValue()).equals((square.getColor()))) {
				res = 1;
			}
			else {
				res = 0;
				}
			}
		else if (betType.equals((RBets.Parity))) {
			//if statement checking if the user has chosen the correct parity
			if ((b.getBetValue()).equals((square.getParity()))){
				res = 1;
			}
			else {
				res = 0;
			}
		}
		else if (betType.equals(RBets.Range)) {
			//if statement checking if the user has chosen the correct range
			if ((b.getBetValue()).equals(square.getRange())) {
				res = 1;
			}
			else {
				res = 0;
			}
			
		}
		// returns the certain res based on if the user was correct or wrong
		return res;
	}
	

}
