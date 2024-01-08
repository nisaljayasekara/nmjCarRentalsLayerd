package lk.nimsara.carRental.dao;

import java.sql.SQLException;
import java.util.List;

public interface CrudDAO <T> extends SuperDAO{
    List<T> getAll() throws SQLException;
    boolean save(T entity) throws SQLException ;
    boolean update(T entity) throws SQLException ;
    boolean exist(String id) throws SQLException;
    boolean delete(String id) throws SQLException ;
    String generateID() throws SQLException;
    T search(String id) throws SQLException;
}
