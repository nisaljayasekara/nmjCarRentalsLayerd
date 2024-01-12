package lk.nimsara.carRental.bo.custom.impl;

import lk.nimsara.carRental.bo.custom.EmployeeBO;
import lk.nimsara.carRental.dao.DAOFactory;
import lk.nimsara.carRental.dao.custom.EmployeeDAO;
import lk.nimsara.carRental.dto.EmployeeDto;
import lk.nimsara.carRental.entity.Customer;
import lk.nimsara.carRental.entity.Employee;
import lk.nimsara.carRental.util.SQLUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeBOImpl implements EmployeeBO {

    EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.EMPLOYEE);

    @Override
    public boolean saveEmployee(EmployeeDto dto) throws SQLException {
        return employeeDAO.save(new Employee(
                dto.getEmployee_id(),
                dto.getEmployee_name(),
                dto.getEmployee_address(),
                dto.getEmployee_job_category(),
                dto.getEmployee_contactNum()));

    }

    @Override
    public boolean deleteEmployee(String Employee_id) throws SQLException {
        return employeeDAO.delete(Employee_id);
    }

    @Override
    public boolean updateEmployee(EmployeeDto dto) throws SQLException {
        return  employeeDAO.update(new Employee(
                dto.getEmployee_id(),
                dto.getEmployee_name(),
                dto.getEmployee_address(),
                dto.getEmployee_job_category(),
                dto.getEmployee_contactNum()));
    }

    @Override
    public EmployeeDto searchEmployee(String id) throws SQLException {
        Employee employee = employeeDAO.search(id);
        return new EmployeeDto(employee.getEmployee_id(),
                employee.getEmployee_name(),
                employee.getEmployee_address(),
                employee.getEmployee_job_category(),
                employee.getEmployee_contactNum());
    }
    @Override
    public List<EmployeeDto> getAllEmployee() throws SQLException {

        List<Employee> employeeList= employeeDAO.getAll();
        List<EmployeeDto> dtoList = new ArrayList<>();

        for (Employee employee:employeeList){
            dtoList.add(new EmployeeDto(
                    employee.getEmployee_id(),
                    employee.getEmployee_name(),
                    employee.getEmployee_address(),
                    employee.getEmployee_job_category(),
                    employee.getEmployee_contactNum()));
        }

        return dtoList;
    }
}
