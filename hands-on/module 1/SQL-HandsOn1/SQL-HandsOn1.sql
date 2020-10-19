-- Query all columns for actors with the first name of "Cuba".
SELECT * FROM sakila.actor WHERE first_name = "Cuba";

-- Query the film title and film id that has an film_id greater than 5 and less than 20.
SELECT title, film_id 
    FROM sakila.film 
    WHERE film_id > 5 AND film_id < 20;

-- Query the first and last name, and email of customers who have the last name "Rodriguez"
-- or their last name begins with a "Mc".
SELECT first_name, last_name, email 
    FROM sakila.customer 
    WHERE last_name = "Rodriguez" OR last_name LIKE "mc%";

-- Query all columns of the films with a title that begins with "a".
SELECT * FROM sakila.film WHERE title LIKE "a%";

-- Query all titles of films that are not in the language of English or Japanese.
SELECT title FROM sakila.film
    WHERE language_id IN (SELECT language_id FROM sakila.language WHERE name != "english" AND name != "japanese")

/*
    You were just hired at a company as a data analyst, and your company needs some 
    information from the database. They would like to see all payments that had a 
    rental amount is over .99 cents. However, they only want to see the rental id 
    and payment date that is attached to that payment. Once you have finished that, 
    they would like to see the staff id and customer id from the payments that have 
    an amount over .99 cents.
*/

SELECT rental_id, payment_date FROM sakila.payment WHERE amount > 0.99;

SELECT staff_id, customer_id FROM sakila.payment WHERE amount > 0.99