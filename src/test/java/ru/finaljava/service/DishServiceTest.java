package ru.finaljava.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.finaljava.model.Dish;
import ru.finaljava.model.DishType;

public class DishServiceTest extends AbstractServiceTest {
    @Autowired
    DishService service;

    @Test
    public void create(){
        Dish dish = new Dish();
        dish.setName("Опупенный десерт!!!! Такого еще не было!");
        dish.setType(DishType.DESERT);
        Dish created = service.create(dish);
    }
}
