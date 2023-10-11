package my.cufee.bforest;

import my.cufee.bforest.Arena.GameDelete;
import my.cufee.bforest.Arena.GameJoin;
import my.cufee.bforest.Arena.GameCreate;
import my.cufee.bforest.Arena.GameLeave;
import my.cufee.bforest.Event.SendingInSpectator;
import org.bukkit.plugin.java.JavaPlugin;

public final class BForest extends JavaPlugin {
    private static BForest instance;


    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        getCommand("BFjoin").setExecutor(new GameJoin());
        getCommand("BFcreate").setExecutor(new GameCreate());
        getCommand("BFleave").setExecutor(new GameLeave());
        getCommand("BFdelete").setExecutor(new GameDelete());
        getServer().getPluginManager().registerEvents(new SendingInSpectator(), this);
    }
    public static BForest getInstance() {
        return instance;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
