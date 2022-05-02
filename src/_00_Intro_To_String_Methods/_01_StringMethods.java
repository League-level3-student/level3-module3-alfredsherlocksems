package _00_Intro_To_String_Methods;

import java.util.ArrayList;
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
    	s1 = s1.trim();
    	s2 = s2.trim();
    	s3 = s3.trim();
    	String[] s1A = s1.split(" ");
    	String[] s2A = s2.split(" ");
    	String[] s3A = s3.split(" ");
    	String[] greatest;
    	String toReturn;
    	if (s1A[1].compareTo(s2A[1]) < 0) {
    		greatest = s1A;
    	}
    	else {
    		greatest = s2A;
    	}
    	if (s3A[1].compareTo(greatest[1]) < 0) {
    		greatest = s3A;
    	}
    	toReturn = greatest[0] + " " + greatest[1];
    	return toReturn;
    }

    // Return the sum of all numerical digits in the String
    public static int numeralSum(String s) {
    	ArrayList<Character> num = new ArrayList<Character>();
    	for (int i = 0; i < s.length(); i++) {
    		char bob = s.charAt(i);
    		if (bob == '1' || bob == '2' || bob == '3' || bob == '4' || bob == '5' || bob == '6' || bob == '7' || bob == '8' || bob == '9') {
    			num.add(bob);
    		}
    	}
    	int r = 0;
    	for (int i = 0; i < num.size(); i++) {
    		r = r + Character.getNumericValue(num.get(i));
    	}
    	
    	return r;
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
        s = Utilities.encrypt(s.getBytes(), (byte)key);
        return s;
    }

    // Call Utilities.decrypt at the bottom of this file to decrypt the
    // cyphertext (encrypted text)
    public static String decrypt(String s, char key) {
        s = Utilities.decrypt(s, (byte)key);
        return s;
    }

    // Return the number of words in String s that end with String substring
    // You can assume there are no punctuation marks between words
    public static int wordsEndsWithSubstring(String s, String substring) {
        int length = substring.length();
        s.trim();
        int subCount = 0;
        String tempSub;
        ArrayList<Integer> spaces = new ArrayList<Integer>();
        for (int i = 0; i < s.length(); i++) {
        	if(s.charAt(i) == ' ') {
        		spaces.add(i);
        	}
        }
        for (int i = 0; i < spaces.size(); i++) {
        	tempSub = s.substring(spaces.get(i) - length, i);
        	if (tempSub.equals(substring)) {
        		length++;
        	}
        }
    	return 0;
    }

    // Given String s, return the number of characters between the first
    // occurrence of String substring and the final occurrence
    // You can assume that substring will appear at least twice
    public static int distance(String s, String substring) {
    	int substringLength = substring.length();
    	int first = s.indexOf(substring) + substringLength;
    	int last = s.lastIndexOf(substring);
    	return last - first;
    }

    // Return true if String s is a palindrome
    // palindromes are words or phrases are read the same forward as backward.
    // HINT: ignore/remove all punctuation and spaces in the String
    public static boolean palindrome(String s) {
        int b = -1;
        char back;
        char bob;
        boolean pal = true;
        s = s.trim();
        String[] pun = new String[]{"!", "?", ":", " ", ";", ".", ",", "-", "_"};
        for (int i = 0; i < pun.length; i++) {
        	s = s.replace(pun[i], "");
        }
        System.out.println(s);
        for (int i = s.length() - 1; i > -1; i--) {
        	b++;
        	bob = s.charAt(b);
        	back = s.charAt(i);
        	bob = Character.toLowerCase(bob);
        	back = Character.toLowerCase(back);
        	if (bob != back) {
        		pal = false;
        	}
        }
    	return pal;
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
