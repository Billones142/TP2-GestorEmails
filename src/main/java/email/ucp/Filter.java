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

    private ArrayList<Mail> userMails;
    private String userAddress;

    private Predicate<Mail> filterPredicate;

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

    public void setFilterPredicate(Predicate<Mail> predicate) {
        this.filterPredicate = predicate;
    }

    public Predicate<Mail> getFilterPredicate() {
        return filterPredicate;
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

    public Filter getEmails_Send() throws Exception{
        String functionDirection= getUserAddress();

        if(getFilterPredicate() == null){
            setFilterPredicate(send(functionDirection));
        }else{
            setFilterPredicate(getFilterPredicate().and(send(functionDirection)));
        }
        
        return this;
    }

    public Filter getEmails_FromUCP(){
        if(getFilterPredicate() == null){
            setFilterPredicate(getFromUCPPredicate());
        }else{
            setFilterPredicate(getFilterPredicate().and(getFromUCPPredicate()));
        }

        return this;
    }

    public Filter getEmails_From(String address){
        if(getFilterPredicate() == null){
            setFilterPredicate(getFromPredicate(address));
        }else{
            setFilterPredicate(getFilterPredicate().and(getFromPredicate(address)));
        }

        return this;
    }

    public Filter getEmails_FromDate(String date){
        if(getFilterPredicate() == null){
            setFilterPredicate(getFromUCPPredicate(date));
        }else{
            setFilterPredicate(getFilterPredicate().and(getFromUCPPredicate(date)));
        }

        return this;
    }
    //*******************FIN MAILS FILTRADOS*******************\\

    public ArrayList<Mail> to_EmailList(){
        return getUserMails()
        .stream()
        .filter(getFilterPredicate())
        .collect(Collectors.toCollection(ArrayList::new));
    }
}