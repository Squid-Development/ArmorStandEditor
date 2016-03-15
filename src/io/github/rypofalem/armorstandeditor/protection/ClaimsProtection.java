package io.github.rypofalem.armorstandeditor.protection;
import org.bukkit.Bukkit;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;

import com.winthier.claims.Claims;
import com.winthier.claims.bukkit.BukkitClaimsPlugin;

public class ClaimsProtection implements Protection {
	Claims claims;
	BukkitClaimsPlugin plugin;
	
	public ClaimsProtection(BukkitClaimsPlugin bukkitClaimsPlugin){
		plugin = bukkitClaimsPlugin;
		claims = Claims.getInstance();
	}
	
	@Override
	public boolean canEdit(Player player, ArmorStand armorstand) {
		if(plugin == null || claims == null || !plugin.isEnabled()) return true;
		return claims.canBuild(player.getUniqueId(), player.getWorld().getName(), armorstand.getLocation().getBlockX(), armorstand.getLocation().getBlockY(), armorstand.getLocation().getBlockZ());
	}
	
}
