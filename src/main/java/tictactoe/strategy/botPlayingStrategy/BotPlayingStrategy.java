package tictactoe.strategy.botPlayingStrategy;

import tictactoe.model.Board;
import tictactoe.model.Move;

public interface BotPlayingStrategy {
    public Move makeMove(Board board);
}
