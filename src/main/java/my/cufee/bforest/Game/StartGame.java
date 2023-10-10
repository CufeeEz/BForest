package my.cufee.bforest.Game;

import my.cufee.bforest.Arena.ArenaLocation;

import my.cufee.bforest.Util.ChatUtil;
import my.cufee.bforest.Util.PlayersCount;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


import java.util.Objects;




public class StartGame {


    public static Player murderRole = GetRole.getMurderRole(PlayersCount.playersOnGame);
    public static void beginGame(Player[] ArrayPlayers){
        ChatUtil.GameRule(murderRole);
        for (int i = 0; i < ArrayPlayers.length; i++) {
            if (!Objects.equals(murderRole, ArrayPlayers[i])) {
                Player survivorPlayer = ArrayPlayers[i];
                survivorPlayer.teleport(ArenaLocation.getLocSpawnSurvivor());
                survivorPlayer.setHealth(20);
                survivorPlayer.getInventory().clear();
                survivorPlayer.setGameMode(GameMode.ADVENTURE);
                survivorPlayer.setFoodLevel(20);
                survivorPlayer.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 9999, 1));
                ItemStack Stick = new ItemStack(Material.STICK);
                Stick.addUnsafeEnchantment(Enchantment.KNOCKBACK, 3);
                survivorPlayer.getInventory().addItem(Stick);
            }
            else{
                Player murderPlayer = ArrayPlayers[i];
                murderPlayer.teleport(ArenaLocation.getLocPreSpawnMurder());
                murderPlayer.setHealth(20);
                murderPlayer.getInventory().clear();
                murderPlayer.setGameMode(GameMode.ADVENTURE);
                murderPlayer.setFoodLevel(20);
                murderPlayer.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 9999, 1));
                murderPlayer.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 9999, 1));
                murderPlayer.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 9999, 2));
                ItemStack Sword = new ItemStack(Material.STONE_SWORD);
                Sword.addEnchantment(Enchantment.DAMAGE_ALL, 5);
                murderPlayer.getInventory().addItem(Sword);
            }
        }
    }
}
