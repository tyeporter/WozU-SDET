
-- Create a table for gyms (specific gym franchise)
CREATE TABLE PlanetFitness(
	branchID INTEGER PRIMARY KEY,
    branchName VARCHAR(100),
    branchAddress VARCHAR(100)
);

-- Create a table for gym members
CREATE TABLE PlanetFitnessMembers(
	memberID INTEGER PRIMARY KEY,
	firstName VARCHAR(100),
    lastName VARCHAR(100),
    age INTEGER
);

-- Alter our PlanetFitnessMembers table
ALTER TABLE PlanetFitnessMembers ADD email VARCHAR(100);

-- Create through table for our many-to-many relationship
CREATE TABLE CheckIn(
	checkInID INTEGER PRIMARY KEY,
    branchID INTEGER,
    memberID INTEGER,
    FOREIGN KEY (branchID) REFERENCES PlanetFitness (branchID),
    FOREIGN KEY (memberID) REFERENCES PlanetFitnessMembers (memberID)
);

-- Insert data into our tables
INSERT INTO PlanetFitness VALUES 
	(1, "Austin (W. Anderson Lane), TX", "1100 W Anderson Ln Austin, TX 78757"),
    (2, "Miami (West Kendall), FL", "15725 SW 72nd St Miami, FL 33193"),
    (3, "Denver (Downtown), CO", "815 16th St Denver, CO 80202");
    
INSERT INTO PlanetFitnessMembers VALUES 
	(1, "John", "Smith", 34, "johnsmith@email.com"),
    (2, "Jane", "Doe", 26, "janedoe@email.com"),
    (3, "Josh", "Drake", 21, "joshdrake@email.com"),
    (4, "James", "Brown", 18, "jamesbrown@email.com");
    
INSERT INTO CheckIn VALUES 
	(1, 2, 1),
    (2, 1, 4),
    (3, 2, 2),
    (4, 3, 3);

-- Select all the data in PlanetFitness table
SELECT * FROM PlanetFitness;

-- Select all the data in PlanetFitnessMembers table that meets condition
SELECT * FROM PlanetFitnessMembers WHERE age > 25;




