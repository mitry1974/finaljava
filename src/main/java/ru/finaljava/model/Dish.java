package ru.finaljava.model;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Entity
@Table(name = "dishes", uniqueConstraints = {@UniqueConstraint(columnNames = {"type", "name"}, name = "dishes_unique_idx")})
public class Dish extends AbstractNamedEntity {

    public Dish(){

    }

    public Dish(DishType type, String name) {
        this.type = type;
        this.name = name;
    }

    @OneToMany(mappedBy = "dish")
    private Collection<MenuItem> menuItems;

    @Column(name = "type")
    @NotNull
    private DishType type;

    @Column(name = "name")
    @NotBlank
    private String name;

    public DishType getType() {
        return type;
    }

    public void setType(DishType type) {
        this.type = type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
