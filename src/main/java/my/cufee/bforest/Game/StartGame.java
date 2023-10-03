package my.cufee.bforest.Game;

import my.cufee.bforest.Arena.ArenaLocation;

import my.cufee.bforest.Util.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;
import java.util.Objects;



import static my.cufee.bforest.Util.PlayersCount.playersOnGame;

public class StartGame {

    static String murderRole = GetRole.GetMurderRole(playersOnGame);

    public static void beginGame(List<String> ArrayPlayers){
        ChatUtil.GameRule(murderRole);
        for (int i = 0; i < ArrayPlayers.size(); i++) {
            if (!Objects.equals(murderRole, ArrayPlayers.get(i))) {
                Player SurvivorPlayer = Bukkit.getPlayerExact(ArrayPlayers.get(i));
                SurvivorPlayer.teleport(ArenaLocation.getLocSpawnSurvivor());
                // Отчистка игрока и подготовка его к игре
                SurvivorPlayer.setHealth(20);
                SurvivorPlayer.getInventory().clear();
                SurvivorPlayer.setGameMode(GameMode.ADVENTURE);
                SurvivorPlayer.setFoodLevel(20);
                SurvivorPlayer.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 9999, 1));
                ItemStack Stick = new ItemStack(Material.STICK);
                Stick.addUnsafeEnchantment(Enchantment.KNOCKBACK, 3);
                SurvivorPlayer.getInventory().addItem(Stick);
            }
            else{
                Player MurderPlayer = Bukkit.getPlayerExact(ArrayPlayers.get(i));
                MurderPlayer.teleport(ArenaLocation.getLocPreSpawnMurder());
                // Отчистка игрока и подготовка его к игре
                MurderPlayer.setHealth(20);
                MurderPlayer.getInventory().clear();
                MurderPlayer.setGameMode(GameMode.ADVENTURE);
                MurderPlayer.setFoodLevel(20);
                MurderPlayer.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 9999, 1));
                MurderPlayer.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 9999, 1));
                MurderPlayer.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 9999, 2));
                ItemStack Sword = new ItemStack(Material.STONE_SWORD);
                Sword.addEnchantment(Enchantment.DAMAGE_ALL, 5);
                MurderPlayer.getInventory().addItem(Sword);

                //
            }
        }
    }
}
