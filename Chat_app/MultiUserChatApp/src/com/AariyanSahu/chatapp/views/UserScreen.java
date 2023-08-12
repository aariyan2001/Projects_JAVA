package com.AariyanSahu.chatapp.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import com.AariyanSahu.chatapp.dao.UserDAO;
import com.AariyanSahu.chatapp.dto.UserDTO;
import com.AariyanSahu.chatapp.utils.UserInfo;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Button;
import javax.swing.DropMode;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class UserScreen extends JFrame {
	private JTextField useridtextfld;
	private JPasswordField pwdtextfld;

	
	public static void main(String[] args) {		
		UserScreen window = new UserScreen();
	}
	UserDAO userDAO = new UserDAO();
	
	private void doLogin() {
		String userid  = useridtextfld.getText();
		char[] password = pwdtextfld.getPassword();		
		//Print password as classname@hashcode(Hexadecimal form)
		
		UserDTO userDTO = new UserDTO(userid, password);
		try {
			String message = "";
			if(userDAO.isLogin(userDTO)) {
				message = "Welcome" + userid;
				UserInfo.USER_NAME = userid;
				JOptionPane.showMessageDialog(this, "Welcome "+userid);
				setVisible(false);
				dispose();
				DashBoard dashboard = new DashBoard("Welcome "+userid);
				dashboard.setVisible(true);
			}
			else {
				JOptionPane.showMessageDialog(this, "Invalid Userid or Password");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void register() {
		String userid  = useridtextfld.getText();
		char[] password = pwdtextfld.getPassword();
		
		//Print password as classname@hashcode(Hexadecimal form)
		
		//UserDAO userDAO = new UserDAO();
		UserDTO userDTO = new UserDTO(userid, password);
		try {
			int result = userDAO.add(userDTO);
			if(result>0) {
				JOptionPane.showMessageDialog(this, "Register Succesfully");
				//System.out.println("Record added....");
			}
			else {
				JOptionPane.showMessageDialog(this, "Not Register, Fail!!");
				//System.out.println("Record Not added....");
			}
		}
		catch (ClassNotFoundException | SQLException ex) {
			// TODO: handle exception
			System.out.println("DB Issue");
			ex.printStackTrace();
		}
		
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Some Generic Exception Raised....");
			e.printStackTrace();  //Where is the exception
			
		}
		System.out.println("User Id: "+userid+" Password: "+password);
	}
	
	
	/**
	 * Create the application.
	 */
	public UserScreen() {
	
		setFont(new Font("Times New Roman", Font.PLAIN, 12));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Authentication ");
		
		
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		
		JLabel loginLbl = new JLabel("Login");
		loginLbl.setForeground(new Color(0, 51, 255));
		loginLbl.setFont(new Font("Arial", Font.BOLD, 30));
		loginLbl.setHorizontalAlignment(SwingConstants.CENTER);
		loginLbl.setBounds(211, 21, 138, 56);
		getContentPane().add(loginLbl);
		
		JLabel userIdLbl = new JLabel("UserId ");
		userIdLbl.setFont(new Font("Arial", Font.ITALIC, 18));
		userIdLbl.setHorizontalAlignment(SwingConstants.CENTER);
		userIdLbl.setBounds(98, 112, 84, 22);
		getContentPane().add(userIdLbl);
		
		useridtextfld = new JTextField();
		useridtextfld.setBounds(241, 115, 252, 22);
		getContentPane().add(useridtextfld);
		useridtextfld.setColumns(10);
		
		JLabel pwdLbl = new JLabel("Password");
		pwdLbl.setHorizontalAlignment(SwingConstants.CENTER);
		pwdLbl.setFont(new Font("Arial", Font.ITALIC, 18));
		pwdLbl.setBounds(86, 155, 96, 22);
		getContentPane().add(pwdLbl);
		
		pwdtextfld = new JPasswordField();
		pwdtextfld.setBounds(241, 158, 252, 22);
		getContentPane().add(pwdtextfld);
		
		JButton loginbt = new JButton("Login");
		loginbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doLogin();
			}
		});
		loginbt.setBackground(new Color(240, 255, 240));
		loginbt.setForeground(new Color(0, 204, 0));
		loginbt.setFont(new Font("Arial", Font.BOLD, 14));
		loginbt.setBounds(241, 229, 113, 31);
		getContentPane().add(loginbt);
		
		JButton registerbt = new JButton("Register");
		registerbt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				register();
			}
		});
		registerbt.setForeground(new Color(128, 0, 0));
		registerbt.setFont(new Font("Arial", Font.BOLD, 14));
		registerbt.setBackground(new Color(255, 250, 250));
		registerbt.setBounds(375, 229, 118, 31);
		getContentPane().add(registerbt);
		setSize(638, 341);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
