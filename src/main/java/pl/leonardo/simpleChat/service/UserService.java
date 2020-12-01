package pl.leonardo.simpleChat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.leonardo.simpleChat.model.User;
import pl.leonardo.simpleChat.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user){
        if(userRepository.findUserIndexById(user.getId()) == -1) userRepository.addUser(user);
    }

    public User getUserById(long id) {
        return userRepository.getUser(id);
    }
    public void updateUser(long id, User user){
        userRepository.updateUser(id, user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteUser(id);
    }
}
