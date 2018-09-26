package ru.finaljava.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import ru.finaljava.model.Dish;
import ru.finaljava.model.DishType;
import util.exception.NotFoundException;

import java.util.List;

import static ru.finaljava.data.DishTestData.*;

public class DishServiceTest extends AbstractServiceTest {
    @Autowired
    DishService service;

    @Test
    public void get() {
        Dish dish = service.get(DISH_ID);
        assertMatch(dish, DISH1);
    }

    @Test(expected = NotFoundException.class)
    public void getNotFound() {
        service.get(1);
    }

    @Test
    public void getAll() {
        List<Dish> dishes = service.getAll();
        assertMatch(dishes, DISHES);
    }

    @Test
    public void create() {
        Dish newDish = new Dish();
        newDish.setName("Опупенный десерт!!!! Такого еще не было!");
        newDish.setType(DishType.DESERT);
        Dish created = service.create(newDish);
        newDish.setId(created.getId());
        assertMatch(service.getAll(), DISH1, DISH2, DISH3, DISH4, DISH5, DISH6, DISH7, DISH8, DISH9, created);
    }

    @Test
    public void update() {
        Dish updated = new Dish(DISH1);
        updated.setName("Updated dish");
        updated.setType(DishType.MAIN);
        service.update(updated);
        assertMatch(service.get(DISH_ID), updated);
    }

    @Test
    public void delete() {
        service.delete(DISH_ID);
        assertMatch(service.getAll(), DISH2, DISH3, DISH4, DISH5, DISH6, DISH7, DISH8, DISH9);
    }

    @Test(expected = NotFoundException.class)
    public void deleteNotFound() {
        service.delete(1);
    }

    @Test(expected = JpaSystemException.class)
    public void testConstraint() {
        Dish dish = new Dish(DISH1);
        dish.setId(0);
        service.create(dish);
    }
}
