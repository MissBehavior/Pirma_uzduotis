package lt.viko.eif.vjakubcevic.shop.model;

import jakarta.xml.bind.annotation.XmlElementWrapper;

import javax.persistence.*;

@Entity
@Table(name = "orderItem")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;


    @OneToOne(targetEntity = Product.class, cascade = CascadeType.ALL)
    private Product product;
    private int orderItemQuantity;

    public OrderItem() {
    }

    public OrderItem(int id, Product product, int orderItemQuantity) {
        this.id = id;
        this.product = product;
        this.orderItemQuantity = orderItemQuantity;
    }

    public OrderItem(Product product, int orderItemQuantity) {
        this.product = product;
        this.orderItemQuantity = orderItemQuantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int orderItemId) {
        this.id = orderItemId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getOrderItemQuantity() {
        return orderItemQuantity;
    }

    public void setOrderItemQuantity(int orderItemQuantity) {
        this.orderItemQuantity = orderItemQuantity;
    }

    public String toString() {
        return String.format("OrderItem: \n\t\t" +
                "Order Item ID = %d\n\t\t" +
                "Quantity = %s\n\t\t\t" +
                "%s\n\t\t", this.id, this.orderItemQuantity, this.product);
    }




}
