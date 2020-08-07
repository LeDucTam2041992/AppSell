package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import jvcontroller.Jv_Controller;
import model.Product;
import model.Specifications;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DetailController implements Initializable {
    Jv_Controller controller = Jv_Controller.getInstance();
    ArrayList<Specifications> specifications = controller.readSpecificationsFromFile("Spec.Dat");
    Product proBuy;

    @FXML
    ImageView productImg = new ImageView();
    @FXML
    Text name;
    @FXML
    TextArea screen;
    @FXML
    TextArea ram;
    @FXML
    TextArea chip;
    @FXML
    TextArea operaSystem;
    @FXML
    TextArea camera;
    @FXML
    TextArea pin;

    public DetailController() throws IOException {
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setProduct(Product product) {
        proBuy = product;
        Specifications spec = controller.findSpecificationsOfProduct(product,specifications);
        name.setText(product.getProductName());
        Image img = new Image(product.getImgLink());
        productImg.setImage(img);
        screen.setText("Screen : " + spec.getScreen());
        ram.setText("Ram : " + spec.getRam());
        chip.setText("Chip : " + spec.getChip());
        operaSystem.setText("Opera System : " + spec.getOperaSystem());
        camera.setText("Camera : " + spec.getCamera());
        pin.setText("Pin : " + spec.getPin());
    }

    public void goBack(ActionEvent event) {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("sample.fxml"));
        Parent sampleParent = null;
        try {
            sampleParent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(sampleParent);
        stage.setScene(scene);
    }

    public void buy(ActionEvent event) {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Custom.fxml"));
        Parent sampleParent = null;
        try {
            sampleParent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        CustomController customController = loader.getController();
        customController.setProBuy(proBuy);
        Scene scene = new Scene(sampleParent);
        stage.setScene(scene);
    }
}
