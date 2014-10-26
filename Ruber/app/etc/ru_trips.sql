DROP TABLE ru_trips

CREATE TABLE ru_trips
(
  id int Identity (1, 1) primary key NOT NULL,
  requestTime BIGINT,
  productId int,
  tripStatus int,
  distance float,
  startTime BIGINT,
  endTime BIGINT,
  startLat BIGINT,
  startLong BIGINT,
  endLat BIGINT,
  endLong BIGINT,
  userId int
)
