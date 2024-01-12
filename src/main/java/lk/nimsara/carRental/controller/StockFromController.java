package lk.nimsara.carRental.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.nimsara.carRental.bo.BOFactory;
import lk.nimsara.carRental.bo.custom.CustomerBO;
import lk.nimsara.carRental.bo.custom.StockBO;
import lk.nimsara.carRental.dto.StockDto;
import lk.nimsara.carRental.dto.tm.StockTm;
import javafx.scene.input.MouseEvent;

import java.sql.SQLException;
import java.util.List;

public class StockFromController {

    @FXML
    private TableColumn<?, ?> ColStockId;

    @FXML
    private TableColumn<?, ?> colDescrition;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TextField txtQty;

    @FXML
    private TextField txtStockDescription;

    @FXML
    private TableView<StockTm> tblstock;

    @FXML
    private TextField txtstock_id;

    StockBO stockBO =(StockBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.STOCK);

    public void initialize() {
        setCellValueFactory();
        loadAllStock();

    }

    private void setCellValueFactory() {
        ColStockId.setCellValueFactory(new PropertyValueFactory<>("stockId"));
        colDescrition.setCellValueFactory(new PropertyValueFactory<>("description"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty_on_hand"));

    }
    private void loadAllStock() {


            ObservableList<StockTm> obList = FXCollections.observableArrayList();

            try {
                List<StockDto> dtoList = stockBO.getAllStock();

                for(StockDto dto : dtoList) {
                    obList.add(
                            new StockTm(
                                    dto.getStockId(),
                                    dto.getDescription(),
                                    dto.getQty_on_hand()
                            )
                    );
                }

                tblstock.setItems(obList);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


    @FXML
    void btnClearOnAction(ActionEvent event) {
              clearFields();

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String stockId =txtstock_id.getText();



        try {
            boolean isDeleted =stockBO.deleteStock(stockId);
            if (isDeleted){
                tblstock.refresh();
                new Alert(Alert.AlertType.CONFIRMATION, "stock deleted!").show();
                loadAllStock();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String stockId =txtstock_id.getText();
        String description =txtStockDescription.getText();
        int qty = Integer.parseInt(txtQty.getText());



        StockDto stockDto =new StockDto(stockId,description,qty);



        try {
            boolean isSaved =stockBO.saveStock(stockDto);
            if (isSaved){
                new Alert(Alert.AlertType.CONFIRMATION, "stock saved!").show();
                loadAllStock();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }


    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String stockId =txtstock_id.getText();
        String description =txtStockDescription.getText();
        int qty = Integer.parseInt(txtQty.getText());



        StockDto stockDto = new StockDto(stockId,description,qty);



        try {
            boolean isUpdated =stockBO.updateStock(stockDto);
            if (isUpdated){
                new Alert(Alert.AlertType.CONFIRMATION, "stock updated!").show();
                loadAllStock();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }


    private void clearFields() {
        txtstock_id.setText("");
        txtStockDescription.setText("");
        txtQty.setText(String.valueOf(""));

    }

    @FXML
    void tblOnMouseClickAction(MouseEvent event) {
        txtstock_id.setText(tblstock.getSelectionModel().getSelectedItem().getStockId());
        txtStockDescription.setText(tblstock.getSelectionModel().getSelectedItem().getDescription());
        txtQty.setText(String.valueOf(tblstock.getSelectionModel().getSelectedItem().getQty_on_hand()));

    }

}
