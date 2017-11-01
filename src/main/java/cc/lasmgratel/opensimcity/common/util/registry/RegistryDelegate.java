package cc.lasmgratel.opensimcity.common.util.registry;

import cc.lasmgratel.opensimcity.common.util.ResourceLocation;

public interface RegistryDelegate<T> {
    /**
     * Get the referent pointed at by this delegate. This will be the currently active item or block, and will change
     * as world saves come and go. Note that item.delegate.get() may NOT be the same object as item, due to item and
     * block substitution.
     *
     * @return The referred object
     */
    T get();

    /**
     * Get the unique resource location for this delegate. Completely static after registration has completed, and
     * will never change.
     * @return The name
     */
    ResourceLocation name();

    /**
     * Get the delegate type. It will be dependent on the registry this delegate is sourced from.
     * @return The type of delegate
     */
    Class<T> type();
}
