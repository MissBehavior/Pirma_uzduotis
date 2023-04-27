package lt.viko.eif.vjakubcevic.shop.model;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String productName;
    private int price;
    @OneToOne(targetEntity = Category.class, cascade = CascadeType.ALL)
    private Category category;

    public Product() {
    }

    public Product(int id, String productName, int price, Category category) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.category = category;
    }

    public Product(String productName, int price, Category category) {
        this.productName = productName;
        this.price = price;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int productId) {
        this.id = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }



    public String toString() {
        return String.format("Product: \n\t\t\t\t" +
                "Product ID = %d\n\t\t\t\t" +
                "Product name = %s\n\t\t\t\t" +
                "Product price = %d\n\t\t\t\t\t" +
                "%s\t\t\t\t\t\t", this.id, this.productName, this.price, this.category);
    }
}
