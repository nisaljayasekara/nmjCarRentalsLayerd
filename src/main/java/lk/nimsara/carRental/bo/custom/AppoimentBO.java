package lk.nimsara.carRental.bo.custom;

import lk.nimsara.carRental.bo.SuperBO;
import lk.nimsara.carRental.dto.AppoimentDto;
import lk.nimsara.carRental.dto.CustomerDto;

import java.sql.SQLException;
import java.util.List;

public interface AppoimentBO extends SuperBO {
    boolean saveAppoiment( AppoimentDto dto) throws SQLException;

    boolean deleteAppoiment(String Appoiment_id) throws SQLException;

    boolean updateAppoiment( AppoimentDto dto) throws SQLException;

    AppoimentDto searchAppoiment(String Appoiment_id) throws SQLException;

    List<AppoimentDto> getAllAppoiment() throws SQLException;
}
