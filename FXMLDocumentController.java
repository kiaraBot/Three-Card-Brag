/************************************************************************
*Alix Field      afield@cnm.edu        Program 6
* FXMLDocumentController.java Class (I also Designed the FormXML)
* 
* Interacts with the user and provides logic for the game
 */
package field.p6_java;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class FXMLDocumentController implements Initializable {
    
    // FXML Variable List  
    @FXML
    private AnchorPane BaseAnchorPane;
    private VBox VBox;
    private HBox studentRulesHeaderHBox;
    private Label studentHeaderLabel;
    private MenuBar showRulesMenuBar;
    private Menu mentabShowRules;
    private TextArea gameRulesTxtArea;
    private SplitPane playerAreasSptPane;
    private AnchorPane p1_AncrPane1;
    private SplitPane p1_SptPane;
    private AnchorPane p1_AncrPane2;
    private TextField p1Name_TxtField;
    private AnchorPane p1_AncrPane3;
    private HBox pl1_HBOX;
    private ImageView p1_ImgView1;
    private ImageView p1_ImView2;
    private ImageView p1_ImView3;
    private Button btnDealCards;
    private AnchorPane p2_AncrPane1;
    private SplitPane p2_SptPane;
    private AnchorPane p2_AncrPane2;
    private TextField p2Name_TxtField;
    private AnchorPane p2_AncrPane3;
    private HBox p2_HBox;
    private ImageView p2_ImgView1;
    private ImageView p2_ImgView2;
    private ImageView p2_ImgView3;
    private Button btnShowWinner;
    
    // Private Class Declerations
    private  Card playerOneCards[] = new Card[3];
    private Card playerTwoCards[] = new Card[3];
    private CardDeck card = new CardDeck();
    private  Three_Card_Brag brag = new Three_Card_Brag();
    
    // Private Variable List
    private String playerOneName;
    private String playerTwoName;

   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO: 
//            Initialize cards face down
//            Cards are not flipped until the user presses Deal Cards
    }    

    @FXML
    private void btnDealCardsPressed(ActionEvent event) {
        // Can only be pressed a total of 8 times
            // When 8th hand is dealt disable this button
                
        dealTheCards();
    }

    @FXML
    private void btnShowWinnerPressed(ActionEvent event) {             
        determineWinner();        
        
        // Changes Player Text Fields to:
            // WINNER  or TIED(both player txtFields)
            // Font becomes larger
            // Label Changes Color
    }

    // FXMLDocController Private Methods
    private void dealTheCards(){
        String drawTopCard =  card.drawTopCard();

        int rank = 0;
        // Assign Top Cards into the Player Arrays  
        // Player One
        playerOneCards[0] = new Card(rank, drawTopCard);        // This is all wrong I know it. 
        playerOneCards[1] = new Card(rank, drawTopCard);
        playerOneCards[2] = new Card(rank, drawTopCard);
        // Player Two
        playerTwoCards[0] = new Card(rank, drawTopCard);
        playerTwoCards[1] = new Card(rank, drawTopCard);
        playerTwoCards[2] = new Card(rank, drawTopCard);       

        // Set Card Images not the image views? WTF does that mean?        
    }

    private void determineWinner(){
            brag.setPlayersHands(playerOneCards, playerTwoCards);
            int winner = brag.getWinningHand();
            
            // Display who won or if it is a draw
            
    } // End determinWhinner();
} // End FXMLDocCont(); Class
