import java.io.*;
import java.util.*;
public class RPList {
	
	 private RoulettePlayer [] plist;
	 private int size;
	 private String fileName;
	 private Scanner y;

	 public RPList(String x) {
		 fileName = x;
		 try {
			 y = new Scanner(new File(x));
		 }
		 catch (Exception e) {
			 System.out.println("not found");
		 }
		 
		 createArray();
		 
	//	 System.out.println(line1[0]);
		 
	 }
	 
	 public void createArray() {
		 String a = null;
		 String b = null;
		
		
		 String line1[] = new String[8];
		 
		 

		 
		 a = (y.nextLine());
		 size = Integer.parseInt(a);
		 plist = new RoulettePlayer[size];

		 int i=0;
		 
		 while (y.hasNext()) {	
			 
			b = y.nextLine();
			line1 = b.split(",");
			plist[i] = new RoulettePlayer(line1[0],line1[1], Double.parseDouble(line1[2]),Double.parseDouble(line1[3]));
			
			
			Question[] quest = new Question[2];
		 
		 if (line1.length <= 4)
		 {
			 //System.out.println("No questions");
		 }
		 else {
			 quest[0] = new Question(line1[4],line1[5]);
			 quest[1] = new Question(line1[6],line1[7]);
			 plist[i].addQuestions(quest);
			 
		 }
			 i++;
		 }
	 }
	 
	 public String toString() {
		 StringBuilder p = new StringBuilder();
				 
		 p.append("Players:");

		 
		 for (int i=0;i<getASize();i++)
		 { 
		 p.append("\t" + plist[i].toString());
		 
		 }		
		 return p.toString();
	 }
	 
	 
	public int getSize() {
		
			 return size;
	 }
	 
	 public int getASize() {
		
		 
		 return size;
	 }
	 
	 public boolean checkId(String x) {

		 for (int i = 0; i < size; i++)
		 {
		 if ((x.equals(plist[i].getName()))) {
			 return true;
		 }
		 }
		 
		return false;
	 }
	 
	 public RoulettePlayer getPlayerPassword(String id, String pass) {
		 
		 //if statement checking if the id matches the password and then return the object that you find that has the attributes looking for
		 
		 for (int i = 0; i<size; i++)
		 {
		 if (id.equals(plist[i].getName()) && (pass.equals(plist[i].getPassword()))) {
			 return plist[i];
		 }
		 }
			 return null;
	 
	 }
	 
	 
	 
	public boolean add(RoulettePlayer p) {
		//size = getASize() *2;
		for (int i= 0; i<size; i++)
		{
		if (p.getName().equals(plist[i].getName())) {
			return false;
			}
		 
		}
		
		if (size == plist.length) {
			RoulettePlayer[] temp = new RoulettePlayer[size*2];
			for (int y = 0; y < size; y++) {
				temp[y] = plist[y];
			}
			//System.arraycopy(plist, 0, temp, 0, size);
			plist = temp;
			
		}
		plist[size] = p;
		size++;
		return true;
		
	}
	public String[] getQuestions(String name) {
		
		//RoulettePlayer[] temp = new RoulettePlayer[size];
		String[] ques = new String[2]; 
		//String [] ques = null;
		for (int i= 0; i<size; i++)
		{
		if (name.equals(plist[i].getName())) {
			//plist[i].getQuestions();
			//System.out.println("hello");
			ques = plist[i].getQuestions();
			
		}
		
		
		}
		return ques;
	}
	
	public String[] getAnswers(String name) {
		
		//RoulettePlayer[] temp = new RoulettePlayer[size];
		String [] ans = null;
		for (int i= 0; i<size; i++)
		{
		if (name.equals(plist[i].getName())) {
			//plist[i].getQuestions();
			//System.out.println("hello");
			ans = plist[i].getAnswers();
			break;
		}
		}
		return ans;
	}

	public void saveList() {
		try {
			PrintWriter fileOut = new PrintWriter(fileName);
			fileOut.println(size);
			for (int i = 0; i < size; i++)
			{
				fileOut.println(plist[i].saveString());
			}
			//System.out.println("hello");

			fileOut.close();
		}
		catch (IOException e) {
			
		}
		
	}
	
	public int updateWithNewPlayer(RoulettePlayer np) {
		for(int i =0; i< plist.length; i++) {
			if(np.getName().equals(plist[i].getName())) {
				plist[i] = np;
				return 0;
			}
		}
		return 1;
	}
	
	public RoulettePlayer getPlayerQuestions(String id, Question[] quest) {
		
		RoulettePlayer temp = null;
		for (int i = 0; i<size; i++)
		 {
		 if (id.equals(plist[i].getName())) {
			 temp = plist[i];
		 }
		 } 
		if (temp.matchQuestions(quest) == true){
			 return temp;	 
		}
		else {
			return null;
		}
		}
}
