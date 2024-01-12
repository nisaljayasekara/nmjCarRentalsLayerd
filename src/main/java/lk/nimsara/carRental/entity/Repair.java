package lk.nimsara.carRental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Repair {
    private String Rapier_id;
    private String Rapier_date;
    private String Rapier_desc;
    private String Rapier_returnDate;
    private String Rapier_price;
    private String Car_id;
}
