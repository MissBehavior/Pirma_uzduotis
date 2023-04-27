package lt.viko.eif.vjakubcevic.shop;

import lt.viko.eif.vjakubcevic.shop.model.*;
import lt.viko.eif.vjakubcevic.shop.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HibernateMain {
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

        Transaction transaction = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(order);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }


    }
}
