/**
 * 
 */
package com.adreeana.oneteam;

/**
 * The list of all principles the team agrees on.
 */
public enum Codex {

	NO_CLUE(
		"Team", "We have no clue to explain this decision"
	),

	SINGLE_GOLDEN_SOURCE(
		"Team", "There must be only one single authoritative place for each piece of data"
	),

	DIP_DOMAIN(
		"Team", "Domain should not depend on any other layer nor technology"
	),

	DUMB_MIDDLEWARE(
		"Sam Newman", "Keep your middleware dumb, and keep the smarts in the endpoints"
	)

	;

	private Codex(String author, String principle) {
		this.author = author;
		this.principle = principle;
	}

	private final String author;
	private final String principle;
}
