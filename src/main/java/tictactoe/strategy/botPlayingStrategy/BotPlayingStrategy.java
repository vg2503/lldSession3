package tictactoe.strategy.botPlayingStrategy;

import tictactoe.model.Board;
import tictactoe.model.Move;
import tictactoe.model.Player;

public interface BotPlayingStrategy {
    public Move makeMove(Board board);
}
