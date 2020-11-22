CREATE TABLE IF NOT EXISTS t_user(
    id_user INTEGER PRIMARY KEY AUTOINCREMENT,
    first_name TEXT NOT NULL,
    last_name TEXT,
    birthday DATE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE IF NOT EXISTS t_address(
    id_address INTEGER PRIMARY KEY AUTOINCREMENT,
    t_user_id_user INTEGER NOT NULL,
    active TEXT NOT NULL,
    type TEXT,
    street TEXT,
    neighbourhood TEXT,
    city TEXT,
    state TEXT,
    postal_code TEXT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY(t_user_id_user) REFERENCES t_user(id)
);
CREATE TABLE IF NOT EXISTS t_blood_pressure(
    id_blood_pressure INTEGER PRIMARY KEY AUTOINCREMENT,
    t_user_id_user INTEGER NOT NULL,
    value_blood_pressure NUMERIC,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY(t_user_id_user) REFERENCES t_user(id_user)
);
CREATE TABLE IF NOT EXISTS t_email(
    id_email INTEGER PRIMARY KEY AUTOINCREMENT,
    t_user_id_user INTEGER NOT NULL,
    type TEXT,
    address_email TEXT,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    active TEXT,
    FOREIGN KEY(t_user_id_user) REFERENCES t_user(id_user)
);
CREATE TABLE IF NOT EXISTS t_exercise(
    id_exercise INTEGER PRIMARY KEY AUTOINCREMENT,
    t_user_id_user INTEGER NOT NULL,
    label TEXT NOT NULL,
    duration DATE NOT NULL,
    description TEXT,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY(t_user_id_user) REFERENCES t_user(id_user)
);
CREATE TABLE IF NOT EXISTS t_food(
    id_food INTEGER PRIMARY KEY AUTOINCREMENT,
    calories INTEGER,
    description TEXT,
    t_user_id_user INTEGER NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY(t_user_id_user) REFERENCES t_user(id_user)
);
CREATE TABLE IF NOT EXISTS t_location(
    id_location INTEGER PRIMARY KEY AUTOINCREMENT,
    t_exercise_id_exercise INTEGER NOT NULL,
    latitude NUMERIC NOT NULL,
    longitude NUMERIC NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY(t_exercise_id_exercise) REFERENCES t_exercise(id_exercise)
);
CREATE TABLE IF NOT EXISTS t_login(
    id_login INTEGER PRIMARY KEY AUTOINCREMENT,
    login TEXT NOT NULL,
    password TEXT NOT NULL,
    t_user_id_user INTEGER NOT NULL,
    FOREIGN KEY(t_user_id_user) REFERENCES t_user(id_user)
);
CREATE TABLE IF NOT EXISTS t_phone(
    id_phone INTEGER PRIMARY KEY AUTOINCREMENT,
    t_user_id_user INTEGER NOT NULL,
    type TEXT DEFAULT 'home',
    number_phone TEXT,
    create_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    active TEXT NOT NULL,
    FOREIGN KEY(t_user_id_user) REFERENCES t_user(id_user)
);
CREATE TABLE IF NOT EXISTS t_subscription(
    id_subscription INTEGER PRIMARY KEY AUTOINCREMENT,
    t_user_id_user INTEGER NOT NULL,
    active TEXT NOT NULL,
    expiration DATE NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    t_plan_id_plan INTEGER NOT NULL,
    FOREIGN KEY(t_plan_id_plan) REFERENCES t_plan(id_plan),
    FOREIGN KEY(t_user_id_user) REFERENCES t_user(id_user)
);
CREATE TABLE IF NOT EXISTS t_weight_height(
    id_weight_height INTEGER PRIMARY KEY AUTOINCREMENT,
    t_user_id_user INTEGER NOT NULL,
    height INTEGER NOT NULL,
    weight NUMERIC NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY(t_user_id_user) REFERENCES t_user(id_user)
);
CREATE TABLE IF NOT EXISTS t_plan(
    id_plan INTEGER PRIMARY KEY AUTOINCREMENT,
    type TEXT NOT NULL,
    description TEXT
);

INSERT INTO
   t_user(first_name, last_name, birthday, created_at) 
VALUES
   (
      'João', 'Cleber', '1990-06-20', datetime('now')
   )
;
INSERT INTO
   t_user(first_name, last_name, birthday, created_at) 
VALUES
   (
      'Maria', 'Bonita', '1980-07-12', datetime('now')
   )
;
INSERT INTO
   t_user(first_name, last_name, birthday, created_at) 
VALUES
   (
      'Guilherme', 'Gomes', '1999-01-10', datetime('now') 
   )
;
INSERT INTO
   t_user(first_name, last_name, birthday, created_at) 
VALUES
   (
      'Marina', 'Teixeira', '1987-04-19', datetime('now') 
   )
;
INSERT INTO
   t_user(first_name, last_name, birthday, created_at) 
VALUES
   (
      'Luiz', 'Oliveira', '1997-11-03', datetime('now') 
   )
;
INSERT INTO
   t_weight_height(t_user_id_user, height, weight, created_at) 
VALUES
   (
      2, 1.50, 80.8, '2019-06-12'
   )
;
INSERT INTO
   t_weight_height(t_user_id_user, height, weight, created_at) 
VALUES
   (
      2, 1.50, 97.5, '2020-08-10'
   )
;
INSERT INTO
   t_weight_height(t_user_id_user, height, weight, created_at) 
VALUES
   (
      2, 1.50, 98.0, '2020-10-16'
   )
;
INSERT INTO
   t_blood_pressure(t_user_id_user, value_blood_pressure, created_at) 
VALUES
   (
      2, 15.6, '2020-08-10'
   )
;
INSERT INTO
   t_blood_pressure(t_user_id_user, value_blood_pressure, created_at) 
VALUES
   (
      2, 12.13, '2020-10-16'
   )
;
INSERT INTO
   t_blood_pressure(t_user_id_user, value_blood_pressure, created_at) 
VALUES
   (
      1, 11.13, '2020-10-18'
   )
;
INSERT INTO
   t_blood_pressure(t_user_id_user, value_blood_pressure, created_at) 
VALUES
   (
      2, 16.13, '2020-10-19'
   )
;
INSERT INTO
   t_exercise( t_user_id_user, label, duration, description, created_at ) 
VALUES
   (
      2, 'Futebol', '2019-06-12', 'Futebol com a Gelera', '2019-06-12' 
   )
;
INSERT INTO
   t_exercise( t_user_id_user, label, duration, description, created_at ) 
VALUES
   (
      2, 'Futebol', '2020-08-10', 'futebol denovo ', '2020-08-10' 
   )
;
INSERT INTO
   t_exercise( t_user_id_user, label, duration, description, created_at ) 
VALUES
   (
      3, 'Futebol', '2020-10-19', 'futebol na praia', '2020-10-19' 
   )
;
INSERT INTO
   t_exercise( t_user_id_user, label, duration, description, created_at ) 
VALUES
   (
      2, 'Futebol', '2020-10-19', 'futebol na quadra', '2020-10-19' 
   )
;
INSERT INTO
   t_food(t_user_id_user, calories, description, created_at) 
VALUES
   (
      2, 500, 'lasanha de 4 queijos', '2020-08-10'
   )
;
INSERT INTO
   t_food(t_user_id_user, calories, description, created_at) 
VALUES
   (
      2, 80, 'maça', '2020-10-16'
   )
;
INSERT INTO
   t_food(t_user_id_user, calories, description, created_at) 
VALUES
   (
      2, 900, 'bolo de cenoura', '2020-10-19'
   )
;
INSERT INTO
   t_food(t_user_id_user, calories, description, created_at) 
VALUES
   (
      4, 1000, 'Feijoada de Domingo', '2020-09-19'
   )
;
INSERT INTO
   t_food(t_user_id_user, calories, description, created_at) 
VALUES
   (
      4, 90, 'Salada De Fruta', '2020-10-19'
   )
;
INSERT INTO
   t_login(login, password, t_user_id_user) 
VALUES
   (
      4, 'haha@tutu', '123456', 4
   )
;