package ru.finaljava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.finaljava.model.Dish;

import java.util.List;

@Transactional(readOnly = true)
public interface CrudDishRepository extends JpaRepository<Dish, Integer> {
    @Modifying
    @Transactional
    @Query("DELETE from Dish d WHERE  d.id=:id")
    int delete(@Param("id") int id);

    @Override
    @Modifying
    @Transactional
    Dish save(Dish dish);

    @Query("SELECT d.id as id, d.name as name, d.type as type FROM Dish d")
    List<Dish> getAll();
}
