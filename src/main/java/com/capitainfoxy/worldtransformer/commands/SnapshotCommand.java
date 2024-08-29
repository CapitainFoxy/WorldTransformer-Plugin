package com.capitainfoxy.worldtransformer.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import com.capitainfoxy.worldtransformer.utils.SnapshotUtils;

public class SnapshotCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 1) {
                String action = args[0];
                if (action.equalsIgnoreCase("save")) {
                    SnapshotUtils.saveSnapshot(player.getWorld());
                    player.sendMessage("World snapshot saved.");
                } else if (action.equalsIgnoreCase("load")) {
                    SnapshotUtils.loadSnapshot(player.getWorld());
                    player.sendMessage("World snapshot loaded.");
                }
                return true;
            }
        }
        return false;
    }
}
