package my.cufee.bforest.Game;

import my.cufee.bforest.Arena.ArenaLocation;

import my.cufee.bforest.Util.ChatUtil;
import my.cufee.bforest.Util.PlayersCount;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
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
                arrayPlayer.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 600, 1));
                ItemStack Stick = new ItemStack(Material.STICK);
                Stick.addUnsafeEnchantment(Enchantment.KNOCKBACK, 3);
                arrayPlayer.getInventory().addItem(Stick);
            } else {
                arrayPlayer.teleport(ArenaLocation.getLocPreSpawnMurder());
                arrayPlayer.setHealth(20);
                arrayPlayer.getInventory().clear();
                arrayPlayer.setGameMode(GameMode.ADVENTURE);
                arrayPlayer.setFoodLevel(20);
                arrayPlayer.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 600, 1));
                arrayPlayer.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 600, 1));
                arrayPlayer.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 600, 2));
                ItemStack Sword = new ItemStack(Material.STONE_SWORD);
                Sword.addEnchantment(Enchantment.DAMAGE_ALL, 5);
                arrayPlayer.getInventory().addItem(Sword);
            }
        }
    }
    public static void giveFirework(){
        Player[] playersArray = PlayersCount.playersOnGame;
        for (Player p : playersArray) {
            if(!murderRole.equals(PlayersCount.playersOnGame)) {
                Firework firework = (Firework) p.getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
                FireworkMeta fireworkMeta = firework.getFireworkMeta();
                fireworkMeta.addEffect(FireworkEffect.builder().withColor(Color.RED).flicker(true).build());
                fireworkMeta.setPower(0);
                firework.setFireworkMeta(fireworkMeta);

            }
        }
    }
    public static void correctEffect(){
        Player[] playersArray = PlayersCount.playersOnGame;
        for (Player p : playersArray) {
            if (!murderRole.equals(PlayersCount.playersOnGame)) {
                p.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 600, 1));
                p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 600, 1));
            }
        }
    }
}
