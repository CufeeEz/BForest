package my.cufee.bforest.Event;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class SendingInSpectator implements Listener {
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();

        // Определите логику, когда игрок умирает и должен стать спектатором
        // Например, вы можете установить игрока в режим спектатора (GameMode.SPECTATOR)

        player.setGameMode(GameMode.SPECTATOR);
    }
}
