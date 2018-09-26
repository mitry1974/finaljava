package ru.finaljava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.finaljava.model.User;
import ru.finaljava.repository.UserRepository;
import util.exception.NotFoundException;

import java.util.List;

import static util.ValidationUtil.checkNotFound;
import static util.ValidationUtil.checkNotFoundWithId;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User create(User user) {
        Assert.notNull(user);
        return checkNotFoundWithId(repository.save(user), user.getId());
    }

    @Override
    public void update(User user) throws NotFoundException {
        Assert.notNull(user);
        repository.save(user);
    }

    @Override
    public User get(int id) throws NotFoundException {
        return checkNotFoundWithId(repository.get(id), id);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        checkNotFoundWithId(repository.delete(id), id);
    }

    @Override
    public List<User> getAll() {
        return repository.getAll();
    }
}
