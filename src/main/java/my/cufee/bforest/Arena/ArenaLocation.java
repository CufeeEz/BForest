package my.cufee.bforest.Arena;

import my.cufee.bforest.BForest;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class ArenaLocation {
    World world = Bukkit.getWorld("world");
    public static Location getLocLobby() {
        World world = Bukkit.getWorld("world");
        Location LobbyLoc = new Location(world, 0.5, -60.0, -35.5);
        return LobbyLoc;
    }
    public static Location getLocSpawnSurvivor() {
        World world = Bukkit.getWorld("world");
        Location LocSpawnSurvivor = new Location(world, 0.5, -60.0, -82.5);
        return LocSpawnSurvivor;
    }
    public static Location getLocSpawnMurder() {
        World world = Bukkit.getWorld("world");
        Location LocSpawnSurvivor = new Location(world, 0.5, -60.0, -219.5);
        return LocSpawnSurvivor;
    }
    public static Location getLocSpawn() {
        World world = Bukkit.getWorld("world");
        Location SpawnLoc = new Location(world, 0.5, -60.0, -35.5);
        return SpawnLoc;
    }
}
