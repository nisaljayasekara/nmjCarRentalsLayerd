package lk.nimsara.carRental.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lk.nimsara.carRental.bo.BOFactory;
import lk.nimsara.carRental.bo.custom.EmployeeBO;
import lk.nimsara.carRental.bo.custom.UserBO;
import lk.nimsara.carRental.util.Navigation;
import lk.nimsara.carRental.util.Utils;

import java.io.IOException;
import java.sql.SQLException;

public class LoginPageFormController {

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUserName;

    UserBO userBO =(UserBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.USER);
   @FXML
    void btnLoginOnAction(ActionEvent event) throws SQLException {
       String userId = userBO.verifyUser(txtUserName.getText(),txtPassword.getText());
        if(userId != null){
            Utils.userId = userId;
            try {
                Navigation.switchNavigation("dashBoardForm.fxml",event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @FXML
    void hLinkSignUp(ActionEvent event) throws IOException {
        Navigation.switchNavigation("createNewAccount_from.fxml", event);

    }

    @FXML
    void btnLogOutOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("loginPageForm.fxml", event);
    }
}



