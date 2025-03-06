package tictactoe;

import tictactoe.model.Game;

import java.util.ArrayList;

public class Client {
    public static void main(String[] args) {
        Game.GameBuilder gameBuilderObj = new Game.GameBuilder();
        Game gameObj = gameBuilderObj
                .setBoard(null)
                .setMoves(new ArrayList<>())
                .setPlayers(new ArrayList<>())
                .setNextPlayerIndex(0)
                .setWinner(null)
                .setWinningStrategy(new ArrayList<>())
                .build();

    }
}
