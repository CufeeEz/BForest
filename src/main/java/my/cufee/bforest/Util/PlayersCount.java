package my.cufee.bforest.Util;

import my.cufee.bforest.Arena.GameCreate;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;


public class PlayersCount {
    public static int count = 0;
    public static void addPlayer(Player player, int id) {
        playersOnGame[id] = (player);
    }
    public static Player[] createArrayPlayersOnGame(int count){
        return playersOnGame = new Player[GameCreate.CreatePlayersCount];
    }
    public static Player[] playersOnGame;
}

