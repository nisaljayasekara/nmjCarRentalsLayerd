package lk.nimsara.carRental.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Salary {
    private String Salary_id;
    private String Salary_date;
    private String SalaryAmount;
    private String Employee_id;
}
