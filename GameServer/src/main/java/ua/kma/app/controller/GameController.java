package ua.kma.app.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import ua.kma.app.game.GameState;
import ua.kma.app.game.Player;

import java.util.ArrayList;


@Controller
public class GameController {

    private ArrayList<String> usernames;

    private ArrayList<GameState> gameStates;

    @MessageMapping("/start_game")
    public void getInitState(Player player) throws Exception{
        usernames.add(player.getUsername());
        if (usernames.size() == 4) {
            sendInitStates();
        }
    }

    @SendTo("/topic/game_init")
    private ArrayList<GameState> sendInitStates() throws Exception{
        GameState gs1 = new GameState(usernames.get(0), 0, 0, false, true);
        GameState gs2 = new GameState(usernames.get(1), 0, 0, false, true);
        GameState gs3 = new GameState(usernames.get(2), 0, 0, false, true);
        GameState gs4 = new GameState(usernames.get(3), 0, 0, false, true);
        gameStates.add(gs1);
        gameStates.add(gs2);
        gameStates.add(gs3);
        gameStates.add(gs4);
        return gameStates;
    }

    @MessageMapping("/game")
    @SendTo("/topic/get_game_states")
    public ArrayList<GameState> getGameStates(GameState gameState) throws Exception{
        gameStates.set(usernames.indexOf(gameState.getUsername()), gameState);
        return gameStates;
    }

}
