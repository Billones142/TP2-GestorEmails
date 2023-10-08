package email.ucp;

import java.util.ArrayList;
import java.util.Arrays;

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
    private ArrayList<String> toAddresses= new ArrayList<String>();
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

    public void setToAddresses(ArrayList<String> to) {
        this.toAddresses = to;
    }

    public ArrayList<String> getToAddresses() {
        return toAddresses;
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

    public void addNewToAddress(String email){  
        getToAddresses().add(email);
    }
}