package email.ucp.classes;

import java.util.ArrayList;

public class Mail {
    private String from;
    private ArrayList<String> to;
    private String subject;
    private String content;


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
}