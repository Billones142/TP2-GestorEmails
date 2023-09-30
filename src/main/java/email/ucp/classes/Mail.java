package email.ucp.classes;

import java.util.ArrayList;

public class Mail {
    public Mail(String fromMail) {
        super();
        setFrom(fromMail);
    }

    private String from= new String();
    private ArrayList<String> to= new ArrayList<String>();
    private String subject= new String();
    private String content= new String();


    //           INICIO ENCAPSULACION           //
    public String getFrom(){
        return from;
    }

    public void setFrom(String direction){
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
    //           FIN ENCAPSULACION           //

    /*public void addNewTo(String email){ //TODO
        getTo().add(email);
    }*/
}