package datrat.codeslogin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

// a
public class loginCommand implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("register")) {

			// Checa se quem mandou o comando foi o console. Caso sim, ele manda uma mensagem.
			// que diz que o console não pode usar o comando.
			if (!(sender instanceof Player)) {
				sender.sendMessage("[Code's Login] - Consoles aren't able to use this command");
				return true;
			}

			// Declarando quem é o player castando "(Player) sender".
			// Assim indicando quem mandou o comando.
			Player player = (Player) sender;

			// Detecção se o player mandou o comando puro.
			// O ensina a usar o comando de maneira correta.
			if (args.length == 0) {
				player.sendMessage(ChatColor.GOLD + "" + "[Code's Login] - Usage: /register (password)");
				return true;
			}

			// Coloca o argumento que o player indicou,
			// Na hashmap.
			passwords.put(player, args[0]);
			return true;
		}
		return false;
	}


	// Hashmap onde guarda um valor "String".
	// No qual seria a senha do usuário.
	public HashMap<Player, String> passwords = new HashMap<>();
}