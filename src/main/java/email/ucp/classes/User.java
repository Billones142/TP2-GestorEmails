package email.ucp.classes;

public class User {
    public User(String newFullName) {
        super();
        setFullName(newFullName);
    }
    private String fullName;

    //           INICIO ENCAPSULACION           //
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }
    //           FIN ENCAPSULACION           //
}