package base.repositories.impl;



import base.repositories.BaseRepository;
import services.impl.EntityManagerMaker;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


public class BaseRepositoryImpl<E, PK extends Serializable> implements BaseRepository<E, PK> {

    protected final EntityManager entityManager = EntityManagerMaker.getEntityManager();

    @Override
    public E save(E e) {
        try {
            entityManager.getTransaction().begin();
            if(!entityManager.contains(e)){
                entityManager.persist(e);
            }
        }catch (Exception exception){
            exception.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return null;
    }

    @Override
    public Optional<E> findByTitle(String title) {
        return Optional.empty();
    }

    @Override
    public void deleteByTitle(String title) {

    }


    @Override
    public void deleteAll() {
        System.out.println("delete by all");
    }

    @Override
    public List<E> findAll() {
        List<E> list = new ArrayList<>();
        /*entityManager.getTransaction().begin();
        TypedQuery<E> findAllQuery = entityManager.createQuery("SELECT a FROM " + (String) E + " a", E.class);*/
        return list/*findAllQuery.getResultList()*/;
    }
}
