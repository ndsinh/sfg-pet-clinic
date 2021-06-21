package guru.springframework.sfgpetclinic.services;

import java.util.Set;

public interface CrudService<T, I> {

    T findById(I id);

    Set<T> findAll();

    T save(T obj);

    void delete(T obj);

    void deleteById(I id);
}
