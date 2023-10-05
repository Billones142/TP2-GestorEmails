package email.ucp;

import java.util.ArrayList;

public class Dealer {
    private ArrayList<User> users;

    //           INICIO ENCAPSULACION           //
    public ArrayList<User> getUsers() {
        return users;
    }

    public User getUser(int index) {
        return users.get(index);
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public void setUsers(User user) {
        this.users.add(user);;
    }
    //           FIN ENCAPSULACION           //

    public void createNewUser(String name, String mail){
        setUsers(new User(name, mail));
    }

    /**
     * se encarga de buscar el indice del usuario que tenga un mail especifico,
     * si no lo encuentra devuelve -1
     * @param mail mail del usuario que se está buscando(String)
     * @return índice del usuario
     */
    private int searchUser(String mail){
        for (int i = 0; i < getUsers().size(); i++) {
            if(getUser(i).getDirection() == mail){
                return i;
            }
        }
        return -1;
    }

    public void sendMail(User from, ArrayList<String> to, String subject, String content){
        Mail newMail= from.createNewEmail(subject, content, to);
        
        for (int i = 0; i < to.size(); i++) { //agrega el nuevo mail a todos los destinatarios
            int userIndex= searchUser(to.get(i));

            if(userIndex == -1){
                break;
            }

            getUser(userIndex).mails.add(newMail);
        }
    }
}