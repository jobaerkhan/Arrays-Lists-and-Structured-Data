
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class CaesarCipher {
    public String encrypt(String input, int key) {
            //Make a StringBuilder with message (encrypted)
            StringBuilder encrypted = new StringBuilder(input);
            //Write down the alphabet
            String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            //Compute the shifted alphabet
            String shiftedAlphabet = alphabet.substring(key)+
            alphabet.substring(0,key);
            //Count from 0 to < length of encrypted, (call it i)
            for(int i = 0; i < encrypted.length(); i++) {
                //Look at the ith character of encrypted (call it currChar)
                char currChar = encrypted.charAt(i);
                //Find the index of currChar in the alphabet (call it idx)
                int idx = alphabet.indexOf(currChar);
                //If currChar is in the alphabet
                if(idx != -1){
                    //Get the idxth character of shiftedAlphabet (newChar)
                    char newChar = shiftedAlphabet.charAt(idx);
                    //Replace the ith character of encrypted with newChar
                    encrypted.setCharAt(i, newChar);
                }
                //Otherwise: do nothing
            }
            //Your answer is the String inside of encrypted
            return encrypted.toString();
        }
        
         public String encryptTwoKeys(String input, int key1, int key2) {
        // Encrypt alphabet with key s
        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String abcEncrypted1 = abc.substring(key1) + abc.substring(0, key1);
        String abcEncrypted2 = abc.substring(key2) + abc.substring(0, key2);
        
        // Make passed String dynamically mutable
        StringBuilder encrypted = new StringBuilder(input);
        // For each character
        for (int i = 0; i < encrypted.length(); i++) {
            // Get character
            char ch = encrypted.charAt(i);
            // If char is a letter
            if (Character.isLetter(ch)) {
                // Convert to uppercase (regardless if it is already)
                char chUpper = Character.toUpperCase(ch);
                // Find its position in normal abc
                int pos = abc.indexOf(chUpper);
                // Find it in one of the encrypted abcs, depending on index 
                char replacee;
                if (i % 2 == 0) {
                    replacee = abcEncrypted1.charAt(pos);
                } else {
                    replacee = abcEncrypted2.charAt(pos);
                }
                // Replace it with letter found in encrypted abc (in correct case)
                if (chUpper == ch) {
                    encrypted.setCharAt(i, replacee);
                } else {
                    encrypted.setCharAt(i, Character.toLowerCase(replacee));
                }
            }
        }
        
        return encrypted.toString();
    }
    
    public void testEncryptTwoKeys() {
        System.out.println(encryptTwoKeys("Top ncmy qkff vi vguv vbg ycpx", 24, 6));
    }
    
     public void testEncrypt() {
        String input = "FIRST LEGION ATTACK EAST FLANK!";
        int key = 23;
        String encrypted = encrypt(input, key);
        System.out.println(input + " encrypted with a key of " 
            + key + " is " + encrypted);
        
        input = "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
        key = 15;
        encrypted = encrypt(input, key);
        System.out.println(input + " encrypted with a key of " 
            + key + " is \n" + encrypted);
    }
    
        public void testCaesar() {
            int key = 15;
            //FileResource fr = new FileResource();
            String message = "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
            String encrypted = encrypt(message.toUpperCase(), key);
            System.out.println(encrypted);
            String decrypted = encrypt(encrypted, 26-key);
            System.out.println(decrypted);
        }
        
        public static void main(String[] args) {
		CaesarCipher test = new CaesarCipher();
		test.testEncryptTwoKeys();

	}
}
