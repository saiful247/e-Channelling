package net.labtest.usermanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.PreparedStatement;

import net.labtest.usermanagement.model.LabTest;

import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;

public class LabTestDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/labtest?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "12345";
	
	private static final String INSERT_LABTESTS_SQL = "INSERT INTO labtest.userlabtest" + "  (name, area, lab, email, phone) VALUES "
			+ " (?, ?, ?, ?, ?);";
	
	private static final String SELECT_LABTEST_BY_ID = "select id,name,area,lab,email,phone from labtest.userlabtest where id =?";
	private static final String SELECT_ALL_LABTEST = "select * from labtest.userlabtest";
	private static final String DELETE_LABTEST_SQL = "delete from labtest.userlabtest where id = ?;";
	private static final String UPDATE_LABTEST_SQL = "update labtest.userlabtest set name = ?,area= ?, lab =?, email =?, phone =? where id = ?;";
	
	
	//Encapsulation dataHiding:meth created as local so cant acces outside
	//Access control:  protected
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
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
	
	//create 
		//abstraction
	//The caller doesn't need to know how the LabTest object is stored in the database; it only interacts with the
	//object through its public interface (getter methods).
		public void insertLabTest(LabTest labtest) throws SQLException {
			try(Connection connection = getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(INSERT_LABTESTS_SQL)){
				preparedStatement.setString(1, labtest.getName());
				preparedStatement.setString(2, labtest.getArea());
				preparedStatement.setString(3, labtest.getLab());
				preparedStatement.setString(4, labtest.getEmail());
				preparedStatement.setString(5, labtest.getPhone());
				preparedStatement.executeUpdate();
						
			}catch (Exception e) {
				e.printStackTrace();
			}

		}
		//update
		
		//abstraction
		public boolean updateLabTest(LabTest labtest) throws SQLException {
			boolean rowUpdated;
			try (Connection connection = getConnection();
					PreparedStatement statement = connection.prepareStatement(UPDATE_LABTEST_SQL);) {
				statement.setString(1, labtest.getName());
				statement.setString(2, labtest.getArea());
				statement.setString(3, labtest.getLab());
				statement.setString(4, labtest.getEmail());
				statement.setString(5, labtest.getPhone());
				statement.setInt(6, labtest.getId());

				rowUpdated = statement.executeUpdate() > 0;
			}
			return rowUpdated;
		}
		
		
		//select user by id
		
		
		public LabTest selectLabTest(int id) {
			LabTest labtest = null;
			
			try (Connection connection = getConnection();
					
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LABTEST_BY_ID);) {
				preparedStatement.setInt(1, id);
				System.out.println(preparedStatement);
				
				ResultSet rs = preparedStatement.executeQuery();

				
				while (rs.next()) {
					String name = rs.getString("name");
					String area = rs.getString("area");
					String lab = rs.getString("lab");
					String email = rs.getString("email");
					String phone = rs.getString("phone");
					labtest = new LabTest(id, name, area, lab, email, phone);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return labtest;
		}
		
		//select all user
		//Collections: The method uses the List interface and ArrayList class from the Java Collections Framework
		public List<LabTest> selectAllLabTests() {
			List<LabTest> labtest = new ArrayList<>();
			
			try (Connection connection = getConnection();
					
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_LABTEST);) {
				System.out.println(preparedStatement);
				
				ResultSet rs = preparedStatement.executeQuery();

				
				while (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String area = rs.getString("area");
					String lab = rs.getString("lab");
					String email = rs.getString("email");
					String phone = rs.getString("phone");
					labtest.add(new LabTest(id, name, area, lab, email, phone));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return labtest;
		}
		
		
		//delete user
		
		public boolean deleteLabTest(int id) throws SQLException {
			boolean rowDeleted;
			try (Connection connection = getConnection();
					PreparedStatement statement = connection.prepareStatement(DELETE_LABTEST_SQL);) {
				statement.setInt(1, id);
				rowDeleted = statement.executeUpdate() > 0;
			}
			return rowDeleted;
		}
		
}
