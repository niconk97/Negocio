package negocio.repositories;
import java.util.List;
public interface I_GenericRepository<E> {
    void save(E e);
    void update(E e);
    void remove(E e);
    List<E> getAll();
    E getById(int id);
}