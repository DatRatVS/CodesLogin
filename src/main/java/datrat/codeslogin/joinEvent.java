package datrat.codeslogin;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class joinEvent implements Listener {

	private final loginCommand isRegisteredGetter = new loginCommand();

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();

		if (isRegisteredGetter.isRegistered = true) {
		player.sendTitle(ChatColor.RED + "Welcome!", "/login (password)", 2, 214748364, 2);
		} else {
			player.sendTitle(ChatColor.RED + "Welcome!", "/register (password)", 2, 214748364, 2);
		}
	}
}
