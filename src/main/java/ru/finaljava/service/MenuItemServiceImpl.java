package ru.finaljava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.finaljava.repository.MenuItemRepository;

@Service
public class MenuItemServiceImpl implements MenuItemService {
    private MenuItemRepository repository;

    @Autowired
    public MenuItemServiceImpl(MenuItemRepository repository) {
        this.repository = repository;
    }
}
