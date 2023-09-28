package email.ucp.classes;

public class User {
    public User(String newFullName, String direction) {
        super();
        setFullName(newFullName);
        setDirection(direction);
        bandeja= new Tray(direction);
    }

    private String fullName;
    private String direction;
    public Tray bandeja;

    //           INICIO ENCAPSULACION           //
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return direction;
    }
    //           FIN ENCAPSULACION           //
}