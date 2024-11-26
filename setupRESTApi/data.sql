-- Create the Registration table
CREATE TABLE Registration (
  ID INT PRIMARY KEY AUTO_INCREMENT,
  FirstName VARCHAR(50) NOT NULL,
  LastName VARCHAR(50) NOT NULL,
  Email VARCHAR(100) UNIQUE NOT NULL,
  DateOfBirth DATE NOT NULL,
  PasswordHash VARCHAR(255) NOT NULL,
  RegistrationDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  IsActive BOOLEAN DEFAULT TRUE,
  PhoneNumber VARCHAR(20),
  Address VARCHAR(255)
);

-- Insert records into the Registration table (Create Operation)
INSERT INTO Registration (
    FirstName, LastName, Email, DateOfBirth, PasswordHash, PhoneNumber, Address
) VALUES
('John', 'Doe', 'john.doe@example.com', '1990-05-15', 'hashed_password_123', '1234567890', '123 Main St, Cityville'),
('Jane', 'Smith', 'jane.smith@example.com', '1988-10-20', 'hashed_password_456', '9876543210', '456 Elm St, Townsville'),
('Alice', 'Johnson', 'alice.johnson@example.com', '1995-12-05', 'hashed_password_789', NULL, '789 Oak St, Villagetown');

-- Fetch all records from the Registration table (Read Operation)
SELECT * FROM Registration;

-- Fetch a single record by ID (Read Operation)
SELECT * FROM Registration WHERE ID = 1;

-- Fetch active users only (Read Operation)
SELECT * FROM Registration WHERE IsActive = TRUE;

-- Search users by name (Read Operation)
SELECT * FROM Registration WHERE FirstName LIKE '%Jane%' OR LastName LIKE '%Smith%';

-- Update a user's email and phone number (Update Operation)
UPDATE Registration
SET Email = 'updated.email@example.com', PhoneNumber = '5555555555'
WHERE ID = 2;

-- Deactivate a user (Update Operation)
UPDATE Registration
SET IsActive = FALSE
WHERE ID = 3;

-- Soft delete (mark inactive) (Update Operation)
UPDATE Registration
SET IsActive = FALSE
WHERE ID = 1;

-- Hard delete (remove record permanently) (Delete Operation)
DELETE FROM Registration
WHERE ID = 2;
