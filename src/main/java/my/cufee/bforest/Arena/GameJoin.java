package my.cufee.bforest.Arena;

import my.cufee.bforest.BForest;
import my.cufee.bforest.Game.GetRole;
import my.cufee.bforest.Game.StartGame;
import my.cufee.bforest.Util.ChatUtil;
import my.cufee.bforest.Util.PlayersCount;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;


public class GameJoin implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player GamePlayer = (Player) commandSender;
            if (GameStatus){
                if (PlayersCount.count <= (int ) GameCreate.CreatePlayersCount){
                    if (!Arrays.asList(PlayersCount.playersOnGame).contains(GamePlayer)) {
                        PlayersCount.addPlayer(GamePlayer, PlayersCount.count);
                        PlayersCount.count += 1;
                        Bukkit.broadcastMessage(ChatColor.GRAY + GamePlayer.getName() + ChatColor.GREEN +
                                " подключился (" + PlayersCount.count + "/" + GameCreate.CreatePlayersCount + ")");
                        GamePlayer.teleport(ArenaLocation.getLocHubGame());
                        if (PlayersCount.count == (int) GameCreate.CreatePlayersCount) {
                            StartGame.setMurderRole();
                            ChatUtil.GameRule(StartGame.murderRole);
                        }
                    }
                    else {
                        commandSender.sendMessage(ChatColor.RED + "Вы уже в игре!" + ChatColor.GRAY +
                                "\nДля выхода из игры напишите /BFleave");
                    }
                }
                else {
                    commandSender.sendMessage(ChatColor.RED + "В игре максимальное количество игроков");
                }
            }
            else {
                commandSender.sendMessage(ChatColor.RED + "Игра не запущена, ожидайте запуск игры!");
            }
        }
        else {
            commandSender.sendMessage(ChatColor.RED + "Вы не игрок!");
        }
        return false;
    }
    public static boolean GameStatus = false;
}

