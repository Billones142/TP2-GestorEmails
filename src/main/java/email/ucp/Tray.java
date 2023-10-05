package email.ucp;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Tray {
    public Tray(String direction) {
        super();
        setPropietaryDirection(direction);
        mails= new ArrayList<Mail>();
    }

    private String propietaryDirection;
    private ArrayList<Mail> mails;

    // Predicados
    private Predicate<Mail> ucp= mail-> mail instanceof Mail; //TODO
    private Predicate<Mail> ucp1= mail-> mail instanceof Mail; //TODO
    private Predicate<Mail> ucp2= mail-> mail instanceof Mail; //TODO
    private Predicate<Mail> ucp3= mail-> mail instanceof Mail; //TODO
    private Predicate<Mail> ucp4= mail-> mail instanceof Mail; //TODO
    private Predicate<Mail> ucp5= mail-> mail instanceof Mail; //TODO


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

    public Predicate<Mail> getUcp() {
        return ucp;
    }
    
    //           FIN ENCAPSULACION           //

    public ArrayList<Mail> getMailsRecieved() {
        return (ArrayList<Mail>) mails.stream().filter(mail -> mail.getFrom() == this.getPropietaryDirection());
    }

    public void add(Mail newMail){
        mails.add(newMail);
    };

    public ArrayList<Mail> getFilteredMails_Send(){ //TODO
        ArrayList<Mail> filteredMails;

        
        filteredMails= (ArrayList<Mail>)mails.stream().filter(send);

        return filteredMails;
    }

    public ArrayList<Mail> getFilteredMails_FromUCP(){ //TODO
        ArrayList<Mail> filteredMails;

        
        filteredMails= (ArrayList<Mail>)mails.stream().filter(ucp);

        return filteredMails;
    }



    public ArrayList<Mail> getFilteredMails_From(String fromMail){ //TODO
        ArrayList<Mail> filteredMails;

        
        filteredMails= (ArrayList<Mail>)mails.stream().filter(mail -> mail.getFrom() == fromMail);

        return filteredMails;
    }
}