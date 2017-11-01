package cc.lasmgratel.opensimcity.client;

import cc.huajistudio.aeb.EventBus;
import cc.lasmgratel.opensimcity.api.event.registry.RegistryEvent;
import cc.lasmgratel.opensimcity.client.render.Game;
import cc.lasmgratel.opensimcity.client.util.registry.OSCClientRegistries;
import cc.lasmgratel.opensimcity.common.util.logger.GdxLogger;
import cc.lasmgratel.opensimcity.common.util.registry.OSCCommonRegistries;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ro.fortsoft.pf4j.DefaultPluginManager;
import ro.fortsoft.pf4j.PluginManager;

import java.nio.file.Paths;

public class OpenSimCityClient {
    private static final PluginManager PLUGIN_MANAGER = new DefaultPluginManager(Paths.get("plugins"));
    private static final Logger LOGGER = LoggerFactory.getLogger("Open SimCity");
    private static final EventBus EVENT_BUS = new EventBus("opensimcity");
    private static final OpenSimCityClient INSTANCE = new OpenSimCityClient();

    public static void main(String[] args) {
        LOGGER.info("Starting OpenSimCity");
        LOGGER.info("Loading plugins in " + Paths.get("plugins").toAbsolutePath());
        PLUGIN_MANAGER.loadPlugins();
        LOGGER.info("Loaded " + PLUGIN_MANAGER.getPlugins().size() + " plugins");
        PLUGIN_MANAGER.startPlugins();
        LOGGER.info("Registering Plops");
        EVENT_BUS.post(new RegistryEvent.Register<>(OSCCommonRegistries.PLOPS));
        LOGGER.info("Registering Models");
        EVENT_BUS.post(new RegistryEvent.Register<>(OSCClientRegistries.MODELS));
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        new LwjglApplication(new Game(), config);
        Gdx.app.setApplicationLogger(new GdxLogger(OpenSimCityClient.getLogger()));
    }

    public static OpenSimCityClient getInstance() {
        return INSTANCE;
    }

    public static EventBus getEventBus() {
        return EVENT_BUS;
    }

    public static Logger getLogger() {
        return LOGGER;
    }

    public static PluginManager getPluginManager() {
        return PLUGIN_MANAGER;
    }
}
