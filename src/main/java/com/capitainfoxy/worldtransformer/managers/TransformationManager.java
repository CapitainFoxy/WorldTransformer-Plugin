ópackage com.capitainfoxy.worldtransformer.managers;

import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;
import com.capitainfoxy.worldtransformer.utils.DatabaseUtils;
import com.capitainfoxy.worldtransformer.utils.SnapshotUtils;

public class TransformationManager {
    private static JavaPlugin plugin;

    public static void initialize(JavaPlugin plugin) {
        TransformationManager.plugin = plugin;
        DatabaseUtils.initializeDatabase();
    }

    public static void applyTransformation(World world, String transformationType) {
        TransformationUtils.transformWorld(world, transformationType);
    }

    public static void saveAllSnapshots() {
        for (World world : plugin.getServer().getWorlds()) {
            SnapshotUtils.saveSnapshot(world);
        }
    }
}
