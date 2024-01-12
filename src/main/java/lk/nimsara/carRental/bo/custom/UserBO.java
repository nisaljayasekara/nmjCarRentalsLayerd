package lk.nimsara.carRental.bo.custom;

import lk.nimsara.carRental.bo.SuperBO;
import lk.nimsara.carRental.dto.UserDto;

import java.sql.SQLException;
import java.util.List;

public interface UserBO extends SuperBO {
     String verifyUser(String userName,String password) throws SQLException;

     List<UserDto> loadAllUser() throws SQLException;

     UserDto searchUser(String id) throws SQLException;
}
