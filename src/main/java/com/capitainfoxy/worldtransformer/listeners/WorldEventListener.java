package com.capitainfoxy.worldtransformer.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.TimeSkipEvent;
import com.capitainfoxy.worldtransformer.managers.TransformationManager;

public class WorldEventListener implements Listener {

    @EventHandler
    public void onTimeSkip(TimeSkipEvent event) {
        if (event.getSkipReason() == TimeSkipEvent.SkipReason.NIGHT_SKIP) {
            TransformationManager.applyTransformation(event.getWorld(), "night_to_day");
        }
    }
}
