package my.cufee.bforest.Game;

import my.cufee.bforest.Arena.ArenaLocation;

import my.cufee.bforest.Util.ChatUtil;
import my.cufee.bforest.Util.PlayersCount;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Objects;

public class StartGame {


    public static Player murderRole;

    public static void setMurderRole(){
        murderRole = GetRole.getMurderRole(PlayersCount.playersOnGame);
    }

    public static void beginGame(Player[] ArrayPlayers){
        for (Player arrayPlayer : ArrayPlayers) {
            if (!Objects.equals(murderRole, arrayPlayer)) {
                arrayPlayer.teleport(ArenaLocation.getLocSpawnSurvivor());
                arrayPlayer.setHealth(20);
                arrayPlayer.getInventory().clear();
                arrayPlayer.setGameMode(GameMode.ADVENTURE);
                arrayPlayer.setFoodLevel(20);
                arrayPlayer.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, Integer.MAX_VALUE, 1));
                ItemStack Stick = new ItemStack(Material.STICK);
                Stick.addUnsafeEnchantment(Enchantment.KNOCKBACK, 3);
                arrayPlayer.getInventory().addItem(Stick);
            } else {
                arrayPlayer.teleport(ArenaLocation.getLocPreSpawnMurder());
                arrayPlayer.setHealth(20);
                arrayPlayer.getInventory().clear();
                arrayPlayer.setGameMode(GameMode.ADVENTURE);
                arrayPlayer.setFoodLevel(20);
                arrayPlayer.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));
                arrayPlayer.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, Integer.MAX_VALUE, 1));
                arrayPlayer.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, Integer.MAX_VALUE, 2));
                ItemStack Sword = new ItemStack(Material.STONE_SWORD);
                Sword.addEnchantment(Enchantment.DAMAGE_ALL, 5);
                arrayPlayer.getInventory().addItem(Sword);
            }
        }
    }
}
