package lab.solar.storm.core;

import lab.solar.storm.api.util.SolarPlugin;
import org.bukkit.plugin.PluginManager;

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
    public boolean loadConfigs() {
        return false;
    }

    @Override
    public boolean registerCommands() {
        return false;
    }

    @Override
    public boolean registerListeners(PluginManager pluginManager) {
        return false;
    }

    @Override
    public boolean registerGlobalWars() {
        return false;
    }
}
