package model;

public class HeadPhone extends Product{
    String type;
    public HeadPhone() {
    }

    public HeadPhone(String type) {
        this.type = type;
    }

    public HeadPhone(String species, String productCode, String productName, int price, String producer, String specifications, String imgLink, String type) {
        super(species, productCode, productName, price, producer, specifications, imgLink);
        this.type = type;
    }

    @Override
    public void showInfo() {
        System.out.println("Species : " + species);
        System.out.println("Product Code : " + productCode);
        System.out.println("Product Name : " + productName);
        System.out.println("Price : " + price);
        System.out.println("Producer : " + producer);
        System.out.println("Type : " + type);
    }

    @Override
    public String fileData() {
        String data = species + "|" + productCode + "|" + productName + "|" + price + "|" + producer + "|"
                + specifications + "|" + imgLink + "|" + type;
        return data;
    }
}
