/************************************************************************
*Alexander Kolberg      akolberg@cnm.edu        Program 6
* Card.java
* 
* Represents data for one playing card
 */
package field.p6_java;

public class Card{

    private String suit = " ";
    private String imageName =" ";
    private String location = "Deck";
    private int rank = 0;


    // Default Constructor
    public Card(){
    }

    // Overloaded Constructor
    public Card(int rank, String suit){
            this.rank=rank;
            this.suit=suit;
    }

    // Setters
    public void setSuit(String suit){
            this.suit=suit;
    }

    public void setRank(int rank){
            this.rank=rank;
    }

    public void setImageName(String name){
            this.imageName=name;
    }

    public void setLocation(String location){
            this.location=location;
    }

    // Getters
    public String getImageName(){
            return(this.imageName);
    }

    public int getRank(){
            return(this.rank);
    }

    public String getSuit(){
            return(this.suit);
    }

    public String getLocation(){
            return(this.location);
    } 
    
} // End CardDeck Class
