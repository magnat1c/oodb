package lab3;

import lab3.model.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class ServiceXML {

    /**
     * метод saveProductData сохраняет объект типа Product в XML документ
     */
    public static void saveProductData(Product product) {

        try {
            JAXBContext context = JAXBContext.newInstance(Product.class);
            Marshaller marshaller = context.createMarshaller();
            // устанавливаем флаг для читабельного вывода XML в JAXB
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // маршаллинг объекта в файл
            marshaller.marshal(product, new File("product.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


    /**
     * Метод loadProductFromXML преобразует XML документ в объект типа Bank
     */
    public static Product loadProductFromXML() {

        try {
            // создаем объект JAXBContext - точку входа для JAXB
            JAXBContext jaxbContext = JAXBContext.newInstance(Product.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();

            return (Product) un.unmarshal(new File("product.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return null;
    }
}
