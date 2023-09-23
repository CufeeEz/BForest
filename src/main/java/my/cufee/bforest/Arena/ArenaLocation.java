package my.cufee.bforest.Arena;

import my.cufee.bforest.BForest;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class ArenaLocation {
    public static Location getLocLobby() {
        World world = Bukkit.getWorld("world");
        Location LobbyLoc = new Location(world, 0.5, -60.0, -35.5);
        return LobbyLoc;
    }
}
