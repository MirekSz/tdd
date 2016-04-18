package pl.altkom.tdd.tictactoe;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class TicTacToeTest {
	@Test
	public void shouldCreateGameWithEmptyFields() throws Exception {
		// given
		TicTacToe game = new TicTacToe();

		// when
		game.start();

		// then
		assertThat(game.isEmpty()).isTrue();
	}

	@Test
	public void shouldSelectSomeSlot() throws Exception {
		// given
		TicTacToe game = new TicTacToe();

		// when
		game.takeO(1, 1);

		// then
		assertThat(game.isTaken(1, 1)).isTrue();
	}

	@Test
	public void shouldWinGameWhenSelectsAllSlotsInRow() throws Exception {
		// given
		TicTacToe game = new TicTacToe();

		// when
		game.takeO(1, 1);
		game.takeO(2, 1);
		game.takeO(3, 1);

		// then
		assertThat(game.getWinner()).isEqualTo("0");
	}

	@Test
	public void shouldWinGameWhenSelectAll() throws Exception {
		// given
		TicTacToe game = new TicTacToe();

		// when
		game.takeO(1, 1);

		// then
		assertThat(game.isTaken(1, 1)).isTrue();
	}

}
