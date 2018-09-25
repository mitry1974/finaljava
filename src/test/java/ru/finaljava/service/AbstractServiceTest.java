package ru.finaljava.service;

import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.finaljava.configuration.DataConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataConfig.class)
@Sql(scripts = "classpath:db/populatedb.sql", config = @SqlConfig(encoding = "UTF-8"))
public abstract class AbstractServiceTest {
}
