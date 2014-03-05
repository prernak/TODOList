package com.rit.todolist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.rit.todolist.bo.Book;
import com.rit.todolist.bo.User;

public class BookDetailsDAO{

	private Connection connect = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	private Statement statement = null;

	// You need to close the resultSet
	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {

		}
	}

	public Object BookDetailsByTitle(String title) {
		Book m_book = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://localhost/bookstore?"
					+ "user=root&password=passowrd");

			preparedStatement = connect
					.prepareStatement("select title, price, name from book, author where book.authorid = author.id and book.title=?");
			preparedStatement.setString(1, title);
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {

		        m_book = new Book();
				m_book.setTitle(resultSet.getString("title"));
				m_book.setPrice(resultSet.getString("price"));
				m_book.setAuthName(resultSet.getString("name"));
				return m_book;
			} else {
				return null;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			close();
		}

	}
	
		public Object BookDetailsByAuthor(String author) {
		Book m_book = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://localhost/bookstore?"
					+ "user=root&password=password");

			preparedStatement = connect
					.prepareStatement("select title, price, name from book, author where book.authorid = author.id and name=?");
			preparedStatement.setString(1, author);
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {

				m_book = new Book();
				m_book.setTitle(resultSet.getString("title"));
				m_book.setPrice(resultSet.getString("price"));
				m_book.setAuthName(resultSet.getString("name"));
				return m_book;
			} else {
				return null;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			close();
		}

	}
	
	


	public static void main(String args[]) {
		
		BookDetailsDAO bdao = new BookDetailsDAO();
		
		Object m_book = bdao.BookDetailsByAuthor("xumin lu");
		
		Book v_book = (Book)m_book;

		
		
		if (m_book == null) {
			System.out.println("Book Not Found");
		}else {
			System.out.println(v_book.getTitle());
		}

	}
}
