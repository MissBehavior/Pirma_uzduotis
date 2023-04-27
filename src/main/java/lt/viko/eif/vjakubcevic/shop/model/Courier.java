package lt.viko.eif.vjakubcevic.shop.model;

import javax.persistence.*;

@Entity
@Table(name = "courier")
public class Courier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String courierName;
    private String courierLastName;
    private String courierphoneNumber;

    //no args constructor
    public Courier() {
    }

    public Courier(int id, String courierName, String courierLastName, String courierphoneNumber) {
        this.id = id;
        this.courierName = courierName;
        this.courierLastName = courierLastName;
        this.courierphoneNumber = courierphoneNumber;
    }

    public Courier(String courierName, String courierLastName, String courierphoneNumber) {
        this.courierName = courierName;
        this.courierLastName = courierLastName;
        this.courierphoneNumber = courierphoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int courierId) {
        this.id = courierId;
    }

    public String getCourierName() {
        return courierName;
    }

    public void setCourierName(String courierName) {
        this.courierName = courierName;
    }

    public String getCourierLastName() {
        return courierLastName;
    }

    public void setCourierLastName(String courierLastName) {
        this.courierLastName = courierLastName;
    }

    public String getCourierphoneNumber() {
        return courierphoneNumber;
    }

    public void setCourierphoneNumber(String courierphoneNumber) {
        this.courierphoneNumber = courierphoneNumber;
    }

    public String toString() {
        return String.format("Courier: \n\t\t" +
                "Courier ID = %d\n\t\t" +
                "Courier Name = %s\n\t\t" +
                "Courier Last Name = %s\n\t\t" +
                "Courier Phone number = %s", this.id, this.courierName, this.courierLastName, this.courierphoneNumber);
    }
}
