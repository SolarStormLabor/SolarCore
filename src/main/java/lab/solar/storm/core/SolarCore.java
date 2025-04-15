package lab.solar.storm.core;

import lab.solar.storm.api.util.SolarPlugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class SolarCore extends SolarPlugin {
    @Override
    public List<String> onStartUp(List<String> stringList) {
        return stringList;
    }

    @Override
    public List<String> onShoutDown(List<String> stringList) {
        return stringList;
    }

    @Override
    public void loadConfigs() {

    }

    @Override
    public void registerCommands() {

    }

    @Override
    public void registerListeners(PluginManager pluginManager) {

    }
}
