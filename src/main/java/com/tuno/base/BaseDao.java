package com.tuno.base;

import java.util.List;

public interface BaseDao<T, ID> {
    long count();
    void delete(T entity);
    long deleteById(ID id);
    List<T> findAll();
    T findById(ID id);
    T insert(T entity);
    T update(T entity);
}
