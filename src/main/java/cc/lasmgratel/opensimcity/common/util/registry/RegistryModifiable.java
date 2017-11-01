package cc.lasmgratel.opensimcity.common.util.registry;

import cc.lasmgratel.opensimcity.common.util.ResourceLocation;

public interface RegistryModifiable<V extends RegistryEntry<V>> extends Registry<V> {
    void clear();
    V remove(ResourceLocation key);
    boolean isLocked();
}
