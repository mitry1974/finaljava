package ru.finaljava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.finaljava.model.Dish;
import ru.finaljava.repository.DishRepository;
import util.exception.NotFoundException;

import java.util.List;

import static util.ValidationUtil.checkNotFoundWithId;

@Service
public class DishServiceImpl implements DishService {
    private DishRepository repository;

    @Autowired
    public DishServiceImpl(DishRepository repository) {
        this.repository = repository;
    }

    @Override
    public Dish create(Dish dish) throws NotFoundException {
        Assert.notNull(dish, "dish must not be null");
        return repository.save(dish);
    }

    @Override
    public void update(Dish dish) throws NotFoundException {
        Assert.notNull(dish, "dish must not be null");
        checkNotFoundWithId(repository.save(dish), dish.getId());
        repository.save(dish);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        checkNotFoundWithId(repository.delete(id), id);
    }

    @Override
    public List<Dish> getAll() {
        return repository.getAll();
    }

    @Override
    public Dish get(int id) {
        return checkNotFoundWithId(repository.get(id), id);
    }
}
