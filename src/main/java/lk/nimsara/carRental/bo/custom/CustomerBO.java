package lk.nimsara.carRental.bo.custom;

import lk.nimsara.carRental.bo.SuperBO;
import lk.nimsara.carRental.dto.CustomerDto;

import java.sql.SQLException;
import java.util.List;

public interface CustomerBO extends SuperBO {
    boolean saveCustomer( CustomerDto dto) throws SQLException;

    boolean deleteCustomer(String Customer_id) throws SQLException;

    boolean updateCustomer( CustomerDto dto) throws SQLException;

    CustomerDto searchCustomer(String bookingId) throws SQLException;

    List<CustomerDto> getAllCustomers() throws SQLException;
}
