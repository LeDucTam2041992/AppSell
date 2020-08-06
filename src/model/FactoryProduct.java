package model;

import java.util.HashMap;
import java.util.Map;

public class FactoryProduct {
    private FactoryProduct(){};
    public static final Product getProduct(String data){
        String[] datas = data.split("\\|");
        switch (datas[0]) {
            case "SmartPhone" :
                Smartphone smartphone = new Smartphone(datas[0],datas[1],datas[2],Integer.parseInt(datas[3]),new Producer()
                        , new Specifications(), new Img() , new HashMap<>());
                smartphone.producer.setNameProducer(datas[4]);
                smartphone.specifications.setCodeSpec(datas[5]);
                smartphone.img.setUrl(datas[6]);
                String s = datas[7].substring(1,datas[7].length()-1);
                s = s.replaceAll("\\s+","");
                String[] s1 = s.split(",");
                Map<String,Integer> map = new HashMap<>();
                for (String a:s1) {
                    String[] b = a.split("=");
                    map.put(b[0],Integer.parseInt(b[1]));
                }
                smartphone.setColorAndQuantity(map);
                return smartphone;
            case "HeadPhone" :
                return new HeadPhone();
            default: throw new IllegalArgumentException("This product type is unsupported");
        }
    }
}
