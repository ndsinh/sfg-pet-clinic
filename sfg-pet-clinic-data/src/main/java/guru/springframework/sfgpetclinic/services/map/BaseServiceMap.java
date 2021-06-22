package guru.springframework.sfgpetclinic.services.map;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public abstract class BaseServiceMap<T, I> {

    protected Map<I, T> innerMap =new LinkedHashMap<>();

    Set<T> getSetValues() {
        return new LinkedHashSet<>(innerMap.values());
    }

    T get(I id) {
        return innerMap.getOrDefault(id, null);
    }

    T put (I id, T object) {
        innerMap.put(id, object);
        return object;
    }

    void removeByKey(I id) {
        innerMap.remove(id);
    }

    void removeByValue(T object) {
        innerMap.entrySet().removeIf(
                entry -> entry.getValue().equals(object)
        );
    }
}
