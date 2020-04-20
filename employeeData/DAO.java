//PartB Given the information about employees of an organization, develop a small java application, using JDBC.

package employeeData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	
	public int insertemp(Employee e)			          //Insert new employee from console to db.
	{
		int r=0;
		Connection conn=new DBConnection().getDBconnection();	  //Establish the connection with db.
		try 							  //Check for the connection if not established print the error path.
		{
			PreparedStatement pst=conn.prepareStatement("insert into employee values(?,?,?,?)");
			pst.setString(1, e.getName());
			pst.setInt(2, e.getAge());
			pst.setString(3, e.getDept());
			pst.setDouble(4, e.getSal());
			r=pst.executeUpdate();
		} 
		catch (SQLException e1) 
		{
			e1.printStackTrace();
		}
		return r;
	}
	
	
	public int deleteemp(String emp)				 //Delete any employee information from console.
	{
		int s=0;
		Connection conn=new DBConnection().getDBconnection();	 //Connection establisment check.
		try 
		{
			PreparedStatement pst=conn.prepareStatement("delete from employee where name=?");
			pst.setString(1, emp);
			s=pst.executeUpdate();
		} 
		catch (SQLException e1)
		{	
			e1.printStackTrace();
		}
		return s;
	}
	
	public void displayname(String ename)				//Display the name of the employee.
	{
		Connection conn=new DBConnection().getDBconnection();
		try 
		{
				PreparedStatement pst = conn.prepareStatement("select * from employee where name=?");
				pst.setString(1, ename);
				ResultSet rs=pst.executeQuery();
				while(rs.next())
				{
					System.out.println("Name : " +rs.getString(1)+ "\t"+  "Age : " +rs.getInt(2)+ "\t"+ "Dept :" +rs.getString(3)+ "\t"+ "Salary :" +rs.getDouble(4));;
				}
		}
		catch (SQLException e) 
		{
				e.printStackTrace();
		}
	
	}
	
	public void displayall()			//Display all the data present in the table employee.
	{
		Connection conn=new DBConnection().getDBconnection();
		try 
		{	
			PreparedStatement pst=conn.prepareStatement("select * from employee");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				System.out.println("Name : " +rs.getString(1)+ "\t"+  "Age : " +rs.getInt(2)+"\t"+ "Dept :" +rs.getString(3)+"\t" + "Salary :" +rs.getDouble(4));;
			}
		} 
		catch (SQLException e1) 
		{
			e1.printStackTrace();
		}
	}

}
