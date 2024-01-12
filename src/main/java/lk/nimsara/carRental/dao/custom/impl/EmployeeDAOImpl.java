package lk.nimsara.carRental.dao.custom.impl;

import lk.nimsara.carRental.dao.custom.EmployeeDAO;
import lk.nimsara.carRental.entity.Customer;
import lk.nimsara.carRental.entity.Employee;
import lk.nimsara.carRental.util.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public List<Employee> getAll() throws SQLException {
        ResultSet resultSet = SQLUtil.crudUtil("SELECT * FROM employee");

        List<Employee> employeeList = new ArrayList<>();

        while (resultSet.next()) {
            String Employee_id= resultSet.getString(1);
            String  Employee_name = resultSet.getString(2);
            String Employee_address = resultSet.getString(3);
            String Employee_job_category = resultSet.getString(4);
            String Employee_contactNum= resultSet.getString(5);

            Employee entity = new Employee(Employee_id,Employee_name,Employee_address,Employee_job_category,Employee_contactNum);
            employeeList.add(entity);
        }
        return employeeList;

    }

    @Override
    public boolean save(Employee entity) throws SQLException {
        return SQLUtil.crudUtil("INSERT INTO employee VALUES(?, ?, ?, ?,?)",
                entity.getEmployee_id(),
                entity.getEmployee_name(),
                entity.getEmployee_address(),
                entity.getEmployee_job_category(),
                entity.getEmployee_contactNum());

    }

    @Override
    public boolean update(Employee entity) throws SQLException {
        return SQLUtil.crudUtil("UPDATE employee SET Employee_name =?,Employee_address =?,Employee_job_category = ?,Employee_contactNum =?  WHERE Employee_id=?",
                entity.getEmployee_name(),
                entity.getEmployee_address(),
                entity.getEmployee_job_category(),
                entity.getEmployee_contactNum(),
                entity.getEmployee_id());
    }

    @Override
    public boolean exist(String id) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String Employee_id) throws SQLException {
        return SQLUtil.crudUtil("DELETE FROM employee WHERE Employee_id = ?",Employee_id);
    }

    @Override
    public String generateID() throws SQLException {
        return null;
    }

    @Override
    public Employee search(String id) throws SQLException {
        ResultSet resultSet = SQLUtil.crudUtil("SELECT * FROM employee WHERE Employee_id = ?",id);
        Employee entity = null;
        if (resultSet.next()){
            String Employee_id= resultSet.getString(1);
            String Employee_name = resultSet.getString(2);
            String Employee_address = resultSet.getString(3);
            String Employee_job_category = resultSet.getString(4);
            String Employee_contactNum= resultSet.getString(5);

            entity = new Employee(Employee_id,Employee_name,Employee_address,Employee_job_category,Employee_contactNum);
        }
        return entity;
    }
}
