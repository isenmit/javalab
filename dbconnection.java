
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbconnection
{
	public Connection getDBconnection()
	{
		Connection conn=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");			//specifies the driver
			System.out.println("Registered successfully");
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		try
		{
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/java","Fazal","Fazal@207");	//database name, user name,password
			System.out.println("Connection successfull\n");	//displayed if connection happens successfully
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return conn;
	}
}
