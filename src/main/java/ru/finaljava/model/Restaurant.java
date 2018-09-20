package ru.finaljava.model;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;

@Entity
@Table(name = "restaurants", uniqueConstraints = @UniqueConstraint(columnNames = "name",name = "restaurants_unique_name_idx"))
public class Restaurant extends AbstractNamedEntity {


    @NotBlank
    @Column(name = "address")
    String address;

    @Column(name = "phone")
    String phone;

    @Size(min=5, max=30)
    @Column(name = "page")
    String page;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "menu_items",
            joinColumns = @JoinColumn(name = "restaurant_id"),
            inverseJoinColumns = @JoinColumn(name = "dish_id"))
    private final Map<DishType, MenuItem> menu= new EnumMap<>(DishType.class);
    //        private Collection<MenuItem> menu;
}
