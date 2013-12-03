package javaChallenges;

/******************************************************************************
 * Class: ArraysStrings
 * Author: Merrill Davis
 * 
 * Purpose: Coding challenges from Cracking the Coding Interview
 ******************************************************************************/

public class ArraysStrings {
	/*
	 * Implement an algorithm to determine if a string has all unique
	 * characters. What if you cannot use additional data structures.
	 */
	public static boolean allUnique(String str) {
		// O(n^2) - time/space tradeoff
		for (int i = 0; i < str.length(); ++i) {
			for (int j = i + 1; j < str.length(); ++j) {
				if (str.charAt(i) == str.charAt(j))
					return false;
			}
		}
		return true;
	}

	/*
	 * Write code to reverse a string
	 */
	public static String reverseString(String str) {
		if (str.length() < 2)
			return str;
		// StringBuilder is more efficient since strings are immutable in Java
		StringBuilder result = new StringBuilder();
		for (int i = str.length() - 1; i >= 0; --i) {
			result.append(str.charAt(i));
		}
		return result.toString();
	}

	/*
	 * Design an algorithm and write the code to remove duplicate characters
	 * from a String without using any additional buffer. One or two additional
	 * variables are fine. An extra copy of the array is not.
	 */
	public static String removeDuplicates(char[] str) {
		// This exercise seems better suited to a C char array, where we
		// could terminate the string by adding a \0 at the end.  I chose to
		// return a string to deal with this issue, although this technically
		// creates an additional data structure.
		// We also bend the additional variables allowance to create a 256 byte array
		// of char counts (its still constant space).
		// If unicode is possible, a hash would be better.
		// We will keep a variable "writeSpot" with current location for a result
		// that omits duplicates.
		// Complexity is O(n) 
		boolean[] exists = new boolean[256];
		int writeSpot = 0;
		for (int i = 0; i < str.length; ++i) {
			// If unique char, copy it to current writeSpot in array 
			if (exists[str[i]] == false) {
				exists[str[i]] = true;
				str[writeSpot] = str[i];
				++writeSpot;
			}
			// Else, advance to next char without including it in result
		}
		return new String(str, 0, writeSpot);
	}

} // end class ArraysStrings
