2)Develop a Java program using Synchronized Threads,which demonstrates Producer Consumer concept.

MultiThreading.java

import java.util.Date;

public class MultiThreading implements Runnable 
{
	Thread t;
	static int[] a=new int[51];
	static int sum=0;

	MultiThreading(String name)
	{
		t=new Thread(this, name);
		System.out.println("childthread:"+t);
		t.start();	
	}
	
	public void run()
	{
		System.out.println(Thread.currentThread().getName());
		if(Thread.currentThread().getName().compareTo("one")==0)
		{
			for(int i=0;i<10;i++)
			{
				sum=sum+a[i];
				try 
				{
					Thread.sleep(1000);
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
			}
			System.out.println("Sum of 1-10 : " +sum);
		}	
			//total=total+sum;
	}
		else if(Thread.currentThread().getName().compareTo("two")==0)
		{
			for(int j=10;j<20;j++)
			{
				sum=sum+a[j];
				try
				{
					Thread.sleep(1000);
				}
				catch (InterruptedException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Sum of 10-20 : " +sum);
			}	
			//total=total+sum;
		}
		
		else if(Thread.currentThread().getName().compareTo("three")==0)
		{
			for(int k=20;k<30;k++)
			{
				sum=sum+a[k];
				try
				{
					Thread.sleep(1000);
				}
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
				System.out.println("Sum of 20-30 : " +sum);
			}	
			//total=total+sum;
		}
		
		else if(Thread.currentThread().getName().compareTo("four")==0)
		{
			for(int l=30;l<40;l++)
			{
				sum=sum+a[l];
				try{
					Thread.sleep(1000);
				}catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Sum of 30-40 : " +sum);
			}
			//total=total+sum;
		}
		
		else if(Thread.currentThread().getName().compareTo("five")==0)
		{
			for(int m=40;m<50;m++)
			{
				sum=sum+a[m];
				try
				{
					Thread.sleep(1000);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				System.out.println("Sum of 40-50 : " +sum);
				//total=total+sum;
			}	
			//System.out.println("Total sum is : " +total);
		}
	}
		
	public static void main(String[] args) 
	{
			for(int x=0;x<51;x++)
			{
				a[x]=x+1;
			}
			
		System.out.println(Thread.currentThread().getName());
		MultiThreading ob1=new MultiThreading("one");
		MultiThreading ob2=new MultiThreading("two");
		MultiThreading ob3=new MultiThreading("three");
		MultiThreading ob4=new MultiThreading("four");
		MultiThreading ob5=new MultiThreading("five");
		
		Date start=new Date();
		
		System.out.println("First Thread is Alive? : " +ob1.t.isAlive());
		System.out.println("Second Thread is Alive? : " +ob2.t.isAlive());
		System.out.println("Third Thread is Alive? : " +ob3.t.isAlive());
		System.out.println("Fourth Thread is Alive? : " +ob4.t.isAlive());
		System.out.println("Fivth Thread is Alive? : " +ob5.t.isAlive());
		

		try 
		{
			System.out.println("waiting for Threads to complete");
			ob1.t.join();
			ob2.t.join();
			ob3.t.join();
			ob4.t.join();
			ob5.t.join();
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Total sum is : " +sum);
		
		System.out.println("First Thread is Alive? :"+ob1.t.isAlive());
		System.out.println("Second Thread is Alive? :"+ob2.t.isAlive());
		System.out.println("Third Thread is Alive? :"+ob3.t.isAlive());
		System.out.println("Fourth Thread is Alive? :"+ob4.t.isAlive());
		System.out.println("Fivth Thread is Alive? :"+ob5.t.isAlive());
		
		System.out.println("Main thread is interupted ");
		
		Date end=new Date();
		long difference=end.getTime()-start.getTime();
		System.out.println("Whole process took "+difference/1000 +" " +"seconds");
		System.out.println("Mian thread is exiting");
	}
}
Output:

main
childthread:Thread[one,5,main]
childthread:Thread[two,5,main]
one
childthread:Thread[three,5,main]
two
childthread:Thread[four,5,main]
three
childthread:Thread[five,5,main]
four
First Thread is Alive? : true
Second Thread is Alive? : true
Third Thread is Alive? : true
Fourth Thread is Alive? : true
Fivth Thread is Alive? : true
waiting for Threads to complete
five
Sum of 1-10 : 105
Sum of 10-20 : 107
Sum of 20-30 : 119
Sum of 30-40 : 141
Sum of 40-50 : 173
Sum of 1-10 : 215
Sum of 10-20 : 218
Sum of 20-30 : 231
Sum of 30-40 : 254
Sum of 40-50 : 287
Sum of 1-10 : 330
Sum of 10-20 : 334
Sum of 20-30 : 348
Sum of 30-40 : 372
Sum of 40-50 : 406
Sum of 1-10 : 450
Sum of 10-20 : 455
Sum of 20-30 : 470
Sum of 30-40 : 495
Sum of 40-50 : 530
Sum of 1-10 : 575
Sum of 10-20 : 581
Sum of 20-30 : 597
Sum of 30-40 : 623
Sum of 40-50 : 659
Sum of 1-10 : 705
Sum of 10-20 : 712
Sum of 20-30 : 729
Sum of 30-40 : 756
Sum of 40-50 : 793
Sum of 1-10 : 840
Sum of 10-20 : 848
Sum of 20-30 : 866
Sum of 30-40 : 894
Sum of 40-50 : 932
Sum of 1-10 : 980
Sum of 10-20 : 989
Sum of 20-30 : 1008
Sum of 30-40 : 1037
Sum of 40-50 : 1076
Sum of 1-10 : 1125
Sum of 10-20 : 1135
Sum of 20-30 : 1155
Sum of 30-40 : 1185
Sum of 40-50 : 1225
Sum of 1-10 : 1275
Sum of 10-20 : 1275
Sum of 20-30 : 1275
Sum of 30-40 : 1275
Sum of 40-50 : 1275
Total sum is : 1275
First Thread is Alive? :false
Second Thread is Alive? :false
Third Thread is Alive? :false
Fourth Thread is Alive? :false
Fivth Thread is Alive? :false
Main thread is interupted 
Whole process took 10 seconds
Mian thread is exiting












