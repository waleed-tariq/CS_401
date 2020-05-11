/*Login panel class
 * Waleed Tariq
 * Assignment 4
 * Creates a login panel and checks if the user exists and if the password is correct
 */


import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginPanel extends JPanel {
	
	//instance variables for all of the buttons, labels, panels, as well as classes and interfaces
	private JButton submitButton;
	private JLabel username, password, label1;
	private JTextField name;
	private JPasswordField pass;
	private JPanel panel3, largePanel, namePanel, passwordPanel;
	public RPList pl;
	public String name1;
	public char[] pass1;
	private RoulettePlayer p;
	private LoginInterface l;

	//constructor for login panel calling in RPList and the login interface
	public LoginPanel(RPList pl, LoginInterface L) {
		
		//assigning the instance variable to the player list that is passed in
		this.pl=pl;
		
		//creating the large panel on which all of the information will be put in
		largePanel = new JPanel();
		//grid layout creating 4 rows for the login label, name panel, password panel, and the button
		largePanel.setLayout(new GridLayout(4,1));
		
		//panel for the label
		label1 = new JLabel("Please login to the site");
		largePanel.add(label1);
		
	
		//panel for the name label as well as the text field
		namePanel = new JPanel();
		namePanel.setLayout(new GridLayout(2,1));
		
		username = new JLabel("Username:");
		namePanel.add(username);
		
		name = new JTextField(20);
		namePanel.add(name);
		
		//panel for the password label as well as the password field
		passwordPanel = new JPanel();
		passwordPanel.setLayout(new GridLayout(2,1));

		password = new JLabel("Password:");
		passwordPanel.add(password);
		
		pass = new JPasswordField(20);
		passwordPanel.add(pass);
		
		//panel for the submit button
		panel3 = new JPanel();
		panel3.setLayout(new FlowLayout());
		submitButton = new JButton("Submit");
		panel3.add(submitButton);
		
		//handler for the submit button
		thehandler handler = new thehandler();
		submitButton.addActionListener(handler);
		
		//adding all the individual panels to the large panel
		largePanel.add(namePanel);
		largePanel.add(passwordPanel);
		largePanel.add(panel3);
		//adding the large panel to the extension
		this.add(largePanel);
		
		//setting the login interface equal to itself to pass it in
		l = L;
		
		
	}
	
	//class and method for the handler of the button
	private class thehandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			//if statement for when the submit button is clicked
			if (e.getSource() == submitButton) {
				//getting the information from the text and password fields
				name1 = name.getText();
				pass1 = pass.getPassword();
				String passString = new String(pass1);
				//setting the player variables to current player entered
				p = pl.getPlayerPassword(name1, passString);
				//if statement checking if the username matches the password
				if (pl.checkId(name1) == true && p != null) {
					JOptionPane.showMessageDialog(null, "Correct id and correct password");
					l.setPlayer(p);
					
				}
				else if (pl.checkId(name1) == false) {
					JOptionPane.showMessageDialog(null, "id '" + name1 + "' not found");
				}
				else if (pl.checkId(name1) == true && p == null) {
					JOptionPane.showMessageDialog(null, "Wrong password for " + name1);
				}
				else if (pl.checkId(name1) == false && p == null) {
					JOptionPane.showMessageDialog(null, "Wrong id and Wrong Password");
				}
			}
			
			
		}
		
		
	}
	
	
	

}
