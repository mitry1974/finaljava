package ru.finaljava.repository;

import org.springframework.stereotype.Repository;
import ru.finaljava.model.User;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private CrudUserRepository repository;

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public boolean delete(int id) {
        return repository.delete(id) != 0;
    }

    @Override
    public User get(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAll() {
        return repository.getAll();
    }
}
