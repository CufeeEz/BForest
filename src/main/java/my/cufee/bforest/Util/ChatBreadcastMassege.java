package my.cufee.bforest.Util;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;




import static my.cufee.bforest.Util.PlayersCount.playersOnGame;

public class ChatBreadcastMassege {
    public static void SendMassages(String massage){
        for(String Player : playersOnGame) {
            Player PlayerSenderMassage = Bukkit.getPlayer(Player);
            if (PlayerSenderMassage != null) {
                PlayerSenderMassage.sendMessage(massage);
            }
        }
    }
}
