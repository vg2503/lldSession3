package tictactoe.model;

import tictactoe.factories.BotPlayingStrategyFactory;
import tictactoe.strategy.botPlayingStrategy.BotPlayingStrategy;

public class BotPlayer extends Player{
    private BotLevel botLevel;
    private BotPlayingStrategy botLevelStrategy;

    public BotPlayer(int id, String name, Symbol symbol, BotLevel botLevel) {
        super(id, name, symbol, PlayerType.BOT);
        this.botLevel = botLevel;
        this.botLevelStrategy = BotPlayingStrategyFactory.getBotPlayingStrategy(botLevel);
    }

    public BotLevel getBotLevel() {
        return botLevel;
    }

    public void setBotLevel(BotLevel botLevel) {
        this.botLevel = botLevel;
    }

    public BotPlayingStrategy getBotLevelStrategy() {
        return botLevelStrategy;
    }

    public void setBotLevelStrategy(BotPlayingStrategy botLevelStrategy) {
        this.botLevelStrategy = botLevelStrategy;
    }

    @Override
    public Move makeMove(Board board) {
        return botLevelStrategy.makeMove( board);
    }
}
