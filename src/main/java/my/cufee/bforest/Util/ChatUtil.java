package my.cufee.bforest.Util;

import my.cufee.bforest.Arena.GameJoin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class ChatUtil {
    private CommandSender.Spigot commandSender;

    public static void Сountdown(List<String> ListPlayersOnGame){
        for(String Player : ListPlayersOnGame){
            Player PlayerSenderMassage = Bukkit.getPlayer(Player);
            if (PlayerSenderMassage != null) {
                PlayerSenderMassage.sendMessage(ChatColor.DARK_GREEN + "Игра начнется через 5 секунд");
                GameJoin.TimeSleep(1000);
                PlayerSenderMassage.sendMessage(ChatColor.DARK_GREEN + "Игра начнется через 4 секунды");
                GameJoin.TimeSleep(1000);
                PlayerSenderMassage.sendMessage(ChatColor.DARK_GREEN + "Игра начнется через 3 секунды");
                GameJoin.TimeSleep(1000);
                PlayerSenderMassage.sendMessage(ChatColor.DARK_GREEN + "Игра начнется через 2 секунды");
                GameJoin.TimeSleep(1000);
                PlayerSenderMassage.sendMessage(ChatColor.DARK_GREEN + "Игра начнется через 1 секунду!");
                GameJoin.TimeSleep(1000);
            }
        }
    }
    public static void GameRule(String murder, List<String> ListPlayersOnGame){
        for(String Player : ListPlayersOnGame) {
            Player PlayerSenderMassage = Bukkit.getPlayer(Player);
            PlayerSenderMassage.sendMessage(ChatColor.GOLD + "Маньяком был выбран - " + murder);
            GameJoin.TimeSleep(500);
            PlayerSenderMassage.sendMessage(ChatColor.GREEN + "Делай все возможное что бы выжить до утра");
            GameJoin.TimeSleep(500);
            PlayerSenderMassage.sendMessage(ChatColor.GREEN + "Бегай, бей, прячься");
            GameJoin.TimeSleep(500);
            PlayerSenderMassage.sendMessage(ChatColor.GREEN + "И помни, у маньяка отличное зрение");
            GameJoin.TimeSleep(500);
            PlayerSenderMassage.sendMessage(ChatColor.GREEN + "Удачи");
        }
    }
}
