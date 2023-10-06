package email.ucp;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

// TODO: hacer que las funciones solo requieran que les pases el usuario

public class Filter {

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

    public ArrayList<Mail> getFilteredMails_Send(ArrayList<Mail> mails,  String propietaryDirection){
        ArrayList<Mail> filteredMails;

        
        filteredMails= mails.stream()
        .filter(send(propietaryDirection))
        .collect(Collectors.toCollection(ArrayList::new));

        return filteredMails;
    }

    public ArrayList<Mail> getFilteredMails_FromUCP(ArrayList<Mail> mails){
        ArrayList<Mail> filteredMails;

        
        filteredMails= mails.stream()
        .filter(getFromUCPPredicate())
        .collect(Collectors.toCollection(ArrayList::new));

        return filteredMails;
    }

    public ArrayList<Mail> getFilteredMails_From(ArrayList<Mail> mails, String fromMail){
        ArrayList<Mail> filteredMails;

        filteredMails= mails.stream()
        .filter(getFromPredicate(fromMail))
        .collect(Collectors.toCollection(ArrayList::new));

        return filteredMails;
    }

    public ArrayList<Mail> getFilteredMails_Date(ArrayList<Mail> mails, String date){
        ArrayList<Mail> filteredMails;

        filteredMails= mails.stream()
        .filter(getFromUCPPredicate(date))
        .collect(Collectors.toCollection(ArrayList::new));

        return filteredMails;
    }
    //*******************FIN MAILS FILTRADOS*******************\\
}