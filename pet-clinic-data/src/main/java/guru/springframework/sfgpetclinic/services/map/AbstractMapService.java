package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap();

    Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    T findById(ID id){
        return map.get(id);
    }

    T save(T entity){
        if (entity != null){
            if (entity.getId()==null){
                entity.setId(this.getNextId());
            }
            map.put(entity.getId(),entity);
        }else{
            throw new RuntimeException("Object cannot be NULL");
        }
        return entity;
    }

    void deleteById(ID id){
        map.remove(id);
    }

    void delete(T entity){
        map.entrySet().removeIf( idtEntry -> idtEntry.getValue().equals(entity) );
    }

    private Long getNextId(){
        Long nextId = null;
        try {
            nextId = Collections.max(map.keySet()) + 1 ;
        }catch (NoSuchElementException e){
            nextId = 1L;
        }
        return nextId;
    }
}
