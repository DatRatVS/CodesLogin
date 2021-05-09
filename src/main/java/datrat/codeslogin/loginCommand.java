package datrat.codeslogin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class loginCommand implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("register")) {

			// Checa se quem mandou o comando foi o console. Caso sim, ele manda uma mensagem,
			// que diz que o console não pode usar o comando.
			if (!(sender instanceof Player)) {
				sender.sendMessage("[Code's Login] - Consoles aren't able to use this command");
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
			passMap.put(player, args[0]);
			player.sendMessage(ChatColor.GOLD + "" + "[Code's Login] - You are registered successfully");
			return true;
		}

		// Retorna falso ao executor do comando caso algo de errado
		// magicamente aconteça.
		return false;
	}

	// Hashmap onde guarda um valor "String".
	// No qual seria a senha do usuário.
	public HashMap<Player, String> passMap = new HashMap<>();
}