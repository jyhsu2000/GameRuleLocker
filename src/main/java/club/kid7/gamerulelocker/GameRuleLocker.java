package club.kid7.gamerulelocker;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class GameRuleLocker extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        GameRuleUtil.checkGameRule();

        Bukkit.getPluginManager().registerEvents(new CommandListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
