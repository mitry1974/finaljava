package ru.finaljava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.finaljava.repository.RestaurantRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    private RestaurantRepository repository;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository repository) {
        this.repository = repository;
    }
}
