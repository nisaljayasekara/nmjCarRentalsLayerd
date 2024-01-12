package lk.nimsara.carRental.dao.custom.impl;

import lk.nimsara.carRental.dao.custom.StockDAO;
import lk.nimsara.carRental.entity.Customer;
import lk.nimsara.carRental.entity.Stock;
import lk.nimsara.carRental.util.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StockDAOImpl implements StockDAO {

    @Override
    public List<Stock> getAll() throws SQLException {
        ResultSet resultSet = SQLUtil.crudUtil("SELECT * FROM stock");

        List<Stock> stockList = new ArrayList<>();

        while (resultSet.next()) {
            String stockId= resultSet.getString(1);
            String description = resultSet.getString(2);
            int qty_on_hand = Integer.parseInt(resultSet.getString(3));

            Stock entity = new Stock(stockId,description,qty_on_hand);
            stockList.add(entity);
        }
        return stockList;
    }


    @Override
    public boolean save(Stock entity) throws SQLException {
        return SQLUtil.crudUtil("INSERT INTO stock VALUES(?, ?, ?)",
                entity.getStockId(),
                entity.getDescription(),
                entity.getQty_on_hand());
    }

    @Override
    public boolean update(Stock entity) throws SQLException {
        return SQLUtil.crudUtil("UPDATE stock SET description =?,qty_On_hand =? WHERE Stock_id=?",

                entity.getDescription(),
                entity.getQty_on_hand(),
                entity.getStockId());
    }

    @Override
    public boolean exist(String id) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return SQLUtil.crudUtil("DELETE FROM stock WHERE stock_id = ?",id);
    }

    @Override
    public String generateID() throws SQLException {
        return null;
    }

    @Override
    public Stock search(String id) throws SQLException {
        ResultSet resultSet = SQLUtil.crudUtil("SELECT * FROM stock WHERE Stock_id = ?",id);
        Stock entity = null;
        if (resultSet.next()){
            String stockId= resultSet.getString(1);
            String description = resultSet.getString(2);
            int qty_on_hand = Integer.parseInt(resultSet.getString(3));

            entity = new Stock(stockId,description,qty_on_hand);
        }
        return entity;
    }

}
