package javaChallenges;

import static org.junit.Assert.*;

import org.junit.Test;

/******************************************************************************
 * Class: ArraysStrings Author: Merrill Davis
 * 
 * Purpose: JUnit tests for class ArraysStrings
 * 
 * Test name format is methodName_BehaviorTested_ExpectedResult
 * 
 ******************************************************************************/

public class ArraysStringsTester {

	// --------------
	// Test allUnique
	// --------------

	@Test
	public void allUnique_AllAreUnique_ExpectTrue() {
		assertEquals("\"Pet can\" -> true", true,
				ArraysStrings.allUnique("Pet can"));
	}

	@Test
	public void allUnique_LettersUniqueTwoSpaces_ExpectFalse() {
		assertEquals("\"Pet can bowl\" -> false", false,
				ArraysStrings.allUnique("Pet can bowl"));
	}

	@Test
	public void allUnique_FirstLastSame_ExpectFalse() {
		assertEquals("\"tal port\" -> false", false,
				ArraysStrings.allUnique("tal port"));
	}

	@Test
	public void allUnique_Numbers_ExpectTrue() {
		assertEquals("\"123456789\" -> true", true,
				ArraysStrings.allUnique("123456789"));
	}

	@Test
	public void allUnique_NumbersRepeat_ExpectFalse() {
		assertEquals("\"123456389\" -> false", false,
				ArraysStrings.allUnique("123456389"));
	}

	@Test
	public void allUnique_RepeatAtMiddle_ExpectFalse() {
		assertEquals("\"abcdeffghijk\" -> false", false,
				ArraysStrings.allUnique("abcdeffghijk"));
	}

	@Test
	public void allUnique_UniquePunctuation_ExpectTrue() {
		assertEquals("\"!@#$% ^&*(\" -> True", true,
				ArraysStrings.allUnique("!@#$% ^&*("));
	}

	// ------------------
	// Test reverseString
	// ------------------
	@Test
	public void reverseString_Sentence() {
		assertEquals(
				"\"Capybaras make cuddly pets.\" -> \".step yldduc ekam sarabypaC",
				".step yldduc ekam sarabypaC",
				ArraysStrings.reverseString("Capybaras make cuddly pets."));
	}
	
	@Test
	public void reverseString_Word() {
		assertEquals("elbirret", ArraysStrings.reverseString("terrible"));
	}
	
	@Test
	public void reverseString_Null() {
		assertEquals("", ArraysStrings.reverseString(""));
	}
	
	@Test
	public void reverseString_SingleChar() {
		assertEquals("a", ArraysStrings.reverseString("a"));
	}
	
	@Test
	public void reverseString_Paldindrome() {
		assertEquals("racecar", ArraysStrings.reverseString("racecar"));
	}
	
	// ----------------
	// removeDuplicates
	// ----------------
	
	@Test
	public void removeDuplicates_NoDupes() {
		String result = "abcdefg";
		String str = "abcdefg";
		assertEquals(result, ArraysStrings.removeDuplicates(str.toCharArray()));
	}
	
	@Test
	public void removeDuplicates_DupeAtStart() {
		String result = "abcdefg";
		String str = "aabcdefg";
		assertEquals(result, ArraysStrings.removeDuplicates(str.toCharArray()));
	}
	
	@Test
	public void removeDuplicates_DupeAtEnd() {
		String result = "abcdefg";
		String str = "aabcdefgg";
		assertEquals(result, ArraysStrings.removeDuplicates(str.toCharArray()));
	}
	
	@Test
	public void removeDuplicates_DupesInARow() {
		String result = "abcdefg";
		String str = "abcccdefgg";
		assertEquals(result, ArraysStrings.removeDuplicates(str.toCharArray()));
	}
	
	@Test
	public void removeDuplicates_MultiplesDupes() {
		String result = "abcdefg";
		String str = "abcccdeefffgg";
		assertEquals(result, ArraysStrings.removeDuplicates(str.toCharArray()));
	}
	
	@Test
	public void removeDuplicates_Null() {
		String result = "";
		String str = "";
		assertEquals(result, ArraysStrings.removeDuplicates(str.toCharArray()));
	}
	
	@Test
	public void removeDuplicates_AllSame() {
		String result = "a";
		String str = "aaaaaaa";
		assertEquals(result, ArraysStrings.removeDuplicates(str.toCharArray()));
	}
	
	@Test
	public void removeDuplicates_SingleChar() {
		String result = "z";
		String str = "z";
		assertEquals(result, ArraysStrings.removeDuplicates(str.toCharArray()));
	}
}
