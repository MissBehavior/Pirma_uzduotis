package lt.viko.eif.vjakubcevic.shop.model;

import javax.persistence.*;

@Entity
@Table(name = "Client")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String userName;
    private String userPassword;
    private String userEmail;
    private boolean isAdmin;

    public User() {
    }

    public User(int id, String userName, String userPassword, String userEmail, boolean isAdmin) {
        this.id = id;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.isAdmin = isAdmin;
    }

    public User(String userName, String userPassword, String userEmail, boolean isAdmin) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.isAdmin = isAdmin;
    }

    public int getId() {
        return id;
    }

    public void setId(int userId) {
        this.id = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }



    public String toString() {
        return String.format("User: \n\t\t" +
                "ID = %d\n\t\t" +
                "Username = %s\n\t\t" +
                "Password = %s\n\t\t" +
                "Email = %s\n\t\t" +
                "Is admin? = %s", this.id, this.userName, this.userPassword, this.userEmail, this.isAdmin);
    }


}
