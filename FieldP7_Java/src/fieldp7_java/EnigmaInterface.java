/**************************************************************************
 * Alix Field           afield@cnm.edu              FieldP7_Java
 * Enigma Program
 * 
 * Program Objective: Encoding & Decoding Strings
 **************************************************************************/
package fieldp7_java;


public interface EnigmaInterface {


    public void setMessage(String message, int key);
    public void setMessage(String message);
    public String getMessage();
    public void setCodedMessage(String codedMessage, int key);
    public String getCodedMessage();
    public int getKey();
    
}
