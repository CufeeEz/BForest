package my.cufee.bforest.Game;

import java.util.List;
import java.util.Random;

public class GetRole {

    static Random random = new Random();
    static String GetMurderRole(List<String> ArrayPlayers) {
        int randomIndex = random.nextInt(ArrayPlayers.size());
        String ManiacRole = ArrayPlayers.get(randomIndex);
        return ManiacRole;
    }
}
