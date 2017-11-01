package cc.lasmgratel.opensimcity.api.ingredient;

import com.google.common.collect.HashBiMap;
import com.google.common.collect.Sets;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class SimpleIngredientEntry implements IngredientEntry {
    private Map<Class<?>, Set<?>> ingredientMap = HashBiMap.create();

    @Override
    public Set<Class<?>> getIngredientClassSet() {
        return ingredientMap.keySet();
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> Set<T> getIngredients(Class<T> ingredientClass) {
        return ingredientMap.get(ingredientClass).stream().map(o -> (T) o).collect(Collectors.toSet());
    }

    @Override
    public <T> void setIngredients(Class<T> ingredientClass, Collection<T> ingredients) {
        if (!ingredientMap.containsKey(ingredientClass))
            ingredientMap.put(ingredientClass, new HashSet<>());
        ((Set<? super T>) ingredientMap.get(ingredientClass)).addAll(Sets.newHashSet(ingredients));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimpleIngredientEntry that = (SimpleIngredientEntry) o;

        return ingredientMap.equals(that.ingredientMap);
    }

    @Override
    public int hashCode() {
        return ingredientMap.hashCode();
    }

    @Override
    public String toString() {
        return ingredientMap.toString();
    }
}
