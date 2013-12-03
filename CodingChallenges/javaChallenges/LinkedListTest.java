package javaChallenges;

import static org.junit.Assert.*;

import org.junit.Test;

/******************************************************************************
 * Class: LinkedList
 * Author: Merrill Davis
 * 
 * Purpose:
 * JUnit tests for class LinkedList.
 * Linked List coding challenges from Cracking the Coding Interview.
 * 
 * Test name format is methodName_BehaviorTested_ExpectedResult
 * 
 ******************************************************************************/

public class LinkedListTest {
	
	// ----------------
	// LinkedList Class
	// ----------------

	// -----------
	// Constructor
	// -----------
	
	@Test
	public void constructor_default_expectNull() {
		assertEquals("", new LinkedList().toString());
	}

	@Test
	public void constructor_oneArgument() {
		assertEquals("42", new LinkedList(42).toString());
	}
	
	// -------
	// addLast, addFirst
	// -------
	
	@Test
	public void addLast_NullList() {
		LinkedList testList = new LinkedList();
		testList.addLast(42);
		assertEquals("42", testList.toString());
	}
	
	@Test
	public void addLast_OneArgConstructed() {
		LinkedList testList = new LinkedList(20);
		testList.addLast(42);
		assertEquals("20 42", testList.toString());
	}
	
	@Test
	public void addfirst_NullList() {
		LinkedList testList = new LinkedList();
		testList.addFirst(42);
		assertEquals("42", testList.toString());
	}
	
	@Test
	public void addFirst_OneArgConstructed() {
		LinkedList testList = new LinkedList(20);
		testList.addFirst(42);
		assertEquals("42 20", testList.toString());
	}

	@Test
	public void addLast_Multiple() {
		LinkedList testList = new LinkedList();
		testList.addLast(42);
		testList.addLast(60);
		testList.addLast(75);
		testList.addLast(-1);
		assertEquals("42 60 75 -1", testList.toString());
	}
	
	@Test
	public void addFirst_Multiple() {
		LinkedList testList = new LinkedList();
		testList.addFirst(42);
		testList.addFirst(60);
		testList.addFirst(75);
		testList.addFirst(-1);
		assertEquals("-1 75 60 42", testList.toString());
	}	

	// ----
	// size
	// ----
	
	@Test
	public void size_defaultConstructed() {
		assertEquals(0, new LinkedList().size());
	}

	@Test
	public void size_oneArgumentConstructed() {
		assertEquals(1, new LinkedList(42).size());
	}
	
	@Test
	public void size_defaultConstructedAddLast1Added() {
		LinkedList testList = new LinkedList();
		testList.addLast(42);
		assertEquals(1, testList.size());
	}
	
	@Test
	public void size_defaultConstructedAddLast2Added() {
		LinkedList testList = new LinkedList();
		testList.addLast(42);
		testList.addLast(62);
		assertEquals(2, testList.size());
	}
	
	@Test
	public void size_defaultConstructedAddFirst2Added() {
		LinkedList testList = new LinkedList();
		testList.addFirst(42);
		testList.addFirst(62);
		assertEquals(2, testList.size());
	}
	
	// -----------
	// constructor
	// -----------
	// takes an array
	
	@Test
	public void constructor_ArrayArgumentNullArray() {
		int[] arr = {};
		LinkedList testList = new LinkedList(arr);
		assertEquals(0, testList.size());
		assertEquals("", testList.toString());
	}
	
	@Test
	public void constructor_ArrayArgument1Item() {
		int[] arr = {15};
		LinkedList testList = new LinkedList(arr);
		assertEquals(1, testList.size());
		assertEquals("15", testList.toString());
	}
	
	@Test
	public void constructor_ArrayArgument2Items() {
		int[] arr = {15, 25};
		LinkedList testList = new LinkedList(arr);
		assertEquals(2, testList.size());
		assertEquals("15 25", testList.toString());
	}
	
	@Test
	public void constructor_ArrayArgument3Items() {
		int[] arr = {15, 25, 0};
		LinkedList testList = new LinkedList(arr);
		assertEquals(3, testList.size());
		assertEquals("15 25 0", testList.toString());
	}
	
	// -----------
	// removeDupes
	// -----------
	@Test
	public void removeDupes_EmptyList() {
		LinkedList testList = new LinkedList();
		testList.removeDupes();
		assertEquals(0, testList.size());
		assertEquals("", testList.toString());
	}
	
	@Test
	public void removeDupes_Size1() {
		LinkedList testList = new LinkedList(20);
		testList.removeDupes();
		assertEquals(1, testList.size());
		assertEquals("20", testList.toString());
	}
	
	@Test
	public void removeDupes_Size2WithDupes() {
		LinkedList testList = new LinkedList(20);
		testList.addLast(20);
		testList.removeDupes();
		assertEquals(1, testList.size());
		assertEquals("20", testList.toString());
	}
	
	@Test
	public void removeDupes_Size2NoDupes() {
		LinkedList testList = new LinkedList(20);
		testList.addLast(15);
		testList.removeDupes();
		assertEquals(2, testList.size());
		assertEquals("20 15", testList.toString());
	}
	
	@Test
	public void removeDupes_DupesAtStart() {
		int[] arr = {10, 10, 10, 25, 30};
		LinkedList testList = new LinkedList(arr);
		testList.removeDupes();
		assertEquals(3, testList.size());
		assertEquals("10 25 30", testList.toString());
	}
	
	@Test
	public void removeDupes_DupesAtEnd() {
		int[] arr = {5, 10, 15, 20, 25, 30, 30, 30};
		LinkedList testList = new LinkedList(arr);
		testList.removeDupes();
		assertEquals(6, testList.size());
		assertEquals("5 10 15 20 25 30", testList.toString());
	}
	
	@Test
	public void removeDupes_ListNoDupes() {
		int[] arr = {5, 10, 15, 20, 25, 30, 35, 40};
		LinkedList testList = new LinkedList(arr);
		testList.removeDupes();
		assertEquals(8, testList.size());
		assertEquals("5 10 15 20 25 30 35 40", testList.toString());
	}
	
	@Test
	public void removeDupes_AllDupes() {
		int[] arr = {5, 5, 5, 5, 5};
		LinkedList testList = new LinkedList(arr);
		testList.removeDupes();
		assertEquals(1, testList.size());
		assertEquals("5", testList.toString());
	}
	
}
