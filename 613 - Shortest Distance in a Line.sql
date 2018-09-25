# Write your MySQL query statement below
SELECT MIN(dis) AS shortest
FROM (SELECT p2.x - p1.x AS dis
      FROM point p1, point p2
      WHERE p1.x < p2.x) AS t