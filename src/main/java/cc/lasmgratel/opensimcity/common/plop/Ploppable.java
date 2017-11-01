package cc.lasmgratel.opensimcity.common.plop;

import cc.lasmgratel.opensimcity.common.util.registry.RegistryEntry;

public interface Ploppable extends RegistryEntry<Ploppable> {
    int getLength();
    int getWidth();
}
