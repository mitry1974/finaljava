package ru.finaljava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.finaljava.model.Dish;

import java.util.List;

public interface DishRepository{
    Dish save(Dish dish);

    boolean delete(int id);

    List<Dish> getAll();
}
