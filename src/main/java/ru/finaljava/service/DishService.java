package ru.finaljava.service;

import ru.finaljava.model.Dish;
import util.exception.NotFoundException;

import java.util.List;

public interface DishService {
    Dish create(Dish dish);

    void update(Dish dish) throws NotFoundException;

    void delete(int id) throws NotFoundException;

    List<Dish> getAll();
}
