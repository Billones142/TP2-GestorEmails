package email.ucp;

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

    public ArrayList<Mail> getMails() {
        return mails;
    }
    
    //           FIN ENCAPSULACION           //

    @SuppressWarnings("unchecked")
    public ArrayList<Mail> getMailsRecieved() {
        return (ArrayList<Mail>) mails.stream().filter(mail -> mail.getFrom() == this.getPropietaryDirection());
    }

    public void add(Mail newMail){
        mails.add(newMail);
    };
}