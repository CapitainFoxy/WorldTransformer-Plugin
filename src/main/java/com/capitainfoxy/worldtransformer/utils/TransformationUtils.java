package com.capitainfoxy.worldtransformer.utils;

import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.Material;

public class TransformationUtils {

    public static void transformWorld(World world, String transformationType) {
        switch (transformationType) {
            case "night_to_day":
                world.setTime(0);
                break;
            case "flood":
                floodWorld(world);
                break;
            case "dry_out":
                dryOutWorld(world);
                break;
            default:
                break;
        }
    }

    private static void floodWorld(World world) {
        for (int x = -100; x < 100; x++) {
            for (int z = -100; z < 100; z++) {
                for (int y = world.getSeaLevel(); y < world.getMaxHeight(); y++) {
                    Block block = world.getBlockAt(x, y, z);
                    if (block.getType() == Material.AIR) {
                        block.setType(Material.WATER);
                    }
                }
            }
        }
    }

    private static void dryOutWorld(World world) {
        for (int x = -100; x < 100; x++) {
            for (int z = -100; z < 100; z++) {
                for (int y = world.getSeaLevel(); y < world.getMaxHeight(); y++) {
                    Block block = world.getBlockAt(x, y, z);
                    if (block.getType() == Material.WATER) {
                        block.setType(Material.AIR);
                    }
                }
            }
        }
    }
}
