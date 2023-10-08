package email.ucp;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class Filter{
    public Filter(User user) {
        super();
        setUserAddress(user.getEmailAddress());
        setUserMails(user.mails);
    }

    private Filter(String filterAddress, ArrayList<Mail> filterMails) { //constructor para las funciones de filter
        super();
        setUserAddress(filterAddress);
        setUserMails(filterMails);
    }

    private ArrayList<Mail> userMails;
    private String userAddress;

    private void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public ArrayList<Mail> getUserMails() {
        return userMails;
    }

    private void setUserMails(ArrayList<Mail> mails) {
        this.userMails = mails;
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

    public Filter getEmails_Send(){
        ArrayList<Mail> mails= getUserMails();
        String functionDirection= getUserAddress();
        ArrayList<Mail> filteredMails;

        
        filteredMails= mails.stream()
        .filter(send(functionDirection))
        .collect(Collectors.toCollection(ArrayList::new));

        return new Filter(functionDirection, filteredMails);
    }

    public Filter getEmails_FromUCP(){
        ArrayList<Mail> mails= getUserMails();
        String functionDirection= getUserAddress();
        ArrayList<Mail> filteredMails;

        
        filteredMails= mails.stream()
        .filter(getFromUCPPredicate())
        .collect(Collectors.toCollection(ArrayList::new));

        return new Filter(functionDirection, filteredMails);
    }

    public Filter getEmails_From(String fromMail){
        ArrayList<Mail> mails= getUserMails();
        String functionDirection= getUserAddress();
        ArrayList<Mail> filteredMails;

        filteredMails= mails.stream()
        .filter(getFromPredicate(fromMail))
        .collect(Collectors.toCollection(ArrayList::new));

        return new Filter(functionDirection, filteredMails);
    }

    public Filter getEmails_FromDate(String date){
        ArrayList<Mail> mails= getUserMails();
        String functionDirection= getUserAddress();
        ArrayList<Mail> filteredMails;

        filteredMails= mails.stream()
        .filter(getFromUCPPredicate(date))
        .collect(Collectors.toCollection(ArrayList::new));

        return new Filter(functionDirection, filteredMails);
    }
    //*******************FIN MAILS FILTRADOS*******************\\

    public ArrayList<Mail> to_EmailList(){
        return getUserMails();
    }
}