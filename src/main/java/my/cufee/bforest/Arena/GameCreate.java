package my.cufee.bforest.Arena;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GameCreate implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player GameCreator = (Player) commandSender;
            if(GameCreator.isOp()) {
                Bukkit.broadcastMessage(ChatColor.GREEN + GameCreator.getName() + " создал игру!" +
                        ChatColor.YELLOW + "\nДля подключение напишите /FBjoin");

            }
            else {
                commandSender.sendMessage(ChatColor.RED + "Вы не оператор!");
            }
        } else {
            commandSender.sendMessage(ChatColor.RED + "Вы не игрок!");

        }
        return false;
    }
}
