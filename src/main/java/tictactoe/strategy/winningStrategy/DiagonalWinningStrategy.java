package tictactoe.strategy.winningStrategy;

import tictactoe.model.*;
import tictactoe.model.Cell;
import tictactoe.model.Player;

public class DiagonalWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Move move) {
        return false;
    }
}
