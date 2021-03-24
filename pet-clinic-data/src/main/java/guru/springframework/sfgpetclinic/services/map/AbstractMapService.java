package guru.springframework.sfgpetclinic.services.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService<T, ID> {

    protected Map<ID, T> map = new HashMap<ID, T>();

    Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    T findById(ID id){
        return map.get(id);
    }

    T save(ID id,T entity){
        map.put(id,entity);
        return entity;
    }

    void deleteById(ID id){
        map.remove(id);
    }

    void delete(T entity){
        map.entrySet().removeIf( idtEntry -> idtEntry.getValue().equals(entity) );
    }
}
