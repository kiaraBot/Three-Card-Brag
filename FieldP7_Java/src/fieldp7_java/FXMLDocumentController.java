/**************************************************************************
 * Alix Field           afield@cnm.edu              FieldP7_Java
 * Enigma Program
 *
 * Program Objective: Encoding & Decoding Strings
 **************************************************************************/
package fieldp7_java;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javax.swing.JFileChooser;


public class FXMLDocumentController implements Initializable {
    private Enigma enigma;


    // ----------------------------------
    // Private Variables
    // ----------------------------------

    // Containers
    @FXML
    private AnchorPane anpaneEnigma;
    @FXML
    private VBox vbxBase;
    @FXML
    private HBox hbxInstructions;
    @FXML
    private HBox hbxKeyMessage;
    @FXML
    private HBox hbxButtons;
    @FXML
    private HBox hbxKeyCodeMessageDIsplay;
    @FXML
    private VBox vbxSummaryLabels;
    @FXML
    private VBox vbxSummaryTextFields;

    // Menu Bar
    @FXML
    private MenuBar mbarEnigma;
    @FXML
    private Menu mlbFile;
    @FXML
    private Menu mlbEdit;
    @FXML
    private MenuItem mitOpenFile;
    @FXML
    private MenuItem mitSaveFile;
    @FXML
    private MenuItem mitCloseEnigma;
    @FXML
    private MenuItem mitEnigmaInfo;

    // Labels
    @FXML
    private Label lbTitle;
    @FXML
    private Label lbEncodeInstruct;
    @FXML
    private Label lbDecodeInstruct;
    @FXML
    private Label lbEnterKey;
    @FXML
    private Label lbEnterMessage;
    @FXML
    private Label lbMessageSummary;
    @FXML
    private Label lbMessage;
    @FXML
    private Label lbCodedMessage;
    @FXML
    private Label lbKey;

    // Text Fields
    @FXML
    private TextField txfUserKey;
    @FXML
    private TextArea txfMessage;
    @FXML
    private TextField txfCodedMessage;
    @FXML
    private TextField txfKeyUsed;

    // Buttons
    @FXML
    private Button btnEncode;
    @FXML
    private Button btnDecode;
    @FXML
    private Button btnClear;
    @FXML
    private RadioButton rbtnGeneratedKey;
    @FXML
    private RadioButton rbtnUserKey;

    // Primitive Variable Declarations

    private String codedMessage;
    private int key;

    public FXMLDocumentController() {
        this.enigma = new Enigma();
        txfCodedMessage = new TextField();
        txfMessage = new TextArea();
        txfUserKey = new TextField();
    }

    private int getKey() {
        key = Integer.parseInt(txfUserKey.getText());
        if(key > Enigma.KEY_MAX || key < Enigma.KEY_MIN){
            System.err.println("THIS IS AN ERROR, DO A POPUP OR WHATEVER!");
        }
        return key;
    }

    private void clear() {
        codedMessage = "";
        key = 10;
        txfUserKey.setText(Integer.toString(key));
        txfMessage.setText("MYWLY*S]*A7>=7;C");
    }

    // ------------------------------------
    // Event Handlers
    // ------------------------------------    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        clear();
    }

    // Encode Message
    @FXML
    private void handleBtnEncodeAction(ActionEvent event) {
        enigma.setMessage(txfMessage.getText(), getKey());
        codedMessage = enigma.getCodedMessage();
        txfCodedMessage.setText(codedMessage);
        txfUserKey.setText(Integer.toString(enigma.getKey()));
    }

    // Decode Coded Message
    @FXML
    private void handleBtnDecodeAction(ActionEvent event) {
        enigma.setCodedMessage(txfMessage.getText(), getKey());
        txfCodedMessage.setText(enigma.getMessage());
        txfUserKey.setText(Integer.toString(enigma.getKey()));
    }

    // Clear Form
    @FXML
    private void handleBtnClearAction(ActionEvent event) {
        clear();
    }

    @FXML
    private void handleUserKeyChange(KeyEvent event) {
        if (!rbtnUserKey.isSelected()) {
            rbtnUserKey.setSelected(true);
        }

    }

    // Use Generated Key for Encoding
    @FXML
    private void handleRadioBtnGeneratedKeyAction(ActionEvent event) {

    }

    // Use Key for Encoding
    @FXML
    private void handleRadioBtnUserKeyAction(ActionEvent event) {
        key = Integer.parseInt(txfUserKey.getText());
    }

    // Use Key for Encoding
    @FXML
    private void handleBtnSwapAction(ActionEvent event) {
        String currentMessage = txfMessage.getText();
        txfMessage.setText(txfCodedMessage.getText());
        txfCodedMessage.setText(currentMessage);
    }

    // Open File
    @FXML
    private void handleMenuOpenFileAction(ActionEvent event) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Open A File to be Decoded");
        fileChooser.setCurrentDirectory(new java.io.File("."));
        String filename = "";

        int status = fileChooser.showOpenDialog(null);
        if (status == JFileChooser.APPROVE_OPTION) {
            try {               //read in the coded message and other input               
                File selectedFile = fileChooser.getSelectedFile();
                filename = selectedFile.getPath();
                File myFile = new File(filename);
                try (Scanner inputFile = new Scanner(myFile)) {
                    codedMessage = inputFile.nextLine();
                    key = inputFile.nextInt();
                }

            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    // Save File
    @FXML
    private void handleMenuSaveFileAction(ActionEvent event) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new java.io.File("."));
        fileChooser.setDialogTitle("Save Encoded Message");
        int status = fileChooser.showSaveDialog(null);
        String filename = "";

        if (status == JFileChooser.APPROVE_OPTION) {
            PrintWriter outputFile = null;
            try {

                File selectedFile = fileChooser.getSelectedFile();
                filename = selectedFile.getPath();
                outputFile = new PrintWriter(filename);
                outputFile.println(enigma.getCodedMessage());
                outputFile.println(key);

                outputFile.close();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    // Close Enigma Program by Menu Item
    @FXML
    private void handleMenuCloseEnigmaProgramAction(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void handleMenuEnigmaInfoAction(ActionEvent event) {

    } // End Event Handlers
} // End FXMLDocumentController Class

