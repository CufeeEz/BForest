package my.cufee.bforest.Game;

import java.util.List;
import java.util.Random;

public class GetRole {

    Random random = new Random();
    private String GetManiacRole(List<String> ArrayPlayers){
        int randomIndex = random.nextInt(ArrayPlayers.size());
        String ManiacRole = ArrayPlayers.get(randomIndex);
        return ManiacRole;
    }
}
