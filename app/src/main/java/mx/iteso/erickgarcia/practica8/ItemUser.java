package mx.iteso.erickgarcia.practica8;

/**
 * Created by erickgarcia on 10/03/18
 */

public class ItemUser {
    private String name, phone;

    public ItemUser(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
