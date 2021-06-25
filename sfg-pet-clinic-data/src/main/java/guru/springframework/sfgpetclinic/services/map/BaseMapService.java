package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.BaseEntity;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public abstract class BaseMapService<T extends BaseEntity, I extends Long> {

    protected Map<Long, T> innerMap = new LinkedHashMap<>();

    Set<T> getSetValues() {
        return new LinkedHashSet<>(innerMap.values());
    }

    T get(I id) {
        return innerMap.getOrDefault(id, null);
    }

    T put(T object) {
        if (object != null) {
            if (object.getId() == null) {
                object.setId(genNextId());
            }
            innerMap.put(object.getId(), object);
            return object;
        }
        throw new RuntimeException("Object cannot be null");
    }

    void removeByKey(I id) {
        innerMap.remove(id);
    }

    void removeByValue(T object) {
        innerMap.entrySet().removeIf(
                entry -> entry.getValue().equals(object)
        );
    }

    private Long genNextId() {
        if (innerMap.isEmpty()) {
            return 1L;
        }
        return Collections.max(innerMap.keySet()) + 1;
    }
}
