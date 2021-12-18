package com.github.theminiluca.clear.lag.nms.v1_17_R1;

import com.github.theminiluca.clear.lag.api.NMS;
import com.github.theminiluca.clear.lag.nms.v1_17_R1.tasks.CheckTask;
import com.github.theminiluca.clear.lag.nms.v1_17_R1.tasks.UntrackerTask;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

public class NMSHandler implements NMS {

	@Override
	public BukkitTask startUntrackerTask(Plugin plugin) {
		return new UntrackerTask().runTaskTimer(plugin, 1000, 1000);
	}

	@Override
	public BukkitTask startUCheckTask(Plugin plugin) {
		return new CheckTask().runTaskTimer(plugin, 1000 + 1, 1000);
	}

}
