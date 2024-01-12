package lk.nimsara.carRental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Car {
    private String id;
    private String name;
    private String availability;
    private String price;

}
