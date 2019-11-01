package lab3.model;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class Stock {
    String Address;
    String phoneNumber;
    Map<Product,Integer> products = new HashMap<Product, Integer>();//Учет количесто каждого товара на складе



    public Stock(String address, String phoneNumber ) {
        this.phoneNumber = phoneNumber;
        this.Address = address;
    }


    @XmlElement(name = "address")
    public String getAdress() {
        return Address;
    }

    public void setAdress(String adress) {
        Address = adress;
    }

    @XmlElement(name = "phoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @XmlElementWrapper(name = "stockProducts")
    @XmlElement(name = "stockProduct")
    public Map<Product, Integer> getProducts() {
        return products;
    }

    public int getProductAmount(Product product){
        // Получаем набор элементов
        Set<Map.Entry<Product, Integer>> set = products.entrySet();

        // Отобразим набор
        for (Map.Entry<Product, Integer> me : set) {
            if(me.getKey()==product)
                return me.getValue();
        }
        return 0;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }
}
