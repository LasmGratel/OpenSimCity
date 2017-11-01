package cc.lasmgratel.opensimcity.common.util.registry;

import cc.lasmgratel.opensimcity.common.util.ResourceLocation;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;

public class SimpleRegistry<V extends RegistryEntry<V>> implements RegistryModifiable<V> {
    private BiMap<ResourceLocation, V> biMap = HashBiMap.create();
    private final Class<V> type;

    public SimpleRegistry(Class<V> type) {
        this.type = type;
    }

    @Override
    public Class<V> getRegistrySuperType() {
        return type;
    }

    @Override
    public void register(V value) {
        biMap.put(value.getRegistryName(), value);
    }

    @SafeVarargs
    @Override
    public final void registerAll(V... values) {
        Arrays.stream(values).forEach(this::register);
    }

    @Override
    public boolean containsKey(ResourceLocation key) {
        return biMap.containsKey(key);
    }

    @Override
    public boolean containsValue(V value) {
        return biMap.containsValue(value);
    }

    @Nullable
    @Override
    public V getValue(ResourceLocation key) {
        return biMap.get(key);
    }

    @Nullable
    @Override
    public ResourceLocation getKey(V value) {
        return biMap.entrySet().stream().filter(entry -> entry.getValue().equals(value)).findAny().orElse(new AbstractMap.SimpleEntry<>(null, value)).getKey();
    }

    @Nonnull
    @Override
    public Set<ResourceLocation> getKeys() {
        return biMap.keySet();
    }

    @Nonnull
    @Override
    public List<V> getValues() {
        return new ArrayList<>(biMap.values());
    }

    @Nonnull
    @Override
    public Set<Map.Entry<ResourceLocation, V>> getEntries() {
        return biMap.entrySet();
    }

    @Override
    public <T> T getSlaveMap(ResourceLocation slaveMapName, Class<T> type) {
        return null;
    }

    @Nonnull
    @Override
    public Iterator<V> iterator() {
        return biMap.values().iterator();
    }

    @Override
    public void clear() {
        biMap.clear();
    }

    @Override
    public V remove(ResourceLocation key) {
        return biMap.remove(key);
    }

    @Override
    public boolean isLocked() {
        return false;
    }
}
