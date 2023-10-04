package email.ucp;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Tray {
    public Tray(String direction) {
        super();
        setPropietaryDirection(direction);
        mails= new ArrayList<Mail>();
    }

    String propietaryDirection;
    private ArrayList<Mail> mails;

    // Predicados
    Predicate<Mail> ucp= mail-> mail instanceof Mail; //TODO
    Predicate<Mail> ucp1= mail-> mail instanceof Mail; //TODO
    Predicate<Mail> ucp2= mail-> mail instanceof Mail; //TODO
    Predicate<Mail> ucp3= mail-> mail instanceof Mail; //TODO
    Predicate<Mail> ucp4= mail-> mail instanceof Mail; //TODO
    Predicate<Mail> ucp5= mail-> mail instanceof Mail; //TODO


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