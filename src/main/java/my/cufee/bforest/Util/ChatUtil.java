package my.cufee.bforest.Util;


import my.cufee.bforest.BForest;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


import java.util.List;

public class ChatUtil {

    public static void Сountdown(List<String> ListPlayersOnGame){
        for(String Player : ListPlayersOnGame){
            Player PlayerSenderMassage = Bukkit.getPlayer(Player);
            if (PlayerSenderMassage != null) {
                PlayerSenderMassage.sendMessage(ChatColor.DARK_GREEN + "Игра начнется через 5 секунд");

                PlayerSenderMassage.sendMessage(ChatColor.DARK_GREEN + "Игра начнется через 4 секунды");

                PlayerSenderMassage.sendMessage(ChatColor.DARK_GREEN + "Игра начнется через 3 секунды");

                PlayerSenderMassage.sendMessage(ChatColor.DARK_GREEN + "Игра начнется через 2 секунды");

                PlayerSenderMassage.sendMessage(ChatColor.DARK_GREEN + "Игра начнется через 1 секунду!");

            }
        }
    }
    public static void GameRule(String murder, List<String> ListPlayersOnGame){
        for(String Player : ListPlayersOnGame) {
            Player PlayerSenderMassage = Bukkit.getPlayer(Player);
            PlayerSenderMassage.sendMessage(ChatColor.GOLD + "Маньяком был выбран - " + murder);

            PlayerSenderMassage.sendMessage(ChatColor.GREEN + "Делай все возможное что бы выжить до утра");

            PlayerSenderMassage.sendMessage(ChatColor.GREEN + "Бегай, бей, прячься");

            PlayerSenderMassage.sendMessage(ChatColor.GREEN + "И помни, у маньяка отличное зрение");

            PlayerSenderMassage.sendMessage(ChatColor.GREEN + "Удачи");
        }
    }
    public static void СountdownStart(List<String> ListPlayersOnGame) {
        for (String Player : ListPlayersOnGame) {
            Player PlayerSenderMassage = Bukkit.getPlayer(Player);

            PlayerSenderMassage.sendMessage(ChatColor.AQUA + "У выживших есть 1 минута чтобы спрятаться");
        }
    }

    public static int timer1 = 5;
    public static void startTimer(List<String> ListPlayersOnGame) {

        Bukkit.getScheduler().runTaskTimer(BForest.ChatUtil, () -> {
            if(timer1 == 0) {
                Bukkit.getScheduler().cancelTasks(BForest.ChatUtil);
            }
            else {
                for(String Player : ListPlayersOnGame){
                    Player PlayerSenderMassage = Bukkit.getPlayer(Player);
                PlayerSenderMassage.sendMessage(ChatColor.DARK_GREEN + "Игра начнется через " + timer1);
                }
                timer1--;
            }

        }, 20, 20);

    }
    public static int timer2 = 5;
    public void startTimerForRules(List<String> ListPlayersOnGame) {

        Bukkit.getScheduler().runTaskTimer(BForest.ChatUtil, () -> {
            if(timer2 == 0) {
                Bukkit.getScheduler().cancelTasks(BForest.ChatUtil);
            }
            else {
                for(String Player : ListPlayersOnGame){
                    Player PlayerSenderMassage = Bukkit.getPlayer(Player);
                    PlayerSenderMassage.sendMessage(ChatColor.DARK_GREEN + "Игра начнется через ");
                }
                //timer2--;
            }

        }, 20, 20);

    }
}
