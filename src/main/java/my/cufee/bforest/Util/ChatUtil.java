package my.cufee.bforest.Util;


import my.cufee.bforest.BForest;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.List;

public class ChatUtil {
    private CommandSender.Spigot commandSender;

    public static void Сountdown(List<String> ListPlayersOnGame){
        for(String Player : ListPlayersOnGame){
            Player PlayerSenderMassage = Bukkit.getPlayer(Player);
            if (PlayerSenderMassage != null) {
                PlayerSenderMassage.sendMessage(ChatColor.DARK_GREEN + "Игра начнется через 5 секунд");
                dfsdfdf();
                PlayerSenderMassage.sendMessage(ChatColor.DARK_GREEN + "Игра начнется через 4 секунды");
                dfsdfdf();
                PlayerSenderMassage.sendMessage(ChatColor.DARK_GREEN + "Игра начнется через 3 секунды");
                dfsdfdf();
                PlayerSenderMassage.sendMessage(ChatColor.DARK_GREEN + "Игра начнется через 2 секунды");
                dfsdfdf();
                PlayerSenderMassage.sendMessage(ChatColor.DARK_GREEN + "Игра начнется через 1 секунду!");
                dfsdfdf();
            }
        }
    }
    public static void GameRule(String murder, List<String> ListPlayersOnGame){
        for(String Player : ListPlayersOnGame) {
            Player PlayerSenderMassage = Bukkit.getPlayer(Player);
            PlayerSenderMassage.sendMessage(ChatColor.GOLD + "Маньяком был выбран - " + murder);
            dfsdfdf();
            PlayerSenderMassage.sendMessage(ChatColor.GREEN + "Делай все возможное что бы выжить до утра");
            dfsdfdf();
            PlayerSenderMassage.sendMessage(ChatColor.GREEN + "Бегай, бей, прячься");
            dfsdfdf();
            PlayerSenderMassage.sendMessage(ChatColor.GREEN + "И помни, у маньяка отличное зрение");
            dfsdfdf();
            PlayerSenderMassage.sendMessage(ChatColor.GREEN + "Удачи");
        }
    }
    public static void СountdownStart(List<String> ListPlayersOnGame) {
        for (String Player : ListPlayersOnGame) {
            Player PlayerSenderMassage = Bukkit.getPlayer(Player);
            dfsdfdf();
            PlayerSenderMassage.sendMessage(ChatColor.AQUA + "У выживших есть 1 минута чтобы спрятаться");
        }
    }
    public static void dfsdfdf(){
        Bukkit.getScheduler().runTaskTimer(BForest.ChatUtil, new Runnable() {
            int ticks = 20;

            @Override
            public void run() {
                if (ticks <= 0) {
                    // Код, который будет выполняться после заданной задержки
                    //Bukkit.getScheduler().cancelTasks(plugin); // Отмена задания
                    return;
                }

                // Ваш код, который будет выполняться каждый тик
                ticks--;
            }
        }, 0, 1);
    }
}
