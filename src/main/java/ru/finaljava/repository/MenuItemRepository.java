package ru.finaljava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.finaljava.model.MenuItem;

public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {
}
