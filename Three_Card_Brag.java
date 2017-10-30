/************************************************************************
*Nathan Butcher      anathan@cnm.edu        Program 6
* Three_Card_Brag.java  Class
* 
* Determines either which player has the winning hand or if players are tied
 */

package field.p6_java;

public class Three_Card_Brag{

    private Card p1Cards[];
    private Card p2Cards[];
    private String rules;
    private int result;

    public Three_Card_Brag(){
            //create rules string;
    }
    public String getRules(){
            return(rules);
    }

    public int getWinningHand(){
            return(result);
    }

    private void whoWon(){
            //figure out which hand won
    }

    public void setPlayersHands(Card p1Hand[],Card p2Hand[]){
            //set values into class variables
            whoWon();
    } // End setPlayersHands
} // End Three_Card_Brag Class

    // Card and Deck Intitalization work
    // the getTopCard method returns a string of the next card in the deck
    //  Still needs to write a shuffle method that puts all the careds back in the deck  and randomizes their order
    //What other methods will you two need?
    // Just write me the method declaration line and I can do the rest (public void shuffle() for example)

