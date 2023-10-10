package my.cufee.bforest.Util;


import my.cufee.bforest.Arena.ArenaLocation;
import my.cufee.bforest.BForest;
import my.cufee.bforest.Game.StartGame;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;




public class ChatUtil {

    public static int TimeOut;
    public static int timer1;
    public static int timerIdGameRule;
    public static void GameRule(Player murder) {
        timer1 = 11;
        TimeOut = 5;
        timerIdGameRule = Bukkit.getScheduler().runTaskTimer(BForest.getInstance(), () -> {
            switch (timer1) {
                case 0:
                    TimeOut();
                    Bukkit.getScheduler().cancelTask(timerIdGameRule);
                    break;
                case 6:
                    ChatBroadcastMessege.SendMessages(ChatColor.GOLD + "Маньяком был выбран - " + murder.getName());
                    StartGame.beginGame(PlayersCount.playersOnGame);
                    break;
                case 5:
                    ChatBroadcastMessege.SendMessages(ChatColor.GREEN + "Делай все возможное что бы выжить до утра");
                    break;
                case 4:
                    ChatBroadcastMessege.SendMessages(ChatColor.GREEN + "Бегай, бей, прячься");
                    break;
                case 3:
                    ChatBroadcastMessege.SendMessages(ChatColor.GREEN + "И помни, у маньяка отличное зрение");
                    break;
                case 2:
                    ChatBroadcastMessege.SendMessages(ChatColor.GREEN + "Удачи");
                    break;
                case 1:
                    ChatBroadcastMessege.SendMessages(ChatColor.AQUA + "У выживших есть 1 минута чтобы спрятаться");
                    break;
            }
            if(timer1 >= 7 & timer1 <= 11){
                ChatBroadcastMessege.SendMessages(ChatColor.DARK_GREEN + "До начала игры осталось " + TimeOut);
                TimeOut--;
            }
            timer1--;
            Bukkit.broadcastMessage(String.valueOf(timer1));
        }, 20, 20).getTaskId();
    }


    static Player murder = StartGame.murderRole;
    public static int timer2;
    public static int timerTimeOut;
    public static void TimeOut() {
        timer2 = 60;
        timerTimeOut = Bukkit.getScheduler().runTaskTimer(BForest.getInstance(), () -> {
            switch (timer2){
                case 0:
                    ChatBroadcastMessege.SendMessages(ChatColor.AQUA + murder.getName() + " идет убивать!");
                    murder.teleport(ArenaLocation.getLocSpawnMurder());
                    Bukkit.getScheduler().cancelTask(timerTimeOut);
                    break;
                case 30:
                    ChatBroadcastMessege.SendMessages(ChatColor.DARK_RED + "У выживших осталось 30 секунд чтобы спрятаться");
                    break;
                case 10:
                    ChatBroadcastMessege.SendMessages(ChatColor.DARK_RED + "У выживших осталось 10 секунд чтобы спрятаться");
                    break;
            }
            timer2--;
        }, 20, 20).getTaskId();
    }
}
