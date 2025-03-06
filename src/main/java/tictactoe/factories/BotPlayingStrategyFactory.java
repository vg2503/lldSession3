package tictactoe.factories;

import tictactoe.model.BotLevel;
import tictactoe.strategy.botPlayingStrategy.BotPlayingStrategy;
import tictactoe.strategy.botPlayingStrategy.EasyBotPlayingStrategy;
import tictactoe.strategy.botPlayingStrategy.HardBotPlayingStrategy;
import tictactoe.strategy.botPlayingStrategy.MediumBotPlayingStrategy;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategy(BotLevel botLevel) {
        switch (botLevel) {
            case EASY -> {
                return new EasyBotPlayingStrategy();
            }
            case MEDIUM -> {
                return new MediumBotPlayingStrategy();
            }
            case HARD -> {
                return new HardBotPlayingStrategy();
            }
        }
        return null;
    }
}
