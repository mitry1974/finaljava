package ru.finaljava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.finaljava.model.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
}
