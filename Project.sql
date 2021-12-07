create table Users (
    id int not null PRIMARY KEY,
    name varchar(20) not null,
    role varchar(5) not null,
    type varchar(10)
);

create table Stocks(
    ticker varchar(5) not null PRIMARY KEY,
    name varchar(20) not null,
    low float(5,2) not null,
    high float(5,2) not null,
    added_by varchar(20) not null,
    added_date varchar(20) not null,
    market_cap varchar(10) not null,
    PE float(3,2),
    type varchar(5) not null,
    div_rate float(2,2) 
);

create table Crypto(
    ticker varchar(5) not null PRIMARY KEY,
    name varchar(20) not null,
    low float(5,5) not null,
    high float(5,4) not null,
    added_by varchar(20) not null,
    added_date varchar(20) not null,
    market_dom float(3,2),
    current_supply varchar(10) Not Null,
    max_supply varchar(10) not null,
    purpose varchar(100),
    mine boolean
);

create table Forex(
    currency_code varchar(5) PRIMARY KEY,
    currency varchar(20),
    Price float(5,2) not null,
    added_by date not null,
    added_date date not null
);

create table Watchlist (
    id int not null,
    ticker varchar(5) not null
);

create table Brokerage (
    name varchar(20) PRIMARY KEY,
    type varchar(10) not null,
    fee int not null
);


INSERT INTO Users VALUES (1, 'Navroop Khangura', 'Owner', 'All');
INSERT INTO Users VALUES (2, 'Sabir Kirpal', 'Owner', 'All');
INSERT INTO Users VALUES (3, 'John Doe', 'User', 'Safe');
INSERT INTO Users VALUES (4, 'John Smith', 'User', 'Growth');
INSERT INTO Users VALUES (5, 'Arthur Williams', 'User', 'Div');
INSERT INTO Users Values (6, 'Jackie Wang', 'User', 'Growth');

INSERT INTO Stocks VALUES ('T', 'At&T', 24.56, 33.88, 'Navroop Khangura', '2021-11-16', '176.1 B', 203.13, 'Safe', 8.43);
INSERT INTO Stocks VALUES ('DKNG', 'Draft Kings', 37.36, 74.38, 'Navroop Khangura', '2021-11-16', '15.3 B', Null, 'Growth', null);
INSERT INTO Stocks VALUES ('BYND', 'Beyond Meat', 76.77, 221.0,  'Navroop Khangura', '2021-11-16', '4.26 B', Null, 'Growth', null);
INSERT INTO Stocks VALUES ('AMZN', 'Amazon', 2881.0, 3773.08, 'Navroop Khangura', '2021-11-16', '1.8 T', 69.45, 'Safe', null);
INSERT INTO Stocks VALUES ('AAPL', 'Apple', 112.59, 157.26, 'Navroop Khangura', '2021-11-16', '2.5 T', 27.36, 'Safe', 0.88);
Insert INTO Stocks Values ('CLOV', 'Clover Health Investment', 6.31, 28.85, 'Navroop Khangura', '2021-11-17','2 B', Null,  'Growth', Null);

INSERT INTO Crypto VALUES ('BTC', 'Bitcoin', 16351.03, 68789.63,  'Navroop Khangura', '2021-11-16', 43.13, '18.9 M','21 M', 'Digital Gold', 'TRUE');
INSERT INTO Crypto VALUES ('ETH', 'Etherum', 465.70, 4891.70, 'Navroop Khangura', '2021-11-16', 19.23,'118.6 M','Unknown', 'Build and publish smart contracts', 'FALSE');
INSERT INTO Crypto VALUES ('DOGE', 'Dogecoin', .00029, .7376, 'Navroop Khangura', '2021-11-16', 1.19, '132.4 B','Unknown', 'Meme', 'FALSE');

INSERT INTO Watchlist VALUES(1,'T');
INSERT INTO Watchlist VALUES(1,'DKNG');
INSERT INTO Watchlist VALUES(1,'BYND');
INSERT INTO Watchlist Values(1, 'BTC');
INSERT INTO Watchlist Values(1, 'ETH');
INSERT INTO Watchlist Values(1, 'DOGE');
INSERT INTO Watchlist Values(2, 'ETH');
Insert into Watchlist Values(2, 'CLOV');
Insert into Watchlist values(3, 'AMZN');

INSERT INTO Brokerage VALUES('Robinhood', 'All', 0);
INSERT INTO Brokerage VALUES('Coinbase', 'Crypto', 0);


/* List all the owners */
Select name, role From Users
where role = 'Owner'

/* Watchlist for user 1*/
Select ticker from Watclist 
where id = 1

/* What brokerages have no  fees */
Select name from brokerage 
where fee = 0

/* List the cyrpto that is mineable */
Select name from Crypto 
where mine = 'TRUE'

/* List the purpose of each Crypto */
Select name, purpose from Crypto

/* List name and ticker of the stock with the lowest 52 week low */
Select name, ticker, min(low) as '52_week_low' from stocks

/* List name and ticker of the stock with the highest 52 week high */
Select name, ticker, max(high) as '52_week_high' from stocks

/* List name and ticker of the stock with the biggest difference in the 52 week high and low */
Select name, ticker, max(high-low) from Stocks

/* List name and ticker of the difference in the 52 week high and low*/
Select name, ticker, (high-low) as 'High-Low' From Stocks
Order by High-Low DESC

/* Remove BTC from User 1 watchlist */
Delete from Watchlist 
where id = 1 and ticker = 'BTC'

/* Remove ETH from User 2 watchlist */
Delete from Watchlist 
where id = 2 and ticker = 'ETH'

/* Update User 6 type to safe */
Update Users
set type = 'Safe'
where id = 6

/* List all growth stocks in Stock etf */
Select name, ticker from Stocks
Where type = 'Growth'

/* How many people watch At&T */
Select count(id) from watchlist 
where ticker = 'T'

/* List all companies that have PE less than 100 and Market Cap over a billion */
Select name, ticker from Watchlist 
Where PE > 0 and PE < 100 And market_cap > 1000000000

/* List all stocks with a div in order from highest to lowest*/
Select name From Stocks
where div_rate > 0 
Order by div_rate DESC

/* What users follow crypto */
Select ID, Watchlist.ticker from Watchlist 
Inner join Crypto on Crypto.ticker = Watchlist.ticker

/* List all the growth stocks user 2 follows */
Select name, stocks.ticker from Stocks 
INNER JOIN Watchlist on stocks.ticker = Watchlist.ticker 
WHERE type = 'Growth'and Watchlist.id = 2

/* What users follow Safe stocks with div higher than 5 */
Select id, Watchlist.ticker from Watchlist 
Inner join Stocks on Stocks.ticker = Watchlist.ticker
where type = 'Safe' and div_rate>5

/* What growth and safe does user 1 follow */
Select name, stocks.ticker from Stocks 
INNER JOIN Watchlist on stocks.ticker = Watchlist.ticker 
WHERE type = 'Growth'and Watchlist.id = 1
union 
Select name, stocks.ticker from Stocks 
INNER JOIN Watchlist on stocks.ticker = Watchlist.ticker 
WHERE type = 'Safe'and Watchlist.id = 1

/* Top 3 percentage change in crypto, in order from highest to lowest */
Select name, ticker, (high/low) as biggest_percentage_change from Crypto 
Order by biggest_percentage_change DESC LIMIT 3

