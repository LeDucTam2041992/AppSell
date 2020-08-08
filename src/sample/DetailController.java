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
import model.SpecHeadPhone;
import model.SpecSmartPhone;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DetailController implements Initializable {
    Jv_Controller controller = Jv_Controller.getInstance();
    ArrayList<SpecSmartPhone> specSmartPhones = controller.readSpecSmartPhoneFromFile("SpecSmartPhone.Dat");
    ArrayList<SpecHeadPhone> specHeadPhones = controller.readSpecHeadPhoneFromFile("SpecHeadPhone.Dat");
    Product proBuy;

    @FXML
    ImageView productImg = new ImageView();
    @FXML
    Text name;
    @FXML
    Text price;
    @FXML
    Text spec1;
    @FXML
    Text spec2;
    @FXML
    Text spec3;
    @FXML
    Text spec4;
    @FXML
    Text spec5;
    @FXML
    Text spec6;
    @FXML
    Text spec7;

    public DetailController() throws IOException {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void setProduct(Product product) {
        proBuy = product;
        SpecSmartPhone specSmartPhone = null;
        SpecHeadPhone specHeadPhone = null;
        if (proBuy.getSpecies().equalsIgnoreCase("Smartphone")) {
            specSmartPhone = controller.findSpecSmartphoneOfProduct(product, specSmartPhones);
            if (specSmartPhone != null) {
                spec1.setText("Screen : " + specSmartPhone.getScreen());
                spec2.setText("Ram : " + specSmartPhone.getRam());
                spec3.setText("Chip : " + specSmartPhone.getChip());
                spec4.setText("Opera System : " + specSmartPhone.getOperaSystem());
                spec5.setText("Camera : " + specSmartPhone.getCamera());
                spec6.setText("Pin : " + specSmartPhone.getPin());
                spec7.setText("Producer : " + product.getProducer());
            }
        }

        if (proBuy.getSpecies().equalsIgnoreCase("HeadPhone")) {
            specHeadPhone = controller.findSpecHeadPhoneOfProduct(product, specHeadPhones);
            if (specHeadPhone != null) {
                spec1.setText("Compatible : " + specHeadPhone.getCompatible());
                spec2.setText("SoundTechnology : " + specHeadPhone.getSoundTechnology());
                spec3.setText("TimeUse : " + specHeadPhone.getTimeUse());
                spec4.setText("Connection distance : " + specHeadPhone.getDistance());
                spec5.setText("Producer : " + product.getProducer());
            }
        }
        name.setText(product.getProductName());
        price.setText("Price : " + product.getPrice() + " Vnd");
        Image img = new Image(product.getImgLink());
        productImg.setImage(img);
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
        Controller controller = loader.getController();
        boolean checkSpecies = proBuy.getSpecies().equalsIgnoreCase("SmartPhone");
        if (checkSpecies) {
            controller.loadSmartPhone();
        } else {
            controller.loadHeadPhone();
        }
        Scene scene = new Scene(sampleParent,1000,700);
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
        Scene scene = new Scene(sampleParent,1000,700);
        stage.setScene(scene);
    }
}
