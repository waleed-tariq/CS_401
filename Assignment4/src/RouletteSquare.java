import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RouletteSquare extends JLabel {
	
	private JLabel labelnum;
	private int x = 0;
	private RouletteWheel wheel;
	private int getSpinResult;
	private RColors color;
	private String color1;
	private RParities parity;
	private String parity1;
	private RRanges range;
	private String range1;
	private String value;
	private JTextArea y;
	boolean chooseNum = false;

	
	public RouletteSquare(int num) {
		
		x = num;
		
		if (x == 0)
		{
			value = "0";
			color=RColors.Green;
			color1 = RColors.Green.name();
			parity1 = RParities.None.name();
			range1 = RRanges.None.name();
			parity = RParities.None;
			range = RRanges.None;
		}
		else if (x == 1)
		{
			color1 = RColors.Red.name();
			parity1 = RParities.Odd.name();
			range1 = RRanges.Low.name();
			value = "1";
			color = RColors.Red;
			parity = RParities.Odd;
			range = RRanges.Low;
		}
		else if (x == 2)
		{
			color1 = RColors.Black.name();
			parity1 = RParities.Even.name();
			range1 = RRanges.Low.name();
			value = "2";
			color = RColors.Black;
			parity = RParities.Even;
			range = RRanges.Low;
		}
		else if (x == 3)
		{
			color1 = RColors.Red.name();
			parity1 = RParities.Odd.name();
			range1 = RRanges.Low.name();
			value = "3";
			color = RColors.Red;
			parity = RParities.Odd;
			range = RRanges.Low;
		}
		else if (x == 4)
		{
			color1 = RColors.Black.name();
			parity1 = RParities.Even.name();
			range1 = RRanges.Low.name();
			value = "4";
			color = RColors.Black;
			parity = RParities.Even;
			range = RRanges.Low;
			}
		else if (x == 5)
		{
			value = ("5");
			color1 = RColors.Red.name();
			parity1 = RParities.Odd.name();
			range1 = RRanges.Low.name();

			color = RColors.Red;
			parity = RParities.Odd;
			range = RRanges.Low;
		}
		else if (x == 6)
		{
			value = ("6");
			color1 = RColors.Black.name();
			parity1 = RParities.Even.name();
			range1 = RRanges.Low.name();

			color = RColors.Black;
			parity = RParities.Even;
			range = RRanges.Low;
		}
		else if (x == 7)
		{
			value = ("7");
			color1 = RColors.Red.name();
			parity1 = RParities.Odd.name();
			range1 = RRanges.Low.name();

			color = RColors.Red;
			parity = RParities.Odd;
			range = RRanges.Low;
		}
		else if (x == 8)
		{
			value = ("8");
			color1 = RColors.Black.name();
			parity1 = RParities.Even.name();
			range1 = RRanges.Low.name();

			color = RColors.Black;
			parity = RParities.Even;
			range = RRanges.Low;
		}
		else if (x == 9)
		{
			value = ("9");
			color1 = RColors.Red.name();
			parity1 = RParities.Odd.name();
			range1 = RRanges.Low.name();

			color = RColors.Red;
			parity = RParities.Odd;
			range = RRanges.Low;
		}
		else if (x == 10)
		{
			value = ("10");
			color1 = RColors.Red.name();
			parity1 = RParities.Even.name();
			range1 = RRanges.Low.name();

			color = RColors.Red;
			parity = RParities.Even;
			range = RRanges.Low;
		}
		else if (x == 11)
		{
			value = ("11");
			color1 = RColors.Black.name();
			parity1 = RParities.Odd.name();
			range1 = RRanges.Low.name();

			color = RColors.Black;
			parity = RParities.Odd;
			range = RRanges.Low;
		}
		else if (x == 12)
		{
			value = ("12");
			color1 = RColors.Red.name();
			parity1 = RParities.Even.name();
			range1 = RRanges.Low.name();

			color = RColors.Red;
			parity = RParities.Even;
			range = RRanges.Low;
		}
		else if (x == 13)
		{
			value = ("13");
			color1 = RColors.Black.name();
			parity1 = RParities.Odd.name();
			range1 = RRanges.Low.name();

			color = RColors.Black;
			parity = RParities.Odd;
			range = RRanges.Low;
		}
		else if (x == 14)
		{
			value = ("14");
			color1 = RColors.Red.name();
			parity1 = RParities.Even.name();
			range1 = RRanges.Low.name();

			color = RColors.Red;
			parity = RParities.Even;
			range = RRanges.Low;
		}
		else if (x == 15)
		{
			value = ("15");
			color1 = RColors.Black.name();
			parity1 = RParities.Odd.name();
			range1 = RRanges.Low.name();

			color = RColors.Black;
			parity = RParities.Odd;
			range = RRanges.Low;
		}
		else if (x == 16)
		{
			value = ("16");
			color1 = RColors.Red.name();
			parity1 = RParities.Even.name();
			range1 = RRanges.Low.name();

			color = RColors.Red;
			parity = RParities.Even;
			range = RRanges.Low;
		}
		else if (x == 17)
		{
			value = ("17");
			color1 = RColors.Black.name();
			parity1 = RParities.Odd.name();
			range1 = RRanges.Low.name();

			color = RColors.Black;
			parity = RParities.Odd;
			range = RRanges.Low;
		}
		else if (x == 18)
		{
			value = ("18");
			color1 = RColors.Red.name();
			parity1 = RParities.Even.name();
			range1 = RRanges.Low.name();

			color = RColors.Red;
			parity = RParities.Even;
			range = RRanges.Low;
		}
		else if (x == 19)
		{
			value = ("19");
			color1 = RColors.Red.name();
			parity1 = RParities.Odd.name();
			range1 = RRanges.High.name();

			color = RColors.Red;
			parity = RParities.Odd;
			range = RRanges.High;
		}
		else if (x == 20)
		{
			value = ("20");
			color1 = RColors.Black.name();
			parity1 = RParities.Even.name();
			range1 = RRanges.High.name();

			color = RColors.Black;
			parity = RParities.Even;
			range = RRanges.High;
		}
		else if (x == 21)
		{
			value = ("21");
			
			color1 = RColors.Red.name();
			parity1 = RParities.Odd.name();
			range1 = RRanges.High.name();

			color = RColors.Red;
			parity = RParities.Odd;
			range = RRanges.High;
		}
		else if (x == 22)
		{
			value = ("22");
			color1 = RColors.Black.name();
			parity1 = RParities.Even.name();
			range1 = RRanges.High.name();

			color = RColors.Black;
			parity = RParities.Even;
			range = RRanges.High;
		}
		else if (x == 23)
		{
			value = ("23");
			color1 = RColors.Red.name();
			parity1 = RParities.Odd.name();
			range1 = RRanges.High.name();

			color = RColors.Red;
			parity = RParities.Odd;
			range = RRanges.High;
		}
		else if (x == 24)
		{
			value = ("24");
			color1 = RColors.Black.name();
			parity1 = RParities.Even.name();
			range1 = RRanges.High.name();

			color = RColors.Black;
			parity = RParities.Even;
			range = RRanges.High;
		}
		else if (x == 25)
		{
			value = ("25");
			color1 = RColors.Red.name();
			parity1 = RParities.Odd.name();
			range1 = RRanges.High.name();

			color = RColors.Red;
			parity = RParities.Odd;
			range = RRanges.High;
		}
		else if (x == 26)
		{
			value = ("26");
			color1 = RColors.Black.name();
			parity1 = RParities.Even.name();
			range1 = RRanges.High.name();

			color = RColors.Black;
			parity = RParities.Even;
			range = RRanges.High;
		}
		else if (x == 27)
		{
			value = ("27");
			color1 = RColors.Red.name();
			parity1 = RParities.Odd.name();
			range1 = RRanges.High.name();

			color = RColors.Red;
			parity = RParities.Odd;
			range = RRanges.High;
		}
		else if (x == 28)
		{
			value = ("28");
			color1 = RColors.Black.name();
			parity1 = RParities.Even.name();
			range1 = RRanges.High.name();

			color = RColors.Black;
			parity = RParities.Even;
			range = RRanges.High;
		}
		else if (x == 29)
		{
			value = ("29");
			color1 = RColors.Black.name();
			parity1 = RParities.Odd.name();
			range1 = RRanges.High.name();

			color = RColors.Black;
			parity = RParities.Odd;
			range = RRanges.High;
		}
		else if (x == 30)
		{
			value = ("30");
			color1 = RColors.Red.name();
			parity1 = RParities.Even.name();
			range1 = RRanges.High.name();

			color = RColors.Red;
			parity = RParities.Even;
			range = RRanges.High;
		}
		else if (x == 31)
		{
			value = ("31");
			color1 = RColors.Black.name();
			parity1 = RParities.Odd.name();
			range1 = RRanges.High.name();

			color = RColors.Black;
			parity = RParities.Odd;
			range = RRanges.High;
		}
		else if (x == 32)
		{
			value = ("32");
			color1 = RColors.Red.name();
			parity1 = RParities.Even.name();
			range1 = RRanges.High.name();

			color = RColors.Red;
			parity = RParities.Even;
			range = RRanges.High;
		}
		else if (x == 33)
		{
			value = ("33");
			color1 = RColors.Black.name();
			parity1 = RParities.Odd.name();
			range1 = RRanges.High.name();

			color = RColors.Black;
			parity = RParities.Odd;
			range = RRanges.High;
		}
		else if (x == 34)
		{
			value = ("34");
			color1 = RColors.Red.name();
			parity1 = RParities.Even.name();
			range1 = RRanges.High.name();

			color = RColors.Red;
			parity = RParities.Even;
			range = RRanges.High;
		}
		else if (x == 35)
		{
			value = ("35");
			parity1 = RParities.Odd.name();
			range1 = RRanges.High.name();

			color = RColors.Black;
			color1 = RColors.Black.name();
			parity = RParities.Odd;
			range = RRanges.High;
		}
		else if (x == 36)
		{
			value = "36";
			color1 = RColors.Red.name();
			parity1 = RParities.Even.name();
			range1 = RRanges.High.name();

			color = RColors.Red;
			parity = RParities.Even;
			range = RRanges.High;
		}
		
	
		setFont(new Font("Serif", Font.BOLD, 40));
		setText(value);
		setHorizontalAlignment(CENTER);
		
		if (color1.equals("Red")) {
			setForeground(Color.RED);
		}
		else if (color1.equals("Green")) {
			setForeground(Color.green);
		}
		else if (color1.equals("BLACK")) {
			setForeground(Color.BLACK);
		}
		setBackground(Color.WHITE);
		setOpaque(true);
		
	}

	public boolean isChosen() {
		if (chooseNum == true) {
			return true;
		}
		else {
			return false;
		}
	}

	public void unChoose() {
		if (chooseNum == false) {
			setBackground(Color.CYAN);
			chooseNum = true;
		}
		else {
			setBackground(Color.WHITE);
			chooseNum = false;
		}
	}
	
	public void unChosen() {
		setBackground(Color.WHITE);
	}
	
	public void chosen() {
		setBackground(Color.CYAN);
		chooseNum = true;
	}

	public String getValue() {
		return value;
	}

	public String getColor() {
		return color1;
	}

	public String getParity() {
		return parity1;
	}

	public String getRange() {
		return range1;
	}

}
