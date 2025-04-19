CREATE TABLE prices (
    id BIGINT PRIMARY KEY,
    brand_id BIGINT,
    start_date TIMESTAMP,
    end_date TIMESTAMP,
    price_list INTEGER,
    product_id BIGINT,
    priority INTEGER,
    price DOUBLE,
    currency VARCHAR(10)
);
