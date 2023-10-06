package email.ucp;

import java.util.ArrayList;

public class User {
    public User(String newFullName, String address) throws Exception{
        super();
        if(!emailAddressIsValid(address)){
            throw new Exception("Email address invalid");
        }
        setFullName(newFullName);
        setDirection(address);
        contacts= new ArrayList<Contact>();
        mails= new ArrayList<Mail>();
    }

    private String fullName;
    private String direction;

    public ArrayList<Contact> contacts;
    public ArrayList<Mail> mails;

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

    public boolean emailAddressIsValid(String address){
        if(!address.trim().contains("@")){
            return false;
        }
        String addressName= address.split("@")[0];
        String addressProvider= address.split("@")[1];
        if(addressName.length() <= 0){
            return false;
        }
        if(addressProvider.length() <= 0){
            return false;
        }
        return true;
    }

    public void addNewContact(String name,String direction){
        contacts.add(new Contact(name, direction));
    }

    public Mail createNewEmail(String subject, String content, String date, ArrayList<String> toEmail) throws Exception{
        Mail mail = new Mail(getDirection(), date);
        mail.setTo(toEmail);
        mail.setSubject(subject);
        mail.setContent(content);

        mails.add(mail);

        return mail;
    }

    public Mail createNewEmail(String subject, String content, String date, Contact contact) throws Exception{
        ArrayList<String> toEmail= new ArrayList<String>();
        toEmail.add(contact.getMail());

        return createNewEmail(subject, content, date, toEmail);
    }
}