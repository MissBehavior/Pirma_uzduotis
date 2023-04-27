package lt.viko.eif.vjakubcevic.shop.util;


import lt.viko.eif.vjakubcevic.shop.model.Order;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class JaxbUtil {

    private JaxbUtil() {
    }

    public static String convertToXML(Order order) throws FileNotFoundException {
        try {
            JAXBContext context = JAXBContext.newInstance(Order.class);

            Marshaller marshaller = null;

            marshaller = context.createMarshaller();

            marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
            OutputStream os = new FileOutputStream("generated.xml");
            marshaller.marshal(order, os);
            marshaller.marshal(order, System.out);
            StringWriter writer = new StringWriter();
            marshaller.marshal(order, writer);

            return writer.toString();

        } catch (/*FileNotFoundException | */JAXBException e) {
            throw new RuntimeException(e);
        }


    }

    public static Order convertToObject(String filePath) throws JAXBException, IOException {

            JAXBContext context = JAXBContext.newInstance(Order.class);

            Unmarshaller unmarshaller = context.createUnmarshaller();

            Path path = Path.of("generated.xml");

            String xmlContent = Files.readString(path);
            System.out.print(xmlContent);

            StringReader reader = new StringReader(xmlContent);

            Order order = (Order) unmarshaller.unmarshal(reader);

            return order;


    }
}

