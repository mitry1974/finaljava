package ru.finaljava.model;

import javax.persistence.*;

@Entity
@Table(name = "menu_items")
public class MenuItem extends AbstractNamedEntity {

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "dish_id")
    private Dish dish;

    @Column(name = "price")
    private Integer price;
}
