package email.ucp;

import java.util.ArrayList;

public class Dealer {
    public Dealer() {
        super();
        users= new ArrayList<User>();
    }
    private ArrayList<User> users;

    //           INICIO ENCAPSULACION           //
    public ArrayList<User> getUsers() {
        return users;
    }

    public User getUser(int index) {
        return users.get(index);
    }

    public User getUser(String address) throws Exception{
        int userIndex= searchUser(address);
        if(userIndex == -1){
            throw new Exception("El usuario no existe");
        }
        return getUser(userIndex);
    }

    private void setUser(User user) {
        this.users.add(user);
    }
    //           FIN ENCAPSULACION           //

    

    public void setNewUser(String name, String mail) throws Exception{
        setUser(new User(name, mail));
    }

    /**
     * se encarga de buscar el indice del usuario que tenga un mail especifico,
     * si no lo encuentra devuelve -1
     * @param address mail del usuario que se está buscando(String)
     * @return índice del usuario
     */
    private int searchUser(String address){
        for (int i = 0; i < getUsers().size(); i++) {
            if(getUser(i).getDirection() == address){
                return i;
            }
        }
        return -1;
    }

    public void sendMail(User from, ArrayList<String> to, String subject, String content, String date) throws Exception{
        Mail newMail= from.createNewEmail(subject,content,date,to);
        
        //agregar el nuevo mail a todos los destinatarios
        for (String address : to) {
            getUser(searchUser(address)).mails.add(newMail);;
        }
    }
}