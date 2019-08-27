
/**
 * Write a description of WordPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.lang.*;

public class WordPlay {

    //Write a method isVowel that has one Char parameter named ch. 
	//This method returns true if ch is a vowel 
	//(one of 'a', 'e', 'i', 'o', or 'u' or the uppercase versions) and false otherwise.
	public /*static*/ Boolean isVowel(char ch) {
		char[] vowelArray = {'a','e','i','o','u'};
		for (char element : vowelArray) {
			if (Character.toLowerCase(ch) == element) {
				return true;
			}			
		}
		return false;
	}
	
	//Write a method replaceVowels that has two parameters, a String named phrase and a Char named ch.
	//This method should return a String that is the string phrase with all the vowels
	//(uppercase or lowercase) replaced by ch. 
	//For example, the call replaceVowels(“Hello World”, ‘*’) returns the string “H*ll* W*rld”. 
	//Be sure to call the method isVowel that you wrote and also test this method.
	public String replaceVowels(String phrase, char ch) {
		//make a StringBuilder with phrase
		StringBuilder ret = new StringBuilder(phrase);
		
		//count from 0 to length of the input
		for (int i =0; i < ret.length();i++) {
			//look at the i th character of phrase
			char currChar = ret.charAt(i);
			//System.out.println(currChar);
			//System.out.println("isVowel("+currChar+") = "+ isVowel(currChar) );
			//if this character is a vowel, 
			if(isVowel(currChar)) {
				//replace it with ch
				ret.setCharAt(i,ch);
				//System.out.println(ret.toString());
			}
		}
		
		return ret.toString();
	}
	
	/*Write a method emphasize with two parameters, a String named phrase and a 
	  character named ch. This method should return a String that is the string phrase but 
	  with the Char ch (upper- or lowercase) replaced by ‘*’ if it is in an odd number location 
	  in the string (e.g. the first character has an odd number location but an even index, 
	  it is at index 0), or ‘+’ if it is in an even number location in the string
	   (e.g. the second character has an even number location but an odd index, it is at index 1).	  
	 */
	
	public String emphasize(String phrase, char ch) {
		//make a StringBuilder with phrase
		 StringBuilder replaced = new StringBuilder(phrase);
                // For each character
                for (int i = 0; i < replaced.length(); i++) {
                    // If character (upper or lower case) equals ch 
                    if (replaced.charAt(i) == ch || Character.toLowerCase(replaced.charAt(i)) == ch) {
                        // If location is odd (even index), replace with *
                        if (i % 2 == 0) {
                            replaced.setCharAt(i, '*');
                        } 
                        // If location is even (odd index), replace with +
                        else {
                            replaced.setCharAt(i, '+');
                        }
                    }
                }
                // Convert back to String and return
                return replaced.toString();
	}
	
	public void TestWorldPlay() {
		
		System.out.println("isVowel('F') = "+ isVowel('F'));
		System.out.println("isVowel('a') = "+ isVowel('a'));
		System.out.println("isVowel('A') = "+ isVowel('A'));
		System.out.println("replaceVowels(\"Hello World\",'*') = "+ replaceVowels("Hello World",'*'));
		System.out.println("emphasize(\"dna ctgaaactga\", 'a') = "+ emphasize("dna ctgaaactga", 'a'));
		System.out.println("emphasize(\"Mary Bella Abracadabra\", 'a') = "+ emphasize("Mary Bella Abracadabra", 'a'));
	}

	public static void main(String[] args) {
		WordPlay w = new WordPlay();
		w.TestWorldPlay();

	}

    
}
