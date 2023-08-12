package com.AariyanSahu.chatapp.views;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class UserView extends JFrame{
	int counter;
	public UserView() {
		counter=0;
		//To make window close on close operation
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		//Defining the size of window
		setSize(500, 400);
		
		//To make this window size fixed
		setResizable(false);  
		
		//To display title of the window
		setTitle("Login");
		
		//to make it pop up center of the screen
		setLocationRelativeTo(null); 
		//setLocation(500, 150);
		
		//Labeling (It gives us label to display on the screen) 
		JLabel welcome = new JLabel("Login");
		//Set the size and Font of the label 
		welcome.setFont(new Font("Arial",Font.BOLD,40));
		
		//getContentPane return a container inside which we added the label welcome and get showed in the window
		Container container = this.getContentPane();
		//we are making off the Containers default layout and set it to null
		container.setLayout(null);
		//now without layout where to arrange? so to make it layout as we want we use set bounds
		welcome.setBounds(150, 50, 150, 100);
		container.add(welcome);
		
		//Creating a button
		JButton button = new JButton("Count");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				counter++;
				welcome.setText("C - "+counter);
								
			}
		});
		button.setBounds(150, 200, 120, 40);
		container.add(button);
		
		//To make the window visible
		setVisible(true);   
		
	}
	
	public static void main(String[] args) {
		UserView userView = new UserView();
	}
}
