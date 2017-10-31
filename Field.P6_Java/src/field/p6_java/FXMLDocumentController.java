/************************************************************************
*Alix Field      afield@cnm.edu        Program 6
* FXMLDocumentController.java Class (I also Designed the FormXML)
* 
* Interacts with the user and provides logic for the game
 ************************************************************************/
package field.p6_java;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


public class FXMLDocumentController implements Initializable {
    
    // FXML Variable List  
    @FXML
    private AnchorPane BaseAnchorPane;
    @FXML
    private VBox VBox;
    @FXML
    private HBox studentRulesHeaderHBox;
    @FXML
    private Label studentHeaderLabel;
    @FXML
    private MenuBar showRulesMenuBar;
    @FXML
    private Menu mentabShowRules;
    @FXML
    private TextArea gameRulesTxtArea;
    @FXML
    private SplitPane playerAreasSptPane;
    @FXML
    private AnchorPane p1_AncrPane1;
    @FXML
    private SplitPane p1_SptPane;
    @FXML
    private AnchorPane p1_AncrPane2;
    @FXML
    private TextField p1Name_TxtField;
    @FXML
    private AnchorPane p1_AncrPane3;
    @FXML
    private HBox pl1_HBOX;
    @FXML
    private ImageView p1_ImgView1;
    @FXML
    private ImageView p1_ImgView2;
    @FXML
    private ImageView p1_ImgView3;
    @FXML
    private Button btnDealCards;
    @FXML
    private AnchorPane p2_AncrPane1;
    @FXML
    private SplitPane p2_SptPane;
    @FXML
    private AnchorPane p2_AncrPane2;
    @FXML
    private TextField p2Name_TxtField;
    @FXML
    private AnchorPane p2_AncrPane3;
    @FXML
    private HBox p2_HBox;
    @FXML
    private ImageView p2_ImgView1;
    @FXML
    private ImageView p2_ImgView2;
    @FXML
    private ImageView p2_ImgView3;
    @FXML
    private Button btnShowWinner;
    @FXML
    private MenuItem showRulesMenuItem;
    
    // Private Class Declerations
    private  Card playerOneCards[] = new Card[3];
    private Card playerTwoCards[] = new Card[3];
    private CardDeck deck = new CardDeck();
    private  Three_Card_Brag brag = new Three_Card_Brag();
    
    // Private Variable List
    private String playerOneName;
    private String playerTwoName;
    
    private int handsDealt = 0;


   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
        // Shuffle the Cards
        // ---------------------------
        deck.shuffle();
        
        // Draw the Top 3 Cards for Each Player
        // -------------------------------------------------------              
        deck.getNextCard();
        for(int x= 0; x< 3; x++)
        {
            playerOneCards[x] = deck.getNextCard();
            playerTwoCards[x] = deck.getNextCard();
        }     
        
        setCardImages(true);
    }   
    
    @FXML
    private void itemShowRulesPressed(ActionEvent event) {
     gameRulesTxtArea.setText(brag.getRules());
    }
    
    @FXML
    private void btnDealCardsPressed(ActionEvent event) {

            if(handsDealt < 8){
                dealTheCards();
                handsDealt++;
            } else {
                btnDealCards.setDisable(true);
            }
    }

    @FXML
    private void btnShowWinnerPressed(ActionEvent event) {             
        determineWinner();        
    }
    
    // FXMLDocController Private Methods
    private void dealTheCards(){
        setCardImages(false);
    }
    
    private void setCardImages(boolean isFaceDown){        
        // Player One Card Images
        ArrayList<ImageView> playerOneCardViews = new ArrayList<ImageView>();
        playerOneCardViews.add(p1_ImgView1);
        playerOneCardViews.add(p1_ImgView2);
        playerOneCardViews.add(p1_ImgView3);
        
        // Player Two Card Images
        ArrayList<ImageView> playerTwoCardViews = new ArrayList<ImageView>();
        playerTwoCardViews.add(p2_ImgView1);
        playerTwoCardViews.add(p2_ImgView2);
        playerTwoCardViews.add(p2_ImgView3);
        
        // Setting Images Views Face Down
        if(isFaceDown){
            Image faceDown = new Image(getClass().getResource("/resources/cards/b1fv.png").toString());
            for(ImageView view : playerOneCardViews){
                view.setImage(faceDown);
             }
            for(ImageView view : playerTwoCardViews){
                view.setImage(faceDown);
            }            
        }
        // Flips Cards Arround
        else{
            Image cardImage; 
            int currentCard = 0;
            for(ImageView view : playerOneCardViews){
                Card card = playerOneCards[currentCard];
                cardImage = new Image(getClass().getResource("/resources/cards/" + card.getImageName()).toString());
                view.setImage(cardImage);
                currentCard++;
             }
            currentCard = 0;
            for(ImageView view : playerTwoCardViews){                
                Card card = playerTwoCards[currentCard];
                cardImage = new Image(getClass().getResource("/resources/cards/" + card.getImageName()).toString());
                view.setImage(cardImage);
                currentCard++;
            }   
        }     
    }      

    private void determineWinner(){
            brag.setPlayersHands(playerOneCards, playerTwoCards);
            int winner = brag.getWinningHand();
            
            
        switch (winner) {
            case 0:
                p1Name_TxtField.setText("TIED");
                p2Name_TxtField.setText("TIED");
                p1Name_TxtField.setFont(new Font(24));
                p2Name_TxtField.setFont(new Font(24));
                break;
            case 1:
                p1Name_TxtField.setText("!!! WINNER !!!");
                p1Name_TxtField.setFont(new Font(24));
                break;
            default:
                p2Name_TxtField.setText("!!! WINNER !!!");
                p2Name_TxtField.setFont(new Font(24));
                break;
        }
    }                

} // End FXMLDocCont(); Class
