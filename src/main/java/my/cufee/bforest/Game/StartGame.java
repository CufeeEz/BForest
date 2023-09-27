package my.cufee.bforest.Game;

import my.cufee.bforest.Util.ChatUtil;
import my.cufee.bforest.Util.PlayersCount;

import java.util.List;
import java.util.Objects;

public class StartGame {

    static String murderRole = GetRole.GetMurderRole(PlayersCount.playersOnGame);
    public static void beginGame(List<String> ArrayPlayers){
        preBeginGame(ArrayPlayers);






    }
    private static void preBeginGame(List<String> ArrayPlayers) {
        ChatUtil.GameRule(murderRole, PlayersCount.playersOnGame);
        for (int i = 0; i < ArrayPlayers.size(); i++) {
            if (Objects.equals(murderRole, ArrayPlayers.get(i))) {
                PlayersCount.SurvivorPlayers.add(ArrayPlayers.get(i));
            }
        }
    }

}
