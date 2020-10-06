package base.repositories;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface BaseRepository<E, PK extends Serializable> {

    E save(E e);

    E findById (PK id);
    Optional<E> findByTitle(String title);

    void deleteByTitle(String title);

    void deleteAll();

    List<E> findAll();


    void deleteById(PK id);

    <E, PK extends Serializable> List<E> findAllByIdsIn(Collection<PK> ids);
}
