package my.cufee.bforest.Util;


import my.cufee.bforest.Arena.ArenaLocation;
import my.cufee.bforest.Arena.EndGame;
import my.cufee.bforest.BForest;
import my.cufee.bforest.Event.ProcessGame;
import my.cufee.bforest.Game.StartGame;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;




public class ChatUtil {
    static World world = Bukkit.getWorld("world");
    public static int TimeOut;
    public static int timer1;
    public static int timerIdGameRule;
    public static void GameRule(Player murder) {
        timer1 = 11;
        TimeOut = 5;
        timerIdGameRule = Bukkit.getScheduler().runTaskTimer(BForest.getInstance(), () -> {
            switch (timer1) {
                case 6:
                    ChatBroadcastMessege.SendMessages(ChatColor.GOLD + "Маньяком был выбран - " + murder.getName());
                    StartGame.beginGame(PlayersCount.playersOnGame);
                    processGame();
                    world.setTime(12000);
                    break;
                case 5:
                    ChatBroadcastMessege.SendMessages(ChatColor.GREEN + "Делай все возможное что бы выжить до утра");
                    break;
                case 4:
                    ChatBroadcastMessege.SendMessages(ChatColor.GREEN + "Бегай, бей, прячься");
                    break;
                case 3:
                    ChatBroadcastMessege.SendMessages(ChatColor.GREEN + "Нужно прожить эту ночь");
                    break;
                case 2:
                    ChatBroadcastMessege.SendMessages(ChatColor.GREEN + "Удачи");
                    TimeOut();
                    Bukkit.getScheduler().cancelTask(timerIdGameRule);
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
        }, 0, 20).getTaskId();
    }
    public static int timer2;
    public static int timerTimeOut;
    public static void TimeOut() {
        timer2 = 60;
        Player murder = StartGame.murderRole;
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
        }, 0, 20).getTaskId();
    }
    public static int timerGame = 600;
    public static int timerIdGameProcess;
    public static void processGame() {
        timerGame = 540;
        timerIdGameProcess = Bukkit.getScheduler().runTaskTimer(BForest.getInstance(), () -> {
            switch (timerGame) {
                case (480):
                    ChatBroadcastMessege.SendMessages("Осталось 8 минут до рассвета!");
                    break;
                case (360):
                    ChatBroadcastMessege.SendMessages("Осталось 6 минут до рассвета!");
                    break;
                case (240):
                    ChatBroadcastMessege.SendMessages("Осталось 4 минут до рассвета!");
                    break;
                case (180):
                    ChatBroadcastMessege.SendMessages("Осталось 3 минут до рассвета!");
                    break;
                case (120):
                    ChatBroadcastMessege.SendMessages("Осталось 2 минут до рассвета!");
                    break;
                case (60):
                    ChatBroadcastMessege.SendMessages("Осталось 1 минут до рассвета!");
                    break;
                case (30):
                    ChatBroadcastMessege.SendMessages("Осталось 30 секунд до рассвета!");
                    break;
                case (10):
                    ChatBroadcastMessege.SendMessages("Осталось 10 секунд до рассвета!");
                    break;
                case (3):
                    ChatBroadcastMessege.SendMessages("Осталось 3 секунды до рассвета!");
                    break;
                case (2):
                    ChatBroadcastMessege.SendMessages("Осталось 2 секунды до рассвета!");
                    break;
                case (1):
                    ChatBroadcastMessege.SendMessages("Осталось 1 секунда до рассвета!");
                    break;
                case (0):
                    ChatBroadcastMessege.SendMessages(ChatColor.GREEN + "Мирные победили!");
                    EndGame.deleteGame(PlayersCount.playersOnGame);
                    Bukkit.getScheduler().cancelTask(timerIdGameProcess);
                    break;
            }
            Bukkit.broadcastMessage(String.valueOf(timerGame));
            timerGame--;
        }, 0, 20).getTaskId();
    }
}
