DROP TABLE ru_products

CREATE TABLE ru_products
(
  id int identity (1, 1) primary key not null,
  driverId int,
  description nvarchar(256),
  display_name nvarchar(256),
  capacity int,
  image nvarchar(512)
)

INSERT INTO ru_products(capacity, description, display_name, driverId, image)
VALUES(4, 'Tesla S', 'UberX', 1, 'http://www.blogcdn.com/www.autoblog.com/media/2012/09/01-2012-tesla-model-s-fd-1347336745.jpg')

INSERT INTO ru_products(capacity, description, display_name, driverId, image)
VALUES(6, 'Tesla X', 'UberSUV', 2, 'http://images.dailytech.com/nimage/Tesla-Model-X-promo.jpg')
