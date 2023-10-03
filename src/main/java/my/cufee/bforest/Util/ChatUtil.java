package my.cufee.bforest.Util;


import my.cufee.bforest.Arena.ArenaLocation;
import my.cufee.bforest.BForest;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;




public class ChatUtil {

    public static int TimeOut = 5;
    public static int timer1 = 11;
    public static int timerIdGameRule;
    public static void GameRule(String murder) {

        timerIdGameRule = Bukkit.getScheduler().runTaskTimer(BForest.ChatUtil, () -> {
            if(timer1 == 0) {
                Bukkit.getScheduler().cancelTask(timerIdGameRule);
                TimeOut(murder);
            }
            else if(timer1 == 6){
               ChatBreadcastMassege.SendMassages(ChatColor.GOLD + "Маньяком был выбран - " + murder);
                timer1--;
            }
            else if(timer1 == 5){
                ChatBreadcastMassege.SendMassages(ChatColor.GREEN + "Делай все возможное что бы выжить до утра");
                timer1--;
            }
            else if(timer1 == 4){
                ChatBreadcastMassege.SendMassages(ChatColor.GREEN + "Бегай, бей, прячься");
                timer1--;
            }
            else if(timer1 == 3){
                ChatBreadcastMassege.SendMassages(ChatColor.GREEN + "И помни, у маньяка отличное зрение");
                timer1--;
            }
            else if(timer1 == 2) {
                ChatBreadcastMassege.SendMassages(ChatColor.GREEN + "Удачи");
                timer1--;
            }
            else if(timer1 == 1) {
                ChatBreadcastMassege.SendMassages(ChatColor.AQUA + "У выживших есть 1 минута чтобы спрятаться");
                timer1--;
            }
            else{
                ChatBreadcastMassege.SendMassages(ChatColor.DARK_GREEN + "До начала игры осталось " + TimeOut);
                TimeOut--;
                timer1--;
            }
        }, 20, 20).getTaskId();
    }



    public static int timer2 = 60;
    public static int timerTimeOut;
    public static void TimeOut(String murder) {
        timerTimeOut = Bukkit.getScheduler().runTaskTimer(BForest.ChatUtil, () -> {
            if(timer2 == 0) {
                Bukkit.getScheduler().cancelTask(timerTimeOut);
                ChatBreadcastMassege.SendMassages(ChatColor.AQUA + murder + " идет убивать!");
                Player MurderPlayer = Bukkit.getPlayerExact(murder);
                MurderPlayer.teleport(ArenaLocation.getLocSpawnMurder());
            }
            else if(timer2 == 30){
                ChatBreadcastMassege.SendMassages(ChatColor.DARK_RED + "У выживших осталось 30 секунд чтобы спрятаться");
                timer2--;
            }
            else if(timer2 == 10){
                ChatBreadcastMassege.SendMassages(ChatColor.DARK_RED + "У выживших осталось 10 секунд чтобы спрятаться");
                timer2--;
            }
            else {
                timer2--;
            }
        }, 20, 20).getTaskId();
    }
}
