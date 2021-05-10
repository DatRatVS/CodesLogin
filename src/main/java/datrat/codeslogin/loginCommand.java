package datrat.codeslogin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.UUID;

public class loginCommand implements CommandExecutor {

	boolean isRegistered = false;

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("register")) {
			if (isRegistered = false) {
				// Checa se quem mandou o comando foi o console. Caso sim, ele manda uma mensagem,
				// que diz que o console não pode usar o comando.
				if (!(sender instanceof Player)) {
					sender.sendMessage("[Code's Login] - Consoles aren't able to use this command.");
					return true;
				}

				// Declarando quem é o player castando "(Player) sender",
				// assim indicando quem mandou o comando.
				Player player = (Player) sender;

				// Detecção se o player mandou o comando puro, caso sim
				// o ensina a usar o comando de maneira correta.
				if (args.length == 0) {
					player.sendMessage(ChatColor.GOLD + "" + "[Code's Login] - Usage: /register (password)");
					return true;
				}

				// Coloca o argumento que o player indicou
				// na hashmap.
				passMap.put(player.getUniqueId(), args[0]);
				player.sendMessage(ChatColor.GOLD + "" + "[Code's Login] - You are registered successfully.");
				player.clearTitle();
				player.sendTitle(ChatColor.RED + "Welcome!", "/login (password)", 2, 214748364, 2);
				isRegistered = true;

				return true;
			} else if (isRegistered = true) {
				Player player = (Player) sender;
				player.sendMessage(ChatColor.GOLD + "" + "[Code's Login] - You are already registered.");
			}
		}
		if (cmd.getName().equalsIgnoreCase("login")) {
			if (isRegistered = true) {
				// Linhas 17 / 18
				if (!(sender instanceof Player)) {
					sender.sendMessage("[Code's Login] - Consoles aren't able to use this command.");
					return true;
				}

				// Linhas 24 / 25
				Player player = (Player) sender;

				// Linhas 28 / 29
				if (args.length == 0) {
					player.sendMessage(ChatColor.GOLD + "" + "[Code's Login] - Usage: /login (password)");
					return true;
				}

				String password = passMap.get(player.getUniqueId());
				if (password != null && password.equals(args[0])) {
					player.sendMessage(ChatColor.GOLD + "" + "[Code's Login] - Successfully logged in!");
					player.clearTitle();
				} else if (password == null) {
					player.sendMessage(ChatColor.GOLD + "" + "[Code's Login] - This isn't a valid password.");
				} else {
					player.sendMessage(ChatColor.GOLD + "" + "[Code's Login] - Wrong password.");
				}
				return true;
			}
		}
		// Retorna falso ao executor do comando caso algo de errado
		// magicamente aconteça.
		return false;
	}

	// Hashmap onde guarda um valor "String".
	// No qual seria a senha do usuário.
	public HashMap<UUID, String> passMap = new HashMap<>();
}