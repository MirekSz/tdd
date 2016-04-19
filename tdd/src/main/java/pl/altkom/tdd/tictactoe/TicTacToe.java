package pl.altkom.tdd.tictactoe;

public class TicTacToe {

	private GamePlayer[][] board = new GamePlayer[3][3];
	private GamePlayer currentPlayer;
	private GameState state;
	private GamePlayer winner;

	public boolean isEmpty() {
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				if (board[x][y] != null) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean isFull() {
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				if (board[x][y] == null) {
					return false;
				}
			}
		}
		return true;
	}

	public void selectO(int x, int y) {
		select(GamePlayer.O, x, y);
	}

	private void validate(GamePlayer player) {
		if (this.state == GameState.WINNER || this.state == GameState.DRAW) {
			throw new IllegalStateException();
		}
		if ((currentPlayer != null) && (currentPlayer == player)) {
			throw new IllegalStateException();
		}
	}

	public boolean isSelected(int x, int y) {
		return board[x - 1][y - 1] != null;
	}

	public GamePlayer getWinner() {
		return this.winner;
	}

	public void selectX(int x, int y) {
		select(GamePlayer.X, x, y);
	}

	private void select(GamePlayer player, int x, int y) {
		validate(player);

		this.currentPlayer = player;
		GamePlayer gamePlayer = board[x - 1][y - 1];
		if (gamePlayer != null) {
			throw new IllegalStateException();
		}
		board[x - 1][y - 1] = player;

		calculateGameState();
	}

	private void calculateGameState() {
		this.state = GameState.CONTINUE;
		if (board[0][0] == board[1][0] && board[1][0] == board[2][0]) {
			this.state = GameState.WINNER;
			this.winner = board[0][0];
			return;
		}
		if (isFull()) {
			this.state = GameState.DRAW;
		}

	}

	public GameState getState() {
		return this.state;
	}

	public static enum GameState {
		CONTINUE, DRAW, WINNER;
	}

	public static enum GamePlayer {
		O, X;
	}

}
