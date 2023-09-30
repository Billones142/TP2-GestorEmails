package email.ucp.classes;

import java.util.ArrayList;

public class User {
    public User(String newFullName, String direction) {
        super();
        setFullName(newFullName);
        setDirection(direction);
        bandeja= new Tray(direction);
    }

    private String fullName;
    private String direction;
    private ArrayList<String> contactos;

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

    public ArrayList<String> getContactos() {
        return contactos;
    }

    public String getContactos(int index) {
        return contactos.get(index);
    }

    public void setContactos(ArrayList<String> contactos) {
        this.contactos = contactos;
    }
    //           FIN ENCAPSULACION           //

    public void addNewContact(String direction){
        getContactos().add(direction);
    }

    public Mail createNewEmail(String subject, String content, ArrayList<String> toEmail){ //TODO
        Mail mail = new Mail(getDirection());
        mail.setTo(toEmail);
        mail.setSubject(subject);
        mail.setContent(content);

        return mail;
    }
}