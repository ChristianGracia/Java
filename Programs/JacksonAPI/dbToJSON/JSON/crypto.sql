CREATE DATABASE Crypto;
use Crypto;
CREATE TABLE CoinInfo
(CoinName varchar(50),
PurchaseDate date,
Amount int(50),
Location varchar(50));

INSERT INTO CoinInfo values("bitcoin", CURRENT_DATE(), 120, 'africa');
INSERT INTO CoinInfo values("litecoin", CURRENT_DATE(), 45, 'africa');
INSERT INTO CoinInfo values("etheruem", CURRENT_DATE(), 91, 'asia');
INSERT INTO CoinInfo values("doge", CURRENT_DATE(), 20, 'asia');
INSERT INTO CoinInfo values("engima", CURRENT_DATE(), 70, 'asia');

select * from CoinInfo where Location ='Asia';