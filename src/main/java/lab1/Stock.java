package lab1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


//Склад
class Stock {
    String Address;
    String phoneNumber;
    Map<Product,Integer> products = new HashMap<Product, Integer>();//Учет количесто каждого товара на складе



    public Stock(String address, String phoneNumber ) {
        this.phoneNumber = phoneNumber;
        this.Address = address;
    }

    public String getAdress() {
        return Address;
    }

    public void setAdress(String adress) {
        Address = adress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
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
}


