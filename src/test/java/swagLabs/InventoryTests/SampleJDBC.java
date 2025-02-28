package swagLabs.InventoryTests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBC {

	@Test
	public void selectExecuteQuery() throws SQLException
	{
		Driver driverRef = new Driver();	//Database
		
		//Register Driver
		DriverManager.registerDriver(driverRef);
		
		//Get Connection with DB
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "Admin@Roopa");
		
		//Issue Create Statement
		Statement state = con.createStatement();
		
		//Execute a query
		ResultSet result = state.executeQuery("select * from customerinfo;");
		
		while(result.next())
		{
			System.out.println(result.getString(1)+"-"+result.getInt(2)+"-"+result.getString(3));
		}
		
		//Close DB
		con.close();
		System.out.println("Database closed");
		
	}
	
	@Test
	public void selectExecuteUpdate() throws SQLException
	{
		Driver driverRef = new Driver();	//Database
		
		//Register Driver
		DriverManager.registerDriver(driverRef);
		
		//Get Connection with DB
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "Admin@Roopa");
		
		//Issue Create Statement
		Statement state = con.createStatement();
		
		//Execute a query
		int result = state.executeUpdate("insert into customerinfo values('RatanTata',1,'Mumbai');");
		
		if(result == 1)
		{
			System.out.println("Data added");
		}
		
		
		//Close DB
		con.close();
		System.out.println("Database closed");
		
	}
	

}
