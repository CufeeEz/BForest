package my.cufee.bforest.Util;


import my.cufee.bforest.Arena.ArenaLocation;
import my.cufee.bforest.BForest;
import my.cufee.bforest.Game.StartGame;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;




public class ChatUtil {

    public static int TimeOut = 5;
    public static int timer1 = 11;
    public static int timerIdGameRule;
    public static void GameRule(Player murder) {

        timerIdGameRule = Bukkit.getScheduler().runTaskTimer(BForest.getInstance(), () -> {
            if(timer1 == 0) {
                timer1--;
                TimeOut();
                Bukkit.getScheduler().cancelTask(timerIdGameRule);
            }
            else if(timer1 == 6){
                ChatBroadcastMessege.SendMessages(ChatColor.GOLD + "Маньяком был выбран - " + murder.getName());
                StartGame.beginGame(PlayersCount.playersOnGame);
                timer1--;
            }
            else if(timer1 == 5){
                ChatBroadcastMessege.SendMessages(ChatColor.GREEN + "Делай все возможное что бы выжить до утра");
                timer1--;
            }
            else if(timer1 == 4){
                ChatBroadcastMessege.SendMessages(ChatColor.GREEN + "Бегай, бей, прячься");
                timer1--;
            }
            else if(timer1 == 3){
                ChatBroadcastMessege.SendMessages(ChatColor.GREEN + "И помни, у маньяка отличное зрение");
                timer1--;
            }
            else if(timer1 == 2) {
                ChatBroadcastMessege.SendMessages(ChatColor.GREEN + "Удачи");
                timer1--;
            }
            else if(timer1 == 1) {
                ChatBroadcastMessege.SendMessages(ChatColor.AQUA + "У выживших есть 1 минута чтобы спрятаться");
                timer1--;
            }
            else if(timer1 >= 7 & timer1 <= 11){
                ChatBroadcastMessege.SendMessages(ChatColor.DARK_GREEN + "До начала игры осталось " + TimeOut);
                TimeOut--;
                timer1--;
            }
        }, 20, 20).getTaskId();
    }


    static Player murder = StartGame.murderRole;
    public static int timer2 = 60;
    public static int timerTimeOut;
    public static void TimeOut() {
        timerTimeOut = Bukkit.getScheduler().runTaskTimer(BForest.getInstance(), () -> {
            if(timer2 == 0) {

                ChatBroadcastMessege.SendMessages(ChatColor.AQUA + murder.getName() + " идет убивать!");
                murder.teleport(ArenaLocation.getLocSpawnMurder());
                Bukkit.getScheduler().cancelTask(timerTimeOut);
            }
            else if(timer2 == 30){
                ChatBroadcastMessege.SendMessages(ChatColor.DARK_RED + "У выживших осталось 30 секунд чтобы спрятаться");
                timer2--;
            }
            else if(timer2 == 10){
                ChatBroadcastMessege.SendMessages(ChatColor.DARK_RED + "У выживших осталось 10 секунд чтобы спрятаться");
                timer2--;
            }
            else {
                timer2--;
            }
        }, 20, 20).getTaskId();
    }
}
