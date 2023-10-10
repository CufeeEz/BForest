package my.cufee.bforest.Arena;

import my.cufee.bforest.Game.StartGame;
import my.cufee.bforest.Util.PlayersCount;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class EndGame {
    public static void deleteGame(Player[] ArrayPlayers) {
        GameJoin.GameStatus = false;
        GameCreate.CreatePlayersCount = 0;
        PlayersCount.count = 0;
        StartGame.murderRole = null;
        Arrays.fill(PlayersCount.playersOnGame, null);
        Bukkit.broadcastMessage("Игра окончена");
        for (int i = 0; i < ArrayPlayers.length; i++){
            Player player = ArrayPlayers[i];
            player.setGameMode(GameMode.ADVENTURE);
        }
    }
}
