package lk.nimsara.carRental.bo.custom;

import lk.nimsara.carRental.bo.SuperBO;
import lk.nimsara.carRental.dto.CustomerDto;
import lk.nimsara.carRental.dto.SalaryDto;

import java.sql.SQLException;
import java.util.List;

public interface SalaryBO extends SuperBO {
    boolean saveSalary( SalaryDto dto) throws SQLException;

    boolean deleteSalary(String Salary_id) throws SQLException;

    boolean updateSalary(SalaryDto dto) throws SQLException;

    SalaryDto searchSalary(String Salary_id) throws SQLException;

    List<SalaryDto> getAllSalary() throws SQLException;
}
