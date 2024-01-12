package lk.nimsara.carRental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Attendance {
    private String attendanceId;
    private LocalDate attendanceDate;
    private String attendanceTime;
    private String employeeId;
}
