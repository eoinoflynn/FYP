/*
 * 
 * Code taken and adapted from https://www.youtube.com/watch?v=-3m2_wHWXf4
 * 
 */
package com.xadmin.usermanagement.dao;

import com.xadmin.usermanagement.bean.Application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//get parameter
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.*;



public class ApplicationDao {
    
    private String jdbcURL = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Eventide1";
    private String jdbcDriver = "com.mysql.jdbc.Driver"; 
    
    
       private static final String INSERT_APPLICATION_SQL = "INSERT INTO application" + "  (activity, location, payment, sdate, edate, length, dname, dbreed, dage, additional, name,userName,status,message) VALUES "
			+ " (?, ?, ?,?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?);";

	private static final String SELECT_APPLICATION_BY_ID = "select appid,activity,location,payment,sdate,edate,length,dname,dbreed,dage,additional,name,userName,status,message from application where appid =?";
	private static final String SELECT_ALL_APPLICATION = "select * from application";
	private static final String DELETE_APPLICATION_SQL = "delete from application where appid = ?;";
	private static final String UPDATE_APPLICATION_SQL = "update application set activity = ?,location= ?, payment =?,sdate =?,edate =?,length =?,dname =?,dbreed =?,dage =?,additional =?,name =?,userName =?,status =?,message =? where appid = ?;";

        
    public ApplicationDao() {
    }
    
