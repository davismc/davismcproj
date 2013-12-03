package com.github.davismc.davismcproj.codingchallenges;

import static org.junit.Assert.*;

import org.junit.Test;

public class Logic1Test {

	@Test
	public void greenTicketNoneEqual() {
		assertEquals("1, 2, 3 -> 0", 0, Logic1.greenTicket(1, 2, 3));
	}
	
	@Test
	public void greenTicketAllEqual() {
		assertEquals("2, 2, 2 -> 20", 20, Logic1.greenTicket(2, 2, 2));
	}
	
	@Test
	public void greenTicketFirstTwoEqual() {
		assertEquals("1, 1, 2 -> 10", 10, Logic1.greenTicket(1, 1, 2));
	}
	
	@Test
	public void greenTicketLastTwoEqual() {
		assertEquals("2, 1, 1 -> 10", 10, Logic1.greenTicket(2, 1, 1));
	}
	
	@Test
	public void greenTicketFirstLastEqual() {
		assertEquals("1, 2, 1 -> 10", 10, Logic1.greenTicket(1, 2, 1));
	}
	
	@Test
	public void greenTicketNoneEqual2() {
		assertEquals("3, 2, 1 -> 0", 0, Logic1.greenTicket(3, 2, 1));
	}
	
	@Test
	public void greenTicketAllZero() {
		assertEquals("0, 0, 0 -> 20", 20, Logic1.greenTicket(0, 0, 0));
	}
}
