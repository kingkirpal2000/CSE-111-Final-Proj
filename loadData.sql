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