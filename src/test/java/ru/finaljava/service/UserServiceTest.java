package ru.finaljava.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import ru.finaljava.model.Role;
import ru.finaljava.model.User;
import util.exception.NotFoundException;

import static ru.finaljava.data.UserTestData.*;

public class UserServiceTest extends AbstractServiceTest {
    @Autowired
    UserService service;

    @Test
    public void create() {
        User u = new User(null, "new name", "new@mail.ru", "password", Role.ROLE_USER);
        User created = service.create(u);
        u.setId(created.getId());
        assertMatch(u, service.get(created.getId()));
    }

    @Test
    public void update() {
        User u = new User(USER);
        u.setName("Измененный");
        service.update(u);
        assertMatch(service.get(u.getId()), u);
    }

    @Test
    public void delete() {
        service.delete(USER_ID);
        assertMatch(service.getAll(), ADMIN);
    }

    @Test(expected = NotFoundException.class)
    public void deleteNotFound() {
        service.delete(1);
    }

    @Test
    public void get() {
        User u = service.get(USER_ID);
        assertMatch(u, USER);
    }

    @Test(expected = NotFoundException.class)
    public void getNotFound() {
        service.get(1);
    }

    @Test(expected = JpaSystemException.class)
    public void testConstraint() {
        User u = new User(null, "Новый", "user@yandex.ru", "password", Role.ROLE_USER);
        service.create(u);
    }
}
