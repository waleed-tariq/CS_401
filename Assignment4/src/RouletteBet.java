// Waleed Tariq
// COE 401 
// 10/16/18
// Assignment 2
// RouletteBet Class


public class RouletteBet {
	//instance variables
	private RBets betType;
	private String betValue;
	
	//constructor method
	public RouletteBet(RBets bet, String val)
	{
		betType = bet;
		betValue = new String(val);
	}
	//setting a neat string and returning it
	public String toString()
	{
		String ans = new String("Type:" + betType + "  Value:" + betValue);
		return ans;
	}
	//getter for the bet type
	public RBets getBetType()
	{
		return betType;
	}
	//getter for the bet value
	public String getBetValue()
	{
		return betValue;
	}
}
