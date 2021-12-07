/* List all the owners */
Select name, role From Users
where role = 'Owner';

/* Watchlist for user 1*/
Select ticker from Watclist
where id = 1;

/* What brokerages have no  fees */
Select name from brokerage
where fee = 0;

/* List the cyrpto that is mineable */
Select name from Crypto
where mine = 'TRUE';

/* List the purpose of each Crypto */
Select name, purpose from Crypto;

/* List name and ticker of the stock with the lowest 52 week low */
Select name, ticker, min(low) as '52_week_low' from stocks;

/* List name and ticker of the stock with the highest 52 week high */
Select name, ticker, max(high) as '52_week_high' from stocks;

/* List name and ticker of the stock with the biggest difference in the 52 week high and low */
Select name, ticker, max(high-low) from Stocks;

/* List name and ticker of the difference in the 52 week high and low*/
Select name, ticker, (high-low) as 'High-Low' From Stocks
Order by High-Low DESC;

/* Remove BTC from User 1 watchlist */
Delete from Watchlist
where id = 1 and ticker = 'BTC';

/* Remove ETH from User 2 watchlist */
Delete from Watchlist
where id = 2 and ticker = 'ETH';

/* Update User 6 type to safe */
Update Users
set type = 'Safe'
where id = 6;

/* List all growth stocks in Stock etf */
Select name, ticker from Stocks
Where type = 'Growth';

/* How many people watch At&T */
Select count(id) from watchlist
where ticker = 'T';

/* List all companies that have PE less than 100 and Market Cap over a billion */
Select name, ticker from Watchlist
Where PE > 0 and PE < 100 And market_cap > 1000000000;

/* List all stocks with a div in order from highest to lowest*/
Select name From Stocks
where div_rate > 0
Order by div_rate DESC;

/* What users follow crypto */
Select ID, Watchlist.ticker from Watchlist
Inner join Crypto on Crypto.ticker = Watchlist.ticker;

/* List all the growth stocks user 2 follows */
Select name, stocks.ticker from Stocks
INNER JOIN Watchlist on stocks.ticker = Watchlist.ticker
WHERE type = 'Growth'and Watchlist.id = 2;

/* What users follow Safe stocks with div higher than 5 */
Select id, Watchlist.ticker from Watchlist
Inner join Stocks on Stocks.ticker = Watchlist.ticker
where type = 'Safe' and div_rate>5;

/* What growth and safe does user 1 follow */
Select name, stocks.ticker from Stocks
INNER JOIN Watchlist on stocks.ticker = Watchlist.ticker
WHERE type = 'Growth'and Watchlist.id = 1
union
Select name, stocks.ticker from Stocks
INNER JOIN Watchlist on stocks.ticker = Watchlist.ticker
WHERE type = 'Safe'and Watchlist.id = 1;

/* Top 3 percentage change in crypto, in order from highest to lowest */
Select name, ticker, (high/low) as biggest_percentage_change from Crypto
Order by biggest_percentage_change DESC LIMIT 3;

