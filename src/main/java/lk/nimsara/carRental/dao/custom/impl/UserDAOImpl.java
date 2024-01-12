package lk.nimsara.carRental.dao.custom.impl;

import lk.nimsara.carRental.dao.custom.UserDAO;
import lk.nimsara.carRental.dto.UserDto;
import lk.nimsara.carRental.entity.Customer;
import lk.nimsara.carRental.entity.User;
import lk.nimsara.carRental.util.SQLUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public List<User> getAll() throws SQLException {

        ResultSet resultSet = SQLUtil.crudUtil("SELECT * FROM user");

        List<User> userList = new ArrayList<>();

        while (resultSet.next()) {
            userList.add(new User(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6)
                    )
            );
        }
        return userList;
    }
    @Override
    public boolean save(User entity) throws SQLException {
        return false;
    }

    @Override
    public boolean update(User entity) throws SQLException {
        return false;
    }

    @Override
    public boolean exist(String id) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }

    @Override
    public String generateID() throws SQLException {
        return null;
    }

    @Override
    public User search(String id) throws SQLException {
        ResultSet resultSet = SQLUtil.crudUtil("SELECT * FROM user WHERE User_id = ?",id);
        User entity = null;
        if (resultSet.next()){
            String userid= resultSet.getString(1);
            String name = resultSet.getString(2);
            String password = resultSet.getString(3);
            String email = resultSet.getString(4);
            String Employee_id= resultSet.getString(5);
            String type= resultSet.getString(6);
            entity = new User(userid,name,password,email,Employee_id,type);
        }
        return entity;
    }

    @Override
    public String verifyUser(String userName, String password) throws SQLException {



        ResultSet resultSet = SQLUtil.crudUtil("SELECT User_password,User_id,type FROM user WHERE USER_name =?",userName);

        try {
            if (resultSet.next()){
                if (password.equals(resultSet.getString(1)) && resultSet.getString(3).equals("admin")){
                    return resultSet.getString(2);
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return null;
    }
}
