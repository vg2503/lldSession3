package tictactoe;

import tictactoe.model.*;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        System.out.println("Welcome to TicTacToe Game");
        Game.GameBuilder gameBuilderObj = Game.getGameBuilder();
        Player player = new HumanPlayer(1, "John", new Symbol('#'));
        Player player2 = new HumanPlayer(2, "Steve", new Symbol('0'));
        Player player3 = new BotPlayer(3, "Bot James", new Symbol('^'), BotLevel.EASY);
        List<Player> players = List.of(player, player2, player3);
        Game gameObj = gameBuilderObj
                .setBoardSize(4)
                .setPlayers(players)
                .setWinningStrategy(new ArrayList<>())
                .build();
        System.out.println("Game Ends");

    }
}
