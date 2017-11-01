package cc.lasmgratel.opensimcity.common.util.registry;

import cc.lasmgratel.opensimcity.common.util.ResourceLocation;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Registry<V extends RegistryEntry<V>> extends Iterable<V> {
    Class<V> getRegistrySuperType();

    void register(V value);

    void registerAll(@SuppressWarnings("unchecked") V... values);

    boolean containsKey(ResourceLocation key);
    boolean containsValue(V value);

    @Nullable
    V getValue(ResourceLocation key);
    @Nullable ResourceLocation getKey(V value);

    @Nonnull
    Set<ResourceLocation> getKeys();
    @Nonnull
    List<V> getValues();
    @Nonnull Set<Map.Entry<ResourceLocation, V>> getEntries();

    /**
     * Retrieve the slave map of type T from the registry.
     * Slave maps are maps which are dependent on registry content in some way.
     * @param slaveMapName The name of the slavemap
     * @param type The type
     * @param <T> Type to return
     * @return The slavemap if present
     */
    <T> T getSlaveMap(ResourceLocation slaveMapName, Class<T> type);
}
