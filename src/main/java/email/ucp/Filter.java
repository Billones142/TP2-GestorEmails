package email.ucp;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

// TODO

public class Filter{
    public Filter(User user) {
        super();
        setUserAddress(user.getEmailAddress());
        setMails(user.mails);
    }

    private ArrayList<Mail> mails;
    private String userAddress;

    private void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public ArrayList<Mail> getMails() {
        return mails;
    }

    private void setMails(ArrayList<Mail> mails) {
        this.mails = mails;
    }


    //*******************COMIENZO PREDICADOS*******************\\
    private Predicate<Mail> send(String propietaryDirection){
        return mail -> mail.getFrom() == propietaryDirection;
    }

    private Predicate<Mail> getFromPredicate(String fromMail){
        return mail -> mail.getFrom() == fromMail;
    }

    private Predicate<Mail> getFromUCPPredicate(){
        return mail -> isFromUCP(mail);
    }

    private Predicate<Mail> getFromUCPPredicate(String date){
        return mail -> mail.getDate() == date;
    }
    //*******************FIN PREDICADOS*******************\\

    private boolean isFromUCP(Mail mail){
        boolean isFromUCP= false;
        String addressProvider= mail.getFrom().split("@")[1];
        if(addressProvider.contains("ucp.edu.ar")){
            isFromUCP= true;
        }
        return isFromUCP;
    }

    //*******************COMIENZO MAILS FILTRADOS*******************\\

    public void get_Send(){
        ArrayList<Mail> mails= getMails();
        String propietaryDirection= getUserAddress();
        ArrayList<Mail> filteredMails;

        
        filteredMails= mails.stream()
        .filter(send(propietaryDirection))
        .collect(Collectors.toCollection(ArrayList::new));

        setMails(filteredMails);
    }

    public void get_FromUCP(ArrayList<Mail> mails){
        ArrayList<Mail> filteredMails;

        
        filteredMails= mails.stream()
        .filter(getFromUCPPredicate())
        .collect(Collectors.toCollection(ArrayList::new));

        setMails(filteredMails);
    }

    public void get_From(ArrayList<Mail> mails, String fromMail){
        ArrayList<Mail> filteredMails;

        filteredMails= mails.stream()
        .filter(getFromPredicate(fromMail))
        .collect(Collectors.toCollection(ArrayList::new));

        setMails(filteredMails);
    }

    public void get_FromDate(ArrayList<Mail> mails, String date){
        ArrayList<Mail> filteredMails;

        filteredMails= mails.stream()
        .filter(getFromUCPPredicate(date))
        .collect(Collectors.toCollection(ArrayList::new));

        setMails(filteredMails);
    }
    //*******************FIN MAILS FILTRADOS*******************\\

    public Arraylist<Mail> toEmailList(){ //TODO
        return getMails();
    }
}