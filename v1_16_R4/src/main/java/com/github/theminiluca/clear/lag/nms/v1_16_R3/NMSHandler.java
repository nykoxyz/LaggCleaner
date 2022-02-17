package com.github.theminiluca.clear.lag.nms.v1_16_R3;

import com.github.theminiluca.clear.lag.nms.v1_16_R3.tasks.CheckTask;
import com.github.theminiluca.clear.lag.nms.v1_16_R3.tasks.UntrackerTask;
import com.github.theminiluca.clear.lag.plugin.api.NMS;
import net.minecraft.server.v1_16_R3.BehaviorController;
import org.bukkit.entity.EntityType;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.List;

public class NMSHandler implements NMS {

	@Override
	public BukkitTask startUntrackerTask(Plugin plugin, int tick) {
		return new UntrackerTask().runTaskTimer(plugin, tick, tick);
	}
	@Override
	public BukkitTask startUCheckTask(Plugin plugin, int tick) {
		return new CheckTask().runTaskTimer(plugin, tick, tick);
	}

	@Override
	public List<String> Entities(boolean isname) {
		List<String> al = new ArrayList<>();
		for (EntityType type : EntityType.values()) {
			if (isname)
				al.add(type.getName());
			else
				al.add(type.name());
		}
		return al;
	}

}
