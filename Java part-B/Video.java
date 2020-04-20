package javalab;
public class Video
{
    String mName;//movie name
    boolean status;//status of return
    double rating;//movie rating
	 public Video(String mName, boolean status, double rating)//constructor
	 {
		super();
		this.mName = mName;//set movie name
		this.status = status;//set return status
		this.rating = rating;//set movie rating	
	 }
	public String getmName()
	{
		return mName;//returns movie name
	}
	public void setmName(String mName) 
	{
		this.mName = mName;//sets movie name
	}
	public boolean isStatus()
	{
		return status;//returns status
	}
	public void setStatus(boolean status) 
	{
		this.status = status;//sets status
	}
	public double getRating() 
	{
		return rating;//returns movie rating
	}
	public double setRating(double rating) 
	{
		return this.rating = rating;//sets movie rating
	}     
}
