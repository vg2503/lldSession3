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

    public static GameBuilder getGameBuilder() {
        return new GameBuilder();
    }

    public Game(GameBuilder builder) {
        this.board = new Board(builder.boardSize);
        this.players = builder.players;
        this.moves = new ArrayList<>();
        this.nextPlayerIndex = 0;
        this.winner = null;
        this.gameState = GameState.IN_PROGRESS;
        this.winningStrategies = builder.winningStrategy;
    }
    public static class GameBuilder{
        private int boardSize;
        private List<Player> players;
        private List<WinningStrategy> winningStrategy;

        private void ValidateBotPlayer(){
            int count = 0;
            for (Player player : players) {
                if(player.getPlayerType() == PlayerType.BOT){
                    count++;
                    if(count > 1){
                        throw new RuntimeException("Game cannot have more than one BOT player");
                    }
                }
            }
        }

        private void validateNoOfPlayers(){
            if(players.size() >= boardSize){
                throw new RuntimeException("Players cannot have more than size of board");
            }
        }

        private void ValidateSymbols(){
            HashSet<Character> symbolsSet = new HashSet<>();

            for(Player player : players){
                if(symbolsSet.contains(player.getSymbol().getPlayerSymbol())){
                    throw new RuntimeException("Symbols cannot have more than one symbol");
                }
                symbolsSet.add(player.getSymbol().getPlayerSymbol());
            }
        }

        private void validateGameObject(){
            validateNoOfPlayers();
            ValidateSymbols();
            ValidateBotPlayer();
        }

        public GameBuilder setBoardSize(int boardSize){
            this.boardSize = boardSize;
            return this;
        }

        public GameBuilder setPlayers(List<Player> players){
            this.players = new ArrayList<>(players);
            return this;
        }

        public GameBuilder setWinningStrategy(List<WinningStrategy> winningStrategy){
            this.winningStrategy = new ArrayList<>(winningStrategy);
            return this;
        }

        public Game build(){
            //perform the validation here
            validateGameObject();
            return new Game(this);
        }

    }
}
