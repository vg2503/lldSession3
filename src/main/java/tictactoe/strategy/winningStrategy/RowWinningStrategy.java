package tictactoe.strategy.winningStrategy;

import tictactoe.model.*;

import java.util.*;


public class RowWinningStrategy implements  WinningStrategy{
    private Map<Integer, Map<Character,Integer>> rowWinningMap;
    public RowWinningStrategy() {
        this.rowWinningMap = new HashMap<>();
    }
    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        Character symbol = move.getPlayer().getSymbol().getPlayerSymbol();
        if(!rowWinningMap.containsKey(row)) {
            rowWinningMap.put(row, new HashMap<>());
        }

        Map<Character, Integer> currRowMap = rowWinningMap.get(row);
        if(!currRowMap.containsKey(symbol)) {
            currRowMap.put(symbol, 1);
        }
        else{
            currRowMap.put(symbol, currRowMap.get(symbol) + 1);
        }

        if(currRowMap.get(symbol) == board.getSize()) {
            return true;
        }
        return false;
    }
}
