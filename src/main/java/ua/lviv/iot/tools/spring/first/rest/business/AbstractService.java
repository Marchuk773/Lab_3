package ua.lviv.iot.tools.spring.first.rest.business;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public abstract class AbstractService<T> {

    protected abstract JpaRepository<T, Integer> getRepository();

    public T createObject(T object) {
        return getRepository().save(object);
    }

    public void deleteObject(Integer id) {
        getRepository().deleteById(id);
    }

    public T findObject(Integer id) {
        return getRepository().findById(id).orElse(null);
    }

    public List<T> findAllObjects() {
        return getRepository().findAll();
    }

    public void updateObject(Integer id, T object) {
        getRepository().save(object);
    }

}
