package my.cufee.bforest.Arena;

import my.cufee.bforest.BForest;
import my.cufee.bforest.Event.ProcessGame;
import my.cufee.bforest.Game.StartGame;
import my.cufee.bforest.Util.ChatUtil;
import my.cufee.bforest.Util.PlayersCount;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

import java.util.Arrays;

public class EndGame {
    public static void deleteGame(Player[] ArrayPlayers) {
        GameJoin.GameStatus = false;
        GameCreate.CreatePlayersCount = 0;
        PlayersCount.count = 0;
        StartGame.murderRole = null;
        for (Player player : ArrayPlayers) {
            player.setGameMode(GameMode.ADVENTURE);
            for (PotionEffect pt : player.getActivePotionEffects()) {
                player.removePotionEffect(pt.getType());
                player.getInventory().clear();
                player.setHealth(20);
                player.teleport(ArenaLocation.getLocLobby());
                player.setFoodLevel(20);
            }
        }
        Arrays.fill(PlayersCount.playersOnGame, null);
        Bukkit.broadcastMessage("Игра окончена");
        Bukkit.getScheduler().cancelTask(ChatUtil.timerIdGameRule);
        Bukkit.getScheduler().cancelTask(ChatUtil.timerTimeOut);
        Bukkit.getScheduler().cancelTask(ChatUtil.timerIdGameProcess);
    }
}
