//Create a Caesar Cipher to alter input letters by three characters in the positive direction of the alphabet

import java.util.Scanner;

public class EncryptionMachine {
	public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";				//set string of possible values without encryption
	private static int SHIFT = 3; 													//modification value
	public static StringBuffer changevalue(String text, int m) 						// Changes value of a character or sequence of characters using alphabet shift
	{
		StringBuffer codeText = new StringBuffer();
		for( int i=0; i < text.length(); i++ ) {									// iterate through each character in the string 
			char uncodedval = text.charAt(i);										// look up the current input character
			if ( uncodedval ==' ') {
				codeText.append(uncodedval);										// do not apply shift to spaces within input string
			} else {
			int indexval = (ALPHABET.indexOf(uncodedval)+ SHIFT) %26;				// find the index value of that character, apply the modification, and around ALPHABET
			char codedval = (char)(((int) ALPHABET.charAt(indexval)));				// find the character within ALPHABET using the the new index value
			codeText.append(codedval); 												// add this value to the encrypted string
			}
		}
		return codeText;
	}
	
	public static void main(String[] args)																				//Request user input for cipher. Print instructions, ask for input values for the keyword and wordsm produce altered text result
	{
		System.out.println("Welcome to the Caesar Cipher program. Please note that this encryption only applies to messages written in lowercase letters.");
		System.out.println("The program will ask for a cryptography key input, the number of words that will be passed, and input words up to the number provided.");
		System.out.println("The end result will print the full set of encrypted words."+"\r\n"+"\r\n");
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Please enter a cryptographic keyword: ");													// Request keyword
			String cryptkeyword = sc.next();
			System.out.print("Encrypted keyword: "+ changevalue(cryptkeyword,SHIFT)+"\r\n"+"\r\n");						// Return encrypted keyword
			System.out.print("Please enter the number of words you wish to encrypt, using a numeral:"+"\r\n"+"\r\n");
			while (!sc.hasNextInt()) sc.next();																			// Only allow next step if the input is a numeral
			int numberwords = sc.nextInt();
			StringBuffer newwords = new StringBuffer();																	// Initialize end string for use in if statement
			for( int i = 0; i < numberwords; i++) {																		// Iteration depending on the amount of words provided
				System.out.print("Please enter a word, in lowercase letters: ");										
				String inputword = sc.next();
				StringBuffer encryptedword = changevalue(inputword,SHIFT);
				System.out.print("Encrypted message: "+ encryptedword +"\r\n"+"\r\n");	
				if (i == 0) {																							
					newwords.append(encryptedword);																		// Set end string's first word
				} else {
					newwords.append(" " + encryptedword);																// Append additional words to end string	
				}
			}
			System.out.print("The full encrypted message is: " + newwords);
		}
	}
	
/*	commented out original work, as it used nextLine()
    public static void main(String[] args)						
	{
		System.out.println("Welcome to the Caesar Cipher program. Please note that this encryption only applies to messages written in lowercase letters. The program will first ask for a cryptography key input, then ask for the message you would like to be encrypted."+"\r\n"+"\r\n");
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Please enter a cryptographic keyword: ");					// Request keyword
			String str = sc.nextLine();
			System.out.print("Encrypted keyword: "+ changevalue(str,SHIFT)+"\r\n"+"\r\n");		
			System.out.print("Please enter your message, in lowercase letters: ");		// Request message
			String str2 = sc.nextLine();
			System.out.print("Encrypted message: "+ changevalue(str2,SHIFT));
		}
	} */
}