package model;

public class Product {
    String species, productCode, productName;
    int price;
    Img img;
    Producer producer;
    Specifications specifications;

    public Product() {
    }

    public Product(String species, String productCode, String productName, int price, Producer producer, Specifications specifications, Img img) {
        this.species = species;
        this.productCode = productCode;
        this.productName = productName;
        this.price = price;
        this.producer = producer;
        this.specifications = specifications;
        this.img = img;
    }

    public Img getImg() {
        return img;
    }

    public void setImg(Img img) {
        this.img = img;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public Specifications getSpecifications() {
        return specifications;
    }

    public void setSpecifications(Specifications specifications) {
        this.specifications = specifications;
    }

    public void showInfo(){};
    public String fileData(){
        return null;
    };
}
