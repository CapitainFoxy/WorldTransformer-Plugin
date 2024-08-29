package com.capitainfoxy.worldtransformer;

import org.bukkit.plugin.java.JavaPlugin;
import com.capitainfoxy.worldtransformer.commands.TransformCommand;
import com.capitainfoxy.worldtransformer.commands.SnapshotCommand;
import com.capitainfoxy.worldtransformer.listeners.WorldEventListener;
import com.capitainfoxy.worldtransformer.managers.TransformationManager;

public class WorldTransformer extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("transform").setExecutor(new TransformCommand());
        this.getCommand("snapshot").setExecutor(new SnapshotCommand());
        getServer().getPluginManager().registerEvents(new WorldEventListener(), this);
        TransformationManager.initialize(this);
    }

    @Override
    public void onDisable() {
        TransformationManager.saveAllSnapshots();
    }
}
