package guru.springframework.sfgpetclinic.services;

import java.util.Set;

public interface CrudService<T, ID> {

    T findById(ID id);
    Set<T> findAll();

    T save(T entity);

    void delete(T entity);
    void deleteById(ID id);
}
