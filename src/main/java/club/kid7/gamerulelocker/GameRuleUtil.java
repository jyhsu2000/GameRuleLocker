package club.kid7.gamerulelocker;

import org.bukkit.Bukkit;
import org.bukkit.World;

import java.util.List;

class GameRuleUtil {
    static void checkGameRule() {
        List<World> worlds = Bukkit.getServer().getWorlds();
        for (World world : worlds) {
            if (world.getGameRuleValue("logAdminCommands").equals("true")) {
                world.setGameRuleValue("logAdminCommands", "false");
            }
        }
    }
}
