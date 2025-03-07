package tictactoe.model;

import tictactoe.exceptions.InvalidMoveException;
import tictactoe.strategy.winningStrategy.WinningStrategy;

import java.util.*;

public class Game {
    public Board getBoard() {
        return board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player getWinner() {
        return winner;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public GameState getGameState() {
        return gameState;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

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

    private boolean validateMove(Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        if(row < 0 || row >= this.board.getSize() || col < 0 || col >= this.board.getSize()) {
            return false;
        }

        Cell boardCell = this.board.getGrid().get(row).get(col);
        if(boardCell.getCellState() == CellState.FILLED) {
            return false;
        }

        return true;
    }

    public void makeMove() throws InvalidMoveException {
        Player player = players.get(nextPlayerIndex);
        System.out.println("Player " + player.getName() + "'s turn");
        Move playerMove = player.makeMove(this.getBoard());
        if(!validateMove(playerMove)){
            throw new InvalidMoveException("Invalid move selected.. Try Again");
        }
        int row = playerMove.getCell().getRow();
        int col = playerMove.getCell().getCol();
        Cell cell = board.getGrid().get(row).get(col);
        cell.setCellState(CellState.FILLED);
        cell.setPlayer(player);
        Move actualMove = new Move(player, cell);
        moves.add(actualMove);
        nextPlayerIndex = (nextPlayerIndex + 1) % players.size();
        if (checkGameWinner(actualMove, player)) return;
        if(moves.size() == board.getSize() * board.getSize()) {
            System.out.println("Game is a draw..");
            gameState = GameState.DRAW;
        }
    }

    private boolean checkGameWinner(Move actualMove, Player player) {
        for (WinningStrategy winningStrategy : winningStrategies) {
            if(winningStrategy.checkWinner(board, actualMove)){
                gameState = GameState.ENDED;
                winner = player;
                System.out.println("Winner is " + player.getName());
                return true;
            }
        }
        return false;
    }

    public void display(){
        Board board = getBoard();
        for (int i = 0; i < board.getGrid().size(); i++) {
            for (int j = 0; j < board.getGrid().get(i).size(); j++) {
                Cell cell = board.getGrid().get(i).get(j);
                char sym = cell.getCellState() == CellState.EMPTY ? '_' : cell.getPlayer().getSymbol().getPlayerSymbol();
                System.out.print("|" + sym + "|");
            }
            System.out.println();
        }

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
