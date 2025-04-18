![SolarStormLab Plugin](https://solarstormlabor.github.io/assets/branding/banner/text.png)
<hr><br>

# ![Plugin Icon](https://solarstormlabor.github.io/assets/branding/emodji/dev.png) SolarCore - Bukkit Plugin Framework

A modular Minecraft server framework featuring:
- **Core System**: Essential server management tools
- **Extensible API**: For developer customization
- **Module Support**: Hot-swappable features

## ![Plugin Icon](https://solarstormlabor.github.io/assets/branding/emodji/logo.png) Features
| Component | Description | API Status |
|-----------|-------------|------------|
| **SolarCore** | Base system with dependency management | `coming soon` |
| **SolarAPI** | Developer interface for extensions | `stable` |
| **SolarModules** | Optional addons (security, permissions, etc.) | `alpha` |

## ![Plugin Icon](https://solarstormlabor.github.io/assets/branding/emodji/dev.png) API Usage
```java
// Basic API implementation example
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
```

## ![Plugin Icon](https://solarstormlabor.github.io/assets/branding/emodji/helper.png) Contribution Guide
1. Fork the repository
2. Follow our [code style](https://solarstormlabor.github.io/dev/styleguide)
3. Submit PRs to `dev` branch
4. Include JUnit tests for new features


![Footer](https://solarstormlabor.github.io/assets/branding/banner/footer.png)
