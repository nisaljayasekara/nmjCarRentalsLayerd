package lk.nimsara.carRental.bo.custom.impl;

import lk.nimsara.carRental.bo.custom.StockBO;
import lk.nimsara.carRental.dao.DAOFactory;
import lk.nimsara.carRental.dao.custom.CustomerDAO;
import lk.nimsara.carRental.dao.custom.SalaryDAO;
import lk.nimsara.carRental.dao.custom.StockDAO;
import lk.nimsara.carRental.dto.CustomerDto;
import lk.nimsara.carRental.dto.StockDto;
import lk.nimsara.carRental.entity.Customer;
import lk.nimsara.carRental.entity.Stock;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StockBOImpl implements StockBO {

    StockDAO stockDAO = (StockDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.STOCK);


    @Override
    public boolean saveStock(StockDto dto) throws SQLException {
        return stockDAO.save(new Stock(
               dto.getStockId(),
                dto.getDescription(),
                dto.getQty_on_hand()));
    }

    @Override
    public boolean deleteStock(String Stock_id) throws SQLException {
        return stockDAO.delete(Stock_id);
    }

    @Override
    public boolean updateStock(StockDto dto) throws SQLException {
        return  stockDAO.update(new Stock(
               dto.getStockId(),
                dto.getDescription(),
                dto.getQty_on_hand()));

    }

    @Override
    public StockDto searchStock(String Stock_id) throws SQLException {
        Stock stock = stockDAO.search(Stock_id);
        return new StockDto(stock.getStockId(),
                stock.getDescription(),
                stock.getQty_on_hand());
    }

    @Override
    public List<StockDto> getAllStock() throws SQLException {
        List<Stock> stockList= stockDAO.getAll();
        List<StockDto> dtoList = new ArrayList<>();

        for (Stock stock:stockList){
            dtoList.add(new StockDto(stock.getStockId(),
                    stock.getDescription(),
                    stock.getQty_on_hand()));

        }

        return dtoList;
    }

}
