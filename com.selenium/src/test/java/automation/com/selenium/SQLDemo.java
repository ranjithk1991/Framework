package automation.com.selenium;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;


public class SQLDemo {

	@Test
	public static void sqlDemoTest() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pytest", "root", "ranjith");
		Statement stmt=connection.createStatement();
		ResultSet rSet = stmt.executeQuery("select * from student");
		
		while(rSet.next())
		{
			String col1=rSet.getString("Name");
			System.out.println(col1);
		}
	}
}
