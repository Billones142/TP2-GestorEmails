package email.ucp;

import java.util.ArrayList;

public class User {
    public User(String newFullName, String direction) {
        super();
        setFullName(newFullName);
        setDirection(direction);
        bandeja= new Tray(direction);
        contacts= new ArrayList<Contact>();
    }

    private String fullName;
    private String direction;

    public ArrayList<Contact> contacts;

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

    public void addNewContact(String name,String direction){
        contacts.add(new Contact(name, direction));
    }

    public Mail createNewEmail(String subject, String content, ArrayList<String> toEmail){
        Mail mail = new Mail(getDirection());
        mail.setTo(toEmail);
        mail.setSubject(subject);
        mail.setContent(content);

        bandeja.add(mail);

        return mail;
    }
}