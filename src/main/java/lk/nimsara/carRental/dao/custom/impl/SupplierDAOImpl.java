package lk.nimsara.carRental.dao.custom.impl;

import lk.nimsara.carRental.dao.custom.SupplierDAO;
import lk.nimsara.carRental.entity.Customer;
import lk.nimsara.carRental.entity.Supplier;
import lk.nimsara.carRental.util.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierDAOImpl implements SupplierDAO {
    @Override
    public List<Supplier> getAll() throws SQLException {

        ResultSet resultSet = SQLUtil.crudUtil("SELECT * FROM supplier");

        List<Supplier> supplierList = new ArrayList<>();

        while (resultSet.next()) {
            String id= resultSet.getString(1);
            String name = resultSet.getString(2);
            String email = resultSet.getString(3);
            String Tel= resultSet.getString(4);
            String User_id= resultSet.getString(5);
            Supplier entity = new Supplier(id,name,email,Tel,User_id);
            supplierList.add(entity);
        }
        return supplierList;
    }

    @Override
    public boolean save(Supplier entity) throws SQLException {
        return SQLUtil.crudUtil("INSERT INTO supplier VALUES(?, ?, ?, ?,?)",
                entity.getSupplier_id(),
                entity.getSupplier_name(),
                entity.getSupplier_email(),
                entity.getTel(),
                entity.getUser_id());
    }

    @Override
    public boolean update(Supplier entity) throws SQLException {
        return SQLUtil.crudUtil("UPDATE supplier SET Supplier_name =?,Supplier_email =?,Tel =?,User_id = ?  WHERE Supplier_id=?",
              entity.getSupplier_name(),
                entity.getSupplier_email(),
                entity.getTel(),
                entity.getUser_id(),
                entity.getSupplier_id());
    }

    @Override
    public boolean exist(String id) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return SQLUtil.crudUtil("DELETE FROM supplier WHERE Supplier_id = ?",id);
    }

    @Override
    public String generateID() throws SQLException {
        return null;
    }

    @Override
    public Supplier search(String id) throws SQLException {
        ResultSet resultSet = SQLUtil.crudUtil("SELECT * FROM supplier WHERE Supplier_id = ?",id);
        Supplier entity = null;
        if (resultSet.next()){
            String  supid= resultSet.getString(1);
            String name = resultSet.getString(2);
            String email = resultSet.getString(3);
            String Tel= resultSet.getString(4);
            String User_id= resultSet.getString(5);
            entity = new Supplier(supid,name,email,Tel,User_id);
        }
        return entity;
    }
}
