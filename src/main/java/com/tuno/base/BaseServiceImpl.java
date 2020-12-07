package com.tuno.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public abstract class BaseServiceImpl<T, ID>  implements BaseService<T, ID>{

    @Autowired
    protected BaseDao baseDao;

    @Transactional(readOnly = true)
    @Override
    public List<T> findAll() {
        return baseDao.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public List<T> findAll(int start, int count) {
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public T findById(ID id) {
        return (T) baseDao.findById(id);
    }

    @Transactional
    @Override
    public T create(T entity) {
        return (T) baseDao.insert(entity);
    }

    @Transactional
    @Override
    public T update(T entity) {
        return (T) baseDao.update(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public long count() {
        return baseDao.count();
    }

    @Transactional
    @Override
    public void delete(T entity) {
        baseDao.delete(entity);
    }
}
