package javalab;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO 
{
	
	public int insertemp(Employee e)//method to insert employee details
	{
		int r=0;
		Connection conn=new DBConnection().getDBconnection();
		try 
		{
			PreparedStatement pst=conn.prepareStatement("insert into employee values(?,?,?,?)");//accepts input parameters at runtime
			pst.setString(1, e.getName());//Sets the designated parameter to the given Java String value
			pst.setInt(2, e.getAge());//Sets the designated parameter to the given Java int value
			pst.setString(3, e.getDept());//Sets the designated parameter to the given Java String value
			pst.setDouble(4, e.getSal());//Sets the designated parameter to the given Java double value
			r=pst.executeUpdate();//Executes the SQL statement

		} 
		catch (SQLException e1) 
		{
			e1.printStackTrace();
		}
		return r;
	}
	
	public int deleteemp(String emp)//method to delete specific employee details
	{
		int s=0;
		Connection conn=new DBConnection().getDBconnection();
		try 
		{
			PreparedStatement pst=conn.prepareStatement("delete from employee where name=?");//accepts parameters to delete details
			pst.setString(1, emp);//Sets the designated parameter to the given Java String value
			s=pst.executeUpdate();//Executes the SQL statement
		} 
		catch (SQLException e1)
		{	
			e1.printStackTrace();
		}
		return s;
	}
	
	public void displayname(String ename)//method to display specific employee details
	{
		Connection conn=new DBConnection().getDBconnection();
		try 
		{
				PreparedStatement pst = conn.prepareStatement("select * from employee where name=?");//accepts parameters to display details
				pst.setString(1, ename);//Sets the designated parameter to the given Java String value
				ResultSet rs=pst.executeQuery();//refers to the row and column data contained in a ResultSet object.
				while(rs.next())
				{
					System.out.println("Name : " +rs.getString(1)+ "\t"+  "Age : " +rs.getInt(2)+ "\t"+ "Dept :" +rs.getString(3)+ "\t"+ "Salary :" +rs.getDouble(4));//displays details
				}
		}
		catch (SQLException e) 
		{
				e.printStackTrace();
		}
	
	}
	
	public void displayall()////method to display all employee details
	{
		Connection conn=new DBConnection().getDBconnection();
		try 
		{	
			PreparedStatement pst=conn.prepareStatement("select * from employee");
			ResultSet rs=pst.executeQuery();//refers to the row and column data contained in a ResultSet object.
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

