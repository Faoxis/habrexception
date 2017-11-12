package org.faoxis.habrexception;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private static final Map<Integer, User> userStorage
            = new HashMap<>();

    static {
        userStorage.put(1, new User(1, "Petr", "Petrov"));
        userStorage.put(2, new User(2, "Ivan", "Ivanov"));
        userStorage.put(3, new User(3, "Sergei", "Sidorov"));
    }

    public User get(int id) {
        User user = userStorage.get(id);
        if (user == null) {
            throw new ThereIsNoSuchUserException();
        }

        return user;
    }

}
