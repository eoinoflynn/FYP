/*
 * 
 * Code taken and adapted from https://www.youtube.com/watch?v=-3m2_wHWXf4
 * 
 */
package com.xadmin.usermanagement.dao;

import com.xadmin.usermanagement.bean.User1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class User1Dao {
    private String jdbcURL = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Eventide1";
    private String jdbcDriver = "com.mysql.jdbc.Driver"; 
    
    private static final String INSERT_USER_SQL = "INSERT INTO user" + "  (name, pass) VALUES "
			+ " (?, ?);";

	private static final String SELECT_USER_BY_ID = "select userid,name,pass from user where userid =?";
	private static final String SELECT_ALL_USER = "select * from user";
	private static final String DELETE_USER_SQL = "delete from user where userid = ?;";
	private static final String UPDATE_USER_SQL = "update user set name = ?,pass= ? where userid = ?;";

    public User1Dao() {
        
    }
    
   protected Connection getConnection() {
 Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver"); //jdbcDriver
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection; 
    }
   
   public void insertUser(User1 user) throws SQLException {
    System.out.println(INSERT_USER_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL)) {
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getPass());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}   
   }

   public User1 selectUser(int userid){
       User1 user = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setInt(1, userid);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String name = rs.getString("name");
				String pass = rs.getString("pass");
				user = new User1(userid, name, pass);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return user;
   }
   
   public List<User1> selectAllUsers(){
     		// using try-with-resources to avoid closing resources (boiler plate code)
		List<User1> user = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USER);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int userid = rs.getInt("userid");
				String name = rs.getString("name");
				String pass = rs.getString("pass");
				user.add(new User1(userid, name, pass));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return user;  
   }
   
   public boolean updateUser(User1 user)  throws SQLException {
       boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USER_SQL);) {
			System.out.println("updated User:"+statement); //maybe User1
			statement.setString(1, user.getName());
			statement.setString(2, user.getPass());
			statement.setInt(3, user.getUserid());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
   }
   
   public boolean deleteUser(int userid) throws SQLException {
       boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USER_SQL);) {
			statement.setInt(1, userid);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
   }
       
   
   
   
   
   
   private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}


}

