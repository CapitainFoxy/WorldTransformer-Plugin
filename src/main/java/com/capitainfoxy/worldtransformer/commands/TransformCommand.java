package com.capitainfoxy.worldtransformer.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import com.capitainfoxy.worldtransformer.managers.TransformationManager;

public class TransformCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 1) {
                String transformationType = args[0];
                TransformationManager.applyTransformation(player.getWorld(), transformationType);
                player.sendMessage("Transformation '" + transformationType + "' applied to the world.");
                return true;
            }
        }
        return false;
    }
}
