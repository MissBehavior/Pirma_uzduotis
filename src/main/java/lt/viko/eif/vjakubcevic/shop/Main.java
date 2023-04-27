package lt.viko.eif.vjakubcevic.shop;

import lt.viko.eif.vjakubcevic.shop.model.*;

import java.util.List;

public class Main {
    public static void main(String... args) {
        Category category = new Category(1, "PhoneCase");
        Product product = new Product(01, "Black Leather Phone Case", 15, category);
        Product product1 = new Product(02, "White Plastic Case", 10, category);
        OrderItem orderItem = new OrderItem(001,product,2);
        OrderItem orderItem1 = new OrderItem(002, product1, 1);
        User user = new User(1, "Bob", "123", "bob@gmail.com", false);
        Courier courier = new Courier(01, "John", "Smith", "867530589");
        Order order = new Order(0001, user, courier, "Jasinskio g. 15", List.of(orderItem, orderItem1));




        System.out.println(order);

    }
}