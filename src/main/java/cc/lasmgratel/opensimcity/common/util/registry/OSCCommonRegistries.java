package cc.lasmgratel.opensimcity.common.util.registry;

import cc.lasmgratel.opensimcity.common.plop.Ploppable;

public interface OSCCommonRegistries {
    Registry<Ploppable> PLOPS = new SimpleRegistry<>(Ploppable.class);
}
