package co.com.sofka.models;


public class UserFormModel {
    private String email;
    private String id;
    private String name;
    private String lastname;
    private String password;
    private String direction;
    private String phone;

    public UserFormModel() {
    }

    public UserFormModel(String email, String id, String name, String lastname, String password, String direction, String phone) {
        this.email = email;
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.password = password;
        this.direction = direction;
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
