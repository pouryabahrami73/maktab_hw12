package base.repositories;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface BaseRepository<E, PK extends Serializable> {

    E save(E e);

    Optional<E> findByTitle(String title);

    void deleteByTitle(String title);

    void deleteAll();

    List<E> findAll();


}
