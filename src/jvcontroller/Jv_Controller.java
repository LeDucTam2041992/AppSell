package jvcontroller;

import model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Jv_Controller {
    private File file;
    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;
    private PrintWriter printWriter;
    private FileReader fileReader;
    private BufferedReader bufferedReader;

    private static Jv_Controller instance;

    private Jv_Controller() {
    }

    public static Jv_Controller getInstance() {
        if (instance == null) {
            synchronized (Jv_Controller.class) {
                if (instance == null) {
                    instance = new Jv_Controller();
                }
            }
        }
        return instance;
    }

    public void openFileToWrite(String fileName) {
        try {
            file = new File(fileName);
            if (!file.exists()) file.createNewFile();
            fileWriter = new FileWriter(fileName, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(bufferedWriter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeFileAfterWrite(String fileName) {
        try {
            printWriter.close();
            bufferedWriter.close();
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void openFileToRead(String fileName) {
        try {
            file = new File(fileName);
            if (!file.exists()) file.createNewFile();
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeFileAfterRead(String fileName) {
        try {
            bufferedReader.close();
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.exists()) file.delete();
    }

    public void writeProducerToFile(String fileName, Producer producer) {
        openFileToWrite(fileName);
        printWriter.println(producer.fileData());
        closeFileAfterWrite(fileName);
    }

    public void writeProductToFile(String fileName, Product product) {
        openFileToWrite(fileName);
        printWriter.println(product.fileData());
        closeFileAfterWrite(fileName);
    }

    public void writeProductToFile(String fileName, LinkedList<Product> products) {
        openFileToWrite(fileName);
        for (Product p : products) {
            printWriter.println(p.fileData());
        }
        closeFileAfterWrite(fileName);
    }

    public void writeCustomerToFile(String fileName, Customer customer) {
        openFileToWrite(fileName);
        printWriter.println(customer.fileData());
        closeFileAfterWrite(fileName);
    }

    public void writeSpecificationsToFile(String fileName, SpecSmartPhone specifications) {
        openFileToWrite(fileName);
        printWriter.println(specifications.fileData());
        closeFileAfterWrite(fileName);
    }

    public void writeSpecificationsToFile(String fileName, SpecHeadPhone specifications) {
        openFileToWrite(fileName);
        printWriter.println(specifications.fileData());
        closeFileAfterWrite(fileName);
    }

    public LinkedList<Customer> readCustomerFromFile(String fileName) throws IOException {
        LinkedList<Customer> customers = new LinkedList<>();
        String data;
        Product product;
        openFileToRead(fileName);
        while ((data = bufferedReader.readLine()) != null) {
            String[] datas = data.split("\\|");
            if (datas[7].equalsIgnoreCase("SmartPhone")) {
                product = new Smartphone();
            } else {
                product = new HeadPhone();
            }
            product.setProductCode(datas[5]);
            product.setProductName(datas[6]);
            Customer customer = new Customer(datas[0], datas[1], datas[2], datas[3], Integer.parseInt(datas[4]), product);
            customers.add(customer);
        }
        closeFileAfterRead(fileName);
        return customers;
    }

    public ArrayList<SpecSmartPhone> readSpecSmartPhoneFromFile(String fileName) throws IOException {
        String data;
        ArrayList<SpecSmartPhone> specs = new ArrayList<>();
        openFileToRead(fileName);
        while ((data = bufferedReader.readLine()) != null) {
            String[] datas = data.split("\\|");
            SpecSmartPhone specifications = new SpecSmartPhone(datas[0], datas[1], datas[2], datas[3], datas[4],
                    datas[5], datas[6]);
            specs.add(specifications);
        }
        closeFileAfterRead(fileName);
        return specs;
    }

    public ArrayList<SpecHeadPhone> readSpecHeadPhoneFromFile(String fileName) throws IOException {
        String data;
        ArrayList<SpecHeadPhone> specs = new ArrayList<>();
        openFileToRead(fileName);
        while ((data = bufferedReader.readLine()) != null) {
            String[] datas = data.split("\\|");
            SpecHeadPhone specifications = new SpecHeadPhone(datas[0], datas[1], datas[2], datas[3], datas[4]);
            specs.add(specifications);
        }
        closeFileAfterRead(fileName);
        return specs;
    }

    public LinkedList<Product> readProductFromFile(String fileName) throws IOException {
        LinkedList<Product> products = new LinkedList<>();
        String data;
        openFileToRead(fileName);
        while ((data = bufferedReader.readLine()) != null) {
            Product product = FactoryProduct.getProduct(data);
            products.add(product);
        }
        closeFileAfterRead(fileName);
        return products;
    }

    public LinkedList<Producer> readProducerFromFile(String fileName) throws IOException {
        LinkedList<Producer> producers = new LinkedList<>();
        openFileToRead(fileName);
        String data;
        while ((data = bufferedReader.readLine()) != null) {
            String[] datas = data.split("\\|");
            Producer producer = new Producer(datas[0], datas[1], datas[2]);
            producers.add(producer);
        }
        closeFileAfterRead(fileName);
        return producers;
    }

    public SpecSmartPhone findSpecSmartphoneOfProduct(Product product, ArrayList<SpecSmartPhone> specifications) {
        String codeSpec = product.getSpecifications();
        for (SpecSmartPhone s : specifications) {
            if (codeSpec.equalsIgnoreCase(s.getCodeSpec())) return s;
        }
        return null;
    }

    public SpecHeadPhone findSpecHeadPhoneOfProduct(Product product, ArrayList<SpecHeadPhone> specifications) {
        String codeSpec = product.getSpecifications();
        for (SpecHeadPhone s : specifications) {
            if (codeSpec.equalsIgnoreCase(s.getCodeSpec())) return s;
        }
        return null;
    }

    public Product findProductByName(String nameFind, LinkedList<Product> products) throws IOException {
        for (Product product: products) {
            if (nameFind.equalsIgnoreCase(product.getProductName())) return product;
        }
        return null;
    }

    public Product findProductByCode(String codeFind, LinkedList<Product> products) throws IOException {
        for (Product product: products) {
            if (codeFind.equalsIgnoreCase(product.getProductCode())) return product;
        }
        return null;
    }

    public LinkedList<Product> findProductByPrice(int price1, int price2, LinkedList<Product> products) throws IOException {
        LinkedList<Product> productFind = new LinkedList<>();
        for (Product product: products) {
            if (product.getPrice() >= price1 && product.getPrice() <= price2) productFind.add(product);
        }
        return productFind;
    }

    public LinkedList<Product> findProductByProducer(String producerName, LinkedList<Product> products) throws IOException {
        LinkedList<Product> productFind = new LinkedList<>();
        for (Product product: products) {
            if (product.getProducer().equalsIgnoreCase(producerName)) productFind.add(product);
        }
        return productFind;
    }
}




