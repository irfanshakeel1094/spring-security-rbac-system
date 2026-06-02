-- Drop table if it already exists
DROP TABLE IF EXISTS user_model;

-- Create table
CREATE TABLE user_model (
                            id SERIAL PRIMARY KEY,
                            username VARCHAR(100) UNIQUE NOT NULL,
                            password VARCHAR(255) NOT NULL,
                            email VARCHAR(150) NOT NULL,
                            phonenumber VARCHAR(20) NOT NULL,
                            role VARCHAR(20) NOT NULL
);

-- Default Admin Account
INSERT INTO user_model
(username, password, email, phonenumber, role)
VALUES
    (
        'admin',
        '<admin-password>',
        'admin@gmail.com',
        '9876543210',
        'ADMIN'
    );

-- Sample User Account
INSERT INTO user_model
(username, password, email, phonenumber, role)
VALUES
    (
        'irfan',
        'irfan123',
        'irfan@gmail.com',
        '9876543210',
        'USER'
    );