package fa.training.services.iServices;

import java.util.List;

public interface PublicationManagement<E> {
    void add (E e);

    int findIndexById(String id);

    List<E> getAll();

    List<E> findByName(String name);

}
