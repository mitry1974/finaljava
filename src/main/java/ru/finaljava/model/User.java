package ru.finaljava.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users" )
public class User extends AbstractNamedEntity {
}
