package lk.nimsara.carRental.bo.custom.impl;

import lk.nimsara.carRental.bo.custom.UserBO;
import lk.nimsara.carRental.dao.DAOFactory;
import lk.nimsara.carRental.dao.custom.StockDAO;
import lk.nimsara.carRental.dao.custom.SupplierDAO;
import lk.nimsara.carRental.dao.custom.UserDAO;
import lk.nimsara.carRental.dto.CustomerDto;
import lk.nimsara.carRental.dto.SupplierDto;
import lk.nimsara.carRental.dto.UserDto;
import lk.nimsara.carRental.entity.Customer;
import lk.nimsara.carRental.entity.Supplier;
import lk.nimsara.carRental.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserBOImpl implements UserBO {

    UserDAO userDAO = (UserDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.USER);
    @Override
    public String verifyUser(String userName, String password) throws SQLException {

        return userDAO.verifyUser(userName,password);
    }

    @Override
    public List<UserDto> loadAllUser() throws SQLException {
        List<User> userList = userDAO.getAll();
        List<UserDto> dtoList = new ArrayList<>();

        for (User user : userList) {
            dtoList.add(new UserDto(user.getUser_id(),
                    user.getUser_name(),
                    user.getUser_password(),
                    user.getUser_email(),
                    user.getEmployee_id(),
                    user.getType()));
        }

        return dtoList;

    }

    @Override
    public UserDto searchUser(String id) throws SQLException {
        User user = userDAO.search(id);
        return new UserDto(user.getUser_id(),
                user.getUser_name(),
                user.getUser_password(),
                user.getUser_email(),
                user.getEmployee_id(),
                user.getType());
    }
}
