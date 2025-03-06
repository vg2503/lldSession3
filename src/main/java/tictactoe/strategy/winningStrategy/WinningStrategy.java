package tictactoe.strategy.winningStrategy;

import tictactoe.model.Board;
import tictactoe.model.Cell;
import tictactoe.model.Player;

public interface WinningStrategy {
    public boolean checkWinner(Board board, Player player, Cell cell);
}
