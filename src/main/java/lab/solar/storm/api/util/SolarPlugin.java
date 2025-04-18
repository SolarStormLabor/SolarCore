package lab.solar.storm.api.util;

import lab.solar.storm.api.logger.SolarLogger;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public abstract class SolarPlugin extends JavaPlugin {
    public static JavaPlugin javaPlugin;
    public static Plugin plugin;
    public static SolarPlugin instance;

    public static final String PREFIX = "§3§lSolar§b§lCore §8>§7";
    public static final String CONSOLE_PREFIX = "\u001B[0m[Solar][Core] \u001B[0m";
    public static String PLUGIN_FOLDER;

    private final String DISABLED = "disabled";

    private String c0 = "\u001B[0m";
    private String c3 = "\u001B[36m";
    private String cb = "\u001B[96m";
    private String c8 = "\u001B[90m";
    private String c7 = "\u001B[37m";
    private String c6 = "\u001B[33m";

    @Override
    public void onEnable() {
        plugin = this;
        javaPlugin = this;
        instance = this;

        PLUGIN_FOLDER = String.valueOf(this.getDataFolder());

        List<String> enableInfo = new ArrayList<>();
        enableInfo.add(solarLoadConfig());
        enableInfo.add(solarRegisterListener());
        enableInfo.add(solarRegisterCommands());
        logEnableMessage(onStartUp(enableInfo));
    }

    @Override
    public void onDisable() {
        List<String> disableInfo = new ArrayList<>();
        disableInfo.add("");
        logEnableMessage(onShoutDown(disableInfo));
    }

    public void onReload() {
        List<String> reloadInfo = new ArrayList<>();
        reloadInfo.add("");
        logEnableMessage(reloadInfo);
    }

    /** Register Types */

    private String solarLoadConfig(){
        try{
            if (loadConfigs()) return DISABLED;
            return "\u001B[90mLoading configs...\u001B[0m";
        } catch (Exception e){
            return c6 + "Fail to load configs\n" + e;
        }
    }

    private String solarRegisterListener(){
        PluginManager pluginManager = Bukkit.getPluginManager();
        try{
            if (registerListeners(pluginManager)) return DISABLED;
            return "\u001B[90mLoading events...\u001B[0m";
        } catch (Exception e){
            return c6 + "Fail to load events\n" + e;
        }
    }

    private String solarRegisterCommands(){
        try{
            if (registerCommands()) return DISABLED;
            return "\u001B[90mLoading commands...\u001B[0m";
        } catch (Exception e){
            return c6 + "Fail to load commands\n" + e;
        }
    }

    private String solarRegisterGlobalWars(){
        try{
            if (registerGlobalWars()) return DISABLED;
            return "\u001B[90mRegister globals...\u001B[0m";
        } catch (Exception e){
            return c6 + "Fail to register globals\n" + e;
        }
    }

    /** Abstract Mappings */

    public abstract List<String> onStartUp(List<String> stringList);

    public abstract List<String> onShoutDown(List<String> stringList);

    public abstract boolean loadConfigs();

    public abstract boolean registerCommands();

    public abstract boolean registerListeners(PluginManager pluginManager);

    public abstract boolean registerGlobalWars();

    /** Enable Message */

    private void logEnableMessage(List<String> list) {
        if(!Bukkit.getPluginManager().isPluginEnabled("SolarCore")){
            SolarLogger.sendMessage(c3 + "   ____"+cb+"  ___ " + c7 + "                         " + c0);
            SolarLogger.sendMessage(c3 + "  /___ "+cb+" |    " + c3 + "§3§lSolar§b§lCore " +c0+ "v-1.0.1         " + c0);
            SolarLogger.sendMessage(c3 + "  ___/ "+cb+" |___ " + c8 + "Running on Bukkit - "+cb+"Paper" + c0);
            SolarLogger.sendMessage(c3 + "       "+cb+"      " + c7 + "                         " + c0);
            for (String s  : list) {
                if (!s.equals(DISABLED)) {};
                SolarLogger.sendMessage( CONSOLE_PREFIX+s);
            }
            SolarLogger.sendMessage(CONSOLE_PREFIX +"Finish Loading [SolarCore]\u001B[0m");
        }
    }
}
