create table public.app_users (
                              id bigserial,
                              user_name varchar(100),
                              user_pass varchar(100),
                              mail varchar(100),
                              age int
);


insert into public.app_users (user_name, user_pass, mail, age) values
    ('user1', 'pass1', 'mail1@yandex.ru', 21),
    ('user2', 'pass2', 'mail2@yandex.ru', 22),
    ('user3', 'pass3', 'mail3@yandex.ru', 23);