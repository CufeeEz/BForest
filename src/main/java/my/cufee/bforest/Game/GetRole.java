package my.cufee.bforest.Game;

import org.bukkit.entity.Player;


import java.util.Random;

public class GetRole {

    public static Player getMurderRole(Player[] playersArray) {
        Random random = new Random();
        int randomIndex = random.nextInt(playersArray.length);
        return playersArray[randomIndex];
    }
}
