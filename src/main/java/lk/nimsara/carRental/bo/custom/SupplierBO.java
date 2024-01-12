package lk.nimsara.carRental.bo.custom;

import lk.nimsara.carRental.bo.SuperBO;
import lk.nimsara.carRental.dto.CustomerDto;
import lk.nimsara.carRental.dto.SupplierDto;

import java.sql.SQLException;
import java.util.List;

public interface SupplierBO extends SuperBO {
    boolean saveSupplier( SupplierDto dto) throws SQLException;

    boolean deleteSupplier(String Supplier_id) throws SQLException;

    boolean updateSupplier( SupplierDto dto) throws SQLException;

    SupplierDto searchSupplier(String Supplier_id) throws SQLException;

    List<SupplierDto> getAllSuppliers() throws SQLException;
}
