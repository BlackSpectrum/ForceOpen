package it.github.mats391.forceopen;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class ForceOpen extends JavaPlugin implements Listener
{

	@Override
	public void onEnable() {
		final PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents( this, this );
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerInteract( final PlayerInteractEvent event ) {
		if ( event.isCancelled() )
			return;

		if ( event.getAction().equals( Action.RIGHT_CLICK_BLOCK ) )
		{
			final Block block = event.getClickedBlock();
			final Player player = event.getPlayer();

			if ( block.getType().equals( Material.CHEST ) )
			{
				final Chest chest = (Chest) block.getState();
				player.openInventory( chest.getInventory() );

			}
		}

	}

}
