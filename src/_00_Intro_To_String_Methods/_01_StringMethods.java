package _00_Intro_To_String_Methods;

import java.util.Base64;

/*
 * Visit the JavaDocs for the String class to view everything you can do with a String.
 * https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
 * https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html
 *
 * HINT:  Here are some String methods you might find useful 
 * contains
 * replace
 * trim
 * length
 * getBytes
 * endsWith
 * split 
 * indexOf
 * lastIndexOf
 * compareTo(IgnoreCase)
 * substring
 * toUpperCase/toLowerCase
 * valueOf
 *
 * Here are some Character methods you might find useful:
 * Character.toLowerCase(char c);
 * Character.toUpperCase(char c);
 * Character.isLetter(char c);
 * Character.isDigit(char c);
 * Character.getNumericValue(char c);
 */

public class _01_StringMethods {

    // Given Strings s1 and s2, return the longer String
    public static String longerString(String s1, String s2) {
        if (s1.length() > s2.length()) {
        	return s1;
        }
        return s2;
    }

    // If String s contains the word "underscores", change all of the spaces
    // to underscores
    public static String formatSpaces(String s) {
       if (s.contains("underscores")) {
    	   s = s.replace(' ', '_');
       }
        return s;
    }

    // Return the name of the person whose LAST name would appear first if they
    // were in alphabetical order.
    // You cannot assume there are no extra spaces around the name, but you can
    // assume there is only one space between the first and last name
    public static String lineLeader(String s1, String s2, String s3) {
    	char[] l1 = new char[3];
    	char one;
    	char two;
    	char three;
    	int a1 = 0;
    	int a2 = 0;
    	int a3 = 0;
    	int c = 0;
    	String r = "";
    	for (int i = 0; i < s1.length(); i++) {
        	if (!(s1.charAt(i) == ' ')) {
        		l1[0] = s1.charAt(i);
        		one = l1[0];
        		a1 = i;
        		break;
        	}
        }
    	for (int i = 0; i < s2.length(); i++) {
        	if (!(s2.charAt(i) == ' ')) {
        		l1[1] = s2.charAt(i);
        		two = l1[1];
        		a2 = i;
        		break;
        	}
        }
    	for (int i = 0; i < s3.length(); i++) {
    		if (!(s3.charAt(i) == ' ')) {
        		l1[2] = s3.charAt(i);
        		three = l1[2];
        		a3 = i;
        		break;
        	}
		}
    	for (int i = 0; i < l1.length; i++) {
    		for (int k = 0; k < l1.length - 1; k++) {
    			if (l1[k+1] > l1[k]) {
    				char t = l1[k];
    				l1[k] = l1[k+1];
    				l1[k+1] = t;
    			}
    		}
    	}
    	if(l1[0] == one) {
    		for (int i = a1; i < s1.length(); i++) {
    			if (s1.charAt(i) == ' ') {
    				c = i;
    				break;
    			}
    		}
    		r = s1.substring(a1, c);
    	}
    	else if (l1[1] == two) {
    		for (int i = a2; i < s2.length(); i++) {
    			if (s2.charAt(i) == ' ') {
    				c = i;
    				break;
    			}
    		}
    		r = s2.substring(a2, c);
    	}
    	else {
    		for (int i = a3; i < s3.length(); i++) {
    			if (s3.charAt(i) == ' ') {
    				c = i;
    				break;
    			}
    		}
    		r = s3.substring(a3, c);
    	}
    	return r;
    }

    // Return the sum of all numerical digits in the String
    public static int numeralSum(String s) {
        int st = Integer.parseInt(s);
        return st;
    }

    // Return the number of times String substring appears in String s
    public static int substringCount(String s, String substring) {
        int l = substring.length();
        int num = 0;
        for (int i = 0; i< s.length() - l + 1; i++) {
        	String s2 = s.substring(i, l + i);
        	if (s2.contains(substring)) {
        		num++;
        	}
        }
    	return num;
    }

    // Call Utilities.encrypt at the bottom of this file to encrypt String s
    public static String encrypt(String s, char key) {
        return encrypt(s, key);
    }

    // Call Utilities.decrypt at the bottom of this file to decrypt the
    // cyphertext (encrypted text)
    public static String decrypt(String s, char key) {
        return decrypt(s, key);
    }

    // Return the number of words in String s that end with String substring
    // You can assume there are no punctuation marks between words
    public static int wordsEndsWithSubstring(String s, String substring) {
        return 0;
    }

    // Given String s, return the number of characters between the first
    // occurrence of String substring and the final occurrence
    // You can assume that substring will appear at least twice
    public static int distance(String s, String substring) {
        return 0;
    }

    // Return true if String s is a palindrome
    // palindromes are words or phrases are read the same forward as backward.
    // HINT: ignore/remove all punctuation and spaces in the String
    public static boolean palindrome(String s) {
        return true;
    }
}

class Utilities {
    // This basic encryption scheme is called single-byte xor. It takes a
    // single byte and uses exclusive-or on every character in the String.
    public static String encrypt(byte[] plaintext, byte key) {
        for (int i = 0; i < plaintext.length; i++) {
            plaintext[i] = (byte) (plaintext[i] ^ key);
        }
        return Base64.getEncoder().encodeToString(plaintext);
    }

    public static String decrypt(String cyphertext, byte key) {
        byte[] b = Base64.getDecoder().decode(cyphertext);
        for (int i = 0; i < b.length; i++) {
            b[i] = (byte) (b[i] ^ key);
        }
        return new String(b);
    }
}
