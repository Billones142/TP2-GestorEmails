package email.ucp.classes;

import java.util.ArrayList;

public class Tray {
    public Tray(String direction) {
        super();
        setPropietaryDirection(direction);
    }

    String propietaryDirection;
    private ArrayList<Mail> mails;

    //           INICIO ENCAPSULACION           //
    public void setPropietaryDirection(String propietaryDirection) {
        this.propietaryDirection = propietaryDirection;
    }

    public String getPropietaryDirection() {
        return propietaryDirection;
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Mail> getMailsRecieved() {
        return (ArrayList<Mail>) mails.stream().filter(mail -> mail.getFrom() == this.getPropietaryDirection());
    }
    //           FIN ENCAPSULACION           //

    public void add(){
        
    };
}
