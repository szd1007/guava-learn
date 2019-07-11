package effectiveJava;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 33. 优先考虑类型安全的异构容器[Map中通过将key进行泛型化，来使Map支持多个类型]
 */
public class Eff_33 {
    private Map<Class<?>, Object> favorites = new HashMap<>();
    public <T> void putFavorite(Class<T> type, T instance){
        favorites.put(Objects.requireNonNull(type),instance);
    }
    public <T> T getFaviorite(Class<T> type){
        return type.cast(favorites.get(type));
    }
}
