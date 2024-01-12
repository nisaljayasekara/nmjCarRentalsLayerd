package lk.nimsara.carRental.dao.custom.impl;

import lk.nimsara.carRental.dao.custom.RepairDAO;
import lk.nimsara.carRental.entity.Customer;
import lk.nimsara.carRental.entity.Repair;
import lk.nimsara.carRental.util.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepairDAOImpl implements RepairDAO {
    @Override
    public List<Repair> getAll() throws SQLException {
        ResultSet resultSet = SQLUtil.crudUtil("SELECT * FROM rapier");

        List<Repair> repairList = new ArrayList<>();

        while (resultSet.next()) {
            String Rapier_id= resultSet.getString(1);
            String Rapier_date = resultSet.getString(2);
            String Rapier_desc = resultSet.getString(3);
            String Rapier_retuenDate = resultSet.getString(4);
            String Rapier_price = resultSet.getString(5);
            String Car_id = resultSet.getString(6);

            Repair entity = new Repair(Rapier_id,Rapier_date,Rapier_desc,Rapier_retuenDate,Rapier_price,Car_id);
            repairList.add(entity);
        }
        return repairList;
    }

    @Override
    public boolean save(Repair entity) throws SQLException {
        return SQLUtil.crudUtil("INSERT INTO rapier VALUES(?, ?, ?, ?,?,?)",
              entity.getRapier_id(),
                entity.getRapier_date(),
                entity.getRapier_desc(),
                entity.getRapier_returnDate(),
                entity.getRapier_price(),
                entity.getCar_id());
    }

    @Override
    public boolean update(Repair entity) throws SQLException {
        return SQLUtil.crudUtil("UPDATE rapier SET Rapier_date =?,Rapier_desc =?,Rapier_returnDate = ?,Rapier_price =?,Car_id = ?  WHERE Rapier_id=?",
                entity.getRapier_date(),
                entity.getRapier_desc(),
                entity.getRapier_returnDate(),
                entity.getRapier_price(),
                entity.getCar_id(),
                entity.getRapier_id());
    }

    @Override
    public boolean exist(String id) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return SQLUtil.crudUtil("DELETE FROM rapier WHERE Rapier_id = ?",id);
    }

    @Override
    public String generateID() throws SQLException {
        return null;
    }

    @Override
    public Repair search(String id) throws SQLException {
        ResultSet resultSet = SQLUtil.crudUtil("SELECT * FROM rapier WHERE Rapier_id = ?",id);
        Repair entity = null;
        if (resultSet.next()){
            String Rapier_id= resultSet.getString(1);
            String Rapier_date = resultSet.getString(2);
            String Rapier_desc = resultSet.getString(3);
            String Rapier_retuenDate = resultSet.getString(4);
            String Rapier_price = resultSet.getString(5);
            String Car_id = resultSet.getString(6);
            entity = new Repair(Rapier_id,Rapier_date,Rapier_desc,Rapier_retuenDate,Rapier_price,Car_id);
        }
        return entity;
    }

}
