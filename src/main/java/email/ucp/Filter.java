package email.ucp;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Filter {

    // predicados
    public Predicate<Mail> getFrom(String address) {
        boolean isFromUCP= false;
        if(address.trim().contains("@")){
            
        }
        return mail-> isFromUCP;
    }

    public Predicate<Mail> getFromUCP() {
        return getFrom("");
    }

    public ArrayList<Mail> getFilteredMails_Send(ArrayList<Mail> mails,  String propietaryDirection){ //TODO
        ArrayList<Mail> filteredMails;

        
        filteredMails= mails.stream().filter(mail -> mail.getFrom() == propietaryDirection)
        .collect(Collectors.toCollection(ArrayList::new));

        return filteredMails;
    }

    public ArrayList<Mail> getFilteredMails_FromUCP(ArrayList<Mail> mails){ //TODO
        ArrayList<Mail> filteredMails;

        
        filteredMails= mails.stream().filter(getFromUCP())
        .collect(Collectors.toCollection(ArrayList::new));

        return filteredMails;
    }

    public ArrayList<Mail> getFilteredMails_From(ArrayList<Mail> mails, String fromMail){ //TODO
        ArrayList<Mail> filteredMails;

        filteredMails= mails.stream().filter(mail -> mail.getFrom() == fromMail)
        .collect(Collectors.toCollection(ArrayList::new));

        return filteredMails;
    }
}