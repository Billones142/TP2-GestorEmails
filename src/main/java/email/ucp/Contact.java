package email.ucp;

public class Contact {
    public Contact(String name, String mail) {
        super();
        setName(name);
        setMailAddress(mail);
    }

    String name;
    String mailAddress;

    //           INICIO ENCAPSULACION           //
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setMailAddress(String mail) {
        this.mailAddress = mail;
    }

    public String getMailAddress() {
        return mailAddress;
    }
    //           FIN ENCAPSULACION           //
}
