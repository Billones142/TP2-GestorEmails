package email.ucp.classes;

public class Contact {
    public Contact(String name, String mail) {
        super();
        setName(name);
        setMail(mail);
    }

    String name;
    String mail;

    //           INICIO ENCAPSULACION           //
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }
    //           FIN ENCAPSULACION           //
}
