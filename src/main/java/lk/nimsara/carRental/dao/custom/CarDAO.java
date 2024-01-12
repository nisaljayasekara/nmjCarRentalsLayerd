package lk.nimsara.carRental.dao.custom;

import lk.nimsara.carRental.dao.CrudDAO;
import lk.nimsara.carRental.entity.Car;

import java.sql.SQLException;

public interface CarDAO extends CrudDAO<Car> {
    boolean updateCarStatus(String id) throws SQLException;
}
