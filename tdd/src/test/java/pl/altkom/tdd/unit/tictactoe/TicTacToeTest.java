package pl.altkom.tdd.unit.tictactoe;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import pl.altkom.tdd.unit.tictactoe.TicTacToe;
import pl.altkom.tdd.unit.tictactoe.TicTacToe.GamePlayer;
import pl.altkom.tdd.unit.tictactoe.TicTacToe.GameState;

public class TicTacToeTest {
	@Test
	public void shouldCreateGameWithEmptyFields() throws Exception {
		// when
		TicTacToe game = new TicTacToe();

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
		game.selectO(1, 1);

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
		game.selectX(1, 2);
		game.selectO(2, 1);
		game.selectX(2, 2);
		game.selectO(3, 1);

		// then
		assertThat(game.getState()).isEqualTo(GameState.WINNER);
		assertThat(game.getWinner()).isEqualTo(GamePlayer.O);
	}

	@Test
	public void gameShouldEndWithDrawWhenAllFieldsAreSelected()
			throws Exception {
		// given
		TicTacToe game = new TicTacToe();

		// when
		game.selectO(1, 1);
		game.selectX(2, 1);
		game.selectO(3, 1);
		game.selectX(1, 2);
		game.selectO(2, 2);
		game.selectX(3, 2);
		game.selectO(1, 3);
		game.selectX(2, 3);
		game.selectO(3, 3);

		// then
		assertThat(game.getState()).isEqualTo(GameState.DRAW);
	}

	@Test(expected = IllegalStateException.class)
	public void cantMakeAnyMoveWhenGameIsOver() throws Exception {
		// given
		TicTacToe game = new TicTacToe();
		game.selectO(1, 1);
		game.selectX(1, 2);
		game.selectO(2, 1);
		game.selectX(2, 2);
		game.selectO(3, 1);
		assertThat(game.getState()).isEqualTo(GameState.WINNER);

		// when
		game.selectX(3, 3);

	}
}
