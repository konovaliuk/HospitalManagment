package jdbc.model.dao;

import java.util.List;
import java.util.Optional;

public interface GenericDao<T> {
	
    Optional<T> find(int id);

    List<T> findAll();

    void create(T t);

    void update(T t);

    void delete(int id);

}
