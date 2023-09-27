package my.cufee.bforest.Arena;

import my.cufee.bforest.Util.PlayersCount;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GameLeave implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player GamePlayer = (Player) commandSender;
            if (GameJoin.GameStatus){
                if (PlayersCount.playersOnGame.contains(GamePlayer.getName())){
                    PlayersCount.count -= 1;
                    Bukkit.broadcastMessage(ChatColor.GRAY + GamePlayer.getName() + ChatColor.GREEN +
                            " вышел из игры (" + PlayersCount.count + "/" + GameCreate.CreatePlayersCount + ")");
                    PlayersCount.playersOnGame.remove(GamePlayer.getName());
                    System.out.println(PlayersCount.playersOnGame);
                    GamePlayer.teleport(ArenaLocation.getLocSpawn());
                }
                else {
                    commandSender.sendMessage(ChatColor.RED + "Вы не в игре!");
                }
            }
            else {
                commandSender.sendMessage(ChatColor.RED + "Игра не запущена!");
            }

        }
        else {
            commandSender.sendMessage(ChatColor.RED + "Вы не игрок!");
        }
        return false;
    }
}
