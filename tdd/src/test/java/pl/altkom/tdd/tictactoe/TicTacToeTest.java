package pl.altkom.tdd.tictactoe;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import pl.altkom.tdd.tictactoe.TicTacToe.GamePlayer;
import pl.altkom.tdd.tictactoe.TicTacToe.GameState;

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
	public void playerShouldSelectSomeSlot() throws Exception {
		// given
		TicTacToe game = new TicTacToe();

		// when
		game.selectO(1, 1);

		// then
		assertThat(game.isSelected(1, 1)).isTrue();
	}

	@Test(expected = IllegalStateException.class)
	public void playerCantSelectAlreadySelectedSlot() throws Exception {
		// given
		TicTacToe game = new TicTacToe();

		// when
		game.selectO(1, 1);

		// then
		assertThat(game.isSelected(1, 1)).isTrue();
	}

	@Test(expected = IllegalStateException.class)
	public void playerCantMakeMoveTwice() throws Exception {
		// given
		TicTacToe game = new TicTacToe();

		// when
		game.selectO(1, 1);
		game.selectO(2, 1);

		// then
		assertThat(game.isSelected(1, 1)).isTrue();
		assertThat(game.isSelected(2, 1)).isTrue();
	}

	@Test
	public void playersCanSelectSlotsOnChange() throws Exception {
		// given
		TicTacToe game = new TicTacToe();

		// when
		game.selectO(1, 1);
		game.selectX(2, 1);
		game.selectO(3, 1);

		// then
		assertThat(game.isSelected(1, 1)).isTrue();
		assertThat(game.isSelected(2, 1)).isTrue();
		assertThat(game.isSelected(3, 1)).isTrue();
	}

	@Test
	public void playerShouldWinGameWhenSelectAllSlotsInLine() throws Exception {
		// given
		TicTacToe game = new TicTacToe();

		// when
		game.selectO(1, 1);
		game.selectO(2, 1);
		game.selectO(3, 1);

		// then
		assertThat(game.getState()).isEqualTo(GameState.WINNER);
		assertThat(game.getWinner()).isEqualTo(GamePlayer.O);
	}
}
