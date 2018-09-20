package ru.finaljava.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "results", uniqueConstraints = @UniqueConstraint(columnNames = "user_id"))
public class Results extends AbstractBaseEntity {

    @Column(name = "user_id")
    private int userId;

    @Column(name = "voted")
    @NotNull
    private LocalDateTime voted;

    @Column(name = "restaurant_id")
    private int restaurantId;
}
