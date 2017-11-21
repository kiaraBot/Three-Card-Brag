import fieldp7_java.Enigma;

public class EnigmaTest {

    private static final Enigma enigma = new Enigma();

    private static void testMessage(String plain, String encoded, int key){
        enigma.setMessage(plain,key);
        String testEncoded = enigma.getCodedMessage();
        System.out.println("Plain: " + plain);
        System.out.println("Encoded: " + encoded + " == " + testEncoded);
        if(testEncoded.equals(encoded)){
            System.out.println("Matches");
        } else {
            System.out.println("AAAA! No Match!!!!!!");
        }
    }

    private static void enigmaInt(int inInt, int match){
        System.out.println("In Int:" + inInt);
        System.out.println("In Key:" + 0);
        System.out.println("match:" + match);
        int enigmaInt = Enigma.intToEnigmaCharInt(inInt,0);
        System.out.println("gened:" + enigmaInt);
        if(enigmaInt == match){
            System.out.println("Matches");
        } else {
            System.out.println("AAAA! No Match!!!!!!");
        }
    }

    public static void main(String[] args) {
        int message1_key = 10;
        String message1 = "COMBO IS 7-43-19";
        String message1_encoded = "MYWLY*S]*A7>=7;C";
        int message2_key = 20;
        String message2 = "See me at 7pm.";
        String message2_encoded = "gyy4\"y4u)4K%\"B";

        testMessage(message1, message1_encoded,message1_key);
        testMessage(message2, message2_encoded,message2_key);

        enigmaInt(127,32);
        enigmaInt(128,33);
        enigmaInt(129,34);

    }

}
