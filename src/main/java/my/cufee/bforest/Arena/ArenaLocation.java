package my.cufee.bforest.Arena;


import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class ArenaLocation {
    World world = Bukkit.getWorld("world");

    public static Location getLocLobby() {
        World world = Bukkit.getWorld("world");
        Location LobbyLoc = new Location(world, -99.0, 116.0, 58.5);
        return LobbyLoc;
    }
    public static Location getLocSpawnSurvivor() {
        World world = Bukkit.getWorld("world");
        Location LocSpawnSurvivor = new Location(world, -67.5, 690.0, 59.5);
        return LocSpawnSurvivor;
    }
    public static Location getLocSpawnMurder() {
        World world = Bukkit.getWorld("world");
        Location LocSpawnSurvivor = new Location(world, -53.5, 70.0, 61.5);
        return LocSpawnSurvivor;
    }
    public static Location getLocPreSpawnMurder() {
        World world = Bukkit.getWorld("world");
        Location LocSpawnSurvivor = new Location(world, 67.5, 113.0, 61.5);
        return LocSpawnSurvivor;
    }
    public static Location getLocHubGame() {
        World world = Bukkit.getWorld("world");
        Location SpawnLoc = new Location(world, -52.5, 113.0, 102.5);
        return SpawnLoc;
    }
}
