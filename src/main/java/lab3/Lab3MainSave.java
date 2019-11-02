package lab3;

import lab3.model.Product;
import lab3.model.Stock;

import java.util.ArrayList;
import java.util.List;

public class Lab3MainSave {

    public static void main(String[] args) {

        // Создаем объект продукт
        Product product = new Product();

        // Создаем объекты - склады где хранится продукт
        Stock stock1 = new Stock("Красная 33","+7984728347");
        Stock stock2 = new Stock("Джалиля 144","+7927465745");

        List<Stock> stocks = new ArrayList<>();
        stocks.add(stock1);
        stocks.add(stock2);

        product.setName("Диван");
        // Прикрепляем склады к продукту
        product.setStocks(stocks);

        // сохраняем объект в в XML документ
        ServiceXML.saveProductData(product);
    }
}