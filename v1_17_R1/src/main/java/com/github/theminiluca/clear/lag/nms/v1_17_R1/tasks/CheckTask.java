package com.github.theminiluca.clear.lag.nms.v1_17_R1.tasks;

import com.github.theminiluca.clear.lag.nms.v1_17_R1.NMSEntityTracker;
import com.github.theminiluca.clear.lag.plugin.api.Config;
import net.minecraft.server.level.ChunkProviderServer;
import net.minecraft.server.level.WorldServer;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_17_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftEntity;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static com.github.theminiluca.clear.lag.plugin.api.Config.getBoolean;
import static com.github.theminiluca.clear.lag.plugin.api.Config.getList;

public class CheckTask extends BukkitRunnable {

    @Override
    public void run() {
        if (UntrackerTask.isRunning()) {
            return;
        }
        if(getBoolean(Config.Enum.ENABLE_ON_ALL_WORLDS)) {
            for(World world : Bukkit.getWorlds()) {
                checkWorld(world.getName());
            }
        }
        else {
            for(String worldName : getList(Config.Enum.WORLDS)) {
                if(Bukkit.getWorld(worldName) == null) {
                    continue;
                }
                checkWorld(worldName);
            }
        }

    }

    public void checkWorld(String worldName) {
        WorldServer ws = ((CraftWorld) Objects.requireNonNull(Bukkit.getWorld(worldName))).getHandle();
        ChunkProviderServer cps = ws.getChunkProvider();

        Set<net.minecraft.world.entity.Entity> trackAgain = new HashSet<>();

        int d = Config.getInt(Config.Enum.TRACKING_RANGE);
        for (Player player : Objects.requireNonNull(Bukkit.getWorld(worldName)).getPlayers()) {
            for (Entity ent : player.getNearbyEntities(d, d, d)) {
                net.minecraft.world.entity.Entity nms = ((CraftEntity) ent).getHandle();
                if (cps.a.G.containsKey(nms.getId()) || !nms.valid) {
                    continue;
                }
                trackAgain.add(nms);
            }
        }
        NMSEntityTracker.trackEntities(cps, trackAgain);
    }


}