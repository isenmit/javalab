5)Given the information about employees of an organization, develop a small java application, using JDBC.

EmpName	Age	Dept	Salary
DEF	     25	ISE	    50000
ABC	     30	ISE	    55000
JDBConnection.java

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection 
{
	public Connection getDBconnection()
	{
		Connection conn=null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Registered successfully");
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		try 
		{
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/EMP","root","");
			System.out.println("Connection successfull\n");
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}	
		return conn;		
	}
}

Employee.java

public class Employee 
{
	String name;
	int age;
	String dept;
	double sal;
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public int getAge() 
	{
		return age;
	}
	public void setAge(int age) 
	{
		this.age = age;
	}
	public String getDept() 
	{
		return dept;
	}
	public void setDept(String dept) 
	{
		this.dept = dept;
	}
	public double getSal() 
	{
		return sal;
	}
	public void setSal(double sal) 
	{
		this.sal = sal;
	}
}

DAO.java


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO 
{
	
	public int insertemp(Employee e)
	{
		int r=0;
		Connection conn=new DBConnection().getDBconnection();
		try 
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
	
	public int deleteemp(String emp)
	{
		int s=0;
		Connection conn=new DBConnection().getDBconnection();
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
	
	public void displayname(String ename)
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
	
	public void displayall()
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


FinalDBProgram.java

import java.util.Scanner;

public class FinalDBProgram 
{
	public static void main(String[] args) 
	{
		for( ; ; )
		{
			Scanner in=new Scanner(System.in);
			System.out.println("\n 1. Insert Emp \n 2. Delete Emp \n 3. Display Acc to Name \n 4. Display All \n 5. Exit \n");
			System.out.println("Enter your choice");
			int n=in.nextInt();
			
			Employee e=new Employee();
			DAO d=new DAO();
			
			switch(n)
			{
			case 1:
					System.out.println("Enter the Employee Name : ");
					e.setName(in.next());
					System.out.println("Enter the Age : ");
					e.setAge(in.nextInt());
					System.out.println("Enter the Dept : ");
					e.setDept(in.next());
					System.out.println("Enter the Salary : ");
					e.setSal(in.nextDouble());
					d.insertemp(e);
					System.out.println("Employee added successfully");
					break;
			case 2:
					System.out.println("Enter the employee name : ");
					String Newname=in.next();
					d.deleteemp(Newname);
					System.out.println("Employee deleeted successfully");
					break;
			case 3:System.out.println("Enter the Employee name to display its attributes : ");
					String ename=in.next();
					System.out.println("Employee details...");
					d.displayname(ename);		
					break;
			case 4:System.out.println("Employee deatils are as follows...");
					d.displayall();
					break;
			case 5:System.exit(0);
					break;
					default:
						System.out.println("Please Choose Valid option \n");
						break;
			}
		}
	}
}

Output:

1. Insert Emp 
 2. Delete Emp 
 3. Display Acc to Name 
 4. Display All 
 5. Exit 

Enter your choice
4
Employee deatils are as follows...
Registered successfully
Connection successfull

Name : rajesh	Age : 20	Dept :ISE	Salary :25000.0
Name : uttam	Age : 21	Dept :ISE	Salary :30000.0

 1. Insert Emp 
 2. Delete Emp 
 3. Display Acc to Name 
 4. Display All 
 5. Exit 

Enter your choice
1
Enter the Employee Name : 
Dhiraj
Enter the Age : 
22
Enter the Dept : 
CSE
Enter the Salary : 
26000
Registered successfully
Connection successfull

Employee added successfully

 1. Insert Emp 
 2. Delete Emp 
 3. Display Acc to Name 
 4. Display All 
 5. Exit 

Enter your choice
4
Employee deatils are as follows...
Registered successfully
Connection successfull

Name : rajesh	Age : 20	Dept :ISE	Salary :25000.0
Name : uttam	Age : 21	Dept :ISE	Salary :30000.0
Name : Dhiraj	Age : 22	Dept :CSE	Salary :26000.0


 

 1. Insert Emp 
 2. Delete Emp 
 3. Display Acc to Name 
 4. Display All 
 5. Exit 

Enter your choice
3
Enter the Employee name to display its attributes : 
Abc
Employee details...
Registered successfully
Connection successfull

Name : rajesh	Age : 20	Dept :ISE	Salary :25000.0

 1. Insert Emp 
 2. Delete Emp 
 3. Display Acc to Name 
 4. Display All 
 5. Exit 

Enter your choice
2
Enter the employee name : 
uttam
Registered successfully
Connection successfull

Employee deleeted successfully

 1. Insert Emp 
 2. Delete Emp 
 3. Display Acc to Name 
 4. Display All 
 5. Exit 

Enter your choice
4
Employee deatils are as follows...
Registered successfully
Connection successfull

Name : rajesh	Age : 20	Dept :ISE	Salary :30000.0
Name : Dhiraj	Age : 22	Dept :CSE	Salary :26000.0


 

 1. Insert Emp 
 2. Delete Emp 
 3. Display Acc to Name 
 4. Display All 
 5. Exit 

Enter your choice
5

			