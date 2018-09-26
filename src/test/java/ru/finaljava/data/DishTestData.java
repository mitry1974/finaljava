package ru.finaljava.data;

import ru.finaljava.model.Dish;
import ru.finaljava.model.DishType;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.finaljava.model.AbstractBaseEntity.START_SEQ;

public class DishTestData {
    public static final int DISH_ID = START_SEQ + 2;

    public static final Dish DISH1 = new Dish(DISH_ID , DishType.STARTER, "Салат рыбный");
    public static final Dish DISH2 = new Dish(DISH_ID + 1, DishType.STARTER, "Квашенная капуста");
    public static final Dish DISH3 = new Dish(DISH_ID + 2, DishType.SOUP, "Солянка");
    public static final Dish DISH4 = new Dish(DISH_ID + 3, DishType.SOUP, "Минестроне");
    public static final Dish DISH5 = new Dish(DISH_ID + 4, DishType.MAIN, "Спагетти неополитано");
    public static final Dish DISH6 = new Dish(DISH_ID + 5, DishType.MAIN, "Пельмени");
    public static final Dish DISH7 = new Dish(DISH_ID + 6, DishType.DESERT, "Мороженное");
    public static final Dish DISH8 = new Dish(DISH_ID + 7, DishType.DESERT, "Десерт фруктовый");
    public static final Dish DISH9 = new Dish(DISH_ID + 8, DishType.DRINK, "Кофе эспрессо");

    public static List<Dish> DISHES = Arrays.asList(DISH1, DISH2, DISH3, DISH4, DISH5, DISH6, DISH7, DISH8, DISH9);
/*
    public final Dish DISH2 = new Dish(DISH_ID + 2, DishType.STARTER, "Салат Мимоза");
    public final Dish DISH3 = new Dish(DISH_ID + 3, DishType.STARTER, "Салат Оливье");
    public final Dish DISH4 = new Dish(DISH_ID + 4, DishType.STARTER, "Маринованные огурцы");
    public final Dish DISH5 = new Dish(DISH_ID + 5, DishType.STARTER, "Соления по грузински");
*/
/*
    public final Dish DISH8 = new Dish(DISH_ID + 8, DishType.SOUP, "Борщ");
    public final Dish DISH9 = new Dish(DISH_ID + 9, DishType.SOUP, "Щи постные");
    public final Dish DISH10 = new Dish(DISH_ID + 10, DishType.SOUP, "Щи мясные");
    public final Dish DISH11 = new Dish(DISH_ID + 11, DishType.SOUP, "Уха");
*/
/*
    public final Dish DISH14 = new Dish(DISH_ID + 14, DishType.MAIN, "Стейк");
    public final Dish DISH15 = new Dish(DISH_ID + 15, DishType.MAIN, "Спагетти Котлета мясная");
    public final Dish DISH16 = new Dish(DISH_ID + 16, DishType.MAIN, "Хинкали из говядины");
    public final Dish DISH17 = new Dish(DISH_ID + 17, DishType.MAIN, "Хинкали из баранины");
    public final Dish DISH18 = new Dish(DISH_ID + 18, DishType.MAIN, "Плов");
*/
/*
    public final Dish DISH21 = new Dish(DISH_ID + 21, DishType.DESERT, "Торт лимонный");
    public final Dish DISH22 = new Dish(DISH_ID + 22, DishType.DESERT, "Чизкейк");
    public final Dish DISH23 = new Dish(DISH_ID + 23, DishType.DESERT, "Торт малиновый");
*/
/*
    public final Dish DISH25 = new Dish(DISH_ID + 25, DishType.DRINK, "Чай черный");
    public final Dish DISH26 = new Dish(DISH_ID + 26, DishType.DRINK, "Чай зеленый");
    public final Dish DISH27 = new Dish(DISH_ID + 27, DishType.DRINK, "Кофе по восточному");
    public final Dish DISH28 = new Dish(DISH_ID + 28, DishType.DRINK, "Кофе американо");
*/


    public static void assertMatch(Dish actual, Dish expected) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected, "menuItems");
    }

    public static void assertMatch(Iterable<Dish> actual, Dish... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Dish> actual, Iterable<Dish> expected) {
        assertThat(actual).usingElementComparatorIgnoringFields("menuItems").isEqualTo(expected);
    }
}