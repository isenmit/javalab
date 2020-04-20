package javalab;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class VideoMethods 
{
	List<Video> MovieList = new ArrayList<Video>();//create list
  public void AddMovies()//method to add movies into the list
  {  
	  Scanner in =new Scanner(System.in);
	  System.out.print("Enter the name of the movie:");
	  String mName=in.nextLine();
	  System.out.print("Enter the status of the movie(True/False):");
	  boolean status=in.nextBoolean();
	  System.out.print("Enter the ratings for the movie(0-5):");
	  double rating=in.nextDouble();
	  Video v= new Video(mName, status, rating);//calls constructor
	  MovieList.add(v);//inserts elements into list
	    System.out.println("Library Initialized");
  }
	  public void DisplayAll()//method to display list
	  {
		  if(MovieList.isEmpty())//checks if list is empty
		  {
			  System.out.println("No movies in the library");
		  }
		  for(Video m : MovieList)//Iterates through whole loop
		  {
			  System.out.println("Movie : " +m.getmName()+"  "+"Status : "+m.isStatus()+"  "+"Rating "+m.getRating());
		  }		
	  }
     
       boolean RentOut(String name)//method to rent movies
      {
    	  for(Video m :MovieList)
    	  {
    		  if(m.getmName().equalsIgnoreCase(name))//checks if movie name is in the list
    		  {
    			  if(m.isStatus())
    			  {
    				  m.setStatus(false);
    				  return true;
    			  }		  
    		  }
    		  return false;  
    	  }
		return false;	  
      }
       
      public void CollectIn(String name,double rat)//method to collect back rented movies
      {
    	  boolean flag=false;
    	  for(Video m :MovieList)
    	  {
    		  if(m.getmName().equalsIgnoreCase(name))//checks if movie name is in the list
    		  { 
    				  m.setStatus(true);
    				  flag=true;
    		          Math.round(m.setRating((m.getRating() + rat)/2)); 
    		  }
    	  }
    	  if(!flag)//movie name is not rented
    	  {
    		  System.out.println("Requested Movie not rented out");
    	  } 	  
      }
}
