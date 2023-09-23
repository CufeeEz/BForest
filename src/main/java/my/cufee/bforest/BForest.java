package my.cufee.bforest;

import my.cufee.bforest.Arena.Arena;
import my.cufee.bforest.Arena.GameCreate;
import my.cufee.bforest.Arena.GameLeave;
import org.bukkit.plugin.java.JavaPlugin;

public final class BForest extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("BFjoin").setExecutor(new Arena());
        getCommand("BFcreate").setExecutor(new GameCreate());
        getCommand("BFleave").setExecutor(new GameLeave());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
