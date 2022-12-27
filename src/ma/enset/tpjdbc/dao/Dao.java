package ma.enset.tpjdbc.dao;


import java.util.List;

public interface Dao<T> {
    List<T> findAll();
    T findById(int id);
    boolean remove(int id);
    boolean add(T p);
}
