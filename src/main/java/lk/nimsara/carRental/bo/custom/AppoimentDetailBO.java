package lk.nimsara.carRental.bo.custom;

import lk.nimsara.carRental.bo.SuperBO;
import lk.nimsara.carRental.dto.AppoimentDto;

import java.sql.SQLException;

public interface AppoimentDetailBO extends SuperBO {
    public boolean saveAppoiment(AppoimentDto dto, String carId) throws SQLException;
}
