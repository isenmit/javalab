/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chethan
 */
public class Video {
    String mName;
    boolean status;
    double rating;
	public Video(String mName, boolean status, double rating) 
	{
            super();
            this.mName = mName;
            this.status = status;
            this.rating = rating;	
	 }
	public String getmName()
	{
            return mName;
	}
	public void setmName(String mName) 
	{
            this.mName = mName;
	}
	public boolean isStatus()
	{
            return status;
	}
	public void setStatus(boolean status) 
	{
            this.status = status;
	}
	public double getRating() 
	{
            return rating;
	}
	public double setRating(double rating) 
	{
            return this.rating = rating;
	} 
    
    
}
