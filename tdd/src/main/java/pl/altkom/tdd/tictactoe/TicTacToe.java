package pl.altkom.tdd.tictactoe;

public class TicTacToe {

	public void start() {
		// TODO Auto-generated method stub

	}

	public boolean isEmpty() {
		return true;
	}

	public void selectO(int i, int j) {
		// TODO Auto-generated method stub

	}

	public boolean isSelected(int i, int j) {
		return true;
	}

	public String getWinner() {
		return "O";
	}

	public void selectX(int i, int j) {
		// TODO Auto-generated method stub

	}

	public GameState getState() {
		return GameState.CONTINUE;
	}

	public static enum GameState {
		CONTINUE, DRAW, WINNER;
	}

	public static enum GamePlayer {
		O, X;
	}

}
