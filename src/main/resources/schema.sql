CREATE TABLE payment (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    ticket_id INT NOT NULL,
    amount DOUBLE NOT NULL,
    payment_method VARCHAR(255) NOT NULL,
    status VARCHAR(255) NOT NULL,
    transaction_id VARCHAR(255) NOT NULL
);
