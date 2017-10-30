/************************************************************************
*Alexander Kolberg      akolberg@cnm.edu        Program 6
* CardDeck.java
* 
* Represents the deck of playing cards
 */
package field.p6_java;

public class CardDeck{
    
    private Card[] cardArray = new Card[52];
    //make sure to keep track of cards dealt
    private boolean[] cardDealt = new boolean[52];
    private boolean dealt = true;
    private int deckIndex=0;
    private int cardCounter=0;
    private Card lastCardReturned;
	
    
    public CardDeck(){
        // load cards

        // Rank Counter
        int i = 2; 
        // Suit Counter
        int suit = 0;
        // Card Counter
        int cardIndex = 0;

        // System.out.println(this.cardArray[0].getSuit());

        // While Loops w/ Switch Cases: Looks at Card Suits and Ranks
        while(i<15){
            suit=0;
            while(suit<4){
                switch (suit){
                case 0:
                cardArray[cardIndex]= new Card(i, "Hearts");
                cardIndex++;
                suit++;
                break;
                case 1:
                cardArray[cardIndex]= new Card(i,"Spades");
                cardIndex++;
                suit++;
                break;
                case 2:
                cardArray[cardIndex]= new Card(i, "Clubs");
                cardIndex++;	
                suit++;			
                break;
                case 3:
                cardArray[cardIndex]= new Card(i, "Diamonds");
                cardIndex++;
                suit++;
                break;

                } //  Switch Cases

            i++;

            } // End Nested While Loop
        
    } // End While Loop

     //Card card = new Card();//figure out ranks
    //card.setRank(14)//ace of spades
    //figure out suits
    //card.setSuit();
    //figure out index in array
    //cardArray[index]=card;
            
} // End Card Deck


    public void shuffle(){

    //shuffles index
    
    } // End shuffle();


    public String drawTopCard(){
        // Local Variavles   
        String card = " ";
        int cardIndex = 0;

        // While Loop and If Else Statements: 
        while(cardIndex<52){
                if(cardArray[cardIndex].getLocation().equals("Deck")){
                        if(cardArray[cardIndex].getRank()<11){
                        card = cardArray[cardIndex].getRank()+ " of " +cardArray[cardIndex].getSuit();
                        cardArray[cardIndex].setLocation("Drawn");
                        cardIndex=52;
                        }
                        else if(cardArray[cardIndex].getRank()==11){
                                card = "Jack of " +cardArray[cardIndex].getSuit();
                                cardArray[cardIndex].setLocation("Drawn");
                                cardIndex=52;
                        }
                        else if(cardArray[cardIndex].getRank()==12){
                                card = "Queen of " +cardArray[cardIndex].getSuit();
                                cardArray[cardIndex].setLocation("Drawn");
                                cardIndex=52;
                        }
                        else if(cardArray[cardIndex].getRank()==11){
                                card = "King of " +cardArray[cardIndex].getSuit();
                                cardArray[cardIndex].setLocation("Drawn");
                                cardIndex=52;
                        }
                        else if(cardArray[cardIndex].getRank()==11){
                                card = "Ace of " +cardArray[cardIndex].getSuit();
                                cardArray[cardIndex].setLocation("Drawn");
                                cardIndex=52;
                        } // End Nested If Else Statements
                } // End If Statements

                cardIndex++;
             } // End While Loop

         return(card);
        } // End drawTopCard();    
} // End CardDeck Class