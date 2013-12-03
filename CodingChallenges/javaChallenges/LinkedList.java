package javaChallenges;

import java.util.HashSet;
import java.util.Set;

/******************************************************************************
 * Class: LinkedList
 * Author: Merrill Davis
 * 
 * Purpose: 
 * Linked List coding challenges from Cracking the Coding Interview.
 * A minimal singly-linked list implementation precedes the practice methods.
 * 
 ******************************************************************************/

public class LinkedList {

	public class Node {
		private int mValue;
		private Node mNext;
		
		public Node() {
			mValue = 0;
			mNext = null;
		}
		
		public Node(int value, Node next) {
			mValue = value;
			mNext = next;
		}
		
		public int getValue() {
			return mValue;
		}
		
		public void setValue(int value) {
			mValue = value;
		}
		
		public Node getNext() {
			return mNext;
		}
		
		public void setNext(Node next) {
			mNext = next;
		}
	}
	
	private Node mRoot;
	private Node mLast;
	private int mSize;
	
	LinkedList () {
		mRoot = null;
		mLast = mRoot;
		mSize = 0;
	}
	
	LinkedList (int value) {
		mRoot = new Node(value, null);
		mLast = mRoot;
		mSize = 1;
	}
	
	LinkedList (int[] arr) {
			mRoot = null;
			mSize = 0;
			mLast = mRoot;
			for (int i = 0; i < arr.length; ++i)
				this.addLast(arr[i]);		
	}
	
	public void addLast(int value) {
		if (mRoot != null) {
			mLast.setNext(new Node(value, null));
			mLast = mLast.getNext();
		}
		else {
			mRoot = new Node(value, null);
			mLast = mRoot;
		}
		++mSize;
	}

	public void addFirst(int value) {
		mRoot = new Node(value, mRoot);
		++mSize;
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder();
		Node current = mRoot;
		while (current != null) {
			result.append(current.getValue() + " ");
			current = current.getNext();
		}
		return result.toString().trim();
	}
	
	public int size() {
		return mSize;
	}

	/*
	 * Write code to remove duplicates from an unsorted linked list
	 */
	
	public void removeDupes() {
		if (mRoot == null)
			return;
		Node trail = mRoot;
		Node current = mRoot.getNext();
		Set<Integer> found = new HashSet<Integer>();
		found.add(trail.getValue());
		while (current != null) {
			if (!found.contains(current.getValue())) {
				found.add(current.getValue());
				trail = current;
				current = current.getNext();
			}
			else {
				trail.setNext(current.getNext());
				current = current.getNext();
				--mSize;
			}
		}
		assert(mSize > 0);
	}
}