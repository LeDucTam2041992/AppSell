package model;

import java.util.Map;

public class Smartphone extends Product{
    Map<String,Integer> colorAndQuantity;

    public Smartphone() {
    }

    public Smartphone(Map<String, Integer> colorAndQuantity) {
        this.colorAndQuantity = colorAndQuantity;
    }

    public Smartphone(String species, String productCode, String productName, int price, Producer producer, Specifications specifications, Img img , Map<String, Integer> colorAndQuantity) {
        super(species, productCode, productName, price, producer, specifications,img);
        this.colorAndQuantity = colorAndQuantity;
    }


    public Map<String, Integer> getColorAndQuantity() {
        return colorAndQuantity;
    }

    public void setColorAndQuantity(Map<String, Integer> colorAndQuantity) {
        this.colorAndQuantity = colorAndQuantity;
    }

    @Override
    public void showInfo() {
        System.out.println("Species : " + species);
        System.out.println("Product Code : " + productCode);
        System.out.println("Product Name : " + productName);
        System.out.println("Price : " + price);
        System.out.println("Producer : " + producer.getNameProducer());
        colorAndQuantity.forEach((s, integer) -> System.out.println(s + " : " + integer));
    }

    @Override
    public String fileData() {
        String data = species + "|" + productCode + "|" + productName + "|" + price + "|" + producer.getNameProducer() + "|"
                + specifications.getCodeSpec() + "|" + img.getUrl() + "|" + colorAndQuantity;
        return data;
    }

}
