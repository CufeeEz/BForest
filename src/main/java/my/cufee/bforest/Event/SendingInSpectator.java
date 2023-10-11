package my.cufee.bforest.Event;

import my.cufee.bforest.Arena.EndGame;
import my.cufee.bforest.Arena.GameCreate;
import my.cufee.bforest.Game.StartGame;
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
            if(player.equals(StartGame.murderRole)) {
                ChatBroadcastMessege.SendMessages("Победили мирные!");
                EndGame.deleteGame(PlayersCount.playersOnGame);
            }
            else {
                player.setGameMode(GameMode.SPECTATOR);
                if(playerDeathCount == GameCreate.CreatePlayersCount) {
                    ChatBroadcastMessege.SendMessages("Победил убийца!");
                    EndGame.deleteGame(PlayersCount.playersOnGame);
                }
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
