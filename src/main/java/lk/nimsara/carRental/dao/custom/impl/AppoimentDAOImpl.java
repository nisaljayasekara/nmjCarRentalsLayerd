package lk.nimsara.carRental.dao.custom.impl;

import lk.nimsara.carRental.dao.custom.AppoimentDAO;
import lk.nimsara.carRental.entity.Appoiment;
import lk.nimsara.carRental.entity.Customer;
import lk.nimsara.carRental.util.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AppoimentDAOImpl implements AppoimentDAO {
    @Override
    public List<Appoiment> getAll() throws SQLException {

            ResultSet resultSet = SQLUtil.crudUtil("SELECT * FROM appoiment");

            List<Appoiment> appoimentList = new ArrayList<>();

            while (resultSet.next()) {
                String id= resultSet.getString(1);
                String date = resultSet.getString(2);
                String time = resultSet.getString(3);
                String Returndate = resultSet.getString(4);
                String Customer_id= resultSet.getString(5);
                String Appoiment_returnTime= resultSet.getString(6);
                String Car_id= resultSet.getString(7);
                String Car_name= resultSet.getString(8);
                String Car_price= resultSet.getString(9);
                String Payment = resultSet.getString(10);


                Appoiment entity = new Appoiment(id,date,time,Returndate,Customer_id,Appoiment_returnTime,Car_id,Car_name,Car_price,Payment);
                appoimentList.add(entity);
            }
            return appoimentList;
        }


    @Override
    public boolean save(Appoiment entity) throws SQLException {
        return SQLUtil.crudUtil("INSERT INTO appoiment VALUES(?, ?, ?, ?,?,?,?,?,?,?)",
               entity.getId(),
                entity.getDate(),
                entity.getTime(),
                entity.getReturndate(),
                entity.getCustomer_id(),
                entity.getAppoiment_returnTime(),
                entity.getCar_id(),
                entity.getCar_name(),
                entity.getCar_price(),
                entity.getPayment());

    }

    @Override
    public boolean update(Appoiment entity) throws SQLException {
        return SQLUtil.crudUtil("UPDATE appoiment SET Appoiment_date=?,Appoiment_time=?,Return_date =?,Customer_id=?,Appoiment_returnTime=?,Car_id=?,Car_name =?,Car_price =?,Payment =? WHERE Appoiment_id=? ",
                entity.getTime(),
                entity.getDate(),
                entity.getReturndate(),
                entity.getCustomer_id(),
                entity.getAppoiment_returnTime(),
                entity.getCar_id(),
                entity.getCar_name(),
                entity.getCar_price(),
                entity.getPayment(),
                entity.getId());
    }

    @Override
    public boolean exist(String id) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return SQLUtil.crudUtil("DELETE FROM appoiment WHERE Appoiment_id = ?",id);

    }

    @Override
    public String generateID() throws SQLException {
        return null;
    }

    @Override
    public Appoiment search(String id) throws SQLException {
        ResultSet resultSet = SQLUtil.crudUtil("SELECT * FROM appoiment WHERE Appoiment_id = ?",id);
        Appoiment entity = null;
        if (resultSet.next()){
            String cusid= resultSet.getString(1);
            String date = resultSet.getString(2);
            String time = resultSet.getString(3);
            String Returndate = resultSet.getString(4);
            String Customer_id= resultSet.getString(5);
            String Appoiment_returnTime= resultSet.getString(6);
            String Car_id= resultSet.getString(7);
            String Car_name= resultSet.getString(8);
            String Car_price= resultSet.getString(9);
            String Payment = resultSet.getString(10);
            entity = new Appoiment(cusid,date,time,Returndate,Customer_id,Appoiment_returnTime,Car_id,Car_name,Car_price,Payment);
        }
        return entity;

    }
}
