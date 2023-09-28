package email.ucp.classes;

import java.util.ArrayList;

public class Mail {
    private String from;
    private ArrayList<String> to;

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
    //           FIN ENCAPSULACION           //
}
