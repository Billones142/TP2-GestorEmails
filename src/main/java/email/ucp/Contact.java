package email.ucp;

import email.ucp.interfaces.IgetDetails;

public class Contact implements IgetDetails{
    public Contact(String name, String mail) {
        super();
        setFullName(name);
        setEmailAddress(mail);
    }

    String fullName;
    String emailAddress;

    //           INICIO ENCAPSULACION           //
    public void setFullName(String name) {
        this.fullName = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setEmailAddress(String mail) {
        this.emailAddress = mail;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
    //           FIN ENCAPSULACION           //
}