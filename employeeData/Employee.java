//Part B Given the information about employees of an organization, develop a small java application, using JDBC.

package employeeData;

public class Employee {
	
	String name;			//Taking the details of the new employee from the user.
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
