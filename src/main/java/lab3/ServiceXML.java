package lab3;

import lab3.model.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class ServiceXML {


    public static void saveProductData(Product product) {

        try {
            JAXBContext context = JAXBContext.newInstance(Product.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(product, new File("product.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


    public static Product loadProductFromXML() {

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Product.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();

            return (Product) un.unmarshal(new File("product.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return null;
    }
}
