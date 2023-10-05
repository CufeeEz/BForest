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
            Player gamePlayer = (Player) commandSender;
            if (GameJoin.GameStatus){
                if (PlayersCount.playersOnGame.equals(gamePlayer.getName())){
                    PlayersCount.count -= 1;
                    Bukkit.broadcastMessage(ChatColor.GRAY + gamePlayer.getName() + ChatColor.GREEN +
                            " вышел из игры (" + PlayersCount.count + "/" + GameCreate.CreatePlayersCount + ")");
                    for (int i = 0; i < PlayersCount.playersOnGame.length; i++) {
                        if (PlayersCount.playersOnGame[i].equals(gamePlayer)) {
                            // Найден игрок, который нужно удалить
                            PlayersCount.playersOnGame[i] = null;
                            break;
                        }
                    }
                    System.out.println(PlayersCount.playersOnGame);
                    gamePlayer.teleport(ArenaLocation.getLocSpawn());
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
