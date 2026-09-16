# Write your MySQL query statement below
# names of coustomer id != 2 And referred not  
SELECT name FROM Customer WHERE referee_id != 2 OR referee_id is null;