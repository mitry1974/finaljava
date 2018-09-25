package ru.finaljava.service;

import ru.finaljava.model.User;
import util.exception.NotFoundException;

import java.util.List;

public interface UserService {
    User create(User user);

    void update(User user) throws NotFoundException;

    User get(int id) throws NotFoundException;

    void delete(int id) throws NotFoundException;

    List<User> getAll();
}
