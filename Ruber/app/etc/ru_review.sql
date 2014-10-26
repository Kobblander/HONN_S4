DROP TABLE ru_review

CREATE TABLE ru_review
(
  id int Identity (1, 1) primary key NOT NULL,
  driverId int,
  rating int,
  comment nvarchar(512)
)