package lk.nimsara.carRental.bo.custom;

import lk.nimsara.carRental.bo.SuperBO;
import lk.nimsara.carRental.dto.AttendanceDto;

import java.sql.SQLException;
import java.util.List;

public interface AttendanceBO extends SuperBO {
    boolean saveAttendance( AttendanceDto dto) throws SQLException;

    boolean deleteAttendance(String Attendance_id) throws SQLException;

    boolean updateAttendance( AttendanceDto dto) throws SQLException;

    AttendanceDto searchAttendance(String Attendance_id) throws SQLException;

    List<AttendanceDto> getAllAttendance() throws SQLException;

}
