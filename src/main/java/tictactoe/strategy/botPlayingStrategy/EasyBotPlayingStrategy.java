package tictactoe.strategy.botPlayingStrategy;

import tictactoe.model.*;

public class EasyBotPlayingStrategy implements BotPlayingStrategy {
    @Override
    public Move makeMove(Board board) {
        for(int i = 0; i < board.getGrid().size(); i++) {
            for(int j = 0; j < board.getGrid().get(i).size(); j++) {
                Cell cell = board.getGrid().get(i).get(j);
                if(cell.getCellState() == CellState.EMPTY){
                    return new Move(null,cell);
                }
            }
        }
        return null;
    }
}
