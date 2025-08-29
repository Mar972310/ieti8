package edu.eci.ieti.ieti8.service;

import java.util.HashMap;
import org.springframework.stereotype.Service;
import edu.eci.ieti.ieti8.entity.User;
import edu.eci.ieti.ieti8.exception.UserNotFoundException;

@Service
public class UserService {

    private HashMap<String, User> users = new HashMap<>();

    public User create(User user){
        users.put(user.getId(), user);
        return users.get(user.getId());
    }

    public User read(String id){
        User user = users.get(id);
        if (user == null) {
            throw new UserNotFoundException(id);
        }
        return user;
    }

    public User update(String id, User user){
        if (!users.containsKey(id)) {
            throw new UserNotFoundException(id);
        }
        users.put(id, user);
        return read(id);
    }

    public boolean delete(String id){
        if (!users.containsKey(id)) {
            throw new UserNotFoundException(id);
        }
        users.remove(id);
        return true;
    }
}
