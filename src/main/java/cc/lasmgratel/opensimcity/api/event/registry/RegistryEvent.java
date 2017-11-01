package cc.lasmgratel.opensimcity.api.event.registry;

import cc.lasmgratel.opensimcity.api.event.Event;
import cc.lasmgratel.opensimcity.common.util.registry.Registry;
import cc.lasmgratel.opensimcity.common.util.registry.RegistryEntry;

public class RegistryEvent<T extends RegistryEntry<T>> extends Event {
    private final Registry<T> registry;
    private final Class<T> registryClass;

    public RegistryEvent(Registry<T> registry) {
        this.registry = registry;
        this.registryClass = registry.getRegistrySuperType();
    }

    public Class<T> getRegistryClass() {
        return registryClass;
    }

    public Registry<T> getRegistry() {
        return registry;
    }

    public static class Register<T extends RegistryEntry<T>> extends RegistryEvent<T> {
        public Register(Registry<T> registry) {
            super(registry);
        }

        public void register(T value) {
            getRegistry().register(value);
        }

        public void registerAll(T... values) {
            getRegistry().registerAll(values);
        }
    }
}
