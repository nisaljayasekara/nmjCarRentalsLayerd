package lk.nimsara.carRental.bo.custom.impl;

import lk.nimsara.carRental.bo.custom.CustomerBO;
import lk.nimsara.carRental.dao.DAOFactory;
import lk.nimsara.carRental.dao.custom.CustomerDAO;
import lk.nimsara.carRental.dto.CustomerDto;
import lk.nimsara.carRental.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerBOImpl implements CustomerBO {

    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    @Override
    public boolean saveCustomer(CustomerDto dto) throws SQLException {
        return customerDAO.save(new Customer(
                dto.getId(),
                dto.getName(),
                dto.getAddress(),
                dto.getEmail(),
                dto.getTel(),
                dto.getUser_id()));
    }

    @Override
    public boolean deleteCustomer(String Customer_id) throws SQLException {
        return customerDAO.delete(Customer_id);
    }

    @Override
    public boolean updateCustomer(CustomerDto dto) throws SQLException {
        return  customerDAO.update(new Customer(
                dto.getId(),
                dto.getName(),
                dto.getAddress(),
                dto.getEmail(),
                dto.getTel(),
                dto.getUser_id()));
    }

    @Override
    public CustomerDto searchCustomer(String bookingId) throws SQLException {
        Customer customer = customerDAO.search(bookingId);
        return new CustomerDto(customer.getId(),
                customer.getName(),
                customer.getAddress(),
                customer.getEmail(),
                customer.getTel(),
                customer.getUser_id());
    }

    @Override
    public List<CustomerDto> getAllCustomers() throws SQLException {

      List<Customer> customerList= customerDAO.getAll();
      List<CustomerDto> dtoList = new ArrayList<>();

      for (Customer customer:customerList){
          dtoList.add(new CustomerDto(customer.getId(),
                  customer.getName(),
                  customer.getAddress(),
                  customer.getEmail(),
                  customer.getTel(),
                  customer.getUser_id()));
      }

        return dtoList;
    }
}

