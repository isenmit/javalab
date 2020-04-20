import  java.util.Scanner;
import java.util.ArrayList;


public class video{
  public static class movie{
    String name ;
    int duration , rating , price , quantity;
    movie(String n , int d , int r , int p , int q){
      name = n ; duration = d ; rating = r ; price =  p; quantity= q;
    }
  }

  //main
  public static void main(String[] args) {
    ArrayList<movie> movies = new ArrayList<movie>();
    Scanner input = new Scanner(System.in);
    while(true){
      System.out.println("Enter 1 To add Movie to store  \n Enter 2 to Borrow a movie \n Enter 3 to return a movie \n Enter your choice : ");
      int choice = input.nextInt();
      switch(choice){
        case 1 : {
            System.out.println("Enter movie name :");
            String n = input.next();
            System.out.println("Enter Duration , rating , price and quantity respectively :");
            int d = input.nextInt() ; int r = input.nextInt() ; int  p = input.nextInt() ; int q = input.nextInt();
            movie temp = new movie(n,d,r,p,q);
            movies.add(temp);
            break;
        }
        case 2 :{
            for(int i = 0 ; i < movies.size() ; i++){
              System.out.println(movies.get(i).name+" "+movies.get(i).quantity);
            }
            System.out.println("Enter the name of movie from list above : ");
            String n = input.next();
            for(int i = 0 ; i < movies.size() ; i++){
              if(n.compareTo(movies.get(i).name) == 0 ){
                if(movies.get(i).quantity == 0){
                  System.out.println("Not Available");
                }
                else{
                  movies.get(i).quantity -=1;
                  System.out.println("Rented | Please pay "+movies.get(i).price+" at the counter");
                }
                break;
              }
            }
            break;
        }
        case 3 :{
            for(int i = 0 ; i < movies.size() ; i++){
              System.out.println(movies.get(i).name);
            }
            System.out.println("Enter the name of movie from list above : ");
            String n = input.next();
            for(int i = 0 ; i < movies.size() ; i++){
              if(n.compareTo(movies.get(i).name) == 0 ){

                  movies.get(i).quantity +=1;
                  System.out.println("Returned | Please Collect "+(movies.get(i).price-movies.get(i).price*0.3)+" at the counter");
                break;
              }
            }
            break;
        }
      }
    }

  }
}
