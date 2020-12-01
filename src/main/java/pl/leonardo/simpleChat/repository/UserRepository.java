package pl.leonardo.simpleChat.repository;

import org.springframework.stereotype.Repository;
import pl.leonardo.simpleChat.model.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private List<User> users = new ArrayList<User>();

    public List<User> findAll() {
        return users;
    }
    public void addUser(User user){
        users.add(user);
    }
    public User getUser(Long id) {
        if(findUserIndexById(id) != -1) return users.get(id.intValue());
        else return null;
    }
    public void updateUser(long id, User user){
        int ID = findUserIndexById(id);
        if(ID != -1){
            users.get(ID).setId(user.getId());
            users.get(ID).setNick(user.getNick());
        }
    }

    public void deleteUser(Long id) {
        if(findUserIndexById(id) != -1){
            users.remove(findUserIndexById(id));
        }
    }

    public int findUserIndexById(long id){
        int index=-1;
        for(User u : users) {
            if(u.getId() == id) {
                index =  u.getId().intValue();
            }
        }
        return index;
    }
}
