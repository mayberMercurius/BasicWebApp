package de.tum.in.ase.eist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class QueryProcessorTest {

	private final QueryProcessor queryProcessor = new QueryProcessor();

	@Test
	void testEmptyStringIfCannotProcessQuery() {
		assertEquals("", queryProcessor.process("test"));
	}

	@Test
	void testKnowsAboutShakespeare() {
		String actual = queryProcessor.process("Shakespeare");
		if (!actual.contains("playwright")) {
			fail("The QueryProcessor does not know about Shakespeare.");
		}
	}

	@Test
	void isNotCaseSensitive() {
		String actual = queryProcessor.process("shakespeare");
		if (!actual.contains("playwright")) {
			fail("Your QueryProcessor should not be case sensitive.");
		}
	}

	@Test
	void testName() {
		String actual = queryProcessor.process("name");
		if (!actual.contains("penguin")) {
			fail("Your do not know who I am");
		}
	}

	@Test
	void testAge() {
		String actual = queryProcessor.process("age");
		if (!actual.contains("2")) {
			fail("Your do not know how old I am");
		}
	}

	@Test
	void testCharacteristic() {
		String actual = queryProcessor.process("characteristic");
		if (!actual.contains("stupid")) {
			fail("Your do not know me");
		}
	}

	@Test
	void testFriend() {
		String actual = queryProcessor.process("friend");
		if (!actual.contains("pgdp")) {
			fail("Your do not know my friend");
		}
	}

}
