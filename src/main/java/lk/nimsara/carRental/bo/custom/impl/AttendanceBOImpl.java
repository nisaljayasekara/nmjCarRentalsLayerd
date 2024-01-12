package lk.nimsara.carRental.bo.custom.impl;

import lk.nimsara.carRental.bo.custom.AttendanceBO;
import lk.nimsara.carRental.dao.DAOFactory;
import lk.nimsara.carRental.dao.custom.AttendanceDAO;
import lk.nimsara.carRental.dto.AttendanceDto;
import lk.nimsara.carRental.dto.CustomerDto;
import lk.nimsara.carRental.entity.Attendance;
import lk.nimsara.carRental.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttendanceBOImpl implements AttendanceBO {

    AttendanceDAO attendanceDAO = (AttendanceDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ATTENDANCE);
    @Override
    public boolean saveAttendance(AttendanceDto dto) throws SQLException {
        return attendanceDAO.save(new Attendance(
                dto.getAttendanceId(),
                dto.getAttendanceDate(),
                dto.getAttendanceTime(),
                dto.getEmployeeId()));
    }

    @Override
    public boolean deleteAttendance(String Attendance_id) throws SQLException {
          return attendanceDAO.delete(Attendance_id);
    }

    @Override
    public boolean updateAttendance(AttendanceDto dto) throws SQLException {
        return  attendanceDAO.update(new Attendance(
                dto.getAttendanceId(),
                dto.getAttendanceDate(),
                dto.getAttendanceTime(),
                dto.getEmployeeId()));
    }

    @Override
    public AttendanceDto searchAttendance(String Attendance_id) throws SQLException {
        Attendance attendance = attendanceDAO.search(Attendance_id);
        return new AttendanceDto(attendance.getAttendanceId(),
                attendance.getAttendanceDate(),
                attendance.getAttendanceTime(),
                attendance.getEmployeeId());
    }

    @Override
    public List<AttendanceDto> getAllAttendance() throws SQLException {
        List<Attendance> attendanceList= attendanceDAO.getAll();
        List<AttendanceDto> dtoList = new ArrayList<>();

        for (Attendance attendance:attendanceList){
            dtoList.add(new AttendanceDto(attendance.getAttendanceId(),
                    attendance.getAttendanceDate(),
                    attendance.getAttendanceTime(),
                    attendance.getEmployeeId()));
        }

        return dtoList;
    }

}
