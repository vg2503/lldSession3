package tictactoe;

import tictactoe.controller.GameController;
import tictactoe.model.*;
import tictactoe.strategy.winningStrategy.ColumnWinningStrategy;
import tictactoe.strategy.winningStrategy.DiagonalWinningStrategy;
import tictactoe.strategy.winningStrategy.RowWinningStrategy;
import tictactoe.strategy.winningStrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        System.out.println("Welcome to TicTacToe Game");
        int boardSize = 3;

        Player player = new HumanPlayer(1, "John", new Symbol('#'));
        Player player2 = new BotPlayer(2, "Steve", new Symbol('0'),BotLevel.EASY);
        //Player player3 = new BotPlayer(3, "Bot James", new Symbol('^'), BotLevel.EASY);
        WinningStrategy winningStrategy1 = new RowWinningStrategy();
        WinningStrategy winningStrategy2 = new ColumnWinningStrategy();
        WinningStrategy winningStrategy3 = new DiagonalWinningStrategy();
        List<WinningStrategy> winningStrategies = List.of(winningStrategy1, winningStrategy2, winningStrategy3);
        List<Player> players = List.of(player, player2);
        GameController gameController = new GameController();
        Game gameObj = gameController.startGame(boardSize,players,winningStrategies);

        while(gameObj.getGameState() == GameState.IN_PROGRESS){
            //play the game
            gameController.display(gameObj);
            gameController.makeMove(gameObj);
        }
        System.out.println("Game Ends");

    }
}
