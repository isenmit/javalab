

1)	Develop a small java application, which accepts employee id from the command prompt and displays the details using arrays.

Emp No 	   Emp Name	   Department 	      Designation and Salary
Your may assume that the array is initialized with the following details
Emp No.	Emp Name	Join Date	Desig Code	Dept           Basic	HRA	     IT
100	     anwar	    01/04/2009	E	        R&D	           20000	8000	3000
101	     kaushar	23/08/2012	C        	PM	           30000	12000	9000
102	     ashraf	    12/11/2008	K	        Acct	       10000	8000	1000
103	     prabej	    29/01/2013	R	        Front Desk	   12000	6000	2000
104	     jahgir	    16/07/2005	M	        Engg	       50000	20000	20000
105	     alamgir	01/01/2000	E	        Manufacturing  23000	9000	4400
106	     aadil	    12/06/2006	C	        PM	           29000	12000	10000
Salary is calculated as Basic+HRA+DA-IT. (DA details are given in the Designation table) 
Designation details:
Designation Code	Designation	DA
e	Engineer	        20000
c	Consultant	        32000
k	Clerk	            12000
r	Receptionist	    15000
m	Manager	            40000
Use Switch-Case to print Designation in the output and to find the value of DA for a particular employee

Employee.java

import java.util.Date;
import java.util.Stack;

public class Employee 
{
	public static void main(String[] args)
	{
		System.out.println("Enter Valid Employee ID : \n");
		int[] EmpId={100,101,102,103,104,105,106};
		String[] EmpName={"anwar","kaushar","ashraf","prabej","jahgir","alamgir","aadil"};
		String[] JoinDate={"01/04/2009","23/08/2012","12/11/2008","29/01/2013","16/07/2005","01/01/2000","12/06/2006"};
		char[] DesigCode={'e','c','k','r','m','e','c'};
		String[] Department={"R&D","PM","Acct","Front Desk","Engg","Manufacturing","PM"};
		double[] Basic={20000,30000,10000,12000,50000,23000,29000};
		double[] HRA={8000,12000,8000,6000,20000,9000,12000};
		double[] IT={3000,9000,1000,2000,20000,4400,10000};
		char[] DesignationCode={'e','c','k','r','m'};
		String[] Designation={"Engineer","Consultant","Clerk","Receptionist","Manager"};
		double[] DA={20000,32000,12000,15000,40000};
		int flag=0;
		int id=Integer.parseInt(args[0]);
		
		for(int i=0;i<EmpId.length;i++)
		{
			if(EmpId[i]==id)
			{
				flag=1;
				System.out.println("Emp Id.	 Emp Name	Department	Designation	   DA");
				System.out.print(EmpId[i]+" 	  "+EmpName[i]+" 		"+Department[i]);
				for(int j=0;j<DesignationCode.length;j++)
				{
					if(DesigCode[i]==DesignationCode[j])
					{	System.out.print(" 		"+Designation[j]+" 	");
						double sum=Basic[i]+HRA[i]+DA[j]-IT[i];
						System.out.print(sum);
					}
				}		
			}	
		}
		if(flag==0)
			System.out.println("There is no employee with EmpId : " +id);
	}
}
Output:

Enter Valid Employee ID : 

Emp Id.	  Emp Name		Department		Designation	 	    DA
 101 	  kaushar		PM 			    Consultant 	    	65000.00



