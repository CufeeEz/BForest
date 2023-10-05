package my.cufee.bforest.Util;


public class ChatBroadcastMessege {
    public static void SendMessages(String message){
        for(org.bukkit.entity.Player Player : PlayersCount.playersOnGame) {
            if (Player != null) {
                Player.sendMessage(message);
            }
        }
    }
}
