package DAO;

import java.util.List;

public interface EntityDao<T,K> {
    public List<T> findAll();

    public T findById(K id);

    public T update(T t);

    public void create(T t);

    public void delete(K id);
}
