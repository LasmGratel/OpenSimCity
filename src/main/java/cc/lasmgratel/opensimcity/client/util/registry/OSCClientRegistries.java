package cc.lasmgratel.opensimcity.client.util.registry;

import cc.lasmgratel.opensimcity.client.model.Model;
import cc.lasmgratel.opensimcity.common.util.registry.Registry;
import cc.lasmgratel.opensimcity.common.util.registry.SimpleRegistry;

public interface OSCClientRegistries {
    Registry<Model> MODELS = new SimpleRegistry<>(Model.class);
}
