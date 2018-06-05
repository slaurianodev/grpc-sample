USE wallet_service_db;

start transaction;

INSERT INTO users (user_name) VALUES ('sergio');

INSERT INTO currencies (currency_name,currency_code) VALUES ('Euro','EUR');
INSERT INTO currencies (currency_name,currency_code) VALUES ('US Dollar','USD');
INSERT INTO currencies (currency_name,currency_code) VALUES ('Pound Sterling','GBP');

commit;
