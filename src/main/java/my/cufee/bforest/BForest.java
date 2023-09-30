package my.cufee.bforest;

import my.cufee.bforest.Arena.GameJoin;
import my.cufee.bforest.Arena.GameCreate;
import my.cufee.bforest.Arena.GameLeave;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class BForest extends JavaPlugin {

    public static BForest ChatUtil;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("BFjoin").setExecutor(new GameJoin());
        getCommand("BFcreate").setExecutor(new GameCreate());
        getCommand("BFleave").setExecutor(new GameLeave());
        ChatUtil = this;

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
