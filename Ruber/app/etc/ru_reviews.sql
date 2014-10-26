DROP TABLE ru_reviews

CREATE TABLE ru_reviews
(
  id int Identity (1, 1) primary key NOT NULL,
  driverId int,
  rating int,
  comment nvarchar(512)
)