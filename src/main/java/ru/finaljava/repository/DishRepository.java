package ru.finaljava.repository;

import ru.finaljava.model.Dish;

import java.util.List;

public interface DishRepository {
    Dish save(Dish dish);

    boolean delete(int id);

    List<Dish> getAll();

    Dish get(int id);
}
