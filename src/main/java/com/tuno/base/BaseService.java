package com.tuno.base;

import java.util.List;

public interface BaseService<T, ID> {
    List<T> findAll();
    List<T> findAll(int start, int count);
    T findById(ID id);
    T create(T entity);
    T update(T entity);
    long count();
    void delete(T entity);
}
