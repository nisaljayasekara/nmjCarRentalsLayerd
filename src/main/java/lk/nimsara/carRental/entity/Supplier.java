package lk.nimsara.carRental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Supplier {
    private String supplier_id;
    private String supplier_name;
    private String supplier_email;
    private String tel;
    private String user_id;
}
