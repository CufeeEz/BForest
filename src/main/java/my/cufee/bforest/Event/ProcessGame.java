package my.cufee.bforest.Event;

import my.cufee.bforest.Arena.EndGame;
import my.cufee.bforest.BForest;
import my.cufee.bforest.Game.StartGame;
import my.cufee.bforest.Util.ChatBroadcastMessege;
import my.cufee.bforest.Util.PlayersCount;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class ProcessGame implements Listener {
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        if (player.equals(StartGame.murderRole)) {
            EndGame.deleteGame(PlayersCount.playersOnGame);
            ChatBroadcastMessege.SendMessages("Победили мирные!");
        }
    }
}
