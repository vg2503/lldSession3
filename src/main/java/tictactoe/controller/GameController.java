package tictactoe.controller;

import tictactoe.exceptions.InvalidMoveException;
import tictactoe.model.Game;
import tictactoe.model.Move;
import tictactoe.model.Player;
import tictactoe.strategy.winningStrategy.WinningStrategy;

import java.util.*;
public class GameController{
    public Game startGame(int boardSize, List<Player> players, List<WinningStrategy> winningStrategiesList){
        Game.GameBuilder gameBuilderObj = Game.getGameBuilder();
        return gameBuilderObj
                .setBoardSize(boardSize)
                .setPlayers(players)
                .setWinningStrategy(winningStrategiesList)
                .build();
    }

    public void display(Game game){
        game.display();
    }

    public void makeMove(Game game) {
        try
        {
            game.makeMove();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
