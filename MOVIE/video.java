//Part B Design and implement a simple inventory central system for a small video rental store using constructors and Object List.

package javalab.movie;

public class video {
	String mName;
    boolean status;
    double rating;
    
	 public video(String mName, boolean status, double rating)   	//Take the movie details from the user.
	 {
		super();
		this.mName = mName;
		this.status = status;
		this.rating = rating;	
	 }
	public String getmName()			//Used to get the movie name the user has given.
	{
		return mName;
	}
	public void setmName(String mName) 		//Used to set the name of new movie that the user defines.
	{
		this.mName = mName;
	}
	public boolean isStatus()			//Get the status if the movie.
	{
		return status;
	}
	public void setStatus(boolean status) 		//Setting the status of the o=movie while entering about some new movie.
	{
		this.status = status;
	}
	public double getRating() 			//Get the rating of the movie that the user has defined.
	{
		return rating;
	}
	public double setRating(double rating) 		//Setting the rating of some new movie.
	{
		return this.rating = rating;
	} 

}
