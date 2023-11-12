package slimebukkit.slimebukkit;

import org.bukkit.plugin.java.JavaPlugin;

public final class SlimeBukkit extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("slime").setExecutor(new SlimeCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
