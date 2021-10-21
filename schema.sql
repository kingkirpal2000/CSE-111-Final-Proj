CREATE TABLE users (
    u_id  decimal(3,0) not null,
    u_name      char(25) not null,
    u_traderType    varchar(152),
    u_role  char(25) not null
);
CREATE TABLE watchlist (
    w_ticker char(10) not null,
    w_id decimal(3,0) not null,
)
CREATE TABLE brokerage (
    b_name  char(25) not null,
    b_fee       decimal(10, 2) not null,
    b_type  varchar(20) not null,
);
CREATE TABLE growth (
    g_high  decimal(10, 2) not null,
    g_low   decimal(10, 2) not null,
    g_ticker    char(10) not null,
    g_marketCap decimal(10, 2) not null,
    g_addedBy   decimal(3, 0) not null, --?
    g_brokerageType varchar(20) not null
);
CREATE TABLE safe (
    s_high  decimal(10, 2) not null,
    s_low   decimal(10, 2) not null,
    s_ticker    char(10) not null,
    s_marketCap decimal(10, 2) not null,
    s_addedBy   decimal(3, 0) not null, --?
    s_brokerageType varchar(20) not null
);
CREATE TABLE crypto (
    c_high  decimal(10, 2) not null,
    c_low   decimal(10, 2) not null,
    c_ticker    char(10) not null,
    c_marketCap decimal(10, 2) not null,
    c_addedBy   decimal(3, 0) not null, --?
    c_brokerageType varchar(20) not null
);
CREATE TABLE dividends (
    d_high  decimal(10, 2) not null,
    d_low   decimal(10, 2) not null,
    d_ticker    char(10) not null,
    d_marketCap decimal(10, 2) not null,
    d_addedBy   decimal(3, 0) not null, --?
    d_brokerageType varchar(20) not null,
    d_dividendYield decimal(3, 2) not null
);