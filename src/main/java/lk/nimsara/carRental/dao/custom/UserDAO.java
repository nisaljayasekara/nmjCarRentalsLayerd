package lk.nimsara.carRental.dao.custom;

import lk.nimsara.carRental.dao.CrudDAO;
import lk.nimsara.carRental.entity.User;

import java.sql.SQLException;

public interface UserDAO extends CrudDAO<User> {

     String verifyUser(String userName,String password) throws SQLException;
}
