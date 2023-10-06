package email.ucp;

import java.util.ArrayList;

public class Mail {
    public Mail(String fromMail, String date) throws Exception{
        super();
        if(!emailAddressIsValid(fromMail)){
            throw new Exception("Email address invalid");
        }
        setFrom(fromMail);
        setDate(date);
    }

    private String from;
    private ArrayList<String> to= new ArrayList<String>();
    private String subject;
    private String content;
    private String date;


    //           INICIO ENCAPSULACION           //
    public String getFrom(){
        return from;
    }

    private void setFrom(String direction){
        from= direction;
    }

    public void setTo(ArrayList<String> to) {
        this.to = to;
    }

    public ArrayList<String> getTo() {
        return to;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }
    //           FIN ENCAPSULACION           //

    public boolean emailAddressIsValid(String address){ //TODO
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

    public void addNewTo(String email){
        getTo().add(email);
    }
}