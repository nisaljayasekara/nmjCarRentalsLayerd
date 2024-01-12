package lk.nimsara.carRental.bo.custom;

import lk.nimsara.carRental.bo.SuperBO;
import lk.nimsara.carRental.dto.EmployeeDto;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeBO extends SuperBO {
    boolean saveEmployee( EmployeeDto dto) throws SQLException;

    boolean deleteEmployee(String Employee_id) throws SQLException;

    boolean updateEmployee( EmployeeDto dto) throws SQLException;

    EmployeeDto searchEmployee(String bookingId) throws SQLException;

    List<EmployeeDto> getAllEmployee() throws SQLException;
}
