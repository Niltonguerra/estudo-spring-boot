CREATE TABLE products (
                          id       BIGSERIAL PRIMARY KEY,          -- PostgreSQL
    -- id    BIGINT AUTO_INCREMENT PRIMARY KEY,  -- MySQL
                          name     VARCHAR(255) NOT NULL,
                          category VARCHAR(255) NOT NULL,
                          price    NUMERIC(19, 2) NOT NULL,
                          sku      VARCHAR(255) NOT NULL UNIQUE,
                          active   BOOLEAN NOT NULL DEFAULT TRUE
);