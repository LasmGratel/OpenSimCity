package cc.lasmgratel.opensimcity.api.ingredient;

import com.google.common.collect.Sets;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

public interface IngredientEntry {
    Set<Class<?>> getIngredientClassSet();

    <T> Set<T> getIngredients(Class<T> ingredientClass);

    @SuppressWarnings("unchecked")
    default <T> T getIngredient(Class<T> ingredientClass) {
        return getIngredients(ingredientClass).size() > 0 ? (T) getIngredients(ingredientClass).toArray()[0] : null;
    }

    <T> void setIngredients(Class<T> ingredientClass, Collection<T> ingredients);
    default <T> void setIngredient(Class<T> ingredientClass, T ingredient) {
        setIngredients(ingredientClass, Collections.singleton(ingredient));
    }
    default <T> void setIngredient(Class<T> ingredientClass, T... ingredients) {
        setIngredients(ingredientClass, Sets.newHashSet(ingredients));
    }
}
