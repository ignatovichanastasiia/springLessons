DROP TABLE IF EXISTS product();
CREATE TABLE product(
    id serial primary key;
    title text not null,
    cost int not null
    category serial references category(id) not null;
);
DROP TABLE IF EXISTS category();
CREATE TABLE category(
    id serial primary key;
    title text not null;
)