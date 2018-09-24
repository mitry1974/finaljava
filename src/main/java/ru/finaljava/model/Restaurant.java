package ru.finaljava.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
@Table(name = "restaurants", uniqueConstraints = @UniqueConstraint(columnNames = "name", name = "restaurants_unique_name_idx"))
public class Restaurant extends AbstractNamedEntity {


    @NotBlank
    @Column(name = "address")
    String address;

    @Column(name = "phone")
    String phone;

    @Size(min = 5, max = 30)
    @Column(name = "page")
    String page;

    @OneToMany(mappedBy = "restaurant")
    Collection<MenuItem> menuItems;
}
