package tictactoe.strategy.winningStrategy;

import tictactoe.model.Board;
import tictactoe.model.Cell;
import tictactoe.model.Player;

public class RowWinningStrategy implements  WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Player player, Cell cell) {
        return false;
    }
}
