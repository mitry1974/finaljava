package ru.finaljava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.finaljava.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
