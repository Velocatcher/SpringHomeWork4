CREATE TABLE IF NOT EXISTS userTable (
id INT AUTO_INCREMENT PRIMARY KEY,
firstName varchar(50) NOT NULL,
lastName varchar(50) NOT NULL,
age INT NOT NULL,
email varchar(50) NOT NULL
);

INSERT INTO userTable (firstName, lastName, age, email)
VALUES
('Robert', 'Patisson', 33, 'vampir@mail.ru'),
('Bred', 'Pitt', 53, 'brett@mail.ru');