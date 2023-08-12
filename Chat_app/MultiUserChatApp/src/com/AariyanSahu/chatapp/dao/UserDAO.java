package com.AariyanSahu.chatapp.dao;
//USER CRUD operation perform

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.AariyanSahu.chatapp.dto.UserDTO;
import com.AariyanSahu.chatapp.utils.Encryption;
import com.mysql.cj.protocol.Resultset;

public class UserDAO {
	
	public boolean isLogin(UserDTO userDTO) throws SQLException,ClassNotFoundException, Exception{
		Connection connection =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		final String sql = "select userid from users where userid=? and password=?";
		try {
			connection = commonDAO.createConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, userDTO.getUserId());
			String encrypted = Encryption.passwordencrypt(new String(userDTO.getPassword()));
			pstmt.setString(2, new String (encrypted));
			rs = pstmt.executeQuery();
			return rs.next();
			/*
			 * if(rs.next()) { return true; } else { return false; }
			 */
		} finally {
			if(rs!=null) {
				rs.close();				
			}
			if(pstmt!=null) {
				pstmt.close();				
			}
			if(connection!=null) {
				connection.close();				
			}
		} 
	}
	
	
	public int add(UserDTO userDTO) throws ClassNotFoundException, SQLException, Exception{
		System.out.println("Recieved: "+ userDTO.getUserId()+" "+userDTO.getPassword());
		Connection connection = null;
		Statement stmt = null;
		try { //Guarded reason
			connection = commonDAO.createConnection();  //connection created
			//Step 2 - Query
			stmt = connection.createStatement();
			int record = stmt.executeUpdate("insert into users (userid,password) values ('"+userDTO.getUserId()+"','"+Encryption.passwordencrypt(new String(userDTO.getPassword()))+"');");  //Insert , update or delete query
			return record;
		}
		finally {  //Always execute (not execute only when System.exit(0) is called)
			if(stmt!=null) {
				stmt.close(); //If open then close
			}
			if(connection!=null) {
				connection.close(); //If open then close
			}			
		}
		
		
	}
}
