DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS dishes;
DROP TABLE IF EXISTS menu_items;
DROP TABLE IF EXISTS restaurants;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS results;
DROP SEQUENCE IF EXISTS global_id_seq;
CREATE SEQUENCE global_id_seq  start 10000;

CREATE TABLE users (
  id       INTEGER PRIMARY KEY DEFAULT nextval('global_id_seq'),
  name     VARCHAR NOT NULL,
  email    VARCHAR NOT NULL,
  password VARCHAR NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx
  ON users (email);

CREATE TABLE user_roles (
  user_id INTEGER NOT NULL,
  role    VARCHAR NOT NULL,
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users ON DELETE CASCADE
);

CREATE TABLE dishes (
  id   INTEGER PRIMARY KEY DEFAULT nextval('global_id_seq'),
  type VARCHAR NOT NULL,
  name VARCHAR NOT NULL,
  CONSTRAINT dishes_unique_idx UNIQUE (type, name)
);

CREATE TABLE menu_items (
  id            INTEGER PRIMARY KEY DEFAULT nextval('global_id_seq'),
  restaurant_id INTEGER NOT NULL,
  dish_id       INTEGER NOT NULL,
  price         INTEGER NOT NULL
);

CREATE TABLE restaurants (
  id      INTEGER PRIMARY KEY DEFAULT nextval('global_id_seq'),
  name    VARCHAR NOT NULL,
  address VARCHAR NOT NULL,
  phone   VARCHAR NULL,
  page    VARCHAR NULL
);
CREATE UNIQUE INDEX restaurants_unique_name_idx
  ON restaurants (name);

CREATE TABLE results (
  id            SERIAL PRIMARY KEY,
  user_id       INTEGER   NOT NULL,
  voted         TIMESTAMP NOT NULL,
  restaurant_id INTEGER   NOT NULL,
  UNIQUE (user_id)
);

