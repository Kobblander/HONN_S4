DROP TABLE ru_drivers

CREATE TABLE ru_drivers
(
  id int identity (1, 1) primary key not null,
  username nvarchar(256) unique not null
  firstname nvarchar(128)
  lastname nvarchar(128)
  password nvarchar(128)
  email nvarchar(256)
)

INSERT INTO ru_drivers(username, firstname, lastname, password, email)
VALUES('Travis Bickle', 'Travis', 'Bickle', '1234567', 'travis@bickle.com')

INSERT INTO ru_drivers(username, firstname, lastname, password, email)
VALUES('John Romero', 'John', 'Romero', '1234567', 'john@romero.com')

INSERT INTO ru_drivers(username, firstname, lastname, password, email)
VALUES('Captain America', 'Captain', 'America', '1234567', 'cap@avengers.com')

INSERT INTO ru_drivers(username, firstname, lastname, password, email)
VALUES('Steven Fry', 'Steven', 'Fry', '1234567', 'steven@fry.com')

INSERT INTO ru_drivers(username, firstname, lastname, password, email)
VALUES('Ronald Jackson', 'Ronald', 'Jackson', '1234567', 'ronald@gmail.com')
