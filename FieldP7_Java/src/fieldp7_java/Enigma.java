/**************************************************************************
 * Alix Field           afield@cnm.edu              FieldP7_Java
 * Enigma Program
 *
 * Program Objective: Encoding & Decoding Strings
 **************************************************************************/

package fieldp7_java;


import java.util.Random;

public class Enigma implements EnigmaInterface {

    // min and max for key
    public static final int KEY_MAX = 50;
    public static final int KEY_MIN = 1;

    private String message;
    private String codedMessage;
    private int key;


    public Enigma() {
        message = "";
        codedMessage = "";
        key = getRandomKey();
    }

    /**
     * Sets the message and generates a random key
     * @param userMessage
     */
    @Override
    public void setMessage(String userMessage) {
        message = userMessage;
        key = getRandomKey();
        codedMessage = encodeMessage(userMessage,key);
    }

    /**
     * Sets the message and generates a random key
     * @param userMessage
     */
    @Override
    public void setMessage(String userMessage, int key) {
        this.message = userMessage;
        this.codedMessage = encodeMessage(userMessage,key);
        this.key = key;
    }

    /**
     * Sets the coded message, decodes it using provided key
     * @param codedMessage
     * @param key
     */
    @Override
    public void setCodedMessage(String codedMessage, int key) {
        this.codedMessage = codedMessage;
        this.message = decodeMessage(codedMessage,key);
        this.key = key;
    }

    @Override
    public String getCodedMessage() {
        return codedMessage;
    }

    @Override
    public String getMessage() {
        return message;
    }

    /**
     * Generates a random number between our min and max
     * @return generated integer
     */
    private int getRandomKey() {
        return new Random().nextInt(KEY_MAX - KEY_MIN + 1) + KEY_MIN;
    }

    public int getKey() {
        return key;
    }

    /**
     * Checks to see if the key entered is an int 1-50
     * if not a good value, it sets the key value to 1
     * @param key
     */
    private void setKey(int key) {
        if (key > KEY_MAX || key < KEY_MIN) {
            key = 1;
        }
        this.key = key;
    }

    /**
     * Converts a normal int into an enigma int
     * @param inInt
     * @param key
     * @return
     */
    public static final int intToEnigmaCharInt(int inInt, int key){
        int newInt = inInt + key;
        // Wrap anything above 126 so that 127 => 32, 128 => 33, 129 => 34
        if(newInt > 126){
            newInt = newInt - 95;
        }
        return newInt;
    }

    /**
     * Converts an enigma int into a normal int
     * @param inInt
     * @param key
     * @return
     */
    public static final int enigmaIntToCharInt(int inInt, int key){
        int newInt = inInt - key;
        // Wrap anything above 126 so that 127 => 32, 128 => 33, 129 => 34
        if(newInt < 0){
            newInt = newInt + 95;
        }
        return newInt;
    }

    private String encodeMessage(String message, int key) {
        setKey(key);
        final int encodeKey = getKey();
        final StringBuffer encoded = new StringBuffer();
        message.chars().forEach(i ->
                encoded.append(Character.toChars(intToEnigmaCharInt(i , encodeKey)))
        );
        return encoded.toString();
    }


    private String decodeMessage(String message, int key) {
        setKey(key);
        final int decodeKey = getKey();
        final StringBuffer decoded = new StringBuffer();
        message.chars().forEach(i ->
                decoded.append(Character.toChars(enigmaIntToCharInt(i , decodeKey)))
        );
        return decoded.toString();
    }


}
