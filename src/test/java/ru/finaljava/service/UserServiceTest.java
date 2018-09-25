package ru.finaljava.service;

import org.hibernate.exception.ConstraintViolationException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.finaljava.model.Role;
import ru.finaljava.model.User;
import util.exception.NotFoundException;

public class UserServiceTest extends AbstractServiceTest {
    @Autowired
    UserService service;

    @Test
    public void create() {
        User u = new User (null, "new name", "new@mail.ru", "password", Role.ROLE_USER);
        //service.create
    }

    @Test
    public void update() {

    }

    @Test
    public void delete() {

    }

    @Test(expected = NotFoundException.class)
    public void deleteNotFound() {

    }

    @Test
    public void get(){

    }

    @Test(expected = NotFoundException.class)
    public void getNotFound(){

    }

    @Test(expected = ConstraintViolationException.class)
    public void testConstraint(){

    }
}
