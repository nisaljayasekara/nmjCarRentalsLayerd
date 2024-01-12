package lk.nimsara.carRental.bo.custom;

import lk.nimsara.carRental.bo.SuperBO;
import lk.nimsara.carRental.dto.CustomerDto;
import lk.nimsara.carRental.dto.RapierDto;

import java.sql.SQLException;
import java.util.List;

public interface RepairBO extends SuperBO {
    boolean saveRepair( RapierDto dto) throws SQLException;

    boolean deleteRepair(String Rapier_id) throws SQLException;

    boolean updateRepair( RapierDto dto) throws SQLException;

    RapierDto searchRepair(String Rapier_id) throws SQLException;

    List<RapierDto> getAllRepair() throws SQLException;
}
