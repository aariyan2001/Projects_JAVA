package com.AariyanSahu.chatapp.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.AariyanSahu.chatapp.network.Client;
import com.AariyanSahu.chatapp.utils.UserInfo;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class ClientChatScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea;
	private Client client;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
			ClientChatScreen frame = new ClientChatScreen();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
					
	}
	
	private void Sendit() {
		String message = textField.getText();
		try {
			client.sendMessage(UserInfo.USER_NAME+"-"+ message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public ClientChatScreen() throws UnknownHostException, IOException {
		textArea = new JTextArea();
		client = new Client(textArea);
		
		
		setTitle("ChitChat");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 526, 325);
		contentPane.add(scrollPane);
		
		
		textArea.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		textArea.setBounds(10, 10, 526, 284);
		scrollPane.setViewportView(textArea);
		
		textField = new JTextField();
		textField.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		textField.setBounds(10, 345, 439, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton Sendit = new JButton("Send ");
		Sendit.setFont(new Font("Times New Roman", Font.BOLD, 16));
		Sendit.setForeground(Color.BLACK);
		Sendit.setBackground(Color.GREEN);
		Sendit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sendit();
			}
		});
		Sendit.setBounds(455, 348, 81, 28);
		contentPane.add(Sendit);
		setVisible(true);
	}
}
