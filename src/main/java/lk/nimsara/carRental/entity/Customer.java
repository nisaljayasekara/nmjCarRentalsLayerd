package lk.nimsara.carRental.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {
    private String id;
    private String name;
    private String address;
    private String Email;
    private String Tel;
    private String User_id;
}

