package tictactoe.model;

import tictactoe.strategy.winningStrategy.WinningStrategy;

import java.util.*;

public class Game {
    private Board board;
    private List<Player> players;
    private Player winner;
    private List<Move> moves;
    private int nextPlayerIndex;
    private GameState gameState;
    private List<WinningStrategy> winningStrategies;
    public Game(GameBuilder builder) {
        this.board = builder.board;
        this.players = builder.players;
        this.moves = builder.moves;
        this.nextPlayerIndex = builder.nextPlayerIndex;
        this.winner = builder.winner;
        this.gameState = builder.gameState;
        this.winningStrategies = builder.winningStrategy;
    }
    public static class GameBuilder{
        private Board board;
        private List<Player> players;
        private Player winner;
        private List<Move> moves;
        private int nextPlayerIndex;
        private List<WinningStrategy> winningStrategy;
        private GameState gameState;
        public GameBuilder setBoard(Board board){
            this.board = board;
            return this;
        }

        public GameBuilder setPlayers(List<Player> players){
            this.players = players;
            return this;
        }
        public GameBuilder setWinner(Player winner){
            this.winner = winner;
            return this;
        }

        public GameBuilder setMoves(List<Move> moves){
            this.moves = moves;
            return this;
        }

        public GameBuilder setNextPlayerIndex(int nextPlayerIndex){
            this.nextPlayerIndex = nextPlayerIndex;
            return this;
        }

        public GameBuilder setWinningStrategy(List<WinningStrategy> winningStrategy){
            this.winningStrategy = winningStrategy;
            return this;
        }

        public GameBuilder setGameState(GameState gameState){
            this.gameState = gameState;
            return this;
        }

        public Game build(){
            //perform the validation here
            return new Game(this);
        }

    }
}
