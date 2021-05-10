package datrat.codeslogin;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class codesLoginMain extends JavaPlugin {

	// Declarando a instancia do plugin pra caso precise.
	public static codesLoginMain instance;

	// Sequencia de inicialização do plugin.
	@Override
	public void onEnable() {

		instance = this;

		// Declara que os comandos "/register" e "/login" existem na classe loginCommand.class
		Objects.requireNonNull(this.getCommand("register")).setExecutor(new loginCommand());
		Objects.requireNonNull(this.getCommand("login")).setExecutor(new loginCommand());

		// Declara que o listener no joinEvent.class existe.
		Bukkit.getServer().getPluginManager().registerEvents(new joinEvent(), this);

	}

	// Sequencia de desligamento do plugin.
	@Override
	public void onDisable() {
	}

	// Declara que a função registerEvents irá registrar eventos.
	public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
		for (Listener listener : listeners) {
			Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
		}
	}
}

