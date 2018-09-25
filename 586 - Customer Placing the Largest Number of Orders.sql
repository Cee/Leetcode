# Write your MySQL query statement below
SELECT t.customer_number
FROM (SELECT customer_number, COUNT(*) AS total
      FROM orders
      GROUP BY customer_number) t
WHERE t.total >= ALL(SELECT COUNT(*) AS total FROM orders GROUP BY customer_number)