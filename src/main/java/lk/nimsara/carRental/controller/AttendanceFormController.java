package lk.nimsara.carRental.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.nimsara.carRental.bo.BOFactory;
import lk.nimsara.carRental.bo.custom.AttendanceBO;
import lk.nimsara.carRental.bo.custom.EmployeeBO;
import lk.nimsara.carRental.dao.custom.impl.EmployeeDAOImpl;
import lk.nimsara.carRental.dto.AttendanceDto;
import lk.nimsara.carRental.dto.EmployeeDto;
import lk.nimsara.carRental.dto.tm.AttendanceTm;
import javafx.scene.input.MouseEvent;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.regex.Pattern;

public class AttendanceFormController {


    @FXML
    private ComboBox<String> cmbEmployee_id;


    @FXML
    private TableColumn<?, ?> colAttendance_date;

    @FXML
    private TableColumn<?, ?> colAttendance_id;

    @FXML
    private TableColumn<?, ?> colAttendance_time;

    @FXML
    private TableColumn<?, ?> colEmployee_id;

    @FXML
    private DatePicker dateSelect;

    @FXML
    private TableView<AttendanceTm> tblAttendance;

    @FXML
    private TextField txtAttendance_id;

    @FXML
    private TextField txtTime;


    AttendanceBO attendanceBO =(AttendanceBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ATTENDANCE);
    EmployeeBO employeeBo =(EmployeeBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.EMPLOYEE);


    public void initialize() {
        setCellValueFactory();
        loadAllAttendance();
        loadEmployeeIds();

    }

    private void loadEmployeeIds() {


        ObservableList<String> obList = FXCollections.observableArrayList();

        try {
            List<EmployeeDto> empList = employeeBo.getAllEmployee();
            for (EmployeeDto employeeDto:empList){
                obList.add(employeeDto.getEmployee_id());
            }
            cmbEmployee_id.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void setCellValueFactory() {
        colAttendance_id.setCellValueFactory(new PropertyValueFactory<>("attendanceId"));
        colAttendance_date.setCellValueFactory(new PropertyValueFactory<>("attendanceDate"));
        colAttendance_time.setCellValueFactory(new PropertyValueFactory<>("attendanceTime"));
        colEmployee_id.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
    }

    private void loadAllAttendance() {

        ObservableList<AttendanceTm> oblist =FXCollections.observableArrayList();

        try {
            List<AttendanceDto> attendanceList =attendanceBO.getAllAttendance();

            for (AttendanceDto attendanceDto:attendanceList){
                AttendanceTm attendanceTm =new AttendanceTm(attendanceDto.getAttendanceId(),
                        attendanceDto.getAttendanceDate(),
                        attendanceDto.getAttendanceTime(),
                        attendanceDto.getEmployeeId());

                oblist.add(attendanceTm);
            }
            tblAttendance.setItems(oblist);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }


    @FXML
    void btnEmployeeCleanOnAction(ActionEvent event) {
        clearFields();
    }

    private void clearFields() {
        txtAttendance_id.setText("");
        dateSelect.setValue(null);
        txtTime.setText("");
        cmbEmployee_id.setValue(null);
    }

    @FXML
    void btnEmployeeDeleteOnAction(ActionEvent event) {
        String id =txtAttendance_id.getText();



        try {
            boolean isDeleted =attendanceBO.deleteAttendance(id);

            if (isDeleted){
                tblAttendance.refresh();
                new Alert(Alert.AlertType.CONFIRMATION, "attendance deleted!").show();
                loadAllAttendance();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    @FXML
    void btnEmployeeSaveOnAction(ActionEvent event) {

        String id =txtAttendance_id.getText();
        LocalDate attendanceDate =dateSelect.getValue();
        String time =txtTime.getText();
        String empID =cmbEmployee_id.getValue();

        AttendanceDto attendanceDto =new AttendanceDto(id,attendanceDate,time,empID);



        try {
            boolean isSaved =attendanceBO.saveAttendance(attendanceDto);
            if (isSaved){
                new Alert(Alert.AlertType.CONFIRMATION, "attendance saved!").show();
                loadAllAttendance();

            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    @FXML
    void btnEmployeeUpdateOnAction(ActionEvent event) {
     /*  String id =txtAttendance_id.getText();
        String date = String.valueOf(dateSelect.getValue());
        String time =txtEmployee_address.getText();
        String Employee_id =txtEmployee_job_category.getText();


        AttendanceDto attendanceDto = new AttendanceDto(id,date,time,Employee_id);



        try {
            boolean isUpdated =attendancModel.updateAttendance(attendanceDto);
            if (isUpdated){
                new Alert(Alert.AlertType.CONFIRMATION, "employee updated!").show();
                loadAllAttendance();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }*/
    }


    @FXML
    void cmbEmployeeOnAction(ActionEvent event) throws SQLException {


        String id =cmbEmployee_id.getValue();
        EmployeeDto employeeDto =employeeBo.searchEmployee(id);

    }
    @FXML
    void tblOnMouseClickAction(MouseEvent event) {
        txtAttendance_id.setText(tblAttendance.getSelectionModel().getSelectedItem().getAttendanceId());
        txtTime.setText(tblAttendance.getSelectionModel().getSelectedItem().getAttendanceTime());
      //  cmbEmployee_id.getValue(tblAttendance.getSelectionModel().getSelectedItem().getEmployeeId());
       // dateSelect.getValue(tblAttendance.getSelectionModel().getSelectedItem().getAttendanceDate());



    }


}

