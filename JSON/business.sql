CREATE DATABASE Business;
use Business;
CREATE TABLE CustomerInfo
(CourseNAme varchar(50),
PurchaseDate date,
Amount int(50),
Location varchar(50));

INSERT INTO CustomerInfo values("bitcoin", CURRENT_DATE(), 120, 'africa');
INSERT INTO CustomerInfo values("litecoin", CURRENT_DATE(), 45, 'africa');
INSERT INTO CustomerInfo values("etheruem", CURRENT_DATE(), 91, 'asia');
INSERT INTO CustomerInfo values("doge", CURRENT_DATE(), 20, 'asia');
INSERT INTO CustomerInfo values("engima", CURRENT_DATE(), 70, 'asia');

select * from CustomerInfo where purchasedDate=CURDATE() and Location ='Asia';