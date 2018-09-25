package ru.finaljava.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Set;

@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Entity
@Table(name = "dishes", uniqueConstraints = {@UniqueConstraint(columnNames = {"type", "name"}, name = "dishes_unique_idx")})
public class Dish extends AbstractNamedEntity {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "dish")
    private Collection<MenuItem> menuItems;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private DishType type;

    public DishType getType() {
        return type;
    }

    public void setType(DishType type) {
        this.type = type;
    }

    public Dish() {

    }

    public Dish(Dish dish){
        this(dish.getId(), dish.getType(), dish.getName());
    }

    public Dish(Integer id, DishType type, String name) {
        super(id, name);
        this.type = type;
    }

}
