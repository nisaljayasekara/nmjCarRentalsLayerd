package lk.nimsara.carRental.dao.custom.impl;

import lk.nimsara.carRental.dao.custom.AttendanceDAO;
import lk.nimsara.carRental.dao.custom.CarDAO;
import lk.nimsara.carRental.entity.Attendance;
import lk.nimsara.carRental.entity.Car;
import lk.nimsara.carRental.entity.Customer;
import lk.nimsara.carRental.util.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AttendanceDAOImpl implements AttendanceDAO {

    @Override
    public List<Attendance> getAll() throws SQLException {

        ResultSet resultSet = SQLUtil.crudUtil("SELECT * FROM attendance");

        List<Attendance> attendanceList = new ArrayList<>();

        while (resultSet.next()) {
            String attendanceId = resultSet.getString(1);
            LocalDate attendanceDate = resultSet.getDate(2).toLocalDate();
            String attendanceTime = resultSet.getString(3);
            String employeeId = resultSet.getString(4);

            Attendance entity = new Attendance(attendanceId, attendanceDate, attendanceTime, employeeId);
            attendanceList.add(entity);
        }
        return attendanceList;
    }

    @Override
    public boolean save(Attendance entity) throws SQLException {
        return SQLUtil.crudUtil("INSERT INTO attendance VALUES(?, ?, ?, ?)",
                entity.getAttendanceId(),
                entity.getAttendanceDate(),
                entity.getAttendanceTime(),
                entity.getEmployeeId());
    }

    @Override
    public boolean update(Attendance entity) throws SQLException {
        return SQLUtil.crudUtil("UPDATE attendance SET AttendanceDate =?,AttendanceTime =?,Employee_id = ? WHERE Attendance_id=?)",
                entity.getAttendanceDate(),
                entity.getAttendanceId(),
                entity.getAttendanceTime(),
                entity.getAttendanceId());
    }

    @Override
    public boolean exist(String id) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return SQLUtil.crudUtil("DELETE FROM attendance WHERE Attendance_id = ?", id);
    }

    @Override
    public String generateID() throws SQLException {
        return null;
    }

    @Override
    public Attendance search(String id) throws SQLException {
        ResultSet resultSet = SQLUtil.crudUtil("SELECT * FROM attendance WHERE Attendance_id = ?",id);
        Attendance entity = null;
        if (resultSet.next()){
            String Attendance_id= resultSet.getString(1);
            LocalDate Attendance_date = resultSet.getDate(2).toLocalDate();
            String Attendance_time = resultSet.getString(3);
            String Employee_id = resultSet.getString(4);

            entity = new Attendance(Attendance_id,Attendance_date,Attendance_time,Employee_id);
        }
        return entity;
    }

}
