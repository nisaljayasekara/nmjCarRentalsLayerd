package lk.nimsara.carRental.dao.custom.impl;

import lk.nimsara.carRental.dao.custom.CustomerDAO;
import lk.nimsara.carRental.dto.CustomerDto;
import lk.nimsara.carRental.entity.Customer;
import lk.nimsara.carRental.util.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public List<Customer> getAll() throws SQLException {

        ResultSet resultSet = SQLUtil.crudUtil("SELECT * FROM customer");

        List<Customer> customerList = new ArrayList<>();

        while (resultSet.next()) {
            String id= resultSet.getString(1);
            String name = resultSet.getString(2);
            String address = resultSet.getString(3);
            String email = resultSet.getString(4);
            String Tel= resultSet.getString(5);
            String User_id= resultSet.getString(6);
            Customer entity = new Customer(id,name,address,email,Tel,User_id);
            customerList.add(entity);
        }
        return customerList;
    }

    @Override
    public boolean save(Customer entity) throws SQLException {
        return SQLUtil.crudUtil("INSERT INTO customer VALUES(?, ?, ?, ?,?,?)",
                entity.getId(),
                entity.getName(),
                entity.getAddress(),
                entity.getEmail(),
                entity.getTel(),
                entity.getUser_id());
    }

    @Override
    public boolean update(Customer entity) throws SQLException {
        return SQLUtil.crudUtil("UPDATE customer SET Customer_name =?,Customer_address =?,Email = ?,Tel =?  WHERE Customer_id=?",
                entity.getName(),
                entity.getAddress(),
                entity.getEmail(),
                entity.getTel(),
                entity.getId());
    }

    @Override
    public boolean exist(String id) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return SQLUtil.crudUtil("DELETE FROM customer WHERE Customer_id = ?",id);
    }

    @Override
    public String generateID() throws SQLException {
        return null;
    }

    @Override
    public Customer search(String id) throws SQLException {
        ResultSet resultSet = SQLUtil.crudUtil("SELECT * FROM customer WHERE Customer_id = ?",id);
        Customer entity = null;
        if (resultSet.next()){
            String cusid= resultSet.getString(1);
            String name = resultSet.getString(2);
            String address = resultSet.getString(3);
            String email = resultSet.getString(4);
            String Tel= resultSet.getString(5);
            String User_id= resultSet.getString(6);
            entity = new Customer(cusid,name,address,email,Tel,User_id);
        }
        return entity;
    }
}

