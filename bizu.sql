CREATE DATABASE bizu;

USE bizu;

CREATE TABLE tb_user(
id int GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
user_name varchar(30) not null,
email varchar(50) UNIQUE not null,
user_password varchar(100) not null
);

-- Senha Teste.123
INSERT INTO tb_user(
	user_name, email, user_password)
	VALUES ('teste', 'teste@gmail.com', '$2a$10$92nKOqH0LI7i4NDIW4u/pepEa4zdOUfQpGlSgZh4q8kYROynkaO0C');
	
create table tb_todo(
id numeric PRIMARY KEY not null,
to_do varchar(30) not null,
priority varchar(50) not null,
status varchar(50) not null,
user_id int not null,
	CONSTRAINT fk_user
		FOREIGN KEY(user_id)
			REFERENCES tb_user(id)
);

CREATE SEQUENCE IF NOT EXISTS todo_seq;