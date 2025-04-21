package net.clown.clownmod.util;

import java.util.HashMap;
import java.util.UUID;

public class ReturnLocationStore {
    public static class Location {
        public final double x, y, z;
        public final float yaw, pitch;

        public Location(double x, double y, double z, float yaw, float pitch) {
            this.x = x; this.y = y; this.z = z;
            this.yaw = yaw; this.pitch = pitch;
        }
    }

    private static final HashMap<UUID, Location> playerLocations = new HashMap<>();

    public static void set(UUID uuid, Location loc) {
        playerLocations.put(uuid, loc);
    }

    public static Location get(UUID uuid) {
        return playerLocations.get(uuid);
    }

    public static boolean has(UUID uuid) {
        return playerLocations.containsKey(uuid);
    }
}
