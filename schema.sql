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
    added_by varchar(20) not null,
    added_date date not null
);

create table Watchlist (
    id int not null,
    ticker varchar(5) not null
);

create table Brokerage (
    name varchar(20),
    type varchar(10) not null,
    fee int not null
);

create table fav_stock(
    fs_id int not null PRIMARY KEY,
    fs_ticker varchar(5) not null
);

create table fav_crypto(
    fc_id int not null PRIMARY KEY,
    fc_ticker varchar(5) not null
);

create table fav_forex(
    ff_id int not null PRIMARY KEY,
    ff_currency_code varchar(5) not null
);

create table s_tradesOn(
    st_ticker varchar(5) not null,
    st_brokerage_name varchar(20)
);

create table c_tradesOn(
    ct_ticker varchar(5) not null,
    ct_brokerage_name varchar(20)
);

create table f_tradesOn(
    ft_currency_code varchar(5) not null,
    ft_brokerage_name varchar(20)
);

create table u_tradesOn(
    ut_id int not null,
    ut_brokerage_name varchar(20)
);