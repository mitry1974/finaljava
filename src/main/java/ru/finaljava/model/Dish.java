package ru.finaljava.model;

import javax.persistence.*;

@Entity
@Table(name = "dishes", uniqueConstraints = {@UniqueConstraint(columnNames = {"restaurant_id", "name"}, name = "dishes_name_idx")})
public class Dish extends AbstractNamedEntity {

}
