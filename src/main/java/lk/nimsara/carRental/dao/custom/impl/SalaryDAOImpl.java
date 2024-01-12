package lk.nimsara.carRental.dao.custom.impl;

import lk.nimsara.carRental.dao.custom.SalaryDAO;
import lk.nimsara.carRental.entity.Customer;
import lk.nimsara.carRental.entity.Salary;
import lk.nimsara.carRental.util.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalaryDAOImpl implements SalaryDAO {
    @Override
    public List<Salary> getAll() throws SQLException {
        ResultSet resultSet = SQLUtil.crudUtil("SELECT * FROM salary");

        List<Salary> salaryList = new ArrayList<>();

        while (resultSet.next()) {
            String id= resultSet.getString(1);
            String name = resultSet.getString(2);
            String address = resultSet.getString(3);
            String email = resultSet.getString(4);

            Salary entity = new Salary(id,name,address,email);
            salaryList.add(entity);
        }
        return salaryList;
    }

    @Override
    public boolean save(Salary entity) throws SQLException {
        return SQLUtil.crudUtil("INSERT INTO salary VALUES(?, ?, ?, ?)",
                entity.getSalary_id(),
                entity.getSalary_date(),
                entity.getSalaryAmount(),
                entity.getEmployee_id()
        );
    }

    @Override
    public boolean update(Salary entity) throws SQLException {
        return SQLUtil.crudUtil("UPDATE salary SET Date =?,Amount =?,Employee_id = ?",
                entity.getSalary_date(),
                entity.getSalaryAmount(),
                entity.getEmployee_id());
    }

    @Override
    public boolean exist(String id) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return SQLUtil.crudUtil("DELETE FROM salary WHERE Salary_id = ?",id);
    }

    @Override
    public String generateID() throws SQLException {
        return null;
    }

    @Override
    public Salary search(String id) throws SQLException {
        ResultSet resultSet = SQLUtil.crudUtil("SELECT * FROM salary WHERE Salary_id = ?",id);
        Salary entity = null;
        if (resultSet.next()){
            String cusid= resultSet.getString(1);
            String name = resultSet.getString(2);
            String address = resultSet.getString(3);
            String email = resultSet.getString(4);

            entity = new Salary(cusid,name,address,email);
        }
        return entity;
    }
}
