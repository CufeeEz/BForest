package my.cufee.bforest.Util;

import my.cufee.bforest.Arena.GameCreate;
import org.bukkit.entity.Player;

public class PlayersCount {
    public static int count = 0;
    public static Player[] playersOnGame = new Player[(int) GameCreate.CreatePlayersCount];
}

