//package com.rit.todolist.dao;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//import com.rit.todolist.bo.User;
//
//public class LoginDAO {
//
//	private Connection connect = null;
//	private PreparedStatement preparedStatement = null;
//	private ResultSet resultSet = null;
//	private Statement statement = null;
//
//	// You need to close the resultSet
//	private void close() {
//		try {
//			if (resultSet != null) {
//				resultSet.close();
//			}
//
//			if (statement != null) {
//				statement.close();
//			}
//
//			if (connect != null) {
//				connect.close();
//			}
//		} catch (Exception e) {
//
//		}
//	}
//
//	public Object login(String username, String password) {
//		User user = null;
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//
//			// Setup the connection with the DB
//			connect = DriverManager.getConnection("jdbc:mysql://localhost/bookstore?"
//					+ "user=root&password=pavan");
//
//			preparedStatement = connect
//					.prepareStatement("SELECT * from userinfo where username=?");
//			preparedStatement.setString(1, username);
//			resultSet = preparedStatement.executeQuery();
//			
//			if (resultSet.next() && password.equals("rahul")) {
//
//				user = new User();
//				user.setUsername(resultSet.getString("username"));
//				user.setPassword(resultSet.getString("password"));
//				user.setId("");
//				return user;
//			} else {
//				return null;
//			}
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//			return null;
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return null;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		} finally {
//			close();
//		}
//
//	}
//	
//	public void logout(String username){
//		
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//
//			// Setup the connection with the DB
//			connect = DriverManager.getConnection("jdbc:mysql://localhost/dem?"
//					+ "user=root&password=root");
//
//
//
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			close();
//		}
//
//	}
//
//	public static void main(String args[]) {
//		LoginDAO dao = new LoginDAO();
//
//		Object user = dao.login("rahul", "rahul");
//		User v_user = (User)user;
//		
//		if (user == null) {
//			System.out.println("Invalid username or password");
//		}else {
//			System.out.println("hello ");
//		}
//
//	}
//}
