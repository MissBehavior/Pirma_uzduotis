package lt.viko.eif.vjakubcevic.shop.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;


import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
@XmlRootElement
@Entity
@Table(name = "mainOrder")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @OneToOne(targetEntity = User.class, cascade = CascadeType.ALL)
    private User user;
    @OneToOne(targetEntity = Courier.class, cascade = CascadeType.ALL)
    private Courier courier;
    private String orderAddress;


    @OneToMany(targetEntity = OrderItem.class, cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    public Order() {
    }

    public Order(int id, User user, Courier courier, String orderAddress, List<OrderItem> orderItems) {
        this.id = id;
        this.user = user;
        this.courier = courier;
        this.orderAddress = orderAddress;
        this.orderItems = orderItems;
    }

    public Order(User user, Courier courier, String orderAddress, List<OrderItem> orderItems) {
        this.user = user;
        this.courier = courier;
        this.orderAddress = orderAddress;
        this.orderItems = orderItems;
    }


    public int getId() {
        return id;
    }

    public void setId(int orderId) {
        this.id = orderId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public String toString() {
        return String.format("lt.viko.eif.vjakubcevic.shop.model: " +
                "\n\tOrder ID = %d" +
                "\n\t%s" +
                "\n\t%s" +
                "\n\tOrder Address = %s" +
                "\n\t%s", this.id, this.user, this.courier, this.orderAddress, constructOrderItemsList());

    }

    private Object constructOrderItemsList() {
        String result = "";
        for (OrderItem orderitem : this.orderItems) {
            result += orderitem.toString();
        }
        return result;
    }
}
