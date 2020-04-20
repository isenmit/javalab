
import java.util.Date;

public class multithreading implements Runnable
{
	Thread t;
	static int[] a=new int[51];
	static int sum=0;

	multithreading(String name)
	{
		t=new Thread(this, name);
		System.out.println("childthread:"+t);
		t.start();
	}

	public void run()
	{
		System.out.println(Thread.currentThread().getName());
		if(Thread.currentThread().getName().compareTo("one")==0)		//comparing threads
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

	}
		else if(Thread.currentThread().getName().compareTo("two")==0)			//comparing threads
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

		}

		else if(Thread.currentThread().getName().compareTo("three")==0)			//comparing threads
		{
			for(int k=20;k<30;k++)
			{
				sum=sum+a[k];
				try
				{
					Thread.sleep(1000);				//thread is suspended from execution for a certain period
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				System.out.println("Sum of 20-30 : " +sum);
			}

		}

		else if(Thread.currentThread().getName().compareTo("four")==0)		//comparing threads
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

		}

		else if(Thread.currentThread().getName().compareTo("five")==0)		//comparing threads
		{
			for(int m=40;m<50;m++)
			{
				sum=sum+a[m];
				try
				{
					Thread.sleep(1000);				//thread is suspended from execution for certain period
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				System.out.println("Sum of 40-50 : " +sum);

			}

		}
	}

	public static void main(String[] args)
	{
			for(int x=0;x<51;x++)
			{
				a[x]=x+1;
			}

		System.out.println(Thread.currentThread().getName());
		multithreading ob1=new multithreading("one");				//creating objects of multithreading class
		multithreading ob2=new multithreading("two");
		multithreading ob3=new multithreading("three");
		multithreading ob4=new multithreading("four");
		multithreading ob5=new multithreading("five");

		Date start=new Date();

		System.out.println("First Thread is Alive? : " +ob1.t.isAlive());		//prints the status of thread
		System.out.println("Second Thread is Alive? : " +ob2.t.isAlive());
		System.out.println("Third Thread is Alive? : " +ob3.t.isAlive());
		System.out.println("Fourth Thread is Alive? : " +ob4.t.isAlive());
		System.out.println("Fivth Thread is Alive? : " +ob5.t.isAlive());


		try
		{
			System.out.println("waiting for Threads to complete");			//waiting for completion of execution
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
		System.out.println("Whole process took "+difference/1000 +" " +"seconds");		//prints the time taken for completion of whole process
		System.out.println("Main thread is exiting");									//main thread then exits from process.
	}
}
