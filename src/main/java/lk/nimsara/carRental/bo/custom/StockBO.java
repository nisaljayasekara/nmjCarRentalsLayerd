package lk.nimsara.carRental.bo.custom;

import lk.nimsara.carRental.bo.SuperBO;
import lk.nimsara.carRental.dto.CustomerDto;
import lk.nimsara.carRental.dto.StockDto;

import java.sql.SQLException;
import java.util.List;

public interface StockBO extends SuperBO {
    boolean saveStock( StockDto dto) throws SQLException;

    boolean deleteStock(String Stock_id) throws SQLException;

    boolean updateStock( StockDto dto) throws SQLException;

    StockDto searchStock(String Stock_id) throws SQLException;

    List<StockDto> getAllStock() throws SQLException;
}
