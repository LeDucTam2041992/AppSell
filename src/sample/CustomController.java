package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import jvcontroller.Jv_Controller;
import model.Customer;
import model.Product;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class CustomController implements Initializable {
    final String CUSTOMER_FILE = "Customer.Dat";
    Product proBuy;
    @FXML
    TextField nameCustomer;
    @FXML
    TextField ageCustomer;
    @FXML
    TextField addressCustomer;
    @FXML
    TextField phoneNumber;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setProBuy(Product product) {
        this.proBuy = product;
    }

    public void confirm(ActionEvent event) {
        String name = nameCustomer.getText();
        String age = ageCustomer.getText();
        String address = addressCustomer.getText();
        String phone = phoneNumber.getText();
        Customer customer;
        boolean checkName = Pattern.matches("[a-zA-Z\\s]+",name);
        boolean checkAge = Pattern.matches("\\d+",age);
        boolean checkAddress = Pattern.matches("[a-zA-Z\\s]+",address);
        boolean checkPhone = Pattern.matches("\\d+",phone);
        if (checkAddress && checkAge && checkName && checkPhone) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Confirmation Dialog");
            alert.setContentText("Are you ok with this?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                String time = java.util.Calendar.getInstance().getTime().toString();
                customer = new Customer(name, age, address, time, Integer.parseInt(phone), proBuy);
                Jv_Controller jv_controller = Jv_Controller.getInstance();
                jv_controller.writeCustomerToFile(CUSTOMER_FILE,customer);
                customer.showInfo();
                cancel(event);

            }
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Have Something Not Right!");
            alert.setContentText("Please Check Your Infomation!");
            alert.showAndWait();
        }
    }

    public void cancel(ActionEvent event) {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("sample.fxml"));
        Parent sampleParent = null;
        try {
            sampleParent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Controller controller = loader.getController();
        boolean x = proBuy.getSpecies().equalsIgnoreCase("SmartPhone");
        if (x) {
            controller.loadSmartPhone();
        } else {
            controller.loadHeadPhone();
        }
        Scene scene = new Scene(sampleParent,1000,700);
        stage.setScene(scene);
    }
}
