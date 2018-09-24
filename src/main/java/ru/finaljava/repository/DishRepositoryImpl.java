package ru.finaljava.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.finaljava.model.Dish;

import java.util.List;

@Repository
public class DishRepositoryImpl implements DishRepository {
    private DishCrudRepository repository;

    @Autowired
    public DishRepositoryImpl(DishCrudRepository repository) {
        this.repository = repository;
    }

    @Override
    public Dish save(Dish dish) {
        return repository.save(dish);
    }

    @Override
    public boolean delete(int id) {
        return repository.delete(id) != 0;
    }

    @Override
    public List<Dish> getAll() {
        return repository.getAll();
    }
}
