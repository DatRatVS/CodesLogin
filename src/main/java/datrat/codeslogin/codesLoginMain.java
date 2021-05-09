package datrat.codeslogin;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class codesLoginMain extends JavaPlugin {

	// Declarando a instancia do plugin pra caso precise.
	public static codesLoginMain instance;

	// Sequencia de inicialização do plugin.
	@Override
	public void onEnable() {

		// Declara que o comando "/register" existe na classe loginCommand.class
		Objects.requireNonNull(this.getCommand("register")).setExecutor(new loginCommand());

	}

	// Sequencia de desligamento do plugin.
	@Override
	public void onDisable() {
	}
}
