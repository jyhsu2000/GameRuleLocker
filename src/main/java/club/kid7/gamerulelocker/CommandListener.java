package club.kid7.gamerulelocker;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandListener implements Listener {
    @EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        String message = event.getMessage();
        //移除插件前綴
        message = message.replaceAll("^/[^\\s]*:", "/");
        String[] split = message.split("\\s+");
        String command = split[0];
        //只處理 gamerule 指令
        if (!command.equalsIgnoreCase("/gamerule")) {
            return;
        }
        //只處理設定規則指令
        if (split.length != 3) {
            return;
        }
        //只處理 logAdminCommands
        if (!split[1].equalsIgnoreCase("logAdminCommands")) {
            return;
        }
        //取消事件，並強制重新檢查所有規則
        event.setCancelled(true);
        GameRuleUtil.checkGameRule();

        player.sendMessage(ChatColor.RED + "此遊戲規則禁止修改，詳情請參閱公告");
    }
}
