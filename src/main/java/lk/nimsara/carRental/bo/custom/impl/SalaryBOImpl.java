package lk.nimsara.carRental.bo.custom.impl;

import lk.nimsara.carRental.bo.custom.SalaryBO;
import lk.nimsara.carRental.dao.DAOFactory;
import lk.nimsara.carRental.dao.custom.SalaryDAO;
import lk.nimsara.carRental.dto.CustomerDto;
import lk.nimsara.carRental.dto.SalaryDto;
import lk.nimsara.carRental.entity.Customer;
import lk.nimsara.carRental.entity.Salary;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class SalaryBOImpl implements SalaryBO {

    SalaryDAO salaryDAO = (SalaryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.SALARY);

    @Override
    public boolean saveSalary(SalaryDto dto) throws SQLException {
        return salaryDAO.save(new Salary(
                dto.getSalary_id(),
                dto.getSalary_date(),
                dto.getSalaryAmount(),
                dto.getEmployee_id()));
    }

    @Override
    public boolean deleteSalary(String Salary_id) throws SQLException {
        return salaryDAO.delete(Salary_id);
    }

    @Override
    public boolean updateSalary(SalaryDto dto) throws SQLException {
        return  salaryDAO.update(new Salary(
                dto.getSalary_id(),
                dto.getSalary_date(),
                dto.getSalaryAmount(),
                dto.getEmployee_id()));
    }

    @Override
    public SalaryDto searchSalary(String Salary_id) throws SQLException {
        Salary salary = salaryDAO.search(Salary_id);
        return new SalaryDto(salary.getSalary_id(),
                salary.getSalary_date(),
                salary.getSalaryAmount(),
                salary.getEmployee_id());
    }

    @Override
    public List<SalaryDto> getAllSalary() throws SQLException {
        List<Salary> salaryList= salaryDAO.getAll();
        List<SalaryDto> dtoList = new ArrayList<>();

        for (Salary salary:salaryList){
            dtoList.add(new SalaryDto(salary.getSalary_id(),
                   salary.getSalary_date(),
                    salary.getSalaryAmount(),
                    salary.getEmployee_id()));
        }

        return dtoList;
    }

}
