package ru.finaljava.model;

import java.util.HashMap;
import java.util.Map;

public class Restaurant extends AbstractBaseNamedEntity {
    String address;
    Map<String, Integer> dishes = new HashMap<>();
}
