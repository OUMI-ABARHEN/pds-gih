package ma.uiass.eia.pds.backend.Dao;

import java.util.List;

public interface Dao <T>{
    void add(T t);
    void delete(T o);
    List<T> getAll();
    T findById(int id);
}
