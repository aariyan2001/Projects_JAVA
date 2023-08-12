package com.AariyanSahu.chatapp.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class DashBoard extends JFrame {

	private JPanel contentPane;

	public DashBoard(String message) {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setBounds(100, 100, 705, 426);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu ChatMenu = new JMenu("Chat");
		menuBar.add(ChatMenu);
		
		JMenuItem StartChat = new JMenuItem("Start Chat");
		StartChat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new ClientChatScreen();
					
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		ChatMenu.add(StartChat);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setTitle(message);
		
		JLabel imagelb = new JLabel("");
		imagelb.setBackground(new Color(255, 255, 255));
		imagelb.setHorizontalAlignment(SwingConstants.CENTER);
		imagelb.setIcon(new ImageIcon("C:\\Users\\sahua\\OneDrive\\Desktop\\Chat_app\\MultiUserChatApp\\src\\Images\\OIP.jfif"));
		
		contentPane.add(imagelb, BorderLayout.CENTER);
	}

}
