package com.tuno.base;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class BaseDaoImpl<T, ID> implements BaseDao<T, ID> {

    @Autowired
    protected SessionFactory sessionFactory;

    public abstract String getHibernateTableName();

    public abstract String getHibernateKeyName();

    @Override
    public long count() {
        Session session=sessionFactory.getCurrentSession();
        String hql="select count(*) from "+getHibernateTableName();
        Query query=session.createQuery(hql);
        return (long) query.uniqueResult();
    }

    @Override
    public void delete(T entity) {
        Session session=sessionFactory.getCurrentSession();
        session.delete(entity);
    }

    @Override
    public long deleteById(ID id) {
        Session session=sessionFactory.getCurrentSession();
        String hql="delete from "+getHibernateTableName()+" where "+getHibernateKeyName()+"= :id";
        Query query=session.createQuery(hql);
        query.setParameter("id",id);
        return query.executeUpdate();
    }


    @Override
    public List<T> findAll() {
        Session session=sessionFactory.getCurrentSession();
        String hql="from "+getHibernateTableName();
        List<T> lists=session.createQuery(hql).list();
        return lists;
    }

    @Override
    public T findById(ID id) {
        Session session=sessionFactory.getCurrentSession();
        String hql="from "+getHibernateTableName()+" where "+getHibernateKeyName()+"= :id";
        Query query=session.createQuery(hql);
        query.setParameter("id",id);
        T entity= (T) query.list().get(0);
        return entity;
    }

    @Override
    public T insert(T entity) {
        Session session=sessionFactory.getCurrentSession();
        session.save(entity);
        return entity;
    }

    @Override
    public T update(T entity) {
        Session session=sessionFactory.getCurrentSession();
        session.update(entity);
        return entity;
    }
}
