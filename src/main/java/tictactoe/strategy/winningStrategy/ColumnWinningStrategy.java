package tictactoe.strategy.winningStrategy;

import tictactoe.model.*;

import java.util.HashMap;
import java.util.Map;


public class ColumnWinningStrategy implements WinningStrategy{
    private Map<Integer, Map<Symbol,Integer>> colWinningMap;
    public ColumnWinningStrategy() {
        this.colWinningMap = new HashMap<>();
    }
    @Override
    public boolean checkWinner(Board board, Move move) {
        int col = move.getCell().getCol();
        Symbol currSymbol = move.getPlayer().getSymbol();
        if(!colWinningMap.containsKey(col)){
            colWinningMap.put(col, new HashMap<>());
        }

        if(!colWinningMap.get(col).containsKey(currSymbol)){
            colWinningMap.get(col).put(currSymbol, 1);
        }
        else{
            colWinningMap.get(col).put(currSymbol, colWinningMap.get(col).get(currSymbol) + 1);
        }
        if(colWinningMap.get(col).get(currSymbol) == board.getSize()){
            return true;
        }
        return false;
    }
}
