package DAO;

import java.util.List;

public interface EntityDAO<T,K> {
    public List<T> findAll();

    public T findById(K k);

    public T update(T t);

    public void delete(K k);
}
