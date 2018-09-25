package ru.finaljava.repository;

import ru.finaljava.model.User;
import java.util.List;

public interface UserRepository {
    User save(User user);

    boolean delete(int id);

    User get(int id);

    List<User> getAll();
}
