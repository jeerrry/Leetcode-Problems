# Write your MySQL query statement below
SELECT employee_id, salary * (employee_id%2) * (name NOT LIKE 'M%') as bonus from Employees ORDER BY employee_id;