package my.cufee.bforest.Event;

import my.cufee.bforest.Arena.GameCreate;
import my.cufee.bforest.Util.ChatBroadcastMessege;
import my.cufee.bforest.Util.PlayersCount;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class SendingInSpectator implements Listener {
    int playerDeathCount = 1;
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        if (isPlayerInArray(player)) {
            playerDeathCount++;
            player.setGameMode(GameMode.SPECTATOR);
            if (playerDeathCount == GameCreate.CreatePlayersCount) {
                ChatBroadcastMessege.SendMessages("Победил убийца!");
            }
        }
    }
    private boolean isPlayerInArray(Player player) {
        Player[] playersArray = PlayersCount.playersOnGame;
        for (Player p : playersArray) {
            if (p != null && p.equals(player)) {
                return true;
            }
        }
        return false;
    }
}
