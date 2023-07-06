# Write your MySQL query statement below
SELECT `name` from Customer WHERE `referee_id` IS NULL OR NOT `referee_id` = (SELECT `id` from Customer where `id` = 2);