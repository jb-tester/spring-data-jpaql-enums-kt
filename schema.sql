

-- Create the issues table
CREATE TABLE if not exists enums.issues
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    title       VARCHAR(255),
    author      VARCHAR(255),
    description TEXT,
    priority    VARCHAR(50),
    state       VARCHAR(50),
    type INT DEFAULT 0
);
-- Create the fruits table
CREATE TABLE if not exists enums.fruits
(
    id       BIGINT AUTO_INCREMENT PRIMARY KEY,
    quantity BIGINT,
    type     VARCHAR(50)
);

-- Create the basic_entities table
CREATE TABLE enums.basic_entities (
                                      id BIGINT AUTO_INCREMENT PRIMARY KEY
);

--
CREATE TABLE enums.basic_entity_test_set (
                                             basic_entity_id BIGINT NOT NULL,
                                             test_set VARCHAR(50),
                                             FOREIGN KEY (basic_entity_id) REFERENCES enums.basic_entities(id) ON DELETE CASCADE
);

-- Sample data
INSERT INTO enums.basic_entities (id) VALUES (1), (2), (3);

INSERT INTO enums.basic_entity_test_set (basic_entity_id, test_set) VALUES
                                                                        (1, 'A'),
                                                                        (1, 'B'),
                                                                        (2, 'C'),
                                                                        (2, 'D'),
                                                                        (3, 'A'),
                                                                        (3, 'C'),
                                                                        (3, 'D');

INSERT INTO enums.issues (title, author, description, priority, state, type)
VALUES ('Database connection timeout', 'irina', 'The application fails to connect to the database after 30 seconds',
        'High', 'Open', 2),
       ('UI button alignment issue', 'ira', 'Submit button is not aligned properly on the login page', 'Low', 'Closed', 3),
       ('Memory leak in service', 'irina', 'Service consumes increasing memory over time', 'High', 'Open', 2),
       ('Add dark mode support', 'john', 'Users requested dark mode for better UX', 'Medium', 'Open', 4),
       ('Fix typo in documentation', 'ira', 'Several typos found in user manual', 'Low', 'Closed', 3),
       ('API response time degradation', 'irina', 'API endpoints responding slower than expected', 'High', 'Open', 2),
       ('Update dependencies', 'mike', 'Several libraries need to be updated to latest versions', 'Medium', 'Open', 4),
       ('Improve error messages', 'ira', 'Error messages need to be more user-friendly', 'Medium', 'Closed', 1);


INSERT INTO enums.fruits (quantity, type)
VALUES (100, 'Apple'),
       (20, 'Banana'),
       (50, 'Orange'),
       (10, 'Peach'),
       (15, 'Mango'),
       (25, 'Melon'),
       (30, 'Pear');
