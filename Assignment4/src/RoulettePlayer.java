/* Assignment 3 class that gives the players name 
 * his bet money
 * and is updated to allow user to borrow money and pay it back
 * Waleed Tariq
   COE 401 
// 11/11/18
// Assignment 3
// Main Class
 */
import java.util.*;

public class RoulettePlayer {
	
	//instance variables
	private String name;
	private double money;
	private String password;
	private double debt;

	private Question[] ques = new Question[2]; 
	
	//constructor
	public RoulettePlayer(String playerName, String playerPassword, double playerMoney, double playerDebt) {
		name = playerName;
		money = playerMoney;
		password = playerPassword;
		debt = playerDebt;
		
	}
	
	public RoulettePlayer(String playerName, String playerPassword) {
		name = playerName;
		password = playerPassword;
	}
	
	
	
	
	public void addQuestions(Question[] y) {
		this.ques = y;
		
		ques[0].getA();
		ques[0].getQ();
		ques[1].getA();
		ques[1].getQ();
	}
	
	public String [] getQuestions() {
		String[] quesOnly = new String[2];
		if (quesOnly[0] == null) {
			quesOnly[0] = ques[0].getQ();
			quesOnly[1] = ques[1].getQ();
			return quesOnly;
		}
		else {
			return null;
		}
	}
	
	public String [] getAnswers() {
		String[] ansOnly = new String[2];
		ansOnly[0] = ques[0].getA();
		ansOnly[1] = ques[1].getA();
		return ansOnly;
	}
	
	
	public boolean matchQuestions(Question [] quesArr) {
		if (quesArr.length == 2) {
			if ((quesArr[0].getA().equals(ques[0].getA()) && quesArr[1].getA().equals(ques[1].getA()))) {
				return true;
			}
			else
			{
				return false;
			}
		}
		else {
				return false;
			}
				
		}
	
	public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!RoulettePlayer.class.isAssignableFrom(obj.getClass())) {
            return false;
        }

        final RoulettePlayer other = (RoulettePlayer) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }

        if (this.password != other.password) {
            return false;
        }

        return true;
    }

	
	
	
	public double borrow(double x)
	{
		 debt = x + getDebt();
		 money = x + getMoney();
		
		return debt;
	}
	
	public double payBack(double y)
	{
		if (y <= debt && y <= money) {
			debt = getDebt() - y;
			money = getMoney() - y;
		}
		else if (y > getDebt()) {
			System.out.println("Amount: " + y + " is more than borrowed: " + getDebt() );
			double cool = y - getDebt();
			debt = cool - debt;
			money = getMoney() - cool;
			System.out.println("Only paying back: " + cool);
		}
		else if (y > getMoney()) {
			System.out.println("Amount: " + y + " is more than cash: " + getMoney() );
			double newCool = y - getMoney();
			money = newCool - getMoney();
			debt = getDebt() - newCool;
			System.out.println("Only paying back: " + newCool);
		}
		return debt;
		
	}
	public double getDebt()
	{
		return debt;
	}
	public void updateDebt(double delta) 
	{
		debt = getDebt() + delta;
	}
	public String getPassword() 
	{
		return password;
	}
	
	public void setPassword(String playerPassword)
	{
		this.password = playerPassword;
	}
	//getter for the name variable
	public String getName() 
	{
		return name;
	}
	

	//getter for the money variable
	public double getMoney() 
	{
		return money;
	}
	//to string method to set up the name and the cash in a neat way
	public String toString() 
	{
		StringBuilder b = new StringBuilder();
		b.append("\nName: " + name + " ");
		b.append("Cash: " + money + " ");
		b.append("Debt: " + debt + " ");
		return b.toString();
	}
	
public void showAllData(){
		
		if (ques[0] == null) {
			System.out.println("Name: " + name + "\n" + "Password: " + password + "\n" + "Cash: " + money + "\n" + "Debt: " + debt + "\n" + "Question: None");

		}
		else {
			System.out.println("Name: " + name + "\n" + "Password: " + password + "\n" + "Cash: " + money + "\n" + "Debt: " + debt + "\n" + "Q: " + ques[0].getQ() +
					" \t" + "A: " + ques[0].getA() + "\n" + "Q: " 
		+ ques[1].getQ() + "\t" + "A: " + ques[1].getA() );
			
		}

		}
	
	public String saveString()
	{
		StringBuilder p = new StringBuilder();
		if (ques[0] ==(null)) {
			p.append(name + "," + password + "," + money + "," + debt);

		}
		else {
		p.append(name + "," + password + "," + money + "," + debt + "," + ques[0].getQ() + "," + ques[0].getA() + "," + ques[1].getQ() + "," + ques[1].getA());
		}
		
		return p.toString();
	}
	
	//updates the money method
	public void updateMoney(double delta) 
	{
		money = getMoney() + delta;
	}
	// checks if the user has money method
	public boolean hasMoney() 
	{
		//double newMoney = money;
		if (money > 0) {
			return true;
		}
		else {
			return false;
		}
			
	}

	
	
}