    protected Connection getConnection(){
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
    
        public class ServletGetParameter extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
	}

}

    //insert opportunity
    public void insertApplication(Application application)throws SQLException {  
 
        		System.out.println(INSERT_APPLICATION_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_APPLICATION_SQL)) {
			preparedStatement.setString(1, application.getActivity());
			preparedStatement.setString(2, application.getLocation());
			preparedStatement.setString(3, application.getPayment());
                        preparedStatement.setString(4, application.getSdate());
                        preparedStatement.setString(5, application.getEdate());
                        preparedStatement.setString(6, application.getLength());
                        preparedStatement.setString(7, application.getDname());
                        preparedStatement.setString(8, application.getDbreed());
                        preparedStatement.setString(9, application.getDage());
                        preparedStatement.setString(10, application.getAdditional());
                        preparedStatement.setString(11, application.getName());
                        preparedStatement.setString(12, application.getUserName());
                        preparedStatement.setString(13, application.getStatus());
                        preparedStatement.setString(14, application.getMessage());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
    }

    //Select Opportunity by id
    public Application selectApplication(int appid) {
		Application application = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_APPLICATION_BY_ID);) {
			preparedStatement.setInt(1, appid);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String activity = rs.getString("activity");
				String location = rs.getString("location");
				String payment = rs.getString("payment");
                                String sdate = rs.getString("sdate");
                                String edate = rs.getString("edate");
                                String length = rs.getString("length");
                                String dname = rs.getString("dname");
                                String dbreed = rs.getString("dbreed");
                                String dage = rs.getString("dage");
                                String additional = rs.getString("additional");
                                String name = rs.getString("name");
                                String userName = rs.getString("userName");
                                String status = rs.getString("status");
                                String message = rs.getString("message");
				application = new Application(appid, activity, location, payment, sdate, edate, length, dname, dbreed, dage, additional,name,userName,status,message);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return application;
	}
    
        //select all opportunities
    public List<Application> selectAllApplication() {
        // using try-with-resources to avoid closing resources (boiler plate code)
		List<Application> application = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
                        
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_APPLICATION);) {
		// ----	 preparedStatement.setString(1, opportunity.getName());
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int appid = rs.getInt("appid");
				String activity = rs.getString("activity");
				String location = rs.getString("location");
				String payment = rs.getString("payment");
                                String sdate = rs.getString("sdate");
                                String edate = rs.getString("edate");
                                String length = rs.getString("length");
                                String dname = rs.getString("dname");
                                String dbreed = rs.getString("dbreed");
                                String dage = rs.getString("dage");
                                String additional = rs.getString("additional");
                                String name = rs.getString("name");
                                String userName = rs.getString("userName");
                                String status = rs.getString("status");
                                String message = rs.getString("message");
				application.add(new Application(appid, activity, location, payment, sdate, edate, length, dname, dbreed, dage, additional, name,userName,status,message));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return application;
    }
    
    //select all opportunities
    public List<Application> selectAllApplication(String owner) {
        // using try-with-resources to avoid closing resources (boiler plate code)
		List<Application> application = new ArrayList<>();
		// Step 1: Establishing a Connection
                String sta = "select * from application where name ='" + owner + "';";

		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
                        
			PreparedStatement preparedStatement = connection.prepareStatement(sta)) {
		// ----	 preparedStatement.setString(1, opportunity.getName());
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int appid = rs.getInt("appid");
				String activity = rs.getString("activity");
				String location = rs.getString("location");
				String payment = rs.getString("payment");
                                String sdate = rs.getString("sdate");
                                String edate = rs.getString("edate");
                                String length = rs.getString("length");
                                String dname = rs.getString("dname");
                                String dbreed = rs.getString("dbreed");
                                String dage = rs.getString("dage");
                                String additional = rs.getString("additional");
                                String name = rs.getString("name");
                                String userName = rs.getString("userName");
                                String status = rs.getString("status");
                                String message = rs.getString("message");
				application.add(new Application(appid, activity, location, payment, sdate, edate, length, dname, dbreed, dage, additional, name,userName,status,message));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return application;
    }
    
    //update opportunity
    public boolean updateApplication(Application application) throws SQLException {
      boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_APPLICATION_SQL);) {
			System.out.println("updated Application:"+statement); 
			statement.setString(1, application.getActivity());
			statement.setString(2, application.getLocation());
			statement.setString(3, application.getPayment());
                        statement.setString(4, application.getSdate());
                        statement.setString(5, application.getEdate());
                        statement.setString(6, application.getLength());
                        statement.setString(7, application.getDname());
                        statement.setString(8, application.getDbreed());
                        statement.setString(9, application.getDage());
                        statement.setString(10, application.getAdditional());
                        statement.setString(11, application.getName());
                        statement.setString(12, application.getUserName());
                        statement.setString(13, application.getStatus());
                        statement.setString(14, application.getMessage());
                        statement.setInt(15, application.getAppid());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
    
    //delete opportunity
    public boolean deleteApplication(int appid) throws SQLException {
        boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_APPLICATION_SQL);) {
			statement.setInt(1, appid);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
    }
    
        //select all opportunities
    public List<Application> selectAllApplicationUser(String user) {
        // using try-with-resources to avoid closing resources (boiler plate code)
		List<Application> application = new ArrayList<>();
		// Step 1: Establishing a Connection
                String sta = "select * from application where userName ='" + user + "';";

		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
                        
			PreparedStatement preparedStatement = connection.prepareStatement(sta)) {
		// ----	 preparedStatement.setString(1, opportunity.getName());
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int appid = rs.getInt("appid");
				String activity = rs.getString("activity");
				String location = rs.getString("location");
				String payment = rs.getString("payment");
                                String sdate = rs.getString("sdate");
                                String edate = rs.getString("edate");
                                String length = rs.getString("length");
                                String dname = rs.getString("dname");
                                String dbreed = rs.getString("dbreed");
                                String dage = rs.getString("dage");
                                String additional = rs.getString("additional");
                                String name = rs.getString("name");
                                String userName = rs.getString("userName");
                                String status = rs.getString("status");
                                String message = rs.getString("message");
				application.add(new Application(appid, activity, location, payment, sdate, edate, length, dname, dbreed, dage, additional, name,userName,status,message));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return application;
    }
    
        public List<Application> selectAllApplicationLocation(String user, String location2) {
        // using try-with-resources to avoid closing resources (boiler plate code)
		List<Application> application = new ArrayList<>();
		// Step 1: Establishing a Connection
                String sta = "select * from application where userName ='" + user + "' and location ='" + location2 + "';";
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
                        
			PreparedStatement preparedStatement = connection.prepareStatement(sta)) {
		// ----	 preparedStatement.setString(1, opportunity.getName());
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int appid = rs.getInt("appid");
				String activity = rs.getString("activity");
				String location = rs.getString("location");
				String payment = rs.getString("payment");
                                String sdate = rs.getString("sdate");
                                String edate = rs.getString("edate");
                                String length = rs.getString("length");
                                String dname = rs.getString("dname");
                                String dbreed = rs.getString("dbreed");
                                String dage = rs.getString("dage");
                                String additional = rs.getString("additional");
                                String name = rs.getString("name");
                                String userName = rs.getString("userName");
                                String status = rs.getString("status");
                                String message = rs.getString("message");
				application.add(new Application(appid, activity, location, payment, sdate, edate, length, dname, dbreed, dage, additional, name,userName,status,message));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return application;
    }
        
                public List<Application> selectAllApplicationLocationOwner(String owner, String location2) {
        // using try-with-resources to avoid closing resources (boiler plate code)
		List<Application> application = new ArrayList<>();
		// Step 1: Establishing a Connection
                String sta = "select * from application where name ='" + owner + "' and location ='" + location2 + "';";
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
                        
			PreparedStatement preparedStatement = connection.prepareStatement(sta)) {
		// ----	 preparedStatement.setString(1, opportunity.getName());
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int appid = rs.getInt("appid");
				String activity = rs.getString("activity");
				String location = rs.getString("location");
				String payment = rs.getString("payment");
                                String sdate = rs.getString("sdate");
                                String edate = rs.getString("edate");
                                String length = rs.getString("length");
                                String dname = rs.getString("dname");
                                String dbreed = rs.getString("dbreed");
                                String dage = rs.getString("dage");
                                String additional = rs.getString("additional");
                                String name = rs.getString("name");
                                String userName = rs.getString("userName");
                                String status = rs.getString("status");
                                String message = rs.getString("message");
				application.add(new Application(appid, activity, location, payment, sdate, edate, length, dname, dbreed, dage, additional, name,userName,status,message));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return application;
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
