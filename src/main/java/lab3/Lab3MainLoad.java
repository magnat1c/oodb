package lab3;

import lab3.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Пример, демонстрирующий преобразование XML документа в объект
 */
public class Lab3MainLoad {

    public static void main(String[] args) {

        Product bank = ServiceXML.loadProductFromXML();

        System.out.println(bank);
    }
}
