package com.adaptionsoft.games.uglytrivia;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class GameTest {
	private Game game;
	
	@Before
	public void before() {
		game = new Game();
	}
	

	//*** currentCategoryByPlace ***
	@Test
	public void currentCategoryByPlaceShouldReturnPopForCorrectPlaces() {
		assertThat(game.currentCategoryByPlace(0), is("Pop"));
		assertThat(game.currentCategoryByPlace(4), is("Pop"));
		assertThat(game.currentCategoryByPlace(8), is("Pop"));
	}

}
