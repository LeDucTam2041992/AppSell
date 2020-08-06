package model;

import java.util.Date;

public class Customer {
    String nameCustomer, age, address, timeBuy;
    int phoneNumber;
    Product product;

    public Customer() {
    }

    public Customer(String nameCustomer, String age, String address, String timeBuy, int phoneNumber, Product product) {
        this.nameCustomer = nameCustomer;
        this.age = age;
        this.address = address;
        this.timeBuy = timeBuy;
        this.phoneNumber = phoneNumber;
        this.product = product;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTimeBuy() {
        return timeBuy;
    }

    public void setTimeBuy(String timeBuy) {
        this.timeBuy = timeBuy;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void showInfo() {
        System.out.println("Name : " + nameCustomer);
        System.out.println("Age : " + age);
        System.out.println("Phone number : " + phoneNumber);
        System.out.println("Address : " + address);
        System.out.println("Item order : " + product.getProductCode());
        System.out.println("Time order : " + timeBuy);
    }

    public String fileData() {
        return nameCustomer + "|" + age + "|" + address + "|" + timeBuy + "|" + phoneNumber + "|"
                + product.getProductCode() + "|" + product.getSpecies();
    }
}
