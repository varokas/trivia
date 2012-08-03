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

	//*** removeQuestionFromCategory ***
	@Test
	public void removeQuestionFromCategoryShouldRemoveFromPopCategoryWhenInputIsPop() {
		String secondQuestion = (String) game.popQuestions.get(1);
		int beforeSize = game.popQuestions.size();
		
		game.removeQuestionFromCategory("Pop");
		
		assertThat(game.popQuestions.size(), is(beforeSize - 1));
		assertThat(game.popQuestions.get(0).toString(), is(secondQuestion));
	}
	
	@Test
	public void removeQuestionFromCategoryShouldRemoveFromPopCategoryWhenInputIsScience() {
		String secondQuestion = (String) game.scienceQuestions.get(1);
		int beforeSize = game.scienceQuestions.size();
		
		game.removeQuestionFromCategory("Science");
		
		assertThat(game.scienceQuestions.size(), is(beforeSize - 1));
		assertThat(game.scienceQuestions.get(0).toString(), is(secondQuestion));
	}
	

	//*** currentCategoryByPlace ***
	@Test
	public void currentCategoryByPlaceShouldReturnPopForCorrectPlaces() {
		assertThat(game.currentCategoryByPlace(0), is("Pop"));
		assertThat(game.currentCategoryByPlace(4), is("Pop"));
		assertThat(game.currentCategoryByPlace(8), is("Pop"));
	}
	
	@Test
	public void currentCategoryByPlaceShouldReturnScienceForCorrectPlaces() {
		assertThat(game.currentCategoryByPlace(1), is("Science"));
		assertThat(game.currentCategoryByPlace(5), is("Science"));
		assertThat(game.currentCategoryByPlace(9), is("Science"));
	}

	@Test
	public void currentCategoryByPlaceShouldReturnSportsForCorrectPlaces() {
		assertThat(game.currentCategoryByPlace(2), is("Sports"));
		assertThat(game.currentCategoryByPlace(6), is("Sports"));
		assertThat(game.currentCategoryByPlace(10), is("Sports"));
	}
	
	@Test
	public void currentCategoryByPlaceShouldReturnRockForCorrectPlacesBetweenOneAndTen() {
		assertThat(game.currentCategoryByPlace(3), is("Rock"));
		assertThat(game.currentCategoryByPlace(7), is("Rock"));
	}
	
	@Test
	public void currentCategoryByPlaceShouldReturnRockForNumbersMoreThanTen() {
		assertThat(game.currentCategoryByPlace(11), is("Rock"));
		assertThat(game.currentCategoryByPlace(101), is("Rock"));
		assertThat(game.currentCategoryByPlace(999), is("Rock"));
	}
	
	@Test
	public void currentCategoryByPlaceShouldReturnRockForNumbersLessThanZero() {
		assertThat(game.currentCategoryByPlace(-1), is("Rock"));
		assertThat(game.currentCategoryByPlace(-55), is("Rock"));
	}
}
