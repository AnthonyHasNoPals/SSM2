package SSM.Abilities;

import SSM.*;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.*;
import org.bukkit.event.Listener;;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

import java.util.List;

public class BoneExplosion extends Ability {

    public BoneExplosion(Plugin plugin) {
        super(plugin);
        this.name = "Bone Explosion";
        this.cooldownTime = 8;
        this.rightClickActivate = true;
    }

    public void useAbility(Player player) {
        List<Entity> canHit = player.getNearbyEntities(4, 4, 4);
        canHit.remove(player);

        if (canHit.size() <= 0){
            return;
        }

        for (Entity entity : canHit) {
            if ((entity instanceof LivingEntity)) {
                ((LivingEntity) entity).damage(6.0);
                entity.getWorld().playSound(entity.getLocation(), Sound.ENTITY_SKELETON_HURT, 10, 10);
            }
        }
    }

}
