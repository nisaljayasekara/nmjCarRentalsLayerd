package lk.nimsara.carRental.bo.custom.impl;

import lk.nimsara.carRental.bo.custom.SupplierBO;
import lk.nimsara.carRental.dao.DAOFactory;
import lk.nimsara.carRental.dao.custom.SupplierDAO;
import lk.nimsara.carRental.dto.CustomerDto;
import lk.nimsara.carRental.dto.SupplierDto;
import lk.nimsara.carRental.entity.Customer;
import lk.nimsara.carRental.entity.Supplier;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class SupplierBOImpl implements SupplierBO {

    SupplierDAO supplierDAO = (SupplierDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.SUPPLIER);

    @Override
    public boolean saveSupplier(SupplierDto dto) throws SQLException {
        return supplierDAO.save(new Supplier(
               dto.getSupplier_id(),
               dto.getSupplier_name(),
                dto.getSupplier_email(),
                dto.getTel(),
                dto.getUser_id()));
    }

    @Override
    public boolean deleteSupplier(String Supplier_id) throws SQLException {
        return supplierDAO.delete(Supplier_id);
    }

    @Override
    public boolean updateSupplier(SupplierDto dto) throws SQLException {
        return  supplierDAO.update(new Supplier(
                dto.getSupplier_id(),
                dto.getSupplier_name(),
                dto.getSupplier_email(),
                dto.getTel(),
                dto.getUser_id()));
    }

    @Override
    public SupplierDto searchSupplier(String Supplier_id) throws SQLException {
        Supplier supplier = supplierDAO.search(Supplier_id);
        return new SupplierDto(supplier.getSupplier_id(),
               supplier.getSupplier_name(),
                supplier.getSupplier_email(),
                supplier.getTel(),
                supplier.getUser_id());
    }

    @Override
    public List<SupplierDto> getAllSuppliers() throws SQLException {
        List<Supplier> supplierList= supplierDAO.getAll();
        List<SupplierDto> dtoList = new ArrayList<>();

        for (Supplier supplier:supplierList){
            dtoList.add(new SupplierDto(supplier.getSupplier_id(),
                  supplier.getSupplier_name(),
                    supplier.getSupplier_email(),
                    supplier.getTel(),
                    supplier.getUser_id()));
        }

        return dtoList;
    }
}
