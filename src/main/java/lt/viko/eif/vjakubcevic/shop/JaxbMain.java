package lt.viko.eif.vjakubcevic.shop;

import lt.viko.eif.vjakubcevic.shop.model.*;
import lt.viko.eif.vjakubcevic.shop.util.HibernateUtil;
import lt.viko.eif.vjakubcevic.shop.util.JaxbUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class JaxbMain {
    public static void main(String[] args) {
        //nepaduodam id, hibernate sugeneruos pats (reikalingi constr be id)

        Category category = new Category("PhoneCase");
        Product product = new Product("Black Leather Phone Case", 15, category);
        Product product1 = new Product("White Plastic Case", 10, category);
        OrderItem orderItem = new OrderItem(product,2);
        OrderItem orderItem1 = new OrderItem(product1, 1);
        User user = new User("Bob", "123", "bob@gmail.com", false);
        Courier courier = new Courier("John", "Smith", "867530589");
        Order order = new Order(user, courier, "Jasinskio g. 15", List.of(orderItem, orderItem1));

        System.out.println(order);

        try {
            String xml = JaxbUtil.convertToXML(order);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Order order1 = null;
        try {
            order1 = JaxbUtil.convertToObject("order.xml");
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(order1);



    }

    }

