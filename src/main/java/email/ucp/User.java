package email.ucp;

import java.util.ArrayList;
import java.util.Arrays;

import email.ucp.interfaces.IgetDetails;

public class User implements IgetDetails{
    public User(String newFullName, String address) throws Exception{
        super();
        if(!emailAddressIsValid(address)){
            throw new Exception("Email address invalid");
        }
        setFullName(newFullName);
        setEmailAddress(address);
        contacts= new ArrayList<Contact>();
        mails= new ArrayList<Mail>();
    }

    private String fullName;
    private String emailAddress;

    public ArrayList<Contact> contacts;
    public ArrayList<Mail> mails;

    //           INICIO ENCAPSULACION           //
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setEmailAddress(String direction) {
        this.emailAddress = direction;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
    //           FIN ENCAPSULACION           //

    public boolean emailAddressIsValid(String address){
        boolean returnValue= true;
        if(!address.trim().contains("@")){
            returnValue= false;
        }
        ArrayList<String> division= new ArrayList<>(Arrays.asList(address.split("@")));
        if(division.size() != 2){
            returnValue= false;
        }else for (String string : division) {
            if(string.length() <= 0){
                returnValue= false;
            }
        }
        
        return returnValue;
    }

    public void addNewContact(String name,String direction){
        contacts.add(new Contact(name, direction));
    }

    public Mail createNewEmail(String subject, String content, String date, ArrayList<String> toEmail) throws Exception{
        Mail mail = new Mail(getEmailAddress(), date);
        mail.setToAddresses(toEmail);
        mail.setSubject(subject);
        mail.setContent(content);

        mails.add(mail);

        return mail;
    }

    public Mail createNewEmail(String subject, String content, String date, Contact contact) throws Exception{
        ArrayList<String> toEmail= new ArrayList<String>();
        toEmail.add(contact.getEmailAddress());

        return createNewEmail(subject, content, date, toEmail);
    }
}