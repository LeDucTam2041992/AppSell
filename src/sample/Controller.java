package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import jvcontroller.Jv_Controller;
import model.Product;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    final String productFile = "Product.Dat";


    Jv_Controller controller = Jv_Controller.getInstance();
    LinkedList<Product> screenMid = new LinkedList<>();
    LinkedList<Product> screenFont = new LinkedList<>();
    LinkedList<Product> screenEnd = new LinkedList<>();

    @FXML
    ImageView imgItem1 = new ImageView();
    @FXML
    Text nameItem1 = new Text();
    @FXML
    Text priceItem1 = new Text();
    @FXML
    ImageView imgItem2 = new ImageView();
    @FXML
    Text nameItem2 = new Text();
    @FXML
    Text priceItem2 = new Text();
    @FXML
    ImageView imgItem3 = new ImageView();
    @FXML
    Text nameItem3 = new Text();
    @FXML
    Text priceItem3 = new Text();
    @FXML
    ImageView imgItem4 = new ImageView();
    @FXML
    Text nameItem4 = new Text();
    @FXML
    Text priceItem4 = new Text();
    @FXML
    ImageView imgItem5 = new ImageView();
    @FXML
    Text nameItem5 = new Text();
    @FXML
    Text priceItem5 = new Text();
    @FXML
    ImageView imgItem6 = new ImageView();
    @FXML
    Text nameItem6 = new Text();
    @FXML
    Text priceItem6 = new Text();
    @FXML
    ImageView imgItem7 = new ImageView();
    @FXML
    Text nameItem7 = new Text();
    @FXML
    Text priceItem7 = new Text();
    @FXML
    ImageView imgItem8 = new ImageView();
    @FXML
    Text nameItem8 = new Text();
    @FXML
    Text priceItem8 = new Text();
    @FXML
    TextField findName;
    @FXML
    CheckBox checkBox1;
    @FXML
    CheckBox checkBox2;
    @FXML
    CheckBox checkBox3;
    @FXML
    CheckBox checkBoxA;

    ArrayList<ImageView> listImg = new ArrayList<>();
    ArrayList<Text> listName = new ArrayList<>();
    ArrayList<Text> listPrice = new ArrayList<>();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listImg.add(imgItem1);
        listName.add(nameItem1);
        listPrice.add(priceItem1);
        listImg.add(imgItem2);
        listName.add(nameItem2);
        listPrice.add(priceItem2);
        listImg.add(imgItem3);
        listName.add(nameItem3);
        listPrice.add(priceItem3);
        listImg.add(imgItem4);
        listName.add(nameItem4);
        listPrice.add(priceItem4);
        listImg.add(imgItem5);
        listName.add(nameItem5);
        listPrice.add(priceItem5);
        listImg.add(imgItem6);
        listName.add(nameItem6);
        listPrice.add(priceItem6);
        listImg.add(imgItem7);
        listName.add(nameItem7);
        listPrice.add(priceItem7);
        listImg.add(imgItem8);
        listName.add(nameItem8);
        listPrice.add(priceItem8);
        try {
            screenFont = controller.readProductFromFile(productFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 8; i++) {
            screenMid.add(screenFont.pop());
        }
        setScreen(screenMid);

    }

    public void goNext() {
        if (!screenFont.isEmpty()) {
            while (!screenMid.isEmpty()) {
                screenEnd.add(screenMid.pop());
            }
            for (int i = 0; i < 8; i++) {
                if (screenFont.isEmpty()) break;
                screenMid.add(screenFont.pop());
            }
            setScreen(screenMid);
        }
    }

    public void Back(ActionEvent event) {
        if (!screenEnd.isEmpty()) {
            while (!screenMid.isEmpty()) {
                screenFont.addFirst(screenMid.removeLast());
            }
            for (int i = 0; i < 8; i++) {
                if (screenEnd.isEmpty()) break;
                screenMid.addFirst(screenEnd.removeLast());
            }
            setScreen(screenMid);
        }
    }

    public void setScreen(LinkedList<Product> screen) {
        Product product;
        String link;
        String name;
        String price;
        for (int i = 0; i < screen.size(); i++) {
            product = screen.get(i);
            link = product.getImg().getUrl();
            name = product.getProductName();
            price = "Price : " + product.getPrice() + " Vnd";
            Image image = new Image(link);
            listImg.get(i).setImage(image);
            listName.get(i).setText(name);
            listPrice.get(i).setText(price);
            listName.get(i).setOnMouseClicked(mouseEvent -> {
                try {
                    showProduct(mouseEvent);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
        for (int i = screen.size(); i < 8; i++) {
            listImg.get(i).setImage(null);
            listName.get(i).setText(null);
            listPrice.get(i).setText(null);
        }
    }

    private void showProduct(MouseEvent mouseEvent) throws IOException {
        Stage primaryStage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        String productName = ((Text) mouseEvent.getSource()).getText();

        LinkedList<Product> products = new LinkedList<>(screenEnd);
        products.addAll(screenMid);
        products.addAll(screenFont);
        Product product = controller.findProductByName(productName, products);

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("detail.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        DetailController D_Controller = loader.getController();
        D_Controller.setProduct(product);
        primaryStage.setTitle(productName);
        primaryStage.setScene(new Scene(root, 1000, 700));
        primaryStage.show();
    }

    public void findProduct(ActionEvent event) throws IOException {
        String str = findName.getText();
        LinkedList<Product> products = new LinkedList<>(screenEnd);
        products.addAll(screenMid);
        products.addAll(screenFont);
        Product product = controller.findProductByName(str,products);
        if(product != null) {
            LinkedList<Product> sc = new LinkedList<>();
            sc.add(product);
            setScreen(sc);
        }
    }

    public void sort(ActionEvent event) throws IOException {
        LinkedList<Product> sortPrice = new LinkedList<>();
        LinkedList<Product> sortProducer = new LinkedList<>();
        LinkedList<Product> sortProduct = new LinkedList<>();
        LinkedList<Product> products = controller.readProductFromFile(productFile);
        boolean isChoose1 = checkBox1.isSelected();
        boolean isChoose2 = checkBox2.isSelected();
        boolean isChoose3 = checkBox3.isSelected();
        boolean isChooseA = checkBoxA.isSelected();
        if (isChoose1) {
            LinkedList<Product> sort1 = controller.findProductByPrice(20000000, 100000000, products);
            sortPrice.addAll(sort1);
        }
        if (isChoose2) {
            LinkedList<Product> sort2 = controller.findProductByPrice(14000000, 20000000, products);
            sortPrice.addAll(sort2);
        }
        if (isChoose3) {
            LinkedList<Product> sort3 = controller.findProductByPrice(6000000, 14000000, products);
            sortPrice.addAll(sort3);
        }
        if (isChooseA) {
            LinkedList<Product> sortA = controller.findProductByProducer("Samsung", products);
            sortProducer.addAll(sortA);
        }

        if(!sortPrice.isEmpty() && !sortProducer.isEmpty()) {
            for (Product p: sortPrice) {
                if(sortProducer.contains(p)) sortProduct.add(p);
            }
        } else if (sortPrice.isEmpty()) {
            sortProduct.addAll(sortProducer);
        } else {
            sortProduct.addAll(sortPrice);
        }

        setScreen(sortProduct);

//        !isChoose1 && !isChoose2 && !isChoose3 && !isChooseA
        if(sortPrice.isEmpty() && sortProducer.isEmpty()) {
            setScreen(screenMid);
        }
    }

}

