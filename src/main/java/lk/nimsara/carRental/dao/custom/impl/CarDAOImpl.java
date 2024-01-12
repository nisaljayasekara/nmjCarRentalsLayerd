package lk.nimsara.carRental.dao.custom.impl;

import lk.nimsara.carRental.dao.custom.CarDAO;
import lk.nimsara.carRental.entity.Car;
import lk.nimsara.carRental.entity.Customer;
import lk.nimsara.carRental.util.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDAOImpl implements CarDAO {
    @Override
    public List<Car> getAll() throws SQLException {
        ResultSet resultSet = SQLUtil.crudUtil("SELECT * FROM car");

        List<Car> carList = new ArrayList<>();

        while (resultSet.next()) {
            String id= resultSet.getString(1);
            String name = resultSet.getString(2);
            String availability = resultSet.getString(3);
            String price = resultSet.getString(4);
            Car entity = new Car(id,name,availability,price);
            carList.add(entity);
        }
        return carList;
    }

    @Override
    public boolean save(Car entity) throws SQLException {
        return SQLUtil.crudUtil("INSERT INTO car VALUES(?, ?, ?, ?)",
                entity.getId(),
                entity.getName(),
                entity.getAvailability(),
                entity.getPrice());
    }

    @Override
    public boolean update(Car entity) throws SQLException {
        return SQLUtil.crudUtil("UPDATE car SET Car_name =?,Car_availability =?,price =? WHERE Car_id=?",
                entity.getName(),
                entity.getAvailability(),
                entity.getPrice(),
                entity.getId());
    }

    @Override
    public boolean exist(String id) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return SQLUtil.crudUtil("DELETE FROM car WHERE Car_id = ?",id);
    }

    @Override
    public String generateID() throws SQLException {
        return null;
    }


    @Override
    public Car search(String id) throws SQLException {
        ResultSet resultSet = SQLUtil.crudUtil("SELECT * FROM car WHERE Car_id = ?",id);
        Car entity = null;
        if (resultSet.next()){
            String Car_id= resultSet.getString(1);
            String Car_name = resultSet.getString(2);
            String Car_Availability = resultSet.getString(3);
            String price = resultSet.getString(4);

            entity = new Car(Car_id,Car_name,Car_Availability,price);
        }
        return entity;
    }

    @Override
    public boolean updateCarStatus(String id) throws SQLException {

        return SQLUtil.crudUtil(" update car set Car_Availability = ? where Car_id = ?","No",id);
    }
}
